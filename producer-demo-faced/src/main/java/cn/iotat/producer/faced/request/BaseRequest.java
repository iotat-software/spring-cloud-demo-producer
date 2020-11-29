package cn.iotat.producer.faced.request;

import java.io.Serializable;

/**
 * 基础请求，该类包含一些请求的公共属性
 * 注意，所有非GET的方法均需要以该类为参数
 *
 * @author Pang
 */
public abstract class BaseRequest implements Serializable {
    private static final long serialVersionUID = -587145464732137914L;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append('}');
        return sb.toString();
    }
}
