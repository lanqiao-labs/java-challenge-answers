import java.util.Scanner;

public class Manage {
    private static Student[] students = new Student[10];
    // 保存当前学生的储存位置
    private static int index=0;
    // 创建控制台输入对象
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("------欢迎来到蓝桥班------");
        while (true){
            System.out.println("1.新增学生");
            System.out.println("2.查询学生");
            System.out.println("请输入对应选项的数字（输入exit退出程序）：");
            String i = sc.next();
            switch(i){
                case "1":
                    addStuent();
                    break;
                case "2":
                    selectStudent();
                    break;
                case "exit":
                    System.out.println("感谢使用！");
                    System.exit(0);
            }
        }
    }

    private static void selectStudent() {
        // 使用 index 作为循环判断条件，避免空指针异常
        for (int i = 0; i < index ; i++) {
            System.out.println("学号："+students[i].getId()+",姓名："+students[i].getName());
        }
    }

    private static void addStuent() {
        // 判断当前下标是否即将超过数组容量，若是则扩充数组容量
        if(index+1==students.length){
            // 创建一个容量为原数组两倍的新数组
            Student[] newStudents = new Student[students.length*2];
            // 将原数组中的元素拷贝至新数组中
            for (int i = 0; i < students.length; i++) {
                newStudents[i] = students[i];
            }
            // 将新数组赋替换掉原数组
            students = newStudents;
        }
        // 提示用户输入新的学生对象信息
        System.out.println("请输入新同学的学号:");
        int id = sc.nextInt();
        System.out.println("请输入新同学的姓名:");
        String name = sc.next();
        // 使用控制台录入的信息创建对象
        Student student = new Student(id,name);
        // 将创建的对象存入数组中
        students[index] = student;
        // 让下标自增1
        index++;
    }

}
