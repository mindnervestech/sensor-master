package com.mnt.sensor_master.security;

import java.io.IOException;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.mnt.sensor_master.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class SecurityTokenHandler {

    public String getToken(User user) {
        JwtBuilder jwts = Jwts.builder();
        jwts.claim("user", user);
        jwts.signWith(SignatureAlgorithm.HS512, "ONTRACK");
        String token = jwts.compact();
        return token;
    }

    @SuppressWarnings("unchecked")
    public LinkedHashMap<String, Object> getLoggedInTenant(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LinkedHashMap<String, Object> tenant = null;
        try {
            String token = request.getHeader("AUTH");
            Jws<Claims> jws = Jwts.parser().setSigningKey("ONTRACK").parseClaimsJws(token);
            tenant = (LinkedHashMap<String, Object>) jws.getBody().get("user");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }
        return tenant;
    }

    public boolean checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String token = request.getHeader("AUTH");
            if (token == null) {
                return false;
            }
            Jws<Claims> jws = Jwts.parser().setSigningKey("ONTRACK").parseClaimsJws(token);
            return jws.getBody().containsKey("user");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return false;
        }
    }

}
