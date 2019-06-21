package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import config.DBConnection;
import models.ZipcodeDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 읽기/쓰기가 분리가 안된 DAO
 * 추 후 서버에 배포하여 서비스를 진행하게 된다면,
 * 쓰레드 세잎 이슈를 확인해야함.
 */
public class ZipcodeDAO {

    private static ZipcodeDAO instance;
    private DBConnection conn;

    static {
        instance = new ZipcodeDAO();
    }
    private ZipcodeDAO() {
        conn = DBConnection.getInstance();
    }

    public static ZipcodeDAO getInstance() {
        return instance;
    }

   public List<ZipcodeDTO> selectByDong(String dong) {
        String sql = "select * from zipcode where dong like ?";;
        PreparedStatement pstmt = null;
        List<ZipcodeDTO> codeList = new ArrayList();
        //String address=null;
        try {
            pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setString(1, "%"+dong+"%");
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                codeList.add(new ZipcodeDTO(
                        res.getString("zipcode"),
                        res.getString("si"),
                        res.getString("gugun"),
                        res.getString("dong"),
                        res.getString("building"),""));
            }
            return codeList;


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return Collections.emptyList();



    }

    /*
    SqlSessionFactory sessionFactory = Config.getSqlSession();
    SqlSession sqlSession;

    public ZipcodeDAO() {
        sqlSession = sessionFactory.openSession(true);
    }

    public List<ZipcodeDTO> getZipcodeList(String dong) {
        List<ZipcodeDTO> zipcodeList = sqlSession.selectList("ZipcodeList.getZipcodeList", dong);
        return zipcodeList;

    }
*/
}
