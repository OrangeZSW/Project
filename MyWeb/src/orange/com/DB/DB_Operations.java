package orange.com.DB;

import orange.com.user.User;

import java.sql.*;
import java.util.ArrayList;

public class DB_Operations {
    private Connection conn;
    private String user = "root";
    private String password = "421232";

    private ArrayList<User> user_mesaage = new ArrayList<>();

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet logIn(String user, String password) {
        String sql = "select * from user where user='" + user + "'and password='" + password + "'";
        Statement stmt = null;
        try {
            connection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private void connection() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyWeb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", user, password);
            System.out.println("连接成功");
        }
    }
}
