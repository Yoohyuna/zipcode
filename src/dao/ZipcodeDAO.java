package dao;


import java.util.List;
import config.Config;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class ZipcodeDAO {

    SqlSessionFactory sessionFactory = Config.getSqlSession();
    SqlSession sqlSession;

    public ZipcodeDAO() {
        sqlSession = sessionFactory.openSession(true);
    }

    public List<ZipcodeDTO> getZipcodeList(String dong) {
        List<ZipcodeDTO> zipcodeList = sqlSession.selectList("ZipcodeList.getZipcodeList", dong);
        return zipcodeList;

    }

}
