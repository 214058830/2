import javax.swing.*;
import java.awt.event.*;


public class RbTest extends JFrame implements ActionListener{

	JRadioButton[] rbts;//单选框数组对象
	ButtonGroup btGroup;//按钮组，从逻辑上来涵盖所有的单选按钮
	JButton bt;

	public RbTest()
	{
		this.setSize(300, 300);
		this.setLayout(null);
		btGroup=new ButtonGroup();
		rbts=new JRadioButton[4];
		String[] strs={"A","B","C","D"};
		for(int i=0;i<strs.length;i++)
		{
			rbts[i]=new JRadioButton(strs[i]);
			rbts[i].setSize(70, 30);
			rbts[i].setLocation(20, 35*i+30);
			btGroup.add(rbts[i]);//从逻辑上将单选按钮添加到一个按钮数组中
			this.add(rbts[i]);//从物理位置上将单选按钮添加到窗体中
		}

		bt=new JButton("确定");
		bt.setSize(70, 30);
		bt.setLocation(20, 200);
		bt.addActionListener(this);
		this.add(bt);
		rbts[0].setSelected(true);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String temp="";
		for(int i=0;i<rbts.length;i++)
		{
			if(rbts[i].isSelected())
			{
				temp=rbts[i].getText();
				break;
			}
		}
		JOptionPane.showMessageDialog(this, "您的选项是:"+temp);


	}

}
