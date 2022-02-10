package xyz.zerxoi.covemidiff.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import xyz.zerxoi.covemidiff.vo.PageVo;
import xyz.zerxoi.covemidiff.xss.SQLFilter;

public class Query<T> {

    public IPage<T> getPage(PageVo pageVo) {
        return getPage(pageVo, null, false);
    }

    public IPage<T> getPage(PageVo pageVo, String defaultOrderField, boolean isAsc) {
        //分页参数
        long curPage = pageVo.getPage() != null ? pageVo.getPage() : 1;
        long size = pageVo.getSize() != null ? pageVo.getSize() : 10;

        //分页对象
        Page<T> page = new Page<>(curPage, size);

        //排序字段
        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String orderField = SQLFilter.sqlInject(pageVo.getSidx());

        //前端字段排序
        if (StringUtils.isNotEmpty(orderField)) {
            if (pageVo.isAsc()) {
                return page.addOrder(OrderItem.asc(orderField));
            } else {
                return page.addOrder(OrderItem.desc(orderField));
            }
        }

        //没有排序字段，则不排序
        if (StringUtils.isBlank(defaultOrderField)) {
            return page;
        }

        //默认排序
        if (isAsc) {
            page.addOrder(OrderItem.asc(defaultOrderField));
        } else {
            page.addOrder(OrderItem.desc(defaultOrderField));
        }

        return page;
    }
}