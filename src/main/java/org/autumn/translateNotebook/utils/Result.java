package org.autumn.translateNotebook.utils;

import org.autumn.translateNotebook.constant.ExceptionEnum;
import org.autumn.translateNotebook.constant.ResultConstant;
import org.autumn.translateNotebook.model.output.ResultInfo;
import org.springframework.stereotype.Component;

@Component
public class Result<T> {
    public Result() {
    }

    /**
     * @return 默认成功
     */
    public ResultInfo success() {
        ResultInfo dataInfo = new ResultInfo();
        return dataInfo;
    }

    /**
     * @param code code码
     * @return 返回code
     */
    public ResultInfo success(Integer code) {
        ResultInfo dataInfo = new ResultInfo();
        dataInfo.setCode(code);
        return dataInfo;
    }

    /**
     * @param msg 消息
     * @return 返回msg
     */
    public ResultInfo success(String msg) {
        ResultInfo dataInfo = new ResultInfo();
        dataInfo.setMsg(msg);
        return dataInfo;
    }


    /**
     * @param data
     * @return 返回结果集
     */
    public ResultInfo success(Object data) {
        ResultInfo dataInfo = new ResultInfo();
        dataInfo.setData(data);
        return dataInfo;
    }

    /**
     * @param code code码
     * @param msg  消息
     * @return 返回code 和msg
     */
    public ResultInfo success(Integer code, String msg) {
        ResultInfo dataInfo = new ResultInfo();
        dataInfo.setCode(code);
        dataInfo.setMsg(msg);
        return dataInfo;
    }


    /**
     * @param msg 消息
     * @return 返回code 和msg
     */
    public ResultInfo failed(String msg) {
        ResultInfo dataInfo = new ResultInfo();
        dataInfo.setCode(ResultConstant.FAILED_CODE);
        dataInfo.setMsg(msg);
        return dataInfo;
    }

    /**
     * @param msg 消息
     * @return 返回code 和msg
     */
    public ResultInfo failed(Integer code,String msg) {
        ResultInfo dataInfo = new ResultInfo();
        dataInfo.setCode(code);
        dataInfo.setMsg(msg);
        return dataInfo;
    }


    /**
     * @param code code
     * @param data 结果集
     * @return 返回 code   结果集
     */
    public ResultInfo success(Integer code, Object data) {
        ResultInfo dataInfo = new ResultInfo();
        dataInfo.setCode(code);
        dataInfo.setData(data);
        return dataInfo;
    }

    /**
     * @param msg  msg
     * @param data 结果集
     * @return 返回 code   结果集
     */
    public ResultInfo success(String msg, Object data) {
        ResultInfo dataInfo = new ResultInfo();
        dataInfo.setMsg(msg);
        dataInfo.setData(data);
        return dataInfo;
    }

    /**
     * @param code code
     * @param msg  msg
     * @param data 结果集
     * @return 返回 code  msg  结果集
     */
    public ResultInfo success(Integer code, String msg, Object data) {
        ResultInfo dataInfo = new ResultInfo();
        dataInfo.setCode(code);
        dataInfo.setMsg(msg);
        dataInfo.setData(data);
        return dataInfo;
    }

    /**
     * @param exceptionEnum 自定义枚举异常类型
     * @Author: BenOniShi
     * @Date: 2020/12/14 14:50
     */
    public ResultInfo filed(ExceptionEnum exceptionEnum) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(exceptionEnum.getExceptionCode());
        resultInfo.setMsg(exceptionEnum.getExceptionMsg());
        return resultInfo;
    }
}
