import javax.swing.*;

import java.util.*;

import java.awt.Color;
import java.awt.event.*;

public class AddStuPanel extends JPanel implements ActionListener{

	JLabel numLabel;
	JLabel nameLabel;
	JLabel sexLabel;
	JTextField numText;
	JTextField nameText;
	JComboBox sexCom;
	JButton addBt;
	JScrollPane scrollpane;
	JTable table;//展示学生信息的表格

	public AddStuPanel()
	{
		this.setLayout(null);
		this.setSize(455,320);
		this.setBackground(Color.lightGray);
		this.init();
		this.refreshTable();
		this.setVisible(true);
	}

	private void init()
	{
		numLabel=new JLabel("请输入学号");
		numLabel.setSize(90,30);
		numLabel.setLocation(30, 20);
		this.add(numLabel);
		numText=new JTextField();
		numText.setSize(120,30);
		numText.setLocation(140, 20);
		this.add(numText);
		nameLabel=new JLabel("请输入姓名");
		nameLabel.setSize(90,30);
		nameLabel.setLocation(30, 60);
		this.add(nameLabel);
		nameText=new JTextField();
		nameText.setSize(120,30);
		nameText.setLocation(140, 60);
		this.add(nameText);
		sexLabel=new JLabel("请选择性别");
		sexLabel.setSize(90,30);
		sexLabel.setLocation(30, 100);
		this.add(sexLabel);
		sexCom=new JComboBox();
		sexCom.setSize(120,30);
		sexCom.setLocation(140, 100);
		sexCom.addItem("男");
		sexCom.addItem("女");
		this.add(sexCom);
		addBt=new JButton("添加");
		addBt.setSize(80,30);
		addBt.setLocation(300, 100);
		addBt.addActionListener(this);
		this.add(addBt);
	}

	private void refreshTable()
	{
		String[] titles={"学号","姓名","性别"};
		StudentDAO dao=new StudentDAO();
		ArrayList<String> stus=dao.findAllStudents();
		Object[][] objs=new Object[stus.size()][3];
		for(int i=0;i<stus.size();i++)
		{
			String[] strs=stus.get(i).split(",");
			objs[i][0]=strs[0];
			objs[i][1]=strs[1];
			objs[i][2]=strs[2];
			System.out.println(strs[0]);
		}
		this.removeAll();
		this.init();
		table=new JTable(objs,titles);
		table.setSize(380,150);
		scrollpane = new JScrollPane(table);
		scrollpane.setLocation(20, 150);
		scrollpane.setSize(400, 150);
		this.add(scrollpane);
	}

	public void actionPerformed(ActionEvent e) {
		if(!checkIsNull())//如果用户输入为空的话
		{
			JOptionPane.showMessageDialog(this, "学号或姓名输入为空");
		}
		else
		{
			if(!checkInput().equals(""))
			{
				JOptionPane.showMessageDialog(this,checkInput());
			}
			else
			{
				StudentDAO dao=new StudentDAO();
				//创建一个操作学生信息文本文件的对象
				StringBuffer stuInfo=new StringBuffer();
				stuInfo.append(numText.getText().trim()+",");
				stuInfo.append(nameText.getText().trim()+",");
				stuInfo.append(sexCom.getSelectedItem());
				if(dao.addStudent(stuInfo.toString()))
				{
					JOptionPane.showMessageDialog(this,"添加学生记录成功");
					numText.setText("");
					nameText.setText("");
					refreshTable();
					//添加成功后刷新表格
				}
				else
				{
					JOptionPane.showMessageDialog(this,"添加学生记录失败");
				}
			}
		}
	}

	//判断用户输入是否为空
	private boolean checkIsNull()
	{
		boolean flag=true;
		if(numText.getText().trim().equals(""))
		{
			flag=false;
		}
		else
		{
			if(nameText.getText().trim().equals(""))
			{
				flag=false;
			}
		}
		return flag;
	}

	//校验用户输入的信息是否有误
	private String checkInput()
	{
		String result="";
		if(numText.getText().trim().length()!=3)
		{
			result="学号的长度不是3位";
		}
		else
		{
			for(int i=0;i<numText.getText().trim().length();i++)
			{
				char ch=numText.getText().trim().charAt(i);
				if((ch<'0')||(ch>'9'))
				{
					result="学号中包含非数字字符";
					break;
				}
			}
		}
		return result;
	}
}
