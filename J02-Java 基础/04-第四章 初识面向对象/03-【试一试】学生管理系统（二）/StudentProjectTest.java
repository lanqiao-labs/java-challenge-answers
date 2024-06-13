public class StudentProjectTest {

    public static void main(String[] args) {

        StudentProject sp = new StudentProject();
        int flag = 0;
        done: while (flag != 6) {
            sp.print();
            flag = sp.showMenu();
            switch (flag) {
                case 1:
                    sp.addData();
                    break;
                case 2:
                    sp.deleteData();
                    break;
                case 3:
                    sp.updateData();
                    break;
                case 4:
                    sp.selectOneData();
                    break;
                case 5:
                    sp.selectAllData();
                    break;
                case 6:
                    System.out.println("结束程序!");
                    break done;
                default:
                    System.out.println("只能选1-6之间");
                    break;
            }
        }
    }
}
