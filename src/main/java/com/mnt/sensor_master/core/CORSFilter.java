package com.mnt.sensor_master.core;

import com.mnt.sensor_master.security.SecurityTokenHandler;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter {

    @Autowired
    SecurityTokenHandler securityTokenHandler;

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Authorization, x-requested-with, origin, content-type, accept,device-id");
        httpResponse.setHeader("Access-Control-Max-Age", "1800");
        if (httpRequest.getMethod().equals("OPTIONS")) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
        } else {
            String url = httpRequest.getServletPath();
            chain.doFilter(request, response);
            if (url.equals("/sensor/master/api/login") 
            		|| url.equals("/sensor/master/api/login")
            		|| url.equals("/sensor/master/api/logout")
            		|| url.equals("/sensor/master/api/changePassword")
            		|| url.equals("/sensor/master/api/resetPassword")
            		|| url.equals("/sensor/master/api/user")
            		|| securityTokenHandler.checkLogin(httpRequest, httpResponse)) {
//                chain.doFilter(request, response);
            } else {
//                httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Please login");
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

}

