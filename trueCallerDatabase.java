import java.sql.*; 
import java.sql.Connection;
import java.sql.DriverManager;

public class trueCallerDatabase {
  public static void main(String args[]) {
    try {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    } catch (Exception e) {
      System.out.println("JDBC-ODBC driver failed to load.");
      return;
    }

    try {
      Connection con = DriverManager.getConnection("jdbc:odbc:abbas", "", "");

	String s=	"create table school (serial_no number,name varchar(20),branch varchar(20),mobile number)";
//	String s=	"insert into school values(01,'abbas','ec',1000);";
//	String s=	"insert into school values(02,'ajab','it',2000)";
//	String s=	"insert into school values(03,'garvit','me'3100);";
	Statement S=con.createStatement();
			
			S.executeQuery(s);  

 con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}