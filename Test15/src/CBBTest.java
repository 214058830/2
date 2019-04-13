import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;


public class CBBTest extends JFrame implements ItemListener
{
	JComboBox cbx;//下拉框
	String currentSelect;
	
	public CBBTest()
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
		currentSelect="机电学院";
		this.add(cbx);
	    this.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(!currentSelect.equals(cbx.getSelectedItem()))
		{
			currentSelect=cbx.getSelectedItem().toString();
			JOptionPane.showMessageDialog(this, "您选择的是"+cbx.getSelectedItem());
		}
	}
}
