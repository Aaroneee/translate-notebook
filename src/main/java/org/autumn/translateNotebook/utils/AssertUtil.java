package org.autumn.translateNotebook.utils;

import org.autumn.translateNotebook.constant.ExceptionEnum;
import org.autumn.translateNotebook.exceptions.ParamsException;

public class AssertUtil {


    /**
     * @param flag flag是真，抛出异常
     * @param msg  抛出的异常消息
     */
    public static void isTrue(boolean flag, String msg) {
        if (flag) {
            throw new ParamsException(msg);
        }

    }

    /**
     * @param msg 抛出异常 返回异常信息
     */
    public static void isTrue(String msg) {
        throw new ParamsException(msg);
    }

    /**
     * @param flag flag是真，抛出异常
     * @param code 异常的code码
     * @param msg  异常的消息
     */
    public static void isTrue(boolean flag, Integer code, String msg) {
        if (flag) {
            throw new ParamsException(code, msg);
        }

    }

    /**
     * @param flag          flag是真，抛出异常
     * @param exceptionEnum 自定义异常枚举分类
     */
    public static void isTrue(boolean flag, ExceptionEnum exceptionEnum) {
        if (flag) {
            throw new ParamsException(exceptionEnum.getExceptionCode(), exceptionEnum.getExceptionMsg());
        }
    }

    /**
     * @param exceptionEnum flag是真，抛出异常
     */
    public static void isTrue(ExceptionEnum exceptionEnum) {
        throw new ParamsException(exceptionEnum.getExceptionCode(), exceptionEnum.getExceptionMsg());
    }

}
