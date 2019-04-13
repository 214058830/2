import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
public class MouseDeal extends MouseAdapter{

	private JButton bt;
	private JFrame frame;

	public  MouseDeal(JButton bt,JFrame frame)
	{
		this.bt=bt;
		this.frame=frame;
	}

	public void mouseEntered(MouseEvent e)
	{
		bt.setText("鼠标进入");
	}

	public void mouseExited(MouseEvent e)
	{
		bt.setText("鼠标离开");
	}

	public void mouseClicked(MouseEvent e)
	{
		frame.getContentPane().setBackground(Color.red);
	}
}
