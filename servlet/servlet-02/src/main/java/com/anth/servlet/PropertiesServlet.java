package com.anth.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream resource = getServletContext().getResourceAsStream("/WEB-INF/classes/com/anth/servlet/aa.properties");
        Properties prop = new Properties();
        prop.load(resource);
        System.out.println(prop.getProperty("username"));
        resp.getWriter().println(prop.getProperty("username"));
        resp.getWriter().println(prop.getProperty("password"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
