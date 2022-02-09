import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCDeleteByPreparedStatement {
    public static void main(String[] args) throws Exception {

        Connection con= DriverManager.getConnection("jdbc:mysql:///edusys", "root", "");
        PreparedStatement ps =con.prepareStatement("delete from instructor where name = 'Wu'");
        int row = ps.executeUpdate();
        if(row>0){
            System.out.println("删除成功");
        }
        ps.close();
        con.close();
    }
    
}
