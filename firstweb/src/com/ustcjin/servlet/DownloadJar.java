package com.ustcjin.servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mi on 2017/1/24.
 */
@WebServlet(name = "DownloadJar")
public class DownloadJar extends HttpServlet {
    private Logger logger = Logger.getLogger("servlet");
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info(sdf.format(new Date()) + "——download jar file...");
        response.setContentType("application/jar");
        ServletContext ctx = getServletContext();
        InputStream is = ctx.getResourceAsStream("resources/jaxb-impl.jar");
        int read = 0;
        byte[] bytes = new byte[1024];
        OutputStream os = response.getOutputStream();
        while((read = is.read(bytes)) != -1){
            os.write(bytes, 0 ,read);
        }
        os.flush();
        os.close();
    }
}
