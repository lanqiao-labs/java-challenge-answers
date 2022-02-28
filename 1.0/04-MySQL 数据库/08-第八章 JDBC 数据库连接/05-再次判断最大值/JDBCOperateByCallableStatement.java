import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.Types;

public class JDBCOperateByCallableStatement {
    public static void main(String[] args) throws Exception {

        Connection con= DriverManager.getConnection("jdbc:mysql:///edusys", "root", "");
        CallableStatement cs =con.prepareCall("{? = call getMax(5, 6)}");
        cs.registerOutParameter(1, Types.INTEGER);
        cs.execute();
        System.out.println("较大值是："+cs.getInt(1));
        cs.close();
        con.close();
    }
    
}
