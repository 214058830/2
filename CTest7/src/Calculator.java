import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Calculator extends JFrame implements ActionListener, KeyListener, MouseListener {
    final int WIDTH = 500, HEIGHT = 350;
    GridLayout gridLayout = new GridLayout(4, 4, 5, 5);
    BorderLayout borderLayout = new BorderLayout();
    FlowLayout flowLayout = new FlowLayout();
    Container container;
    JPanel panel, buttonPanel;
    JButton[] buttons;
    String[] name;
    JTextField textField;
    boolean cleared = true;

    public Calculator() {
        super("Calculator");
        container = getContentPane();
        buttonPanel = new JPanel();
        panel = new JPanel();
        buttonPanel.setLayout(gridLayout);
        textField = new JTextField(15);
        textField.setFont(textField.getFont().deriveFont(Font.BOLD,
                (float) 32.0));
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(textField);
        container.setLayout(borderLayout);
        container.add(panel, borderLayout.NORTH);
        container.add(buttonPanel, borderLayout.CENTER);
        buttons = new JButton[16];
        name = new String[] { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2",
                "3", "-", "0", ".", "=", "+" };
        for (int index = 0; index <= 15; index++) {
            buttons[index] = new JButton(name[index]);
            buttons[index].addActionListener(this);
            buttons[index].addKeyListener(this);
            buttons[index].addMouseListener(this);
            buttons[index].setFont(buttons[index].getFont().deriveFont(
                    Font.BOLD, (float) 32.0));
            buttonPanel.add(buttons[index]);
        }
        this.addKeyListener(this);
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setLocation(screenWidth / 2 - WIDTH / 2, screenHeight / 2 - HEIGHT / 2);
        setVisible(true);
        setFocusable(true);
    }

    String calculate(String str) {
        String result = "Wrong Expression";
        String temp = "";
        if (str.charAt(0) != '-'
                && !(str.charAt(0) <= '9' && str.charAt(0) >= '0')) {
            return result;
        }
        LinkedList<Double> list = new LinkedList<Double>();
        LinkedList<Character> optList = new LinkedList<Character>();
        Double doubleTemp;
        boolean isFormerOpt = true;
        for (int index = 0; index <= str.length() - 1; index++) {
            if (index == 0) {
                isFormerOpt = true;
            } else {
                if (str.charAt(index - 1) > '9' || str.charAt(index - 1) < '0') {
                    isFormerOpt = true;
                } else {
                    isFormerOpt = false;
                }
            }
            if (str.charAt(index) != '+' && str.charAt(index) != '*'
                    && str.charAt(index) != '/'
                    && (!(str.charAt(index) == '-' && isFormerOpt == false))) {
                temp += str.charAt(index);
            } else {
                doubleTemp = new Double(temp);
                list.add(doubleTemp);
                temp = "";
                optList.add(str.charAt(index));
            }
        }
        doubleTemp = new Double(temp);
        list.add(doubleTemp);
        boolean isThereHigherOpt = true;
        while (isThereHigherOpt == true) {
            isThereHigherOpt = false;
            for (int index = 0; index <= optList.size() - 1; index++) {
                if (optList.get(index) == '*') {
                    Double t = list.get(index) * list.get(index + 1);
                    list.remove(index + 1);
                    list.set(index, t);
                    optList.remove(index);
                    isThereHigherOpt = true;
                    break;
                }
                if (optList.get(index) == '/') {
                    Double t = list.get(index) / list.get(index + 1);
                    list.remove(index + 1);
                    list.set(index, t);
                    optList.remove(index);
                    isThereHigherOpt = true;
                    break;
                }
            }
        }
        while (optList.isEmpty() == false) {
            for (int index = 0; index <= optList.size() - 1; index++) {
                if (optList.get(index) == '+') {
                    Double t = list.get(index) + list.get(index + 1);
                    list.remove(index + 1);
                    list.set(index, t);
                    optList.remove(index);
                    break;
                }
                if (optList.get(index) == '-') {
                    Double t = list.get(index) + 0.0 - list.get(index + 1);
                    list.remove(index + 1);
                    list.set(index, t);
                    optList.remove(index);
                    break;
                }
            }
        }
        if (list.size() == 1) {
            result = list.get(0).toString();
        }
        return result;
    }

    void addText(char ch) {
        if (cleared == true && ((ch <= '9' && ch >= '0'))) {
            textField.setText("");
            cleared = false;
        }
        String str = textField.getText();
        if (ch != '=') {
            if (str.length() > 0) {
                if (str.charAt(str.length() - 1) <= '9'
                        && str.charAt(str.length() - 1) >= '0') {
                    if (ch != '.') {
                        textField.setText(str + ch);
                    } else {
                        boolean isTherePoint = false;
                        int i = str.length() - 1;
                        while (i >= 0) {
                            if (str.charAt(i) == '*' || str.charAt(i) == '/'
                                    || str.charAt(i) == '+'
                                    || str.charAt(i) == '-') {
                                break;
                            }
                            if (str.charAt(i) == '.') {
                                isTherePoint = true;
                                break;
                            }
                            i--;
                        }
                        if (isTherePoint == false) {
                            textField.setText(str + ch);
                        }
                    }
                } else {
                    if ((ch <= '9' && ch >= '0') || ch == '-') {
                        textField.setText(str + ch);
                    }
                }
            } else {
                if (ch == '-' || (ch <= '9' && ch >= '0'))
                    textField.setText(str + ch);
            }
            cleared = false;
        } else {
            if (cleared == true) {
                textField.setText("");
            } else {
                str = textField.getText();
                textField.setText("");
                if (str.length() > 0) {
                    if (str.charAt(str.length() - 1) <= '9'
                            && str.charAt(str.length() - 1) >= '0') {
                        textField.setText(calculate(str));
                    } else {
                        textField.setText("Wrong Expression");
                    }
                }
            }
            cleared = true;
        }
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source.getClass() == JButton.class) {
            JButton button = (JButton) source;
            char ch = button.getText().charAt(0);
            addText(ch);
        }
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
        char ch = e.getKeyChar();
        if (ch == ' ') {
            System.exit(EXIT_ON_CLOSE);
        }
        if (ch == KeyEvent.VK_ENTER) {
            buttons[14].setBackground(Color.LIGHT_GRAY);
            for (int i = 0; i <= name.length - 1; i++) {
                if (i != 14) {
                    buttons[i].setBackground(Color.GRAY);
                }
            }
            addText('=');
            return;
        }
        for (int index = 0; index <= name.length - 1; index++) {
            if (ch == name[index].charAt(0)) {
                // System.out.println(ch);
                buttons[index].setBackground(Color.LIGHT_GRAY);
                for (int i = 0; i <= name.length - 1; i++) {
                    if (i != index) {
                        buttons[i].setBackground(Color.GRAY);
                    }
                }
                addText(ch);
                break;
            }
        }
    }

    public void mouseClicked(MouseEvent event) {
    }

    public void mouseEntered(MouseEvent event) {
        Object source = event.getSource();
        if (source.getClass() == JButton.class) {
            JButton button = (JButton) source;
            button.setBackground(Color.LIGHT_GRAY);
        }
    }

    public void mousePressed(MouseEvent event) {
    }

    public void mouseReleased(MouseEvent event) {
    }

    public void mouseExited(MouseEvent event) {
        Object source = event.getSource();
        if (source.getClass() == JButton.class) {
            JButton button = (JButton) source;
            button.setBackground(Color.GRAY);
        }
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}