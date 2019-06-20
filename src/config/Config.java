package config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Config {

    public static SqlSessionFactory sqlsession;

    static{
        try {

            String resource ="../Config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlsession = new SqlSessionFactoryBuilder().build(reader);
            reader.close();

        } catch (IOException e) {

            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }

    public static SqlSessionFactory getSqlSession(){

        return sqlsession;
    }

}






