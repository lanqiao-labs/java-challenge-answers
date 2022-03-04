/**
 * @author Teacher Tao
 */
public class Student {
    
    // 两个属性
    // 学生姓名
    private String name;	
    // 学生年级
    private String grade;
    
    // 提供构造方法
    public Student() {
		
	}

	public Student(String name, String grade) {
		super();
		this.name = name;
		this.grade = grade;
    }
    
    // 提供 get/set 方法
    public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}
    
    // 重写 toString、hashCode、equals 方法
    
    @Override
	public String toString() {
		return "Student:name=" + name + ",grade=" + grade;
	}
    
    @Override
    public int hashCode() {
        final int prime = 31;
		int result = 1;
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		if(obj instanceof Student) {
			Student s = (Student) obj;
			if (grade == null) {
				if (s.grade != null) {
					return false;
				}
			} else if (!grade.equals(s.grade)) {
				return false;
			}
			if (name == null) {
				if (s.name != null) {
					return false;
				}
			} else if (!name.equals(s.name)) {
				return false;
			}
		}
		return true;
    } 
}