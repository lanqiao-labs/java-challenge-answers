import java.util.Date;

/**
 * @author Teacher Tao
 *
 */
public class Teacher extends Person {
	//参加工作日期
	private Date worktime;
	//职称
	private String title;
	
	public Teacher() {
		
	}

	public Teacher(Date worktime, String title) {
		super();
		this.worktime = worktime;
		this.title = title;
	}

	public Teacher(String name, int age, Date worktime, String title) {
		super(name, age);
		this.worktime = worktime;
		this.title = title;
	}

	public Date getWorktime() {
		return worktime;
	}

	public void setWorktime(Date worktime) {
		this.worktime = worktime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + super.getName() + ", age=" + super.getAge() +", worktime=" + worktime + ", title=" + title + "]";
	}

}
