package all;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Regist {
    MyWindowListener mw;
    Frame f;
    Button but1;
    Button but2;
    Label label;
    Label label1;
    Label label2;
    TextField idText;
    TextField passwordText;

    public Regist(){
        mw = new MyWindowListener();
        this.init_Frame();
        this.init_Label();
        this.init_Button();
        this.init_TextField();
        this.addListener();
    }

    private void init_Label(){
        double width = Toolkit.getDefaultToolkit().getScreenSize().width;
        label = new Label("**管理员注册界面**");
        label1 = new Label("账号：");
        label2 = new Label("密码：");
        label.setBounds((int)width/2-75, 40, 150, 30);
        label1.setBounds(100, 110, 40, 30);
        label2.setBounds(100, 160, 40, 30);
        f.add(label);
        f.add(label1);
        f.add(label2);
    }

    private void init_Button(){
        but1 = new Button("返回登陆");
        but2 = new Button("注册");
        but1.setBounds(220, 200, 100, 30);
        but2.setBounds(100, 200, 100, 30);
        f.add(but1);
        f.add(but2);
    }

    private void init_Frame(){
        double width = Toolkit.getDefaultToolkit().getScreenSize().width;
        double height = Toolkit.getDefaultToolkit().getScreenSize().height;
        f = new Frame("管理员注册");
        f.setSize(400,300);
        f.setLocation((int)width/2-200,(int)height/2-150);
        f.setVisible(true);
        f.addWindowListener(mw);
        f.setLayout(null);
    }

    private void init_TextField(){
        idText = new TextField(6);
        passwordText = new TextField(6);
        idText.setBounds(150, 110, 180, 30);
        passwordText.setBounds(150, 160, 180, 30);
        f.add(idText);
        f.add(passwordText);
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
                Data2Packet dataPacket = new Data2Packet();
                dataPacket.setNumber(idText.getText());
                dataPacket.setPassword(passwordText.getText());
                AdminDao.addData2Packet(dataPacket);
            }
        });
    }

}
