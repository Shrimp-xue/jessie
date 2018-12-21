package com.jessie.common.filter;

import com.jessie.common.utils.SpringContextHolder;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter;

/**
 * @program: jessie
 * @description: 页面高速缓存过滤器
 * @author: Shrimp
 * @create: 2018-12-20 14:38
 **/
public class PageCachingFilter extends SimplePageCachingFilter {

    private CacheManager cacheManager = SpringContextHolder.getBean(CacheManager.class);

    @Override
    protected CacheManager getCacheManager() {
        return cacheManager;
    }

}