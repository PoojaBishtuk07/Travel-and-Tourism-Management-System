import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;;

public class BookHotel extends JFrame implements ActionListener {

    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookprice, back;

    public BookHotel(String username) {
        this.username = username;
        setBounds(200, 150, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("BOOK Hotel");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("tahoma", Font.PLAIN, 16));
        lblusername.setBounds(40, 70, 100, 20);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setFont(new Font("tahoma", Font.PLAIN, 16));
        labelusername.setBounds(250, 70, 100, 20);
        add(labelusername);
        // id
        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setFont(new Font("tahoma", Font.PLAIN, 16));
        lblpackage.setBounds(40, 110, 150, 20);
        add(lblpackage);
        chotel = new Choice();
        chotel.setBounds(250, 110, 200, 25);
        add(chotel);
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from hotel ");
            while (rs.next()) {
                chotel.add(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // number
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setFont(new Font("tahoma", Font.PLAIN, 16));
        lblpersons.setBounds(40, 150, 150, 20);
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);

        // number
        JLabel lbldays = new JLabel("No of Days");
        lbldays.setFont(new Font("tahoma", Font.PLAIN, 16));
        lbldays.setBounds(40, 190, 150, 20);
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 25);
        add(tfdays);

        JLabel lblac = new JLabel("Ac/ Non-AC");
        lblac.setFont(new Font("tahoma", Font.PLAIN, 16));
        lblac.setBounds(40, 230, 150, 20);
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 230, 200, 25);
        add(cac);

        JLabel lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("tahoma", Font.PLAIN, 16));
        lblfood.setBounds(40, 270, 150, 20);
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 270, 200, 25);
        add(cfood);

        JLabel lblid = new JLabel("Id");
        lblid.setFont(new Font("tahoma", Font.PLAIN, 16));
        lblid.setBounds(40, 310, 150, 20);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 310, 200, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("tahoma", Font.PLAIN, 16));
        lblnumber.setBounds(40, 350, 150, 20);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 350, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("tahoma", Font.PLAIN, 16));
        lblphone.setBounds(40, 390, 150, 20);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 390, 200, 25);
        add(labelphone);
        JLabel lblprice = new JLabel("Total Price");
        lblprice.setFont(new Font("tahoma", Font.PLAIN, 16));
        lblprice.setBounds(40, 430, 150, 20);
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setBounds(250, 430, 200, 25);
        add(labelprice);

        try {
            conn c = new conn();
            String query = "select * from customer where username = '" + username + "' ";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice = new JButton("Checkprice");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.white);
        checkprice.setBounds(60, 470, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookprice = new JButton("Book Hotel");
        bookprice.setBackground(Color.BLACK);
        bookprice.setForeground(Color.white);
        bookprice.setBounds(200, 470, 120, 25);
        bookprice.addActionListener(this);
        add(bookprice);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(340, 470, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(500, 50, 600, 450);
        add(icon);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '" + chotel.getSelectedItem() + "' ");
                while (rs.next()) {

                    int cost = Integer.parseInt(rs.getString("costperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));
                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());
                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();
                    if (persons * days > 0) {
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("Yes") ? ac : 0;
                        total += cost;
                        total = total * persons * days;
                        labelprice.setText("Rs" + total);

                    } else {
                        JOptionPane.showMessageDialog(null, "Please Enter the Valid Number");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == bookprice) {

            try {

                conn c = new conn();
                c.s.executeUpdate("insert into bookhotel values('" + labelusername.getText() + "', '"
                        + chotel.getSelectedItem() + "', '" + tfpersons.getText() + "', '" + tfdays.getText() + "', '"
                        + cac.getSelectedItem() + "', '" + cfood.getSelectedItem() + "', '" + labelid.getText()
                        + "', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '"
                        + labelprice.getText() + "')");
                JOptionPane.showMessageDialog(null, "Hotel booked successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }

    }

    public static void main(String args[]) {
        new BookHotel("pooja");

    }
}