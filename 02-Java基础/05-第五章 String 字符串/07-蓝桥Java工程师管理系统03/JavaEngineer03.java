import java.util.Scanner;

class JavaEngineer03 {
    //Java工程师月薪
    static double avgSalary = 0.0;
    //底薪
    static int basSalary;
    //月工作完成分数（最小值为0，最大值为150）
    static int comResult;
    //月实际工作天数
    static double workDay;
    //月应扣保险数
    static double insurance;
    //从控制台获取输入的对象
    static Scanner input = new Scanner(System.in);
    //用户选择的数
    static int userSel = -1;
    //用户姓名
    static String engName = "" ;
    //用户密码
    static String p1,p2;
    //用户性别
    static String sex;
    //用户学历
    static String education;

    public static void main(String[] args) {
        //使用while(true)，在单个模块功能执行结束后，重新输出主界面，继续循环
        while (true) {
            userSel = showMenu();
            //当用户输入0时，退出while循环，结束程序
            if (userSel == 0) {
                break;
            }
        }
    }


    public static int showMenu() {
        //显示主界面
        System.out.println("--------------------------------------------------------------");
        System.out.println("|             蓝桥Java工程师管理系统                 |");
        System.out.println("--------------------------------------------------------------");
        System.out.println("1. 输入Java工程师资料");
        System.out.println("2. 删除指定Java工程师资料");
        System.out.println("3. 查询Java工程师资料");
        System.out.println("4. 修改Java工程师资料");
        System.out.println("5. 计算Java工程师的月薪");
        System.out.println("6. 保存新添加的工程师资料");
        System.out.println("7. 对Java工程师信息排序（1编号升序，2姓名升序）");
        System.out.println("8. 输出所有Java工程师信息");
        System.out.println("9. 清空所有Java工程师数据");
        System.out.println("10. 打印Java工程师数据报表");
        System.out.println("11. 从文件重新导入Java工程师数据");
        System.out.println("0. 结束（编辑工程师信息后提示保存）");
        System.out.print("请输入您的选择：");
        userSel = input.nextInt();
        switch (userSel) {
            case 1:
                inputEnginnerInfo();
                break;
            case 2:
                deleteEnginnerInfo();
                break;
            case 3:
                queryEnginnerInfo();
                break;
            case 4:
                updateEnginnerInfo();
                break;
            case 5:
                calAvgSalary();
                break;
            case 6:
                saveEnginnerInfo();
                break;
            case 7:
                rankEnginners();
                break;
            case 8:
                showEnginners();
                break;
            case 9:
                emptyEnginners();
                break;
            case 10:
                printEnginnersData();
                break;
            case 11:
                importEnginnersData();
                break;
            case 0:
                System.out.println("程序结束！");
                break;
            default:
                System.out.println("数据输入错误！");
                break;
        }
        return userSel;
    }

    //  计算Java工程师的月薪
    public static void calAvgSalary() {
        System.out.print("请输入Java工程师底薪：");
        //从控制台获取输入的底薪，将其赋值给basSalary
        basSalary = input.nextInt();
        System.out.print("请输入Java工程师月工作完成分数（最小值为0，最大值为150）：");
        //从控制台获取输入的月工作完成分数，赋值给comResult
        comResult = input.nextInt();
        System.out.print("请输入Java工程师月实际工作天数：");
        //从控制台获取输入的月实际工作天数，赋值给workDay
        workDay = input.nextDouble();
        System.out.print("请输入Java工程师月应扣保险数：");
        //从控制台获取输入的月应扣保险数，赋值给insurance
        insurance = input.nextDouble();
                    /*Java工程师月薪= 底薪 + 底薪×25%×月工作完成分数/100+
                     15×月实际工作天数 - 月应扣保险数；
                    */
        avgSalary = basSalary + basSalary * 0.25 * comResult / 100
                + 15 * workDay - insurance;
        System.out.println("Java工程师月薪为：" + avgSalary);
    }

    //使用verify方法对用户名、密码进行验证，返回是否成功
    public static boolean verify(String name,String pwd1,String pwd2){
        boolean flag = false;//标识是否成功
        if(name.length() < 2 || pwd1.length() < 8){
            System.out.println("用户名长度不能小于2，密码长度不能小于8！");
            }else if(!pwd1.equals(pwd2)){
                System.out.println("两次输入的密码不相同！");
            }else{
                System.out.println("注册成功！请牢记用户名和密码。");
                flag=true;
        }
        return flag;
    }


     public static void inputEnginnerInfo() {
        
        boolean resp = false;
        do{
            System.out.print("请输入Java工程师用户名： ");
            engName = input.next();
            System.out.print("请输入密码： ");
            p1 = input.next();
            System.out.print("请再次输入密码： ");
            p2 = input.next();
            //调用verify方法对用户名、密码进行验证，返回是否成功
            resp = verify(engName, p1, p2);
        }while(!resp);
        System.out.print("请输入性别： ");
        sex = input.next();
        System.out.print("请输入学历： ");
        education = input.next();
        System.out.print("请输入底薪： ");
        basSalary = input.nextInt();
    }


    public static void deleteEnginnerInfo() {
        System.out.println("本模块功能未实现");
    }

    public static void queryEnginnerInfo() {
        System.out.print("Java工程师用户名： ");
        System.out.println(engName);
        System.out.print("\t密码： ");
        System.out.println(p2);
        System.out.print("\t性别： ");
        System.out.println(sex);
        System.out.print("\t学历： ");
        System.out.println(education);

        System.out.print("\t底薪： ");
        System.out.println(basSalary);
    }


    public static void updateEnginnerInfo() {
        System.out.println("本模块功能未实现");
    }

    public static void saveEnginnerInfo() {
        System.out.println("本模块功能未实现");
    }

    public static void rankEnginners() {
        System.out.println("本模块功能未实现");
    }

    public static void showEnginners() {
        System.out.println("本模块功能未实现");
    }

    public static void emptyEnginners() {
        System.out.println("本模块功能未实现");
    }

    public static void printEnginnersData() {
        System.out.println("本模块功能未实现");
    }

    public static void importEnginnersData() {
        System.out.println("本模块功能未实现");
    }
}

