package com.exam.ssm.tools.Message;
import java.util.HashMap;
import java.util.Map;
public class ResponseMessage {

    public static final String ERROR = "error";
    private final String message;
    private final int code;
    private final Map<String, Object> data = new HashMap<>();

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public Map<String, Object> getData() {
        return data;
    }
    public ResponseMessage putDataValue(String key, Object value) {
        data.put(key, value);
        return this;
    }

    private ResponseMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseMessage ok() {
        return new ResponseMessage(200, "Ok");
    }
    public static  ResponseMessage passwordorusernameerror(){
        return new ResponseMessage(400,"password or sid error");
    }
    public static  ResponseMessage passwordorusernamenotnull(){
        return new ResponseMessage(400,"password or sid can not be null");
    }

    public static ResponseMessage notFound() {
        return new ResponseMessage(404, "Not Found");
    }

    public static ResponseMessage badRequest() {
        return new ResponseMessage(400, "Bad Request");
    }

    public static ResponseMessage forbidden() {
        return new ResponseMessage(403, "Forbidden");
    }

    public static ResponseMessage unauthorized() {
        return new ResponseMessage(401, "unauthorized");
    }

    public static ResponseMessage serverInternalError() {
        return new ResponseMessage(500, "Server Internal Error");
    }

    public static ResponseMessage customerError() {
        return new ResponseMessage(1001, "Customer Error");
    }

}
