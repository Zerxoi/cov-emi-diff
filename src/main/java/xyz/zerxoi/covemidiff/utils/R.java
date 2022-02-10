package xyz.zerxoi.covemidiff.utils;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class R {
    private Integer code;
    private String msg;
    private Object data;

    private R() {
    }

    public static R error() {
        return error("Internal Server Error");
    }

    public static R error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.code = code;
        r.msg = msg;
        return r;
    }

    public static R ok() {
        return ok("success");
    }

    public static R ok(String msg) {
        R r = new R();
        r.code = HttpStatus.OK.value();
        r.msg = msg;
        return r;
    }

    public R data(Object data) {
        this.data = data;
        return this;
    }
}
