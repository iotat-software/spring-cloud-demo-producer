package cn.iotat.producer.faced.response;

import java.io.Serializable;

/**
 * 基础响应类
 *
 * @author Pang
 * @date 2020/10/13
 */
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = -6483908989592039115L;
    /**
     * 数据
     */
    private T data;
    /**
     * 错误码
     */
    private String errCode;
    /**
     * 错误提示信息
     */
    private String errMsg;
    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 成功返回
     *
     * @param data 数据
     * @param <E>  数据类型
     * @return 结果
     */
    public static <E> BaseResponse<E> success(E data) {
        BaseResponse<E> response = new BaseResponse<>();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    /**
     * 错误返回
     *
     * @param errorCode 返回错误码枚举
     * @return 结果
     */
    public static <E> BaseResponse<E> error(ErrorCodeEnum errorCode) {
        BaseResponse<E> response = new BaseResponse<>();
        response.setSuccess(false);
        response.setErrCode(errorCode.getErrCode());
        response.setErrMsg(errorCode.getErrMsg());
        return response;
    }

    /**
     * 错误返回，自定义错误信息
     *
     * @param errorCode 返回错误码枚举
     * @param errMsg    错误信息
     * @return 结果
     */
    public static <E> BaseResponse<E> error(ErrorCodeEnum errorCode, String errMsg) {
        BaseResponse<E> response = new BaseResponse<>();
        response.setSuccess(false);
        response.setErrCode(errorCode.getErrCode());
        response.setErrMsg(errMsg);
        return response;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"data\":")
                .append(data);
        sb.append(",\"errCode\":\"")
                .append(errCode).append('\"');
        sb.append(",\"errMsg\":\"")
                .append(errMsg).append('\"');
        sb.append(",\"success\":")
                .append(success);
        sb.append('}');
        return sb.toString();
    }
}
