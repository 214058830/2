package all;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Password {
    MyWindowListener mw;
    Frame f;
    Button but1;
    Button but2;
    Label label;
    Label label1;
    Label label2;
    Label label3;
    TextField idText;
    TextField passwordText;
    TextField passwordText2;

    public Password(){
        mw = new MyWindowListener();
        this.init_Frame();
        this.init_Label();
        this.init_Button();
        this.init_TextField();
        this.addListener();
    }

    private void init_Label(){
        double width = Toolkit.getDefaultToolkit().getScreenSize().width;
        label = new Label("密码界面**");
        label1 = new Label("账号：");
        label2 = new Label("原密码：");
        label3 = new Label("新密码：");
        label.setBounds((int)width/2-75, 40, 150, 30);
        label1.setBounds(100, 100, 40, 30);
        label2.setBounds(80, 135, 70, 30);
        label3.setBounds(80,170,70,30);
        f.add(label);
        f.add(label1);
        f.add(label2);
        f.add(label3);
    }

    private void init_Button(){
        but1 = new Button("返回登陆");
        but2 = new Button("修改");
        but1.setBounds(220, 220, 100, 30);
        but2.setBounds(100, 220, 100, 30);
        f.add(but1);
        f.add(but2);
    }

    private void init_Frame(){
        double width = Toolkit.getDefaultToolkit().getScreenSize().width;
        double height = Toolkit.getDefaultToolkit().getScreenSize().height;
        f = new Frame("修改密码");
        f.setSize(400,300);
        f.setLocation((int)width/2-200,(int)height/2-150);
        f.setVisible(true);
        f.addWindowListener(mw);
        f.setLayout(null);
    }

    private void init_TextField(){
        idText = new TextField(6);
        passwordText = new TextField(6);
        passwordText2 = new TextField(6);
        idText.setBounds(150, 100, 180, 30);
        passwordText.setBounds(150, 135, 180, 30);
        passwordText2.setBounds(150, 170, 180, 30);
        f.add(idText);
        f.add(passwordText);
        f.add(passwordText2);
    }

    private void addListener(){
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new LoginInterface();
            }
        });
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i;
                ArrayList<Data2Packet> dataList = AdminDao.LandAllData();
                String[][] tbody = listArray(dataList);
                String number = idText.getText();
                for (i = 0; i < tbody.length; i++) {
                    if (tbody[i][0].equals(number)) {
                        if (tbody[i][1].equals(passwordText.getText())) {
                            updataPassword();
                            break;
                        }
                    }
                }
                if(i == tbody.length) new False();
            }
        });
    }

    public String[][] listArray(ArrayList<Data2Packet>list){
        String[][] tbody = new String[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            Data2Packet dataPacket = list.get(i);
            tbody[i][0] = dataPacket.getNumber();
            tbody[i][1] = dataPacket.getPassword();
        }
        return tbody;
    }

    public void updataPassword(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs =null;
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "UPDATE `Land` SET password = "+ passwordText2.getText()
                    +" WHERE number =" + idText.getText();
            int num = stmt.executeUpdate(sql);
            if(num > 0){
                new Success();
            }
            else{
                new False();
            }
        }catch (Exception e){
            new False();
        }finally {
            JDBCUtils.release(rs, stmt, conn);
        }
    }
    public void addDataPacket(Data2Packet dataPacket){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "INSERT INTO `Land`(number, password)"
                    + "VALUES ('" + dataPacket.getNumber() + "','"
                    + dataPacket.getPassword() + "')";
            int num = stmt.executeUpdate(sql);
            if(num > 0){
                new Success();
            }
            else new False();
        }catch (Exception e){
            new False();
        }finally {
            JDBCUtils.release(rs, stmt, conn);
        }
    }

}
