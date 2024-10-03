package com.study.hello.distributed.mybatis.framework.commons.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.study.hello.distributed.mybatis.framework.commons.api.page.ApiOrderItem;
import com.study.hello.distributed.mybatis.framework.commons.api.page.IApiPage;
import com.study.hello.distributed.mybatis.framework.commons.util.JsonUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
@ApiModel
@NoArgsConstructor
@JsonPropertyOrder({"pageNumber", "pageSize", "pageCount", "totalCount", "prev", "next", "records"})
public class ApiPage<T> extends ApiObject implements IApiPage<T> {
    private static final long serialVersionUID = 1L;

    private List<T> records = Collections.emptyList();

    @JsonIgnore
    private long total = 0;

    @JsonIgnore
    private long size = 10;

    @JsonIgnore
    private long current = 1;

    @JsonIgnore
    private List<ApiOrderItem> orders = new ArrayList<>();

    /**
     * 自动优化 count sql
     */
    @JsonIgnore
    private boolean optimizeCountSql = true;

    /**
     * 是否进行 count 查询
     */
    @JsonIgnore
    private boolean searchCount = true;


    /**
     * 将 IPage 对象转换为 ApiPage 对象
     *
     * @param <A>
     * @param <B>
     * @param page
     * @param func
     * @return
     */
    public static <A, B> ApiPage<B> to(IApiPage<A> page, Function<A, B> func) {
        ApiPage<B> api = new ApiPage<>();
        api.setRecords(page.getRecords().stream().map(func).collect(Collectors.toList()));
        return getPage(page, api);
    }

    /**
     * 将 IPage 对象转换为 ApiPage 对象
     *
     * @param <A>
     * @param <B>
     * @param page
     * @param typeClass
     * @return
     */
    public static <A, B> ApiPage<B> to(IApiPage<A> page, Class<B> typeClass) {
        ApiPage<B> api = new ApiPage<>();
        api.setRecords(page.getRecords().stream().map(record -> JsonUtils.convertValue(record, typeClass)).collect(Collectors.toList()));
        return getPage(page, api);
    }

    private static <A, B> ApiPage<B> getPage(IApiPage<A> page, ApiPage<B> api) {
        api.setCurrent(page.getCurrent());
        api.setSize(page.getSize());
        api.setPages(page.getPages());
        api.setOptimizeCountSql(page.optimizeCountSql());
        api.setOrders(page.orders());
        api.setTotal(page.getTotal());
        api.setSearchCount(page.searchCount());
        return api;
    }

    /**
     * @param <E>
     * @return 返回一个懒查询分页
     */
    public static <E> ApiPage<E> lazy(List<E> items) {
        ApiPage<E> api = new ApiPage<>();
        api.setSearchCount(false); // 指示实际并没有查询总条数
        if (CollectionUtils.isNotEmpty(items)) {
            api.setRecords(items);
            api.setTotalCount(items.size());
            api.setPageSize(items.size());
            api.setPageNumber(1);
        }
        return api;
    }

    /**
     * @param <E>
     * @return 返回一个空对象
     */
    public static <E> ApiPage<E> empty() {
        return new ApiPage<>();
    }

    @ApiModelProperty(value = "当前页码（从1开始）", example = "1", position = 10, required = true)
    public final int getPageNumber() {
        return (int) getCurrent();
    }

    /**
     * @param pageNumber
     */
    public void setPageNumber(int pageNumber) {
        setCurrent(pageNumber);
    }

    @ApiModelProperty(value = "页面大小（每页记录的数量，默认10）", example = "10", position = 20, required = true)
    public final int getPageSize() {
        return (int) getSize();
    }

    /**
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        setSize(pageSize);
    }

    @ApiModelProperty(value = "页面数量", example = "10", position = 30, required = true)
    public final int getPageCount() {
        return (int) getPages();
    }

    /**
     * @param pageCount
     */
    public void setPageCount(int pageCount) {
        // dummy
    }

    public final long getTotal() {
        return this.total;
    }

    @ApiModelProperty(value = "总记录数量", example = "100", position = 40, required = true)
    public final int getTotalCount() {
        return (int) getTotal();
    }

    /**
     * @param totalCount
     */
    public void setTotalCount(int totalCount) {
        setTotal(totalCount);
    }

    @ApiModelProperty(value = "是否有上一页", example = "false", position = 50, required = true)
    public final boolean getPrev() {
        return hasPrevious();
    }

    /**
     * @param prev
     */
    public void setPrev(boolean prev) {
        // dummy
    }

    @ApiModelProperty(value = "是否有下一页", example = "true", position = 60, required = true)
    public final boolean getNext() {
        return hasNext();
    }

    /**
     * @param next
     */
    public void setNext(boolean next) {
        // dummy
    }

    @Override
    @ApiModelProperty(value = "记录列表", position = 70, required = true)
    public List<T> getRecords() {
        return this.records;
    }

    public boolean hasPrevious() {
        return this.current > 1;
    }

    public boolean hasNext() {
        return this.current < this.getPages();
    }


    @Override
    public long getSize() {
        return this.size;
    }


    @Override
    public long getCurrent() {
        return this.current;
    }


    @JsonIgnore
    @Override // hide from swagger
    public long getPages() {
        return IApiPage.super.getPages();
    }


    @Override
    public List<ApiOrderItem> orders() {
        return getOrders();
    }

    public List<ApiOrderItem> getOrders() {
        return orders;
    }

    public void setOrders(List<ApiOrderItem> orders) {
        this.orders = orders;
    }

    @Override
    public boolean optimizeCountSql() {
        return optimizeCountSql;
    }

    @Override
    @JsonIgnore
    public boolean searchCount() {
        return isSearchCount();
    }

    public boolean isSearchCount() {
        if (total < 0) {
            return false;
        }
        return searchCount;
    }

    @Override
    public ApiPage<T> setSize(long size) {
        this.size = size;
        return this;
    }

    @Override
    public ApiPage<T> setCurrent(long current) {
        this.current = current;
        return this;
    }

    @Override
    public ApiPage<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

    @Override
    public ApiPage<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    public ApiPage<T> addOrder(ApiOrderItem... items) {
        orders.addAll(Arrays.asList(items));
        return this;
    }

    public ApiPage<T> addOrder(List<ApiOrderItem> items) {
        orders.addAll(items);
        return this;
    }

    public ApiPage<T> setSearchCount(boolean searchCount) {
        this.searchCount = searchCount;
        return this;
    }

    public ApiPage<T> setOptimizeCountSql(boolean optimizeCountSql) {
        this.optimizeCountSql = optimizeCountSql;
        return this;
    }

}
