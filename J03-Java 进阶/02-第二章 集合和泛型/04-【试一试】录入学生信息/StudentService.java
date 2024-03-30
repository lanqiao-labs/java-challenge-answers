import java.util.HashSet;
import java.util.Set;

/**
 * @author Teacher Tao
 */
public class StudentService {

    // 创建集合对象
    private Set<Student> students = new HashSet<>();
    
    // 录入学生信息
    public boolean addStudent(Student student){
           return students.add(student);
    }
    // 显示学生信息
    public void showStudent(){
        for (Student student : students) {
			System.out.println(student);
		}
    }
    
    
    public static void main(String[] args) {
		StudentService ss = new StudentService();
        System.out.println(ss.addStudent(new Student("张三","一年级"))?"学生信息录入成功":"学生信息录入失败");
        System.out.println(ss.addStudent(new Student("李四","二年级"))?"学生信息录入成功":"学生信息录入失败");
        System.out.println(ss.addStudent(new Student("小桃子","三年级"))?"学生信息录入成功":"学生信息录入失败");
        System.out.println(ss.addStudent(new Student("张三","一年级"))?"学生信息录入成功":"学生信息录入失败");
		ss.showStudent();
	}
}
