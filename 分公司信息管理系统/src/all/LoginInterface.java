package all;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LoginInterface {
    MyWindowListener mw;
    Frame f;
    Button but1;
    Button but2;
    Button but3;
    Label label;
    Label label1;
    Label label2;
    TextField idText;
    JPasswordField passwordText;

    public LoginInterface(){
        mw = new MyWindowListener();
        this.init_Frame();
        this.init_Button();
        this.init_Label();
        this.init_TextField();
        this.addListener();
    }

    private void init_Frame(){
        double width = Toolkit.getDefaultToolkit().getScreenSize().width;
        double height = Toolkit.getDefaultToolkit().getScreenSize().height;
        f = new Frame("登陆界面");
        f.setSize(400,300);
        f.setLocation((int)width/2-200,(int)height/2-150);
        f.addWindowListener(mw);
        f.setLayout(null);
        f.setVisible(true);
    }

    private void init_Button(){
        but1 = new Button("登陆");
        but2 = new Button("注册新用户");
        but3 = new Button("修改密码");
        but1.setBounds(100, 200, 100, 30);
        but2.setBounds(200, 200, 100, 30);
        but3.setBounds(300, 150, 80, 30);
        f.add(but1);
        f.add(but2);
        f.add(but3);
    }

    private void init_Label(){
        label = new Label("**分公司信息管理系统**");
        label1 = new Label("账号：");
        label2 = new Label("密码：");
        label.setBounds(120, 80, 150, 30);
        label1.setBounds(80, 120, 40, 30);
        label2.setBounds(80, 150, 40, 30);
        f.add(label);
        f.add(label1);
        f.add(label2);
    }

    private void init_TextField(){
        idText = new TextField(6);
        passwordText = new JPasswordField(6);
        idText.setBounds(120, 120, 180, 30);
        passwordText.setBounds(120, 150, 180, 30);
        f.add(idText);
        f.add(passwordText);
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

    private void addListener(){
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    ArrayList<Data2Packet> dataList = AdminDao.LandAllData();
                    String[][] tbody = listArray(dataList);
                    String number = idText.getText();
                    int i;
                    for (i = 0; i < tbody.length; i++) {
                        if (tbody[i][0].equals(number)) {
                            if (tbody[i][1].equals(passwordText.getText())) {
                                f.dispose();
                                new Administer();
                                break;
                            }
                        }
                    }
                    if(i == tbody.length)  new FalsePassword();
            }
        });
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Regist();
            }
        });
        but3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Password();
            }
        });
    }

}
