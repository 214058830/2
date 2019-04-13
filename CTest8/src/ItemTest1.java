import javax.swing.*;
import java.awt.event.*;


public class ItemTest1 extends JFrame implements ItemListener
{
	JComboBox com;//下拉框对象
	JComboBox com1;
	String currentSelect;//当前的选项

	String[] strs1={"机械设计及其自动化","机械电子工程"};
	String[] strs2={"计算机科学与技术","网络工程"};
	String[] strs3={"工业设计","艺术设计"};

	public ItemTest1()
	{
		this.setSize(300,300);
		this.setLayout(null);
		com=new JComboBox();
		com.setSize(120,30);
		com.setLocation(30,30);

		String[] strs={"机电学院","电信学院","设艺学院"};
		for(int i=0;i<strs.length;i++)
		{
			com.addItem(strs[i]);
		}
		currentSelect="机电学院";
		com.addItemListener(this);
		this.add(com);
		com1=new JComboBox();
		com1.setSize(120,30);
		com1.setLocation(30,80);
		for(int i=0;i<strs1.length;i++)
		{
			com1.addItem(strs1[i]);
		}
		this.add(com1);
		this.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(!currentSelect.equals(com.getSelectedItem()))
		{
			currentSelect= com.getSelectedItem().toString();
			com1.removeAllItems();
			if(currentSelect.equals("机电学院"))
			{
				for(int i=0;i<strs1.length;i++)
				{
					com1.addItem(strs1[i]);
				}
			}
			else
			{
				if(currentSelect.equals("电信学院"))
				{
					for(int i=0;i<strs2.length;i++)
					{
						com1.addItem(strs2[i]);
					}
				}
				else
				{
					for(int i=0;i<strs3.length;i++)
					{
						com1.addItem(strs3[i]);
					}
				}
			}
		}


	}
}
