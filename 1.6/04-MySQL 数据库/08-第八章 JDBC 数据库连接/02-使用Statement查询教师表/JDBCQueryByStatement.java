import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCQueryByStatement {
    public static void main(String[] args) throws Exception {

        Connection con= DriverManager.getConnection("jdbc:mysql:///edusys", "root", "");
        Statement sta= con.createStatement();
        ResultSet rs =sta.executeQuery("select * from classroom");
        while(rs.next()){
            System.out.println(rs.getString(1)+"\t"+rs.getInt(2)+"\t"+rs.getObject(3));
        }

        rs.close();
        sta.close();
        con.close();
    }
    
}
