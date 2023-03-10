package com.anth.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 让浏览器 每五秒刷新一次
        resp.setHeader("refresh","3");
        // 在内存中创建图片
        BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        // 得到图片
        Graphics2D g = (Graphics2D) image.getGraphics();
        // 设置背景颜色
        g.setColor(Color.white);
        g.fillRect(0,0,100,20);
        // 给数据
        g.setColor(Color.blue);
        g.setFont(new Font("宋体",Font.BOLD,20));
        g.drawString(makeNum(),0,20);

        //告诉浏览器 ，这个请求用图片的方式打开
        resp.setContentType("image/png");
        //网站存在缓存，不让浏览器缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("pragma","no-cache");

        // 把图片写给浏览器
        ImageIO.write(image,"png",resp.getOutputStream());
    }

    // 生成随机数
    private String makeNum(){
        String s = new Random().nextInt(9999999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 7-s.length(); i++) {
            sb.append(0);
        }
        s = sb.toString() + s;
        return s;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}


