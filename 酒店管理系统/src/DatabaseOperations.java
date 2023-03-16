import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseOperations {
    Connection conn;
    Statement stmt;
    ResultSet rs;

    //连接数据库
    void connectToTheDatabase() {
        String user = "root";
        String password = "421232";
        //驱动程序名
        String driver = "com.mysql.cj.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/酒店管理系统?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        try {
            //注册驱动
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("数据库连接成功\n");
        } catch (Exception e) {
            System.out.println("数据库连接失败\n");
        }
    }

    //检查账户和密码
    boolean checkAccountAndPassword(String user, String password) {
        try {
            stmt = conn.createStatement();
            String sql = "select * from 用户 where 用户名='" + user + "' and 密码='" + password + "';";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    //注册账号
    int registerAnAccount(String username, String name, String password, String phone) {
        try {
            stmt = conn.createStatement();
            //验证用户名
            String sql1 = "select * from 用户 where 用户名='" + username + "';";
            rs = stmt.executeQuery(sql1);
            if (rs.next()) {
                //用户名重复
                return 1;
            }
            //验证电话
            String sql2 = "select * from 用户 where 联系电话='" + phone + "';";
            rs = stmt.executeQuery(sql2);
            if (rs.next()) {
                //电话已绑定
                return 2;
            }
            String sql3 = " insert into 用户 (用户名,姓名,密码,联系电话) values ('" + username + "','" + name + "','" + password + "','" + phone + "'); ";
            stmt.executeUpdate(sql3);
            return 0;
        } catch (Exception e) {
            System.out.println(e);
            return 3;
        }
    }

    //获取剩余所有未预定房间
    String getAllRooms() {
        String text = "";
        String string[] = new String[100];
        int roomTypeNumber[] = new int[100];
        string[0] = "\t" + "客房编号" + " \t" + "客房类型名称" + " \t" + "床位数" + " \t" + "价格" + " \t\t" + "客房描述" + "\n\n";
        try {
            stmt = conn.createStatement();
            String sql1 = "select * from 客房 where 客房状态='false';";
            rs = stmt.executeQuery(sql1);
            int n = 1;
            while (rs.next()) {
                string[n] = "\t" + rs.getString("客房编号") + " \t\t";
                roomTypeNumber[n] = rs.getInt("客房类型编号");
                n++;
            }
            n = 1;
            ResultSet rs2 = null;
            while (string[n] != null) {
                String sql2 = "select * from 客房类型 where 客房类型编号='" + roomTypeNumber[n] + "';";
                rs2 = stmt.executeQuery(sql2);
                while (rs2.next()) {
                    string[n] = string[n] + rs2.getString("客房类型名称") + " \t\t" + rs2.getString("床位数") + " \t\t" + rs2.getString("价格") + " \t\t" + rs2.getString("客房描述");
                }
                n++;
            }
            for (int i = 0; string[i] != null; i++) {
                text = text + string[i] + "\n";
            }
            return text;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //根据房间类型查找未预定房间
    String typeFindRoom(String roomtype) {
        String string = "";
        String text[] = new String[100];
        int roomTypeNumber[] = new int[100];
        int roomTypenumber = 0;
        text[0] = "\t" + "客房编号" + " \t" + "客房类型名称" + " \t" + "床位数" + " \t" + "价格" + " \t\t" + "客房描述" + "\n\n";
        try {
            stmt = conn.createStatement();
            String sql1 = "select * from 客房类型 where 客房类型名称='" + roomtype + "';";
            rs = stmt.executeQuery(sql1);
            if (rs.next()) {
                roomTypenumber = rs.getInt("客房类型编号");
            }
            String sql2 = "select * from 客房 where 客房类型编号=" + roomTypenumber + " and 客房状态='false';";
            rs = stmt.executeQuery(sql2);
            int n = 1;
            while (rs.next()) {
                text[n] = "\t" + rs.getString("客房编号") + " \t\t";
                roomTypeNumber[n] = rs.getInt("客房类型编号");
                n++;
            }
            n = 1;
            ResultSet rs2 = null;
            while (text[n] != null) {
                String sql3 = "select * from 客房类型 where 客房类型编号='" + roomTypeNumber[n] + "';";
                rs2 = stmt.executeQuery(sql3);
                while (rs2.next()) {
                    text[n] = text[n] + rs2.getString("客房类型名称") + " \t\t" + rs2.getString("床位数") + " \t\t" + rs2.getString("价格") + " \t\t" + rs2.getString("客房描述");
                }
                n++;
            }
            for (int i = 0; text[i] != null; i++) {
                string = string + text[i] + "\n";
            }
            return string;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //根据用户名查找用户已预定房间
    String findAReservedRoom(String username) {
        String string = "";
        String text[] = new String[100];
        text[0] = "入住客房编号" + " \t" + "入住日期" + " \t\t     " + "结账日期" + " \t\t    " + "押金" + " \t" + "总金额" + " \n\n";
        try {
            stmt = conn.createStatement();
            String sql = "select * from 登记信息 where 用户名='" + username + "' and 结账日期 is null;";
            rs = stmt.executeQuery(sql);
            int n = 1;
            while (rs.next()) {
                String roomNumber = rs.getString("入住客房编号");
                String indata = rs.getString("入住日期");
                String outdata = rs.getString("结账日期");
                String deposit = rs.getString("押金");
                String lumpSum = rs.getString("总金额");
                if (roomNumber != null) {
                    text[n] = roomNumber + " \t\t\t" + indata + " \t" + outdata + " \t\t\t    " + deposit + "元" + " \t" + lumpSum + "元";
                }
                n++;
            }
            for (int i = 0; text[i] != null; i++) {
                string = string + text[i] + "\n";
            }
            return string;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //根据房间号选择是否预定该房间
    void roomNumberToChooseWhetherToBook(DatabaseOperations a, UserInterface userInterface, String number, String username, String name) {
        try {
            stmt = conn.createStatement();
            //先判断有没有该房间
            String sql1 = "select * from 客房 where 客房编号='" + number + "' and 客房状态='false';";
            rs = stmt.executeQuery(sql1);
            if (rs.next()) {
                //如果有的话查询该客房的价格
                String sql2 = "select * from 客房类型 where 客房类型编号=(select 客房类型编号 from 客房 where 客房编号='" + number + "');";
                rs = stmt.executeQuery(sql2);
                if (rs.next()) {
                    int price = rs.getInt("价格");
                    //是否确定预定该房间
                    int n = JOptionPane.showConfirmDialog(userInterface.frame, "该房间价格为" + price + ",押金为50,一共需要" + (price + 50) + "元,是否确定预定该房间?", "确认预定", JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_NO_OPTION) {
                        //如果确认预定该房间，将该房间状态设置为true,并且登记信息
                        String sql3 = "update 客房 set 客房状态='true' where 客房编号='" + number + "';";
                        stmt.executeUpdate(sql3);
                        //登记信息
                        //获取日期
                        Date date = new Date();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        String dat = formatter.format(date);
                        String sql4 = "insert into 登记信息 (客户姓名,用户名,入住客房编号,入住日期,押金,总金额) values ('" + name + "','" + username + "','" + number + "','" + dat + "',50,'" + (price + 50) + "')";
                        stmt.executeUpdate(sql4);
                        JOptionPane.showMessageDialog(userInterface.frame, "成功预定'" + number + "'号房间,请即使付款!", "确认", 1);
                        userInterface.textArea.setText(a.findAReservedRoom(username));
                    }
                }
            } else {
                JOptionPane.showMessageDialog(userInterface.frame, "没有该房间或该房间已被预定!", "错误", 0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //根据房间号选择是否退房
    void checkOutTheRoomNumber(DatabaseOperations a, UserInterface userInterface, String number, String username) {
        try {
            stmt = conn.createStatement();
            //判断是否已经预定该房间
            String sql1 = "select * from 登记信息 where 用户名='" + username + "' and 结账日期 is null;";
            rs = stmt.executeQuery(sql1);
            if (rs.next()) {
                //是否确定退房
                int n = JOptionPane.showConfirmDialog(userInterface.frame, "是否确定退房", "确认退房", JOptionPane.YES_NO_OPTION);
                //退房
                if (n == JOptionPane.YES_NO_OPTION) {
                    String sql2 = "update 客房 set 客房状态='false' where 客房编号='" + number + "';";
                    stmt.executeUpdate(sql2);
                    JOptionPane.showMessageDialog(userInterface.frame, "退房成功!押金即将退还,欢迎下次光临!", "退房成功", 1);
                    //获取日期
                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    String dat = formatter.format(date);
                    //更新登记信息
                    String sql3 = "update 登记信息 set 结账日期='" + dat + "' where 入住客房编号='" + number + "';";
                    stmt.executeUpdate(sql3);
                    userInterface.textArea.setText(a.findAReservedRoom(username));
                }
            }
            //没有该房间或未预定
            else {
                JOptionPane.showMessageDialog(userInterface.frame, "没有该房间或您未预定,请您重新输入!", "错误", 0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 所有被预定房间
    String allBookedRooms() {
        String string = "";
        String text[] = new String[100];
        String user_name[] = new String[100];
        String contact_Number[] = new String[100];
        contact_Number[0] = "";
        text[0] = "用户名" + " \t" + "入住客房编号" + " \t" + "入住日期" + " \t\t     " + "押金" + " \t " + "总金额" + " \t" + "联系电话" + "\n\n";
        try {
            stmt = conn.createStatement();
            String sql = "select * from 登记信息 where  结账日期 is null;";
            rs = stmt.executeQuery(sql);
            int n = 1;
            String username, roomNumber, indata, deposit, lumpSum, name;
            while (rs.next()) {
                name = rs.getString("客户姓名");
                username = rs.getString("用户名");
                user_name[n] = username;
                roomNumber = rs.getString("入住客房编号");
                indata = rs.getString("入住日期");
                //String outdata = rs.getString("结账日期");
                deposit = rs.getString("押金");
                lumpSum = rs.getString("总金额");
                //获取该用户联系电话
                if (roomNumber != null) {
                    text[n] = name + " \t" + roomNumber + " \t\t\t" + indata + " \t" + deposit + "元" + " \t " + lumpSum + "元" + " \t";
                }
                n++;
            }
            int j = 1;
            while (user_name[j] != null) {
                String sql2 = "select * from 用户 where 用户名='" + user_name[j] + "';";
                rs = stmt.executeQuery(sql2);
                while (rs.next()) {
                    String contactNumber = rs.getString("联系电话");
                    contact_Number[j] = contactNumber;
                    j++;
                }
            }
            for (int i = 0; text[i] != null; i++) {
                string = string + text[i] + contact_Number[i] + "\n";
            }
            return string;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
