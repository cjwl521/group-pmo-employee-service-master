package com.chinasoft.employee.util;

import com.github.pagehelper.PageInfo;
/**
 * 框架 pageinfo 转化为 prdPageinfo Object
 * @author wang
 *
 */
public class PageInfoConvertPrdPageInfoUtil {
    
    
    
    public static <T> PrdPageInfo<T> convert(PageInfo<T> source){
        if(source == null){
            return null;
        }
        PrdPageInfo<T> target = new PrdPageInfo<>();
        target.setList(source.getList());
        target.setPage(source.getPageNum());
        target.setPagesize(source.getPageSize());
        target.setPages(source.getPages());
        target.setTotal(source.getTotal());
        return target;
        
    }
    
}
