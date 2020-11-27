package cn.iotat.producer.faced.response;

public enum ErrorCodeEnum {
    //=========== 参数错误(1xxx) ===========
    HAVE_NO_ID("1000","param 'id' is required")
    //=========== 内部错误(2xxx) ===========

    //=========== 网络错误(3xxx) ===========
    ;

    ErrorCodeEnum(String errCode, String errMsg) {
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    private String errMsg;

    private String errCode;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"errMsg\":\"")
                .append(errMsg).append('\"');
        sb.append(",\"errCode\":")
                .append(errCode);
        sb.append('}');
        return sb.toString();
    }
}
