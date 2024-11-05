package airIndia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class JDBCConnection {

    Connection con;
    Statement s;
//	PreparedStatement ps = null;

    public JDBCConnection() {

        try {
//			1. load or register THE Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
//			2. establish connection

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airIndiaTicketBooking","root","man123");

            s = con.createStatement();
//			 ps = con.prepareStatement("CREATE TABLE login(userName VARCHAR(40),password VARCHAR(30)");
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

}