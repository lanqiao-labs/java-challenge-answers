public class Student
{
    private String name;
    private String sex;
    private int age;

    public Student(String name, String sex, int age)
    {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getSex()
    {
        return sex;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public int getAge()
    {
        return age;
    }
    public boolean setAge(int age)
    {
        if (age >25)
        {
            return false;
        }
        else
        {
            this.age = age;
            return true;
        }
    }
}