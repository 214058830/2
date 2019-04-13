import javax.swing.*;
import java.awt.event.*;


public class ItemTest extends JFrame implements ItemListener
{
	JComboBox com;//下拉框对象
	String currentSelect;//当前的选项

	public ItemTest()
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
		this.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(!currentSelect.equals(com.getSelectedItem()))
		{
			currentSelect= com.getSelectedItem().toString();
			JOptionPane.showMessageDialog(this, com.getSelectedItem());
		}


	}
}
