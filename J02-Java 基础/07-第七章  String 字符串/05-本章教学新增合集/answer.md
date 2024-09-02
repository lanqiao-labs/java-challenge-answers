---
show: step
version: 1.0
enable_checker: true
---

# 相关实现代码

## 挑战名称

- 身份证号码信息提取【高】
- 获取火车中文站点【中】
- 荒野生存挑战【高】
- 黄金的价值【中】
- 课程与学分【高】
- 文本去重【中】



## 身份证号码信息提取【高】 实现代码


```java
import java.util.Scanner;

public class IdCardNumInfoExt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的身份证号码:");
        String idCard;
        while (true){
            idCard = sc.next();
            if (idCard.length() != 18) {
                System.out.println("您输入身份证号码有误，请重新输入。");
            }
            else {
                break;
            }
        }

        // 提取身份证号码信息数据
        String year = idCard.substring(6, 10);
        String month = idCard.substring(10, 12);
        String day = idCard.substring(12, 14);
        String gender = idCard.substring(16, 17);

        // 处理性别数据
        int num = gender.charAt(0);
        if (num % 2 == 0) {
            gender = "女";
        }
        else {
            gender = "男";
        }
        // 优化利用(?:)三元运算符实现性别的设置，gender = num % 2 == 0 ? "女": "男";

        // 信息输出核对
        System.out.println("《提取的身份证号码信息》");
        System.out.println("出生日期：" + year + "年" + month + "月" + day + "日");
        System.out.println("性别：" + gender);
    }
}
```

## 获取火车中文站点【中】 实现代码


```java
public class TrainChinaSite {
    public static void main(String[] args) {
        String data = "var station_names = '@bjb|北京北|VAP|beijingbei|bjb|0|0357|北京|||@bjd|北京东|BOP|beijingdong|bjd|1|0357|北京|||@bji|北京|BJP|beijing|bj|2|0357|北京|||@bjn|北京南|VNP|beijingnan|bjn|3|0357|北京|||@bjx|北京大兴|IPP|beijingdaxing|bjdx|4|0357|北京|||@bjx|北京西|BXP|beijingxi|bjx|5|0357|北京|||@bjy|北京朝阳|IFP|beijingchaoyang|bjcy|6|0357|北京|||@cqb|重庆北|CUW|chongqingbei|cqb|7|1717|重庆|||@cqi|重庆|CQW|chongqing|cq|9|1717|重庆|||@cqn|重庆南|CRW|chongqingnan|cqn|10|1717|重庆|||@cqx|重庆西|CXW|chongqingxi|cqx|12|1717|重庆|||@sha|上海|SHH|shanghai|sh|13|0712|上海|||@shn|上海南|SNH|shanghainan|shn|14|0712|上海|||@shq|上海虹桥|AOH|shanghaihongqiao|shhq|15|0712|上海|||@shx|上海西|SXH|shanghaixi|shx|16|0712|上海|||@tjb|天津北|TBP|tianjinbei|tjb|17|0359|天津|||@tji|天津|TJP|tianjin|tj|18|0359|天津|||@tjn|天津南|TIP|tianjinnan|tjn|19|0359|天津|||@tjx|天津西|TXP|tianjinxi|tjx|20|0359|天津|||@wxi|万象|YTM|wanxiang|wx|21|9206|万象|lao|老挝|vientiane@bji|滨江|BJB|binjiang|bj|22|0034|哈尔滨|||@bla|百浪|BRZ|bailang|bl|23|1607|南宁|||@bmq|班猫箐|BNM|banmaoqing|bmq|24|1902|昆明|||@byi|北营|BIV|beiying|by|25|0405|太原|||@cch|长春|CCT|changchun|cc|26|0110|长春|||@ccn|长春南|CET|changchunnan|ccn|27|0110|长春|||@ccx|长春西|CRT|changchunxi|ccx|28|0110|长春|||@cdd|成都东|ICW|chengdudong|cdd|30|1707|成都|||@cdn|成都南|CNW|chengdunan|cdn|31|1707|成都|||@cdu|成都|CDW|chengdu|cd|33|1707|成都|||@cdx|成都西|CMW|chengduxi|cdx|34|1707|成都|||@cgy|陈官营|CAJ|chenguanying|cgy|35|2102|兰州|||@cqi|长清|CNK|changqing|cq|36|0602|济南|||@csh|长沙|CSQ|changsha|cs|37|1407|长沙|||@csn|长沙南|CWQ|changshanan|csn|38|1407|长沙|||@csx|长沙西|RXQ|changshaxi|csx|39|1407|长沙|||@czh|常庄|CVK|changzhuang|cz|40|0602|济南|||@dch|大成|DCT|dacheng|dc|41|0205|沈阳|||';";

。
        int startIndex = data.indexOf("'");
。
        int lastIndex = data.lastIndexOf("'");

        String cleanOutStr = data.substring(startIndex + 1, lastIndex);

        String[] sites = cleanOutStr.split("\\|");

        for (int i = 1; i <= sites.length; i += 10){
            System.out.print(sites[i] + ",");
        }
        
    }

}
```

## 荒野生存挑战【高】 实现代码


```java
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class IntoTheWild {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入挑战者进岛日期，格式 yyyy-MM-dd：");
        String passInto = sc.next();
        System.out.println("请输入挑战者离岛日期，格式 yyyy-MM-dd：");
        String leaveInto = sc.next();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date passIntoDate = sdf.parse(passInto);
        Date leaveIntoDate = sdf.parse(leaveInto);
        
        long passIntoMsec = passIntoDate.getTime();
        long leaveIntoMsec = leaveIntoDate.getTime();

        System.out.println("挑战者在荒野生存挑战：" + (leaveIntoMsec - passIntoMsec) / 1000 / 60 / 60 / 24 + "天");
    }
}
```

## 黄金的价值【中】 实现代码


```java
import java.text.NumberFormat;
import java.util.Scanner;

public class InvestmentValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您之前购买黄金的数量(单位:克)：");
        float xau = sc.nextFloat();
        
        System.out.println("请输入2024年7月12日每克黄金汇率：");
        float value_7 = sc.nextFloat();
        
        System.out.println("请输入2024年8月12日每克黄金汇率：");
        float value_8 = sc.nextFloat();
        
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println("截止2024年7月12日，您购买的黄金总价值为：" + nf.format(xau * value_7));
        System.out.println("截止2024年8月12日，您购买的黄金总价值为："  + nf.format(xau * value_8));
        
        nf = NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(4);
        float ringRatio = (value_8 - value_7) / value_7 * 1;
        System.out.println("黄金投资8月12日环比上月：" + nf.format(ringRatio));

    }
}
```


## 课程与学分【高】 实现代码


```java
public class CouAndCre {
    public static void main(String[] args) {
        String[] subjects = {"网页三剑客", "Java程序设计基础", "MySQL数据库", "Linux操作系统", "SSM框架技术"};
        int[] credits = {5, 7, 4, 3, 8};

        StringBuffer sb = new StringBuffer();

        for(int i=0; i<subjects.length; i++){
            if(i == 0){
                sb.append("{").append(subjects[i]).append(":").append(credits[i]).append(",");
            }else if(i == subjects.length - 1){
                sb.append(subjects[i]).append(":").append(credits[i]).append("}");
            }else {
                sb.append(subjects[i]).append(":").append(credits[i]).append(",");
            }
        }

        System.out.println(sb);
    }
}
```


## 文本去重【中】 实现代码


```java
public class TextDup {
    public static void main(String[] args) {
        String content = "我爱北京天安门和北京故宫，清晨太阳冉冉升起。";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < content.length(); i++){
            char c = content.charAt(i);
            if (content.indexOf(c) == content.lastIndexOf(c)) {
                sb.append(c);
            }
            else {
                if (content.indexOf(c) == i){
                    sb.append(c);
                }
            }
        }
        System.out.println(sb);
    }
}
```

