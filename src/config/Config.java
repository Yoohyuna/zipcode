package config;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;

import javax.servlet.ServletContext;
import javax.sql.DataSource;


public class Config {

    private static SqlSessionFactory sqlSession;

    private static final String CONFIGURE_FILE = "WEB-INF/config.xml";


    public static SqlSessionFactory getSqlSession(ServletContext context){
        if (Objects.nonNull(sqlSession)) {

            return sqlSession;
        }
        /*DataSource dataSource =
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
*/
        try {
            if (Objects.isNull(sqlSession)) {
                Reader reader = new InputStreamReader(context.getResource(CONFIGURE_FILE).openStream());
                sqlSession = new SqlSessionFactoryBuilder().build(reader);

                reader.close();
                return sqlSession;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}






