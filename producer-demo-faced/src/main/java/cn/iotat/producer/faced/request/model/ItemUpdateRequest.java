package cn.iotat.producer.faced.request.model;

import cn.iotat.producer.faced.request.BaseRequest;

/**
 * {@link cn.iotat.producer.faced.request.model.ItemAddRequest}
 * 此处新增一个更新请求是为了显示与新增请求不同
 *
 * @author pang
 */
public class ItemUpdateRequest extends BaseRequest {
    private static final long serialVersionUID = 3939699311652860980L;
    /**
     * 表单中的id
     */
    private long id;
    /**
     * 表单中的name
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
