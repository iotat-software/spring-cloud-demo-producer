package cn.iotat.producer.model;

import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {
    private static final long serialVersionUID = 7031497240691638896L;
    private long itemId;
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
        return getItemId() == item.getItemId() &&
                getItemName().equals(item.getItemName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId(), getItemName());
    }
}
