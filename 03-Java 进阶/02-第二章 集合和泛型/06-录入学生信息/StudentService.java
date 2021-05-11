import java.util.HashSet;
import java.util.Set;

/**
 * @author Teacher Tao
 */
public class StudentService {

    // 创建集合对象
    private Set<Student> students = new HashSet<>();
    
    // 录入学生信息
    public boolean addStudent(){
        try {
			students.add(new Student("张三","一年级"));
			students.add(new Student("李四","二年级"));
			students.add(new Student("小桃子","三年级"));
			students.add(new Student("张三","一年级"));
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    // 显示学生信息
    public void showStudent(){
        for (Student student : students) {
			System.out.println(student);
		}
    }
    
    
    public static void main(String[] args) {
		StudentService ss = new StudentService();
		System.out.println(ss.addStudent()?"学生信息录入成功":"学生信息录入失败");
		ss.showStudent();
	}
}