import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Querysys {
	 // 补充代码
     static String url="jdbc:mysql:///edusys";
     static String username="root";
     static String pwd="";
     static Scanner sc=new Scanner(System.in);
    
     public static void executeQuery() {
        Connection connection=null;
        PreparedStatement stmt =null;
        ResultSet rs =null;
        try{
             // 补充代码
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("请选择你要查询的信息类别：1.学生信息\t 2.课程信息\t 3.导师信息");
            String choice = sc.next();
            String sql=null;
            switch(choice){
                case "1":
					sql="select ID,name,dept_name from student";
					break;
                case "2":
					sql="select course_id,title,dept_name from course ";
					break;
                default:
					sql="select ID,name,dept_name from instructor";
					break;
            } 
            connection= DriverManager.getConnection(url,username,pwd);
            stmt =connection.prepareStatement(sql);
            rs =stmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getObject(1)+"\t"+rs.getObject(2)+"\t"+rs.getObject(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(rs != null)rs.close();
                if(stmt != null)stmt.close();
                if(connection != null)connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws Exception {
        executeQuery();   
    }
}
