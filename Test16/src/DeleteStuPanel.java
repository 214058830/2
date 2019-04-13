import javax.swing.*;

import java.util.*;

import java.awt.Color;
import java.awt.event.*;

public class DeleteStuPanel extends JPanel implements ActionListener{

	JLabel numLabel;
	JTextField numText;
	JButton delBt;
	JScrollPane scrollpane;
	JTable table;//展示学生信息的表格

	public DeleteStuPanel()
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
		delBt=new JButton("删除");
		delBt.setSize(80,30);
		delBt.setLocation(300, 20);
		delBt.addActionListener(this);
		this.add(delBt);
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
		scrollpane.setLocation(20, 60);
		scrollpane.setSize(400, 230);
		this.add(scrollpane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(!checkIsNull())//如果用户输入为空的话
		{
			JOptionPane.showMessageDialog(this, "学号输入为空");
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
				if(dao.deleteStudent(numText.getText().trim()))
				{
					JOptionPane.showMessageDialog(this,"删除学生记录成功");
					numText.setText("");
					refreshTable();
				}
				else
				{
					JOptionPane.showMessageDialog(this,"删除学生记录失败");
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
