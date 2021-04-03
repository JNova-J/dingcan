package com.jj.filter;

import com.jj.utils.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JDBCUtils.commitAndClose();
        }catch (Exception e){
            JDBCUtils.rollback();//回滚事务
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {

    }
}
