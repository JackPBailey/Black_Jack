import javax.swing.*;

public class Gui {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ui");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(300,300);

        JButton button = new JButton("press");
        button.setSize(100,100);
        frame.getContentPane().add(button);

        JButton button1 = new JButton("press1");
        button.setSize(100,100);
        frame.getContentPane().add(button1);

        frame.setVisible(true);

    }

}
