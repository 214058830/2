import javax.swing.*;


public class CBTest extends JFrame{

	JCheckBox[] cbs;//单选框数组对象


	public CBTest()
	{
		this.setSize(300, 300);
		this.setLayout(null);
		cbs=new JCheckBox[4];
		String[] strs={"A","B","C","D"};
		for(int i=0;i<strs.length;i++)
		{
			cbs[i]=new JCheckBox(strs[i]);
			cbs[i].setSize(70, 30);
			cbs[i].setLocation(20, 35*i+30);
			this.add(cbs[i]);//从物理位置上将复选按钮添加到窗体中
		}
		this.setVisible(true);
	}

}
