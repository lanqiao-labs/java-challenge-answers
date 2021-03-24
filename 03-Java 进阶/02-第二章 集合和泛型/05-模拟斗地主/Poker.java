import java.util.ArrayList;
import java.util.Collections;

public class Poker {
    public static void main(String[] args) {
        //1.准备牌
        //定义一个存储54张牌的ArrayList集合，泛型使用String
        ArrayList<String> poker = new ArrayList<>();
        //定义两个集合，一个数存储牌的花色，一个存储牌的序号
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();
        //将花色添加到花色集合中
        colors.add("♠");
        colors.add("♥");
        colors.add("♣");
        colors.add("♦");
        //将字母添加到序号集合中
        numbers.add("J");
        numbers.add("Q");
        numbers.add("K");
        numbers.add("A");
        //将 2~10 的数字添加到序号集合中
        for (int i = 2; i <= 10; i++) {
            numbers.add(i+"");
        }
        //先把大王小王存储到poker集合中
        poker.add("大王");
        poker.add("小王");
        //循环嵌套遍历两个数组，组装52张牌
        for (String number:numbers) {
            for (String color : colors) {
                //把组装好的牌存储到poker集合中
                poker.add(color+number);
            }
        }
        
        //2.洗牌
         
        Collections.shuffle(poker);
        
        //3.发牌
        //定义4个集合，存储玩家的牌和底牌
        ArrayList<String> player01 = new ArrayList<>();
        ArrayList<String> player02 = new ArrayList<>();
        ArrayList<String> player03 = new ArrayList<>();
        ArrayList<String> diPai = new ArrayList<>();

        /**
         * 遍历poker集合，获取每一张牌
         * 使用poker集合的索引%3给3个玩家轮流发牌
         * 剩余3张牌给底牌
         * 注意：  先判断底牌(i>=51),否则就发没了
         */
        for (int i = 0; i < poker.size(); i++) {
            //获取每一牌
            String p = poker.get(i);
            //轮流发牌
            if (i>=51){
                //给底牌发牌
                diPai.add(p);
            }else if (i%3 == 0){
                //给玩家1发牌
                player01.add(p);
            }else if (i%3 == 1){
                //给玩家2发牌
                player02.add(p);
            }else if (i%3 == 2){
                //给玩家3发牌
                player03.add(p);
            }
        }
        //4.看牌
        System.out.println("玩家1："+player01);
        System.out.println("玩家2："+player02);
        System.out.println("玩家3："+player03);
        System.out.println("底牌："+diPai);
    }
}