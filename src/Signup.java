import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
   JButton create, back;
   JTextField tfname, tfusername, tfpassword, tfanswer ;
   Choice security;
    Signup()
    {
    setBounds(350,200,900,360);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
   
//panel
JPanel p1= new JPanel();
p1.setBackground(new Color (133,193,233));
p1.setBounds(0,0,500,400);
p1.setLayout(null);
add(p1);
//label1
JLabel lblusername = new JLabel("User Name");
lblusername.setFont(new Font ("Tahoma",Font.BOLD,14));
lblusername.setBounds(50,20,125,25);
p1.add(lblusername);
//textfield1
tfusername = new JTextField();
tfusername.setBounds(190,20,180,25);
tfusername.setBorder(BorderFactory.createEmptyBorder());
p1.add(tfusername);



//labe2
JLabel lblname= new JLabel("Name");
lblname.setFont(new Font ("Tahoma",Font.BOLD,14));
lblname.setBounds(50,60,125,25);
p1.add(lblname);
//textfield2
tfname = new JTextField();
 tfname.setBounds(190,60,180,25);
 tfname.setBorder(BorderFactory.createEmptyBorder());
p1.add( tfname);

//label3 for PASSWORD
JLabel lblpassword= new JLabel("Password");
lblpassword.setFont(new Font ("Tahoma",Font.BOLD,14));
lblpassword.setBounds(50,100,125,25);
p1.add(lblpassword);
//textfield
tfpassword = new JTextField();
 tfpassword.setBounds(190,100,180,25);
 tfpassword.setBorder(BorderFactory.createEmptyBorder());
p1.add( tfpassword);


//label4 for SECURITY
JLabel lblsecurity= new JLabel("Security Question");
lblsecurity.setFont(new Font ("Tahoma",Font.BOLD,14));
lblsecurity.setBounds(50,140,125,25);
p1.add(lblsecurity);
//drop-down
security = new Choice();
security.add("your favourite series");
security.add("your lucky number");
security.add("enter your last password");
security.add("your kinder garden school name");
security.add("your favourite anime character");
security.add("your favourite color");
security.add("your favourite ice-cream");
security.setBounds(190,140,180,25);
p1.add(security);



//label3 for answer 
JLabel lblanswer= new JLabel("Answer");
lblanswer.setFont(new Font ("Tahoma",Font.BOLD,14));
lblanswer.setBounds(50,180,125,25);
p1.add(lblanswer);
//textfield for answer security question
 tfanswer = new JTextField();
 tfanswer.setBounds(190,180,180,25);
tfanswer.setBorder(BorderFactory.createEmptyBorder());
p1.add( tfanswer);
//button for create
create = new JButton("Create");
create.setBackground(Color.WHITE);
create.setForeground(new Color (133,193,233));
create.setFont (new Font ("Tahoma",Font.BOLD,14));
create.setBounds(80,250,100,30);
create.addActionListener(this);
p1.add(create);

//button for back
back = new JButton("Back");
back.setBackground(Color.white);
back.setForeground(new Color(133,193,233));
back.setFont (new Font ("Tahoma",Font.BOLD,14));
back.setBounds(250,250,100,30);
back.addActionListener(this);
p1.add(back);

//insert image
ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
Image i2 = i1.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT );
ImageIcon i3 = new ImageIcon(i2);
JLabel image = new JLabel(i3);
image.setBounds(580,50,250,250);
add(image);


setVisible(true);
    }
    

public void actionPerformed (ActionEvent ae)
{
if(ae.getSource() == create){
  String username = tfusername.getText();
  String name = tfname.getText();
  String password = tfpassword.getText();
  String question  = security.getSelectedItem();
    String answer= tfanswer.getText();
String query = "insert into account values('"+username+"', '"+name+"', '"+password+"','"+question+"', '"+answer+"' )";
try{
   conn c = new conn();
   c.s.executeUpdate(query);
   JOptionPane.showMessageDialog(null, "Account Created Successfully");
   setVisible(false);
   new login();
}catch(Exception e)
{
    e.printStackTrace();
}

}else if (ae.getSource () == back){
 setVisible(false);
 new login();
}
}
    public static void main(String args[])
    {
        new Signup();
    }
}
