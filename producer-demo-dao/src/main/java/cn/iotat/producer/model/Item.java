package cn.iotat.producer.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * 数据库对应的实体类，此包下的所有类应该与数据库吻合，且一个表对应一个model
 * 注意，这个实体类必须要实现Serializable接口
 * 这个实体类的toString()方法尽量使用json格式（其实所有的toString()方法都应该以json格式输出）
 * 这里还重写了equals()和hashCode()方法，对于包含信息的类推荐实现这两个方法，
 * 且斟酌如何判断两个对象是否相等，例如此处认为itemId相等的对象则为相等的对象
 *
 * @author pang
 */
public class Item implements Serializable {
    private static final long serialVersionUID = 7031497240691638896L;
    /**
     * 对应表中的item_id字段
     */
    private long itemId;
    /**
     * 对应表中的item_name字段
     */
    private String itemName;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"itemId\":")
                .append(itemId);
        sb.append(",\"itemName\":\"")
                .append(itemName).append('\"');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getItemId() == item.getItemId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId(), getItemName());
    }
}
