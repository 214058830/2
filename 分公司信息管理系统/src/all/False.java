package all;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class False {
    Frame f;
    Button but1;
    Label label;
    MyWindowListener mw;
    //String reason;

    public False() {
        //this.reason = reason;
        mw = new MyWindowListener();
        //this.init_Label();
        this.init_Frame();
        this.init_Button();
        this.addListener();
    }

    private void init_Frame(){
        double width = Toolkit.getDefaultToolkit().getScreenSize().width;
        double height = Toolkit.getDefaultToolkit().getScreenSize().height;
        f = new Frame("False");
        f.setSize(200,150);
        f.setLocation((int)width/2-200+100,(int)height/2-150+75);
        f.setVisible(true);
        f.addWindowListener(mw);
        f.setLayout(null);
    }

//    private void init_Label(){
//        label = new Label(reason);
//        label.setBounds(50, 50, 100, 30);
//        f.add(label);
//    }

    private void init_Button(){
        but1 = new Button("确认");
        but1.setBounds(50, 100, 100, 30);
        f.add(but1);
    }

    private void addListener(){
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
    }
}
