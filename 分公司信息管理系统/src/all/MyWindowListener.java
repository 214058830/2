package all;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class MyWindowListener implements WindowListener {
    public void windowClosing(WindowEvent e) {
        Window window = e.getWindow();
        window.setVisible(false);
        window.dispose();
    }
    public void windowActivated(WindowEvent e) {

    }
    public void windowClosed(WindowEvent e) {

    }
    public void windowDeactivated(WindowEvent e) {

    }
    public void windowDeiconified(WindowEvent e) {

    }
    public void windowIconified(WindowEvent e) {

    }
    public void windowOpened(WindowEvent e) {

    }
}
