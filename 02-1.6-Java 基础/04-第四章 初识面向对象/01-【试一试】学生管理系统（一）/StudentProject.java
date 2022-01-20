import java.util.Scanner;
/**
 * 创建一个学生管理系统的类
 * @author lanqiao
 */
public class StudentProject {
    public static void main(String[] args) {
        int studentSel = -1;                //用户选择输入的参数

        // 输出系统名称
        print();

        //使用while(true)，在单个模块功能执行结束后，重新输出主界面，继续循环
        while (true) {
            //调用showMenu()方法获得用户输入
            studentSel = showMenu();

            switch (studentSel) {
                case 1:
                    addData();
                    break;
                case 2:
                    deleteData();
                    break;
                case 3:
                    updateData();
                    break;
                case 4:
                    selectOneData();
                    break;
                case 5:
                    selectAllData();
                    break;
                case 6:
                    System.out.println("结束程序！");
                    break;
                default:
                    System.out.println("输入数据不正确！");
                    break;
            }

            //当学生输入6时，退出while循环，结束程序
            if (studentSel == 6){
                break;
            }
        }
    }

    /**
     * 该方法输出系统信息
     */
    public static void print(){
        System.out.println("*********************");
        System.out.println("*                   *");
        System.out.println("*  学生信息管理系统  *");
        System.out.println("*                   *");
        System.out.println("*********************");
    }

    /**
     * 该方法显示程序主界面，返回用户输入的功能菜单数
     */
    public static int showMenu(){
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
     * 添加数据
     */
    public static void addData(){
        System.out.println("执行1.添加学生信息模块");
        System.out.println("******************");
        System.out.println("******************");
    }


    /**
     * 删除数据
     */
    public static void deleteData(){
        System.out.println("执行2.删除学生信息模块");
        System.out.println("******************");
        System.out.println("******************");
    }

    /**
     * 修改数据
     */
    public static void updateData(){
        System.out.println("执行3.修改学生信息模块");
        System.out.println("******************");
        System.out.println("******************");
    }

    /**
     * 查询指定学生的信息
     */
    public static void selectOneData(){
        System.out.println("执行4.查询指定学生信息模块");
        System.out.println("******************");
        System.out.println("******************");
    }

    /**
     * 查询所有学生的信息
     */
    public static void selectAllData(){
        System.out.println("执行5.查询所有学生信息模块");
        System.out.println("******************");
        System.out.println("******************");
    }
}