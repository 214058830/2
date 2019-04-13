import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;


public class CBBTest1 extends JFrame implements ItemListener
{
	JComboBox cbx;//下拉框
	String currentSelect;

	public CBBTest1()
	{
		this.setSize(300, 300);
		this.setLayout(null);
		cbx=new JComboBox();
		cbx.setSize(150, 30);
		cbx.setLocation(30,30);
		String[] strs={"红色","蓝色","绿色"};
		for(int i=0;i<strs.length;i++)
		{
			cbx.addItem(strs[i]);
		}
		cbx.addItemListener(this);
		currentSelect="红色";
		this.getContentPane().setBackground(Color.red);
		this.add(cbx);
		this.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(!currentSelect.equals(cbx.getSelectedItem()))
		{
			currentSelect=cbx.getSelectedItem().toString();
			if(currentSelect.equals("红色"))
			{
				this.getContentPane().setBackground(Color.red);
			}
			else
			{
				if(currentSelect.equals("蓝色"))
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
}
