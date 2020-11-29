package cn.iotat.producer.faced.request.model;

import cn.iotat.producer.faced.request.BaseRequest;

/**
 * item的表单类，注意，这个类是在cn.iotat.producer.faced.request.model包下，
 * 该包下的类为外部系统调用本系统的参数，外部系统在调用本系统时候，必须使用该包下的类作为参数进行调用
 * 由于本系统为demo系统，所以此处仅仅将变量名做了修改
 * （这里主要是强调此包下的类不一定与model类数据结构相同，真实情况是，为了不泄露数据库模型以及便于外部调用，该包下的类尽量做出更改）
 * 注意，该类同{@link cn.iotat.producer.model.Item}一样，需要以json方式重写toString方法以及实现Serializable接口
 *
 * @author pang
 */
public class ItemAddRequest extends BaseRequest {
    private static final long serialVersionUID = -7605482535729640559L;
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
