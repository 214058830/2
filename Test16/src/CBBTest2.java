import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.*;
import javax.swing.*;

public class CBBTest2 extends JFrame implements ItemListener
{
	JComboBox cbx;//学院下拉框
	JComboBox cbx1;//专业下拉框
	JComboBox cbx2;//班级下拉框
	String currentSelectXY;
	String currentSelectZY;

	String[] strs1={"机械电子工程","机械设计与制造"};
	String[] strs2={"网络工程","计算机科学与技术"};
	String[] strs3={"信息与计算科学","数学与应用数学"};
	public CBBTest2()
	{
		double width = Toolkit.getDefaultToolkit().getScreenSize().width;
		double height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(400,300);
		this.setLocation((int)(width-400)/2,(int)(height - 300)/2);
		this.setLayout(null);
		cbx=new JComboBox();
		cbx.setSize(150, 30);
		cbx.setLocation(125,90);
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
		cbx1.setLocation(125,135);
		for(int i=0;i<strs1.length;i++)
		{
			cbx1.addItem(strs1[i]);
		}
		currentSelectZY="机械电子工程";
		//cbx1.setSelectedItem("机械电子工程");
		cbx1.addItemListener(this);
		this.add(cbx1);
		cbx2=new JComboBox();
		cbx2.setSize(150, 30);
		cbx2.setLocation(125,180);
		for(int i=0;i<3;i++)
		{
			cbx2.addItem(currentSelectZY+(i+1)+"班");
		}
		this.add(cbx2);
		this.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e)
	{
		JComboBox cbb=(JComboBox)e.getSource();
		if(cbb.equals(cbx))//判断事件源是显示学院的下拉框
		{
			if (!currentSelectXY.equals(cbx.getSelectedItem())) {
				currentSelectXY = cbx.getSelectedItem().toString();
				cbx1.removeAllItems();
				cbx2.removeAllItems();
				if (currentSelectXY.equals("机电学院")) {
					for (int i = 0; i < strs1.length; i++) {
						cbx1.addItem(strs1[i]);
					}
				} else {
					if (currentSelectXY.equals("电信学院")) {
						for (int i = 0; i < strs2.length; i++) {
							cbx1.addItem(strs2[i]);
						}
					} else {
						for (int i = 0; i < strs3.length; i++) {
							cbx1.addItem(strs3[i]);
						}
					}
				}
			}
		}
		else
		{
			if ((cbx1.getItemCount()!=0)&&(!currentSelectZY.equals(cbx1.getSelectedItem()))) {
				currentSelectZY = cbx1.getSelectedItem().toString();
				cbx2.removeAllItems();
				for (int i = 0; i < 3; i++) {
					cbx2.addItem(currentSelectZY + (i + 1) + "班");
				}

			}
		}
	}
}
