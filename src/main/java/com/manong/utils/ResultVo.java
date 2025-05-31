package com.manong.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一结果返回类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVo<T> {
    private int code; // 状态码
    private String msg; // 消息
    private T data; // 数据

    public static <T> ResultVo<T> success(String msg, T data) {
        return new ResultVo<>(200, msg, data);
    }

    public static <T> ResultVo<T> success(String msg) {
        return new ResultVo<>(200, msg, null);
    }

    public static <T> ResultVo<T> fail(String msg, T data) {
        return new ResultVo<>(500, msg, data);
    }

    public static <T> ResultVo<T> fail(String msg) {
        return new ResultVo<>(500, msg, null);
    }
}