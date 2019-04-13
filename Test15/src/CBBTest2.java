import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;


public class CBBTest2 extends JFrame implements ItemListener
{
	JComboBox cbx;//下拉框
	JComboBox cbx1;//下拉框
	String currentSelectXY;

	String[] strs1={"机械电子工程","机械设计与制造"};
	String[] strs2={"网络工程","计算机科学与技术"};
	String[] strs3={"信息与计算科学","数学与应用数学"};
	public CBBTest2()
	{
		this.setSize(300, 300);
		this.setLayout(null);
		cbx=new JComboBox();
		cbx.setSize(150, 30);
		cbx.setLocation(30,30);
		String[] strs={"机电学院","电信学院","文理学院"};
		for(int i=0;i<strs.length;i++)
		{
			cbx.addItem(strs[i]);
		}
		cbx.addItemListener(this);
		currentSelectXY="机电学院";
		this.add(cbx);
		cbx1=new JComboBox();
		cbx1.setSize(150, 30);
		cbx1.setLocation(30,70);
		for(int i=0;i<strs1.length;i++)
		{
			cbx1.addItem(strs1[i]);
		}
		this.add(cbx1);
		this.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e)
	{
		if(!currentSelectXY.equals(cbx.getSelectedItem()))
		{
			currentSelectXY=cbx.getSelectedItem().toString();
			cbx1.removeAllItems();
			if(currentSelectXY.equals("机电学院"))
			{
				for(int i=0;i<strs1.length;i++)
				{
					cbx1.addItem(strs1[i]);
				}
			}
			else
			{
				if(currentSelectXY.equals("电信学院"))
				{
					for(int i=0;i<strs2.length;i++)
					{
						cbx1.addItem(strs2[i]);
					}
				}
				else
				{
					for(int i=0;i<strs3.length;i++)
					{
						cbx1.addItem(strs3[i]);
					}
				}
			}
		}
	}
}
