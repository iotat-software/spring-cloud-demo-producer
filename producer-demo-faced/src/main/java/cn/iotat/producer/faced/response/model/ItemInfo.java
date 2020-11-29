package cn.iotat.producer.faced.response.model;

import cn.iotat.producer.faced.request.model.ItemAddRequest;

import java.io.Serializable;

/**
 * item信息类，这里主要是用于区分DAO层的model类，该包下的类均为向其他系统或向C端提供的类
 * 更多信息参考{@link ItemAddRequest}
 *
 * @author pang
 */
public class ItemInfo implements Serializable {
    private static final long serialVersionUID = -7058865937293412516L;
    /**
     * itemId
     */
    private long id;
    /**
     * itemName
     */
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
