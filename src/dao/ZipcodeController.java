package dao;

import config.Config;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ZipcodeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException{


        request.setCharacterEncoding("UTF-8");
        ZipcodeDTO dto = new ZipcodeDTO();

        dto.setZipcode(request.getParameter("zipcode"));
        dto.setSi(request.getParameter("si"));
        dto.setGugun(request.getParameter("gugun"));
        dto.setDong(request.getParameter("dong"));
        dto.setBuilding(request.getParameter("building"));

        SqlSessionFactory sqlMapper = Config.getSqlSession();

        SqlSession sqlSession = sqlMapper.openSession();

        sqlSession.selectList("getZipcodeList",dto);
        sqlSession.commit();
        //response.sendRedirect("list.my");


    }

}
