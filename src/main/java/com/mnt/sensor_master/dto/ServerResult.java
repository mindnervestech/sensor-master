package com.mnt.sensor_master.dto;

import java.util.HashMap;

public class ServerResult extends HashMap<String, Object> {

    public static String MSG_SAVED_SUCCESSFULLY = "Saved successfully";
    public static String MSG_DELETED_SUCCESSFULLY = "Deleted successfully";

    public ServerResult setData(Object data) {
        put("data", data);
        return this;
    }

    public ServerResult setCode(int data) {
        put("code", data);
        return this;
    }

    public ServerResult setError() {
        put("error", true);
        return this;
    }

    public ServerResult setMessage(String data) {
        put("message", data);
        return this;
    }
}