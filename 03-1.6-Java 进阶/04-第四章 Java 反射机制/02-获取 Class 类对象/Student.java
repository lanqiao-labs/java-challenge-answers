/**
 * @author Teacher Tao
 *
 */
public class Student extends Person {
	//年级
	private String grade;
	
	public Student() {
		
	}
	
	public Student(String grade) {
		super();
		this.grade = grade;
	}

	public Student(String name, int age, String grade) {
		super(name, age);
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [name=" + super.getName() + ", age=" + super.getAge() +", grade= " + grade + "]";
	}

}
