import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener {

    JLabel labelusername , labelname;
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfaddress, tfemail, tfphone  ;
    JRadioButton rmale, rfemale, rothers;
    JButton add, back;
AddCustomer( String username)
{
setBounds(450,200,850,550);
setLayout(null);
getContentPane().setBackground(Color.WHITE);

  JLabel lblusername = new JLabel("Username");
lblusername.setBounds(30,50,150,25);
add(lblusername);

labelusername = new JLabel();
labelusername.setBounds(220,50,150,25);
add( labelusername);



JLabel lblid = new JLabel("Id");
lblid.setBounds(30,90,150,25);
add(lblid);
  
comboid = new JComboBox(new String[] {"Paasport", "Adharcard","Pan Card","Voter-id card"});
comboid.setBounds(220,90,150,25);
comboid.setBackground(Color.WHITE);
add(comboid);

JLabel lblnumber = new JLabel("Number");
lblnumber.setBounds(30,130,150,25);
add(lblnumber);
 
tfnumber = new JTextField();
tfnumber.setBounds(220,130,150,25);
add(tfnumber);


JLabel lblname = new JLabel("Name");
lblname.setBounds(30,170,150,25);
add(lblname);
 
 labelname = new JLabel();
labelname.setBounds(220,170,150,25);
add(labelname);


JLabel lblgender = new JLabel("Gender");
lblgender.setBounds(30,210,150,25);
add(lblgender);

rmale= new JRadioButton("Male");
rmale.setBackground(Color.white);
rmale.setBounds(220,210,70,25);
add(rmale);


rfemale= new JRadioButton("Female");
rfemale.setBackground(Color.white);
rfemale.setBounds(300,210,70,25);
add(rfemale);


rothers= new JRadioButton("Others");
rothers.setBackground(Color.white);
rothers.setBounds(380,210,70,25);
add(rothers);
ButtonGroup bg= new ButtonGroup();
bg.add(rmale);
bg.add(rfemale);
bg.add(rothers);

JLabel lblcountry = new JLabel("Country");
lblcountry.setBounds(30,250,150,25);
add(lblcountry);
 
tfcountry = new JTextField();
tfcountry.setBounds(220,250,150,25);
add(tfcountry );

JLabel lblcaddress = new JLabel("Address");
lblcaddress.setBounds(30,290,150,25);
add(lblcaddress);
 
tfaddress = new JTextField();
tfaddress.setBounds(220,290,150,25);
add(tfaddress );


JLabel lblemail = new JLabel("E-mail");
lblemail .setBounds(30,330,150,25);
add(lblemail );
 
tfemail = new JTextField();
tfemail.setBounds(220,330,150,25);
add(tfemail );

JLabel lblphone = new JLabel("Phone Number");
lblphone.setBounds(30,370,150,25);
add(lblphone );
 
tfphone = new JTextField();
tfphone.setBounds(220,370,150,25);
add(tfphone );

add = new JButton("Add");
add.setBackground(Color.black);
add.setBounds(70,430,100,25);
add.setForeground(Color.WHITE);
add.addActionListener(this);
add(add);

back = new JButton("Back");
back.setBackground(Color.black);
back.setBounds(220,430,100,25);
back.setForeground(Color.WHITE);
back.addActionListener(this);
add(back);

ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
Image i2 = i1.getImage().getScaledInstance(450,420 , Image.SCALE_DEFAULT);
ImageIcon i3= new ImageIcon(i2);
JLabel image = new JLabel(i3);
image.setBounds(400,40,400,500);
add(image);


try{

conn c = new conn();
ResultSet rs= c.s.executeQuery("select * from account where username = '"+username+"' ");
while(rs.next()){

    labelusername.setText(rs.getString("username"));
     labelname.setText(rs.getString("name"));
} 
}catch(Exception e)
{
    e.printStackTrace();
}


setVisible(true);
}
 

public void actionPerformed (ActionEvent ae){

    if(ae.getSource()==add)
    {
   String username = labelusername.getText();
   String id = (String)comboid.getSelectedItem(); 
  String number = tfnumber.getText();
  String name = labelname.getText();
  String gender=null;
  if(rmale.isSelected())
  {
    gender= "Male";
  } else if(rfemale.isSelected())
  {
    gender= "Female";
  } else
  {
    gender="Others";
  }
    String country = tfcountry.getText();
    String address = tfaddress.getText();
    String email = tfemail.getText();
    String phone = tfphone.getText();

    try{
       conn c= new conn ();
    String query = "insert into customer values('"+username+"','"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+email+"', '"+phone+"')";
   c.s.executeUpdate(query);
   JOptionPane.showMessageDialog(null, "Customer details added successfully");
   setVisible(false);

} catch(Exception e)
    {
        e.printStackTrace();
    }

    }else {
    setVisible(false);
}}

 
    public static void main(String args[])
    {
        new AddCustomer("pooja");
    }
}
