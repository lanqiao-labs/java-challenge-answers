import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class JDBCQueryByPreparedStatement {
    public static void main(String[] args) throws Exception {

        Connection con= DriverManager.getConnection("jdbc:mysql:///edusys", "root", "");
        PreparedStatement ps =con.prepareStatement("select * from instructor where salary > 6000");
        ResultSet rs =ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString(2)+"\t"+rs.getObject(4));
        }
        rs.close();
        ps.close();
        con.close();
    }
    
}
