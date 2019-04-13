import javax.swing.*;
import java.awt.event.*;

public class WindowTest extends JFrame implements WindowListener
{
	public WindowTest()
	{
		this.setSize(300,300);
		this.addWindowListener(this);
		this.setVisible(true);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		//JOptionPane.showMessageDialog(this, "窗体获得焦点");
	}
	public void windowClosed(WindowEvent e) {

	}
	public void windowClosing(WindowEvent e) {
		JOptionPane.showMessageDialog(this, "正在关闭");
	}
	public void windowDeactivated(WindowEvent e) {
		//JOptionPane.showMessageDialog(this, "窗体失去焦点");
	}
	public void windowDeiconified(WindowEvent e) {
		JOptionPane.showMessageDialog(this, "窗体恢复正常");
	}
	public void windowIconified(WindowEvent e) {
		JOptionPane.showMessageDialog(this, "窗体图标化");
	}
	public void windowOpened(WindowEvent e) {
		JOptionPane.showMessageDialog(this, "窗体已经打开");
	}
}