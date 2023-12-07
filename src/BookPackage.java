import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;;

public class BookPackage extends JFrame implements ActionListener {

     Choice cpackage;
     JTextField tfpersons;
     String username;
     JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
     JButton checkprice, bookprice, back;

     public BookPackage(String username) {
          this.username = username;
          setBounds(250, 200, 1100, 450);
          setLayout(null);
          getContentPane().setBackground(Color.white);

          JLabel text = new JLabel("BOOK PACKAGE");
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
          JLabel lblpackage = new JLabel("Select Package");
          lblpackage.setFont(new Font("tahoma", Font.PLAIN, 16));
          lblpackage.setBounds(40, 110, 150, 20);
          add(lblpackage);
          cpackage = new Choice();
          cpackage.add("Golden Package");
          cpackage.add("Silver Package");
          cpackage.add("Bronze Package");
          cpackage.setBounds(250, 110, 200, 25);
          add(cpackage);

          // number
          JLabel lblpersons = new JLabel("Total Persons");
          lblpersons.setFont(new Font("tahoma", Font.PLAIN, 16));
          lblpersons.setBounds(40, 150, 150, 20);
          add(lblpersons);

          tfpersons = new JTextField("1");
          tfpersons.setBounds(250, 150, 200, 25);
          add(tfpersons);

          JLabel lblid = new JLabel("Id");
          lblid.setFont(new Font("tahoma", Font.PLAIN, 16));
          lblid.setBounds(40, 190, 150, 20);
          add(lblid);

          labelid = new JLabel();
          labelid.setBounds(250, 190, 200, 25);
          add(labelid);

          JLabel lblnumber = new JLabel("Number");
          lblnumber.setFont(new Font("tahoma", Font.PLAIN, 16));
          lblnumber.setBounds(40, 230, 150, 20);
          add(lblnumber);

          labelnumber = new JLabel();
          labelnumber.setBounds(250, 230, 150, 25);
          add(labelnumber);

          JLabel lblphone = new JLabel("Phone");
          lblphone.setFont(new Font("tahoma", Font.PLAIN, 16));
          lblphone.setBounds(40, 270, 150, 20);
          add(lblphone);

          labelphone = new JLabel();
          labelphone.setBounds(250, 270, 200, 25);
          add(labelphone);
          JLabel lblprice = new JLabel("Total Price");
          lblprice.setFont(new Font("tahoma", Font.PLAIN, 16));
          lblprice.setBounds(40, 310, 150, 20);
          add(lblprice);

          labelprice = new JLabel();
          labelprice.setBounds(250, 310, 200, 25);
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
          checkprice.setBounds(60, 380, 120, 25);
          checkprice.addActionListener(this);
          add(checkprice);

          bookprice = new JButton("Book Package");
          bookprice.setBackground(Color.BLACK);
          bookprice.setForeground(Color.white);
          bookprice.setBounds(200, 380, 120, 25);
          bookprice.addActionListener(this);
          add(bookprice);

          back = new JButton("Back");
          back.setBackground(Color.BLACK);
          back.setForeground(Color.white);
          back.setBounds(340, 380, 120, 25);
          back.addActionListener(this);
          add(back);

          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
          Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
          ImageIcon i3 = new ImageIcon(i2);
          JLabel icon = new JLabel(i3);
          icon.setBounds(550, 50, 500, 300);
          add(icon);

          setVisible(true);
     }

     public void actionPerformed(ActionEvent ae) {
          if (ae.getSource() == checkprice) {
               String pack = cpackage.getSelectedItem();
               int cost = 0;
               if (pack.equals("Gold Package")) {
                    cost += 35000;
               } else if (pack.equals("Silver Package")) {
                    cost += 40000;
               } else {
                    cost += 30000;

               }
               int persons = Integer.parseInt(tfpersons.getText());
               cost *= persons;
               labelprice.setText("Rs " + cost);

          } else if (ae.getSource() == bookprice) {

               try {

                    conn c = new conn();
                    c.s.executeUpdate("insert into bookpackage values('" + labelusername.getText() + "', '"
                              + cpackage.getSelectedItem() + "', '" + tfpersons.getText() + "', '" + labelid.getText()
                              + "', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '"
                              + labelprice.getText() + "')");
                    JOptionPane.showMessageDialog(null, "Package booked successfully");
                    setVisible(false);

               } catch (Exception e) {
                    e.printStackTrace();
               }

          } else {
               setVisible(false);
          }

     }

     public static void main(String args[]) {
          new BookPackage("pooja");

     }
}