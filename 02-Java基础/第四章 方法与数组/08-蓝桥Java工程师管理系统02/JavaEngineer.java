import java.util.Scanner;

class JavaEngineer {
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

    public static void inputEnginnerInfo() {
        System.out.println("本模块功能未实现");
    }

    public static void deleteEnginnerInfo() {
        System.out.println("本模块功能未实现");
    }

    public static void queryEnginnerInfo() {
        System.out.println("本模块功能未实现");
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

