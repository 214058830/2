import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;


public class MenuTest extends JFrame implements ActionListener{

	JMenuBar bar;//菜单栏
	JMenu menu;//菜单
	JMenuItem[] items;//菜单项数组
	JButton[] bts;//按钮数组


	public MenuTest()
	{
		this.setSize(300,300);
		this.setLayout(null);
		this.initMenu();
		this.initButton();
		this.setVisible(true);
	}

	private void initMenu()
	{
		bar=new JMenuBar();
		//创建菜单栏对象
		menu=new JMenu("设置颜色");
		//创建菜单
		String[] strs={"红色","蓝色","绿色"};
		items=new JMenuItem[strs.length];
		for(int i=0;i<items.length;i++)
		{
			items[i]=new JMenuItem(strs[i]);
			//创建菜单项，并附上文本信息
			items[i].addActionListener(this);
			menu.add(items[i]);//将菜单项添加到菜单中
		}
		bar.add(menu);//将菜单添加到菜单栏中
		this.setJMenuBar(bar);//设置窗体的菜单栏
	}

	private void initButton()
	{
		String[] strs={"红色","蓝色","绿色"};
		bts=new JButton[strs.length];
		for(int i=0;i<bts.length;i++)
		{
			bts[i]=new JButton(strs[i]);
			bts[i].setSize(80,30);
			bts[i].setLocation(30,35*i+30);
			bts[i].addActionListener(this);
			this.add(bts[i]);
		}

	}



	@Override
	public void actionPerformed(ActionEvent e) {

		/*if(e.getSource().getClass().toString().contains("JMenuItem"))
		{
			JMenuItem item=(JMenuItem)e.getSource();
			if(item.getText().equals("红色"))
			{
				this.getContentPane().setBackground(Color.red);
			}
			else
			{
				if(item.getText().equals("蓝色"))
				{
					this.getContentPane().setBackground(Color.blue);
				}
				else
				{
					this.getContentPane().setBackground(Color.green);
				}
			}
		}
		else
		{
			JButton item=(JButton)e.getSource();
			if(item.getText().equals("红色"))
			{
				this.getContentPane().setBackground(Color.red);
			}
			else
			{
				if(item.getText().equals("蓝色"))
				{
					this.getContentPane().setBackground(Color.blue);
				}
				else
				{
					this.getContentPane().setBackground(Color.green);
				}
			}
		}*/
		AbstractButton item=(AbstractButton)e.getSource();
		if(item.getText().equals("红色"))
		{
			this.getContentPane().setBackground(Color.red);
		}
		else
		{
			if(item.getText().equals("蓝色"))
			{
				this.getContentPane().setBackground(Color.blue);
			}
			else
			{
				this.getContentPane().setBackground(Color.green);
			}
		}

	}


}
