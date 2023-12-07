import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {

    About() {
        setBounds(600, 200, 500, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel l1 = new JLabel("About Us");
        l1.setBounds(200, 10, 100, 40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("tahoma", Font.PLAIN, 20));
        add(l1);
        String s = " About Projects   \n" + "\n" +
                "The objective of the Travel and Tourism Management System Project is to develop a system that automatics the processes and activites of a travel and the purposesis to design a system using which one can perform all operation related to traveling. \n"
                +
                "Advantages of Projets: \n " + "\n" +
                "Gives accurate information \n" +
                "Simplifies the mannual work \n" +
                " Increase customer awareness of travel destinations and accommodations. \n" +
                " Persuade tourists to visit a destination. \n" +
                "Remind tourists about a destination and where to do all the bookings from.\n" +
                "Contribute to the growth of local and national economies worldwide. \n" +
                "Promote local brands. \n";

        TextArea area = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 100, 450, 300);
        add(area);

        JButton back = new JButton("Back");
        back.setBounds(200, 420, 100, 25);
        back.addActionListener(this);
        add(back);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String args[]) {

        new About();
    }

}
