import java.sql.*;
public class conn
{
    Connection c;
    Statement s;
    //Ragister the driver
    conn(){
try{ 
    Class.forName("com.mysql.cj.jdbc.Driver");
c=DriverManager.getConnection("jdbc:mysql:/// Travelmanagementsystem","root","PrograMOBI7");
s = c.createStatement();
} catch (Exception e)
{
    e.printStackTrace();
}
}
}