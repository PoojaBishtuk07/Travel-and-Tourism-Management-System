import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.sql.ResultSet;
public class login extends JFrame implements ActionListener{
    JButton login, signup, password ;
    JTextField tfusername, tfpassword;
    login(){
        setSize(900,400);
   setLocation(350,200);
   setLayout(null);
getContentPane().setBackground(Color.white);
//left panel
JPanel p1 = new JPanel();
p1.setBackground(new Color(131,193,233));
p1.setBounds(0,0,400,400);
p1.setLayout(null);
add(p1);
//insert image
ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT );
ImageIcon i3 = new ImageIcon(i2);
JLabel image = new JLabel(i3);
image.setBounds(100,120,200,200);
p1.add(image); // image above panel.
//right panel
JPanel p2 = new JPanel();
p2.setBackground(Color.LIGHT_GRAY);
p2.setLayout(null);
p2.setBounds(400,30,450,300);
add(p2);
//for Username 
JLabel lblusername = new JLabel("User Name");
lblusername.setBounds(60,20,100,25 );
lblusername.setFont(new Font("SAN SERIF",Font.PLAIN,20));
p2.add(lblusername);
//textfield 
 tfusername = new JTextField();
tfusername.setBounds(60,60,300,30);
tfusername.setBorder(BorderFactory.createEmptyBorder());
p2.add(tfusername);
//for password 
JLabel lblpassword = new JLabel("Password");
lblpassword.setBounds(60,110,100,25 );
lblpassword.setFont(new Font("SAN SERIF",Font.PLAIN,20));
p2.add(lblpassword);
//textfield 
 tfpassword = new JTextField();
tfpassword.setBounds(60,150,300,30);
tfpassword.setBorder(BorderFactory.createEmptyBorder());
p2.add(tfpassword);
//button
login = new JButton("Login");
login.setBounds(60,200,130,30);
login.setBackground(new Color(131,193,233));
login.setForeground(Color.WHITE);
login.setBorder(new LineBorder(new Color(133,193,233)));
login.addActionListener(this);
p2.add(login);
//2nd button
 signup = new JButton("Signup ");
signup.setBounds(230,200,130,30);
signup.setBackground(new Color(131,193,233));
signup.setForeground(Color.WHITE);
signup.setBorder(new LineBorder(new Color(133,193,233)));
signup.addActionListener(this);
p2.add(signup);
//forgot password button
 password = new JButton(" Forget Password");
 password.setBounds(130,250,130,30);
 password.setBackground(new Color(131,193,233));
password.setForeground(Color.WHITE);
password.setBorder(new LineBorder(new Color(133,193,233)));
 password.addActionListener(this);
p2.add( password);
//text
JLabel text = new JLabel("trouble in Login..");
text.setBounds(300,250,150,20);
text.setForeground(Color.RED);
p2.add(text);

   setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == login){
try{
String username =tfusername.getText();
String pass = tfpassword.getText();
String query = "select * from account where username= '"+username+"' AND password = '"+pass+"' ";
conn c = new  conn();
ResultSet rs= c.s.executeQuery(query);
if(rs.next())
{
    setVisible(false);
    new Loading(username);
} else {
    JOptionPane.showMessageDialog(null, "Incorrect username or password");
}
}catch(Exception e){
    e.printStackTrace();
}

        } else if (ae.getSource ()== signup)
{
setVisible(false);
new Signup();
} else {
setVisible(false);
new ForgetPassword();

}
   }
public static void main(String[] args)
{
    new login();
}
}
