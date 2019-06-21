package config;

import models.ZipcodeDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/yoo";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "1234";

    private static DBConnection instance;

    static {
        instance = new DBConnection();
    }

    public static DBConnection getInstance() {
        return instance;
    }
    private Connection conn = null;

    public Connection getConn() {
        try {
            conn.setAutoCommit(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this.conn;
    }

    private DBConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * DBConnection이 잘 동작하는지 체크하는 테스트 메서드
     * @param args
     */
    public static void main(String[]args) {
        Connection conn = DBConnection.getInstance().getConn();
        List<ZipcodeDTO> codeList = new ArrayList();

        PreparedStatement pstmt = null;
        String sql = "select count(*) from zipcode";
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();

            while (res.next()) {
                codeList.add(new ZipcodeDTO(
                        res.getString("zipcode"),
                        res.getString("si"),
                        res.getString("gugun"),
                        res.getString("dong"),
                        res.getString("building"),""));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        for(ZipcodeDTO dto : codeList) {
            System.out.println(dto);
        }

    }
}
