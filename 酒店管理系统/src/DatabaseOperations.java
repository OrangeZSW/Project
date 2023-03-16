import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseOperations {
    Connection conn;
    Statement stmt;
    ResultSet rs;

    //�������ݿ�
    void connectToTheDatabase() {
        String user = "root";
        String password = "421232";
        //����������
        String driver = "com.mysql.cj.jdbc.Driver";
        //URLָ��Ҫ���ʵ����ݿ���mydata
        String url = "jdbc:mysql://localhost:3306/�Ƶ����ϵͳ?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        try {
            //ע������
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("���ݿ����ӳɹ�\n");
        } catch (Exception e) {
            System.out.println("���ݿ�����ʧ��\n");
        }
    }

    //����˻�������
    boolean checkAccountAndPassword(String user, String password) {
        try {
            stmt = conn.createStatement();
            String sql = "select * from �û� where �û���='" + user + "' and ����='" + password + "';";
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

    //ע���˺�
    int registerAnAccount(String username, String name, String password, String phone) {
        try {
            stmt = conn.createStatement();
            //��֤�û���
            String sql1 = "select * from �û� where �û���='" + username + "';";
            rs = stmt.executeQuery(sql1);
            if (rs.next()) {
                //�û����ظ�
                return 1;
            }
            //��֤�绰
            String sql2 = "select * from �û� where ��ϵ�绰='" + phone + "';";
            rs = stmt.executeQuery(sql2);
            if (rs.next()) {
                //�绰�Ѱ�
                return 2;
            }
            String sql3 = " insert into �û� (�û���,����,����,��ϵ�绰) values ('" + username + "','" + name + "','" + password + "','" + phone + "'); ";
            stmt.executeUpdate(sql3);
            return 0;
        } catch (Exception e) {
            System.out.println(e);
            return 3;
        }
    }

    //��ȡʣ������δԤ������
    String getAllRooms() {
        String text = "";
        String string[] = new String[100];
        int roomTypeNumber[] = new int[100];
        string[0] = "\t" + "�ͷ����" + " \t" + "�ͷ���������" + " \t" + "��λ��" + " \t" + "�۸�" + " \t\t" + "�ͷ�����" + "\n\n";
        try {
            stmt = conn.createStatement();
            String sql1 = "select * from �ͷ� where �ͷ�״̬='false';";
            rs = stmt.executeQuery(sql1);
            int n = 1;
            while (rs.next()) {
                string[n] = "\t" + rs.getString("�ͷ����") + " \t\t";
                roomTypeNumber[n] = rs.getInt("�ͷ����ͱ��");
                n++;
            }
            n = 1;
            ResultSet rs2 = null;
            while (string[n] != null) {
                String sql2 = "select * from �ͷ����� where �ͷ����ͱ��='" + roomTypeNumber[n] + "';";
                rs2 = stmt.executeQuery(sql2);
                while (rs2.next()) {
                    string[n] = string[n] + rs2.getString("�ͷ���������") + " \t\t" + rs2.getString("��λ��") + " \t\t" + rs2.getString("�۸�") + " \t\t" + rs2.getString("�ͷ�����");
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

    //���ݷ������Ͳ���δԤ������
    String typeFindRoom(String roomtype) {
        String string = "";
        String text[] = new String[100];
        int roomTypeNumber[] = new int[100];
        int roomTypenumber = 0;
        text[0] = "\t" + "�ͷ����" + " \t" + "�ͷ���������" + " \t" + "��λ��" + " \t" + "�۸�" + " \t\t" + "�ͷ�����" + "\n\n";
        try {
            stmt = conn.createStatement();
            String sql1 = "select * from �ͷ����� where �ͷ���������='" + roomtype + "';";
            rs = stmt.executeQuery(sql1);
            if (rs.next()) {
                roomTypenumber = rs.getInt("�ͷ����ͱ��");
            }
            String sql2 = "select * from �ͷ� where �ͷ����ͱ��=" + roomTypenumber + " and �ͷ�״̬='false';";
            rs = stmt.executeQuery(sql2);
            int n = 1;
            while (rs.next()) {
                text[n] = "\t" + rs.getString("�ͷ����") + " \t\t";
                roomTypeNumber[n] = rs.getInt("�ͷ����ͱ��");
                n++;
            }
            n = 1;
            ResultSet rs2 = null;
            while (text[n] != null) {
                String sql3 = "select * from �ͷ����� where �ͷ����ͱ��='" + roomTypeNumber[n] + "';";
                rs2 = stmt.executeQuery(sql3);
                while (rs2.next()) {
                    text[n] = text[n] + rs2.getString("�ͷ���������") + " \t\t" + rs2.getString("��λ��") + " \t\t" + rs2.getString("�۸�") + " \t\t" + rs2.getString("�ͷ�����");
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

    //�����û��������û���Ԥ������
    String findAReservedRoom(String username) {
        String string = "";
        String text[] = new String[100];
        text[0] = "��ס�ͷ����" + " \t" + "��ס����" + " \t\t     " + "��������" + " \t\t    " + "Ѻ��" + " \t" + "�ܽ��" + " \n\n";
        try {
            stmt = conn.createStatement();
            String sql = "select * from �Ǽ���Ϣ where �û���='" + username + "' and �������� is null;";
            rs = stmt.executeQuery(sql);
            int n = 1;
            while (rs.next()) {
                String roomNumber = rs.getString("��ס�ͷ����");
                String indata = rs.getString("��ס����");
                String outdata = rs.getString("��������");
                String deposit = rs.getString("Ѻ��");
                String lumpSum = rs.getString("�ܽ��");
                if (roomNumber != null) {
                    text[n] = roomNumber + " \t\t\t" + indata + " \t" + outdata + " \t\t\t    " + deposit + "Ԫ" + " \t" + lumpSum + "Ԫ";
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

    //���ݷ����ѡ���Ƿ�Ԥ���÷���
    void roomNumberToChooseWhetherToBook(DatabaseOperations a, UserInterface userInterface, String number, String username, String name) {
        try {
            stmt = conn.createStatement();
            //���ж���û�и÷���
            String sql1 = "select * from �ͷ� where �ͷ����='" + number + "' and �ͷ�״̬='false';";
            rs = stmt.executeQuery(sql1);
            if (rs.next()) {
                //����еĻ���ѯ�ÿͷ��ļ۸�
                String sql2 = "select * from �ͷ����� where �ͷ����ͱ��=(select �ͷ����ͱ�� from �ͷ� where �ͷ����='" + number + "');";
                rs = stmt.executeQuery(sql2);
                if (rs.next()) {
                    int price = rs.getInt("�۸�");
                    //�Ƿ�ȷ��Ԥ���÷���
                    int n = JOptionPane.showConfirmDialog(userInterface.frame, "�÷���۸�Ϊ" + price + ",Ѻ��Ϊ50,һ����Ҫ" + (price + 50) + "Ԫ,�Ƿ�ȷ��Ԥ���÷���?", "ȷ��Ԥ��", JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_NO_OPTION) {
                        //���ȷ��Ԥ���÷��䣬���÷���״̬����Ϊtrue,���ҵǼ���Ϣ
                        String sql3 = "update �ͷ� set �ͷ�״̬='true' where �ͷ����='" + number + "';";
                        stmt.executeUpdate(sql3);
                        //�Ǽ���Ϣ
                        //��ȡ����
                        Date date = new Date();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        String dat = formatter.format(date);
                        String sql4 = "insert into �Ǽ���Ϣ (�ͻ�����,�û���,��ס�ͷ����,��ס����,Ѻ��,�ܽ��) values ('" + name + "','" + username + "','" + number + "','" + dat + "',50,'" + (price + 50) + "')";
                        stmt.executeUpdate(sql4);
                        JOptionPane.showMessageDialog(userInterface.frame, "�ɹ�Ԥ��'" + number + "'�ŷ���,�뼴ʹ����!", "ȷ��", 1);
                        userInterface.textArea.setText(a.findAReservedRoom(username));
                    }
                }
            } else {
                JOptionPane.showMessageDialog(userInterface.frame, "û�и÷����÷����ѱ�Ԥ��!", "����", 0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //���ݷ����ѡ���Ƿ��˷�
    void checkOutTheRoomNumber(DatabaseOperations a, UserInterface userInterface, String number, String username) {
        try {
            stmt = conn.createStatement();
            //�ж��Ƿ��Ѿ�Ԥ���÷���
            String sql1 = "select * from �Ǽ���Ϣ where �û���='" + username + "' and �������� is null;";
            rs = stmt.executeQuery(sql1);
            if (rs.next()) {
                //�Ƿ�ȷ���˷�
                int n = JOptionPane.showConfirmDialog(userInterface.frame, "�Ƿ�ȷ���˷�", "ȷ���˷�", JOptionPane.YES_NO_OPTION);
                //�˷�
                if (n == JOptionPane.YES_NO_OPTION) {
                    String sql2 = "update �ͷ� set �ͷ�״̬='false' where �ͷ����='" + number + "';";
                    stmt.executeUpdate(sql2);
                    JOptionPane.showMessageDialog(userInterface.frame, "�˷��ɹ�!Ѻ�𼴽��˻�,��ӭ�´ι���!", "�˷��ɹ�", 1);
                    //��ȡ����
                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    String dat = formatter.format(date);
                    //���µǼ���Ϣ
                    String sql3 = "update �Ǽ���Ϣ set ��������='" + dat + "' where ��ס�ͷ����='" + number + "';";
                    stmt.executeUpdate(sql3);
                    userInterface.textArea.setText(a.findAReservedRoom(username));
                }
            }
            //û�и÷����δԤ��
            else {
                JOptionPane.showMessageDialog(userInterface.frame, "û�и÷������δԤ��,������������!", "����", 0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // ���б�Ԥ������
    String allBookedRooms() {
        String string = "";
        String text[] = new String[100];
        String user_name[] = new String[100];
        String contact_Number[] = new String[100];
        contact_Number[0] = "";
        text[0] = "�û���" + " \t" + "��ס�ͷ����" + " \t" + "��ס����" + " \t\t     " + "Ѻ��" + " \t " + "�ܽ��" + " \t" + "��ϵ�绰" + "\n\n";
        try {
            stmt = conn.createStatement();
            String sql = "select * from �Ǽ���Ϣ where  �������� is null;";
            rs = stmt.executeQuery(sql);
            int n = 1;
            String username, roomNumber, indata, deposit, lumpSum, name;
            while (rs.next()) {
                name = rs.getString("�ͻ�����");
                username = rs.getString("�û���");
                user_name[n] = username;
                roomNumber = rs.getString("��ס�ͷ����");
                indata = rs.getString("��ס����");
                //String outdata = rs.getString("��������");
                deposit = rs.getString("Ѻ��");
                lumpSum = rs.getString("�ܽ��");
                //��ȡ���û���ϵ�绰
                if (roomNumber != null) {
                    text[n] = name + " \t" + roomNumber + " \t\t\t" + indata + " \t" + deposit + "Ԫ" + " \t " + lumpSum + "Ԫ" + " \t";
                }
                n++;
            }
            int j = 1;
            while (user_name[j] != null) {
                String sql2 = "select * from �û� where �û���='" + user_name[j] + "';";
                rs = stmt.executeQuery(sql2);
                while (rs.next()) {
                    String contactNumber = rs.getString("��ϵ�绰");
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
