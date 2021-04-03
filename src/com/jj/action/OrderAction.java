package com.jj.action;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class OrderAction {
    public abstract void execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException;
}
