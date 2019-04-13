import javax.swing.*;
import java.awt.event.*;

public class MainFrm extends JFrame implements ActionListener
{
	JMenuBar bar;
	JMenu menu;
	JMenuItem[] items;
	JPanel panel;

	public MainFrm()
	{
		this.setSize(500,400);
		this.setTitle("学生信息管理");
		this.setLayout(null);
		this.intiMenu();
		this.setVisible(true);
	}

	private void intiMenu()
	{
		bar=new JMenuBar();
		menu=new JMenu("操作");
		items=new JMenuItem[4];
		String[] menuNames={"增加","删除","修改","查询"};
		for(int i=0;i<menuNames.length;i++)
		{
			items[i]=new JMenuItem(menuNames[i]);
			items[i].addActionListener(this);
			menu.add(items[i]);
		}
		bar.add(menu);
		this.setJMenuBar(bar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item=(JMenuItem)e.getSource();
		if(panel!=null)
		{
			this.remove(panel);
		}
		if(item.getText().equals("增加"))
		{
			panel=new AddStuPanel();
			//创建一个增加学生信息的面板对象
			panel.setLocation(20,20);
			this.add(panel);
			this.repaint();
		}
		else
		{
			if(item.getText().equals("删除"))
			{
				panel=new DeleteStuPanel();
				//创建一个增加学生信息的面板对象
				panel.setLocation(20,20);
				this.add(panel);
				this.repaint();
			}
			else
			{
				if(item.getText().equals("修改"))
				{
					panel=new UpdateStuPanel();
					//创建一个增加学生信息的面板对象
					panel.setLocation(20,20);
					this.add(panel);
					this.repaint();
				}
			}
		}

	}
}
