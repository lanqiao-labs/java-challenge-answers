import java.util.Scanner;

/**
 * 定义一个StudentProject类
 * @author lanqiao
 */
public class StudentProject {

    /**
     * 该方法输出系统信息
     */
    public void print(){
        System.out.println("*********************");
        System.out.println("*                   *");
        System.out.println("*  学生信息管理系统  *");
        System.out.println("*                   *");
        System.out.println("*********************");
    }

    /**
     * 该方法显示程序主界面，返回用户输入的功能菜单数
     * @return 返回输入的序号
     */
    public int showMenu(){
        System.out.println("*********************");
        System.out.println("1. 添加学生信息");
        System.out.println("2. 删除学生信息");
        System.out.println("3. 修改学生信息");
        System.out.println("4. 查询指定学生信息");
        System.out.println("5. 查询所有学生信息");
        System.out.println("6. 退出程序");
        System.out.println("*********************");
        System.out.print("请选择你的输入（只能输入1、2、3、4、5、6）：");
        Scanner input = new Scanner(System.in);
        return input.nextInt();    //从控制台获取用户输入的选择
    }

    /**
     *  添加数据
     */
    public void addData(){
        System.out.println("执行1.添加学生信息模块");
        System.out.println("******************");
        System.out.println("******************");
    }

    /**
     * 删除数据
     */
    public void deleteData(){
        System.out.println("执行2.删除学生信息模块");
        System.out.println("******************");
        System.out.println("******************");
    }

    /**
     * 修改数据
     */
    public void updateData(){
        System.out.println("执行3.修改学生信息模块");
        System.out.println("******************");
        System.out.println("******************");
    }

    /**
     * 查询指定学生的数据
     */
    public void selectOneData(){
        System.out.println("执行4.查询指定学生信息模块");
        System.out.println("******************");
        System.out.println("******************");
    }

    /**
     * 查询所有学生的信息
     */
    public void selectAllData(){
        System.out.println("执行5.查询所有学生信息模块");
        System.out.println("******************");
        System.out.println("******************");
    }
}