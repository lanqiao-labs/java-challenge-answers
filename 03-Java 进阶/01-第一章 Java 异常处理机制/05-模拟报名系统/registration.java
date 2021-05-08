import java.util.InputMismatchException;
import java.util.Scanner;

public class registration {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        String Name;
        int Age;
        String Gender;

        System.out.println("请输入您的姓名(不小于 1 个字符且不超过 20 个字符)：");
        Name = inputName();

        System.out.println("请输入您的年龄(18~35)：");
        Age = inputAge();

        System.out.println("请选择您的性别：1. 男    2. 女");
        Gender = setGender();

        System.out.println("您的报名信息为： 姓名：" + Name + "；年龄：" + Age + "；性别：" + Gender);
    }

    public static String inputName() {

        String str;

        while(true){
            try{
                str = setName(s.nextLine());
                return str;
            } catch (nameLengthException e){
                System.out.println(e.toString());
            }
        }
    }

    public static int inputAge() {

        int age;

        while(true){

            try {
                age = setAge(s.nextInt());
                return age;
            } catch (InputMismatchException e){
                System.out.println("年龄应输入数字，请重新输入：");
                s = new Scanner(System.in);
            } catch (ageException e){
                System.out.println(e.toString());
            }
        }
    }

    public static String setName(String str) throws nameLengthException{

        if(str.length() > 20 || str.length() < 1){
            throw new nameLengthException();
        } else {
            return str;
        }
    }

    public static int setAge(int age) throws ageException {

        if(age <= 35 && age >= 18){
            return age;
        } else {
            throw new ageException(age);
        }
    }

    public static String setGender() {

        int num;

        String[] GenderOption = {"男", "女"};

        while(true){

            try{
                num = s.nextInt();
                return GenderOption[num - 1];
            } catch (InputMismatchException e){
                System.out.println("请输入 1 或 2 选择您的性别，请重新输入：");
                s = new Scanner(System.in);
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("请输入 1 或 2 选择您的性别，请重新输入：");
            }
        }
    }

    static class nameLengthException extends Exception {

        private String message;

        public nameLengthException(){
            message = "您输入的姓名长度不符合要求，请重新输入：";
        }

        public String toString(){
            return message;
        }


    }

    static class ageException extends Exception {

        private String message;

        public ageException(int age){
            message = "年龄设置为 " + age + " 不符合要求，请重新输入：";
        }

        public String toString(){
            return message;
        }

    }
}
