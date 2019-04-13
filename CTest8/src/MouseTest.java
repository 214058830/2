import javax.swing.*;

import java.awt.event.*;

public class MouseTest extends JFrame implements MouseListener{

	JButton bt;

	public MouseTest()
	{
		this.setSize(300,300);
		this.setLayout(null);
		bt=new JButton("按钮");
		bt.setSize(110,30);
		bt.setLocation(30,30);
		bt.addMouseListener(this);
		this.add(bt);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		bt.setText("鼠标进入");

	}

	@Override
	public void mouseExited(MouseEvent e) {
		bt.setText("鼠标离开");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
