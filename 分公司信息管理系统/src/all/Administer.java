package all;

import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Administer {
    MyWindowListener mw;
    Frame f;
    Button but1;
    Button but2;
    Button but3;
    Button but4;
    Label label;
    Label label1;
    Label label2;
    Label label3;
    Label label4;
    Label label5;
    Label label6;
    TextField num;
    TextField name;
    TextField old;
    TextField money;
    TextField sex;
    JTable table;

    public Administer(){
        mw = new MyWindowListener();
        this.init_Frame();
        this.init_Label();
        this.init_Button();
        this.addListener();
        this.init_TextField();
        this.init_Table();
    }

    private void init_Table(){
        DefaultTableModel model=new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"编号","姓名","年龄","性别", "工资"});
        table=new JTable(10,5);
        f.add(table);
        table.setBounds(250, 100, 1000, 400);
        table.setBackground(Color.gray);
        table.setRowHeight(40);
        table.setEnabled(false);
    }

    private void init_TextField(){
        num =new TextField(6);
        name = new TextField(6);
        old = new TextField(6);
        money = new TextField(6);
        sex = new TextField(6);
        num.setBounds(275,560,150,40);
        name.setBounds(475, 560, 150, 40);
        old.setBounds(675, 560, 150, 40);
        sex.setBounds(875, 560, 150, 40);
        money.setBounds(1075, 560, 150, 40);

        f.add(num);
        f.add(name);
        f.add(old);
        f.add(money);
        f.add(sex);
    }

    private void init_Frame(){
        f = new Frame("信息管理界面");
        double width = Toolkit.getDefaultToolkit().getScreenSize().width;
        double height = Toolkit.getDefaultToolkit().getScreenSize().height;
        f.setSize((int)width,(int)height);
        f.setLocation(0,0);
        f.setVisible(true);
        f.addWindowListener(mw);
        f.setLayout(null);
    }

    private void init_Label(){
        double width = Toolkit.getDefaultToolkit().getScreenSize().width;
        label = new Label("XXXX公司信息管理系统");
        label1 = new Label("菜单栏");
        label2 = new Label("姓名");
        label4 = new Label("性别");
        label3 = new Label("年龄");
        label5 = new Label("工资");
        label6 = new Label("编号");
        label.setBounds((int)width/2-75, 40, 150, 30);
        label1.setBounds(100,130,150,40);
        label2.setBounds(530,515,150,40);
        label3.setBounds(730,515,150,40);
        label4.setBounds(930,515,150,40);
        label5.setBounds(1130,515,150,40);
        label6.setBounds(330,515,150,40);
        f.add(label);
        f.add(label1);
        f.add(label2);
        f.add(label3);
        f.add(label4);
        f.add(label5);
        f.add(label6);
    }

    private void init_Button(){
        but1 = new Button("查询");
        but2 = new Button("删除");
        but3 = new Button("修改");
        but4 = new Button("增加");
        but1.setBounds(50, 175, 150, 40);
        but2.setBounds(50, 255, 150, 40);
        but3.setBounds(50, 335, 150, 40);
        but4.setBounds(50, 415, 150, 40);
        f.add(but1);
        f.add(but2);
        f.add(but3);
        f.add(but4);
    }

    private void addListener(){
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queryItem();
            }
        });
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delItem();
            }
        });
        but3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updataItem();
            }
        });
        but4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });
    }

    public void queryItem(){
        ArrayList<DataPacket> dataList;
        String n = num.getText();
        String[] thead = {"编号","姓名","年龄","性别", "工资"};
        if(num.getText().length() == 0){
            dataList = AdminDao.queryAllData();
        }
        else {
            dataList = AdminDao.queryNumData(n);
        }
        String[][] tbody = list2Array(dataList);
        TableModel dataModel = new DefaultTableModel(tbody, thead);
        table.setModel(dataModel);
    }
    public String[][] list2Array(ArrayList<DataPacket>list){
        String[][] tbody = new String[list.size()][5];
        for(int i = 0; i < list.size(); i++){
            DataPacket dataPacket = list.get(i);
            tbody[i][0] = dataPacket.getNum();
            tbody[i][1] = dataPacket.getName();
            tbody[i][2] = dataPacket.getOld();
            tbody[i][3] = dataPacket.getSex();
            tbody[i][4] = dataPacket.getmoney();
        }
        return tbody;
    }

    public void addItem(){
        DataPacket dataPacket = new DataPacket();
        dataPacket.setNum(num.getText());
        dataPacket.setName(name.getText());
        dataPacket.setOld(old.getText());
        dataPacket.setSex(sex.getText());
        dataPacket.setMoney(money.getText());
        AdminDao.addDataPacket(dataPacket);
    }

    public void delItem(){
        String delNumber = num.getText();
        AdminDao.delDataPacket(delNumber);
    }

    public void updataItem(){
        DataPacket dataPacket = new DataPacket();
        dataPacket.setNum(num.getText());
        dataPacket.setName(name.getText());
        dataPacket.setOld(old.getText());
        dataPacket.setSex(sex.getText());
        dataPacket.setMoney(money.getText());
        AdminDao.ModifyDataPacket(dataPacket);
    }

}
