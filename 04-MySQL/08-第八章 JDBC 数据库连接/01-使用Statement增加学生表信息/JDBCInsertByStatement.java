import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCInsertByStatement{

    public static void main(String[] args) throws Exception {
        Connection con= DriverManager.getConnection("jdbc:mysql:///edusys", "root", "");
        Statement sta= con.createStatement();
        sta.executeUpdate("insert into student(ID,name,dept_name,tot_cred) values(33123,'Rong','Music',67)");
        sta.close();
        con.close();
    }
    
}