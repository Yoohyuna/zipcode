package controllers;

import dao.ZipcodeDAO;
import models.ZipcodeDTO;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class ZipcodeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        String dong=request.getParameter("dong");
        List<ZipcodeDTO> list = ZipcodeDAO.getInstance().selectByDong(dong);

        for(ZipcodeDTO dto : list) {
            System.out.println(dto);
        }

        request.setAttribute("list", list);
       // response.sendRedirect("ZipCheck2.jsp"+ list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ZipCheck2.jsp");
        dispatcher.forward(request, response);



    }

}
