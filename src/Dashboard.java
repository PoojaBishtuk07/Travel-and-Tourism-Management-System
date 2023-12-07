import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
   String username;
   JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, checkPackages, bookPackage, viewPackage;
   JButton viewHotels, destinations, bookHotel, viewBookedHotel, payments, calculator, notepad, about;
   JButton deletePersonalDetails;

   Dashboard(String username) {
      this.username = username;
      // setBounds(0,0,1600,1000);
      setExtendedState(JFrame.MAXIMIZED_BOTH); // full screen
      setLayout(null);

      JPanel p1 = new JPanel();
      p1.setLayout(null);
      p1.setBackground(new Color(0, 0, 102));
      p1.setBounds(0, 0, 1500, 40);
      add(p1);

      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
      Image i2 = i1.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel icon = new JLabel(i3);
      icon.setBounds(5, 0, 60, 50);
      p1.add(icon);

      JLabel heading = new JLabel("Dashboard");
      heading.setBounds(80, 5, 300, 40);
      heading.setForeground(Color.WHITE);
      heading.setFont(new Font("ITALICS", Font.BOLD, 30));
      p1.add(heading);

      JPanel p2 = new JPanel();
      p2.setLayout(null);
      p2.setBackground(new Color(0, 0, 102));
      p2.setBounds(0, 40, 300, 900);
      add(p2);

      addPersonalDetails = new JButton("Add Personal Details");
      addPersonalDetails.setBounds(0, 0, 300, 45);
      addPersonalDetails.setBackground(new Color(0, 0, 102));
      addPersonalDetails.setForeground(Color.WHITE);
      addPersonalDetails.setFont(new Font("TAHOMA", Font.PLAIN, 20));
      addPersonalDetails.setMargin(new Insets(0, 0, 0, 60));
      addPersonalDetails.addActionListener(this);
      p2.add(addPersonalDetails);

      updatePersonalDetails = new JButton("Update personal Details");
      updatePersonalDetails.setBounds(0, 45, 300, 45);
      updatePersonalDetails.setBackground(new Color(0, 0, 102));
      updatePersonalDetails.setForeground(Color.WHITE);
      updatePersonalDetails.setFont(new Font("TAHOMA", Font.PLAIN, 20));
      updatePersonalDetails.setMargin(new Insets(0, 0, 0, 30));
      p2.add(updatePersonalDetails);

      viewPersonalDetails = new JButton("View  Details");
      viewPersonalDetails.setBounds(0, 90, 300, 45);
      viewPersonalDetails.setBackground(new Color(0, 0, 102));
      viewPersonalDetails.setForeground(Color.WHITE);
      viewPersonalDetails.setFont(new Font("TAHOMA", Font.PLAIN, 20));
      viewPersonalDetails.setMargin(new Insets(0, 0, 0, 130));
      viewPersonalDetails.addActionListener(this);
      p2.add(viewPersonalDetails);

      deletePersonalDetails = new JButton("Delete Personal Details");
      deletePersonalDetails.setBounds(0, 135, 300, 45);
      deletePersonalDetails.setBackground(new Color(0, 0, 102));
      deletePersonalDetails.setForeground(Color.WHITE);
      deletePersonalDetails.setFont(new Font("TAHOMA", Font.PLAIN, 20));
      deletePersonalDetails.setMargin(new Insets(0, 0, 0, 40));
      deletePersonalDetails.addActionListener(this);
      p2.add(deletePersonalDetails);

      checkPackages = new JButton("Check Packages");
      checkPackages.setBounds(0, 180, 300, 45);
      checkPackages.setBackground(new Color(0, 0, 102));
      checkPackages.setForeground(Color.WHITE);
      checkPackages.setFont(new Font("TAHOMA", Font.PLAIN, 20));
      checkPackages.setMargin(new Insets(0, 0, 0, 110));
      checkPackages.addActionListener(this);
      p2.add(checkPackages);

      bookPackage = new JButton("Book Packages");
      bookPackage.setBounds(0, 225, 300, 45);
      bookPackage.setBackground(new Color(0, 0, 102));
      bookPackage.setForeground(Color.WHITE);
      bookPackage.setFont(new Font("TAHOMA", Font.PLAIN, 20));
      bookPackage.setMargin(new Insets(0, 0, 0, 120));
      bookPackage.addActionListener(this);
      p2.add(bookPackage);

      viewPackage = new JButton("View Packages ");
      viewPackage.setBounds(0, 270, 300, 45);
      viewPackage.setBackground(new Color(0, 0, 102));
      viewPackage.setForeground(Color.WHITE);
      viewPackage.setFont(new Font("TAHOMA", Font.PLAIN, 20));
      viewPackage.setMargin(new Insets(0, 0, 0, 120));
      viewPackage.addActionListener(this);

      p2.add(viewPackage);

      viewHotels = new JButton("View Hotels ");
      viewHotels.setBounds(0, 315, 300, 45);
      viewHotels.setBackground(new Color(0, 0, 102));
      viewHotels.setForeground(Color.WHITE);
      viewHotels.setFont(new Font("TAHOMA", Font.PLAIN, 20));
      viewHotels.setMargin(new Insets(0, 0, 0, 140));
      viewHotels.addActionListener(this);
      p2.add(viewHotels);

      bookHotel = new JButton("Book Hotel ");
      bookHotel.setBounds(0, 360, 300, 45);
      bookHotel.setBackground(new Color(0, 0, 102));
      bookHotel.setForeground(Color.WHITE);
      bookHotel.setFont(new Font("TAHOMA", Font.PLAIN, 20));
      bookHotel.setMargin(new Insets(0, 0, 0, 140));
      bookHotel.addActionListener(this);
      p2.add(bookHotel);

      viewBookedHotel = new JButton("View Booked Hotel ");
      viewBookedHotel.setBounds(0, 405, 300, 45);
      viewBookedHotel.setBackground(new Color(0, 0, 102));
      viewBookedHotel.setForeground(Color.WHITE);
      viewBookedHotel.setFont(new Font("TAHOMA", Font.PLAIN, 20));
      viewBookedHotel.setMargin(new Insets(0, 0, 0, 70));
      viewBookedHotel.addActionListener(this);
      p2.add(viewBookedHotel);

      destinations = new JButton("Destinations  ");
      destinations.setBounds(0, 450, 300, 45);
      destinations.setBackground(new Color(0, 0, 102));
      destinations.setForeground(Color.WHITE);
      destinations.setFont(new Font("TAHOMA", Font.PLAIN, 20));
      destinations.setMargin(new Insets(0, 0, 0, 125));
      destinations.addActionListener(this);
      p2.add(destinations);

      payments = new JButton(" Payments ");
      payments.setBounds(0, 495, 300, 45);
      payments.setBackground(new Color(0, 0, 102));
      payments.setForeground(Color.WHITE);
      payments.setFont(new Font("TAHOMA", Font.PLAIN, 20));
      payments.setMargin(new Insets(0, 0, 0, 155));
      payments.addActionListener(this);
      p2.add(payments);

      calculator = new JButton("Calculator ");
      calculator.setBounds(0, 540, 300, 45);
      calculator.setBackground(new Color(0, 0, 102));
      calculator.setForeground(Color.WHITE);
      calculator.setFont(new Font("TAHOMA", Font.PLAIN, 20));
      calculator.setMargin(new Insets(0, 0, 0, 145));
      calculator.addActionListener(this);
      p2.add(calculator);
      notepad = new JButton("Notepad  ");
      notepad.setBounds(0, 585, 300, 45);
      notepad.setBackground(new Color(0, 0, 102));
      notepad.setForeground(Color.WHITE);
      notepad.setFont(new Font("TAHOMA", Font.PLAIN, 20));
      notepad.setMargin(new Insets(0, 0, 0, 155));
      notepad.addActionListener(this);
      p2.add(notepad);

      about = new JButton("About  ");
      about.setBounds(0, 630, 300, 45);
      about.setBackground(new Color(0, 0, 102));
      about.setForeground(Color.WHITE);
      about.setFont(new Font("TAHOMA", Font.PLAIN, 20));
      about.setMargin(new Insets(0, 0, 0, 175));
      about.addActionListener(this);
      p2.add(about);

      ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
      Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
      ImageIcon i6 = new ImageIcon(i5);
      JLabel image = new JLabel(i6);
      image.setBounds(0, 0, 1650, 1000);
      add(image);

      JLabel text = new JLabel("Travel and Tourism Management System");
      text.setBounds(400, 70, 1200, 70);
      text.setForeground(Color.WHITE);
      text.setFont(new Font("RALEWAY", Font.PLAIN, 50));
      image.add(text);

      setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == addPersonalDetails) {
         new AddCustomer(username);
      } else if (ae.getSource() == viewPersonalDetails) {
         new ViewCustomer(username);

      } else if (ae.getSource() == updatePersonalDetails) {
         new UpdateCustomer(username);
      } else if (ae.getSource() == checkPackages) {
         new CheckPackages();

      } else if (ae.getSource() == bookPackage) {
         new BookPackage(username);
      } else if (ae.getSource() == viewPackage) {
         new ViewPackage(username);
      } else if (ae.getSource() == viewHotels) {
         new CheckHotel();
      } else if (ae.getSource() == destinations) {
         new Destinations();
      } else if (ae.getSource() == bookHotel) {
         new BookHotel(username);
      } else if (ae.getSource() == viewBookedHotel) {
         new ViewBookedHotel(username);
      } else if (ae.getSource() == payments) {
         new Payments();
      } else if (ae.getSource() == calculator) {
         try {
            Runtime.getRuntime().exec("calc.exe");
         } catch (Exception e) {
            e.printStackTrace();

         }
      } else if (ae.getSource() == notepad) {

         try {
            Runtime.getRuntime().exec("notepad.exe");
         } catch (Exception e) {
            e.printStackTrace();

         }
      } else if (ae.getSource() == about) {

         new About();
      } else if (ae.getSource() == deletePersonalDetails) {

         new DeleteDetails(username);
      }
   }

   public static void main(String args[]) {
      new Dashboard("");

   }
}
