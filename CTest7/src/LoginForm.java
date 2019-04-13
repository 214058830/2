import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame{//继承窗体类

	private JLabel label1;
	private JLabel label2;//定义标签对象
	private JTextField text1;
	private JTextField text2;//定义文本框对象
	private JButton bt1;
	private JButton bt2;//定义按钮对象


	public LoginForm()
	{
		this.setSize(400, 300);//设置窗体的大小
		this.setTitle("登录窗体");//设置窗体标题
		//创建控件
		label1=new JLabel("用户名");
		label2=new JLabel("密    码");
		text1=new JTextField();
		text2=new JTextField();
		bt1=new JButton("登录");
		bt2=new JButton("退出");


		this.add(label1,BorderLayout.NORTH);
		this.add(text1,BorderLayout.SOUTH);
		this.add(label2,BorderLayout.EAST);
		this.add(text2,BorderLayout.WEST);
		this.add(bt1,BorderLayout.CENTER);
		this.add(bt2,BorderLayout.CENTER);


		this.setVisible(true);//设置窗体可见
	}
}
