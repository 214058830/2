import javax.swing.*;

import java.awt.event.*;

public class MouseTest1 extends JFrame{

	JButton bt;

	public MouseTest1()
	{
		this.setSize(300,300);
		this.setLayout(null);
		bt=new JButton("按钮");
		bt.setSize(110,30);
		bt.setLocation(30,30);
		bt.addMouseListener(new MouseDeal(bt,this));
		this.add(bt);
		this.setVisible(true);
	}


}
