import javax.swing.*;
import java.awt.*;

public class LoginForm2 extends JFrame{//继承窗体类

	private JLabel label1;
	private JLabel label2;//定义标签对象
	private JTextField text1;
	private JTextField text2;//定义文本框对象
	private JButton bt1;
	private JButton bt2;//定义按钮对象


	public LoginForm2()
	{
		this.setSize(400, 230);//设置窗体的大小
		this.setTitle("登录窗体");//设置窗体标题
		this.setLayout(null);
		//将窗体的默认布局方式设置为无布局方式
		//创建控件
		label1=new JLabel("用户名");
		label1.setSize(80, 30);
		label1.setLocation(60,30);

		label2=new JLabel("密    码");
		label2.setSize(80, 30);
		label2.setLocation(60,75);

		text1=new JTextField();
		text1.setSize(170, 30);
		text1.setLocation(140,30);


		text2=new JTextField();
		text2.setSize(170, 30);
		text2.setLocation(140,75);

		bt1=new JButton("登录");
		bt1.setSize(90, 30);
		bt1.setLocation(90,130);

		bt2=new JButton("退出");
		bt2.setSize(90, 30);
		bt2.setLocation(190,130);




		this.add(label1);
		this.add(text1);
		this.add(label2);
		this.add(text2);
		this.add(bt1);
		this.add(bt2);


		this.setVisible(true);//设置窗体可见
	}
}
