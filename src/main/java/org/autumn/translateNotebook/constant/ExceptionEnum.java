package org.autumn.translateNotebook.constant;

import org.autumn.translateNotebook.exceptions.CommonException;

public enum ExceptionEnum implements CommonException {
    INTERNAL_ERROR(500, "内部服务异常"),
    NO_ACCESS(501, "无权限访问"),
    NETWORK_BUSY(600, "网络繁忙,请稍后再试"),
    IMAGE_TYPE_ERROR(601, "请上传图片"),
    MOBILE_ERROR(602, "手机号码有误，请重新输入"),
    MOBILE_CODE_ERROR(603, "验证码输入错误，请重新输入"),
    LOGIN_STATE_ERROR(604, "登录状态异常"),
    TENANT_ERROR(605, "验证错误,请重新登陆"),
    PARAMS_ERROR(100, "参数异常");

    private int code;
    private String msg;

    ExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getExceptionCode() {
        return code;
    }

    @Override
    public String getExceptionMsg() {
        return msg;
    }
}
