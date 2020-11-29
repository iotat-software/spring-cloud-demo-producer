package cn.iotat.producer.faced.response;

import java.io.Serializable;
import java.util.Collection;

/**
 * 分页的基本返回，注意该类并不能作为{@link cn.iotat.producer.faced.response.BaseResponse}的替代
 * 而是应该作为其参数传入
 *
 * @author pang
 */
public class PageData<E> implements Serializable {
    private static final long serialVersionUID = 414202552389263186L;
    /**
     * 页长
     */
    private int pageSize;
    /**
     * 页码
     */
    private int pageNum;
    /**
     * 列表总数
     */
    private int totalCount;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 是否包含下一页
     */
    private boolean hasNext;
    /**
     * 数据集合
     */
    private Collection<E> data;

    /**
     * 生成分页数据
     *
     * @param data       数据
     * @param pageNum    页码
     * @param pageSize   页长
     * @param totalCount 数据总量
     * @return 分页数据
     */
    public static <E> PageData<E> genPageResponse(Collection<E> data, int pageNum, int pageSize, int totalCount) {
        PageData<E> pageData = new PageData<>();
        pageData.setData(data);
        pageData.setPageNum(pageNum);
        pageData.setPageSize(pageSize);
        pageData.setTotalCount(totalCount);
        int totalPage = totalCount / pageSize;
        pageData.setTotalPage(totalPage);
        boolean hasNext = pageNum < totalPage;
        pageData.setHasNext(hasNext);
        return pageData;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public Collection<E> getData() {
        return data;
    }

    public void setData(Collection<E> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"pageSize\":")
                .append(pageSize);
        sb.append(",\"pageNum\":")
                .append(pageNum);
        sb.append(",\"totalCount\":")
                .append(totalCount);
        sb.append(",\"totalPage\":")
                .append(totalPage);
        sb.append(",\"hasNext\":")
                .append(hasNext);
        sb.append(",\"data\":")
                .append(data);
        sb.append('}');
        return sb.toString();
    }
}
