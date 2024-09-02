
# 一、现代陆战装备（一）

## 参考答案

1. `MarineEquipment.java` 类

```java
package org.lanqiao.entity;

/**
 * 陆战装备类
 */
public class MarineEquipment {
    private int range;  //射程
    private double weight;  //重量

    /**
     * get/set方法
     */
    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * 构造方法
     */
    public MarineEquipment() {
    }

    public MarineEquipment(int range, double weight) {
        this.range = range;
        this.weight = weight;
    }

    /**
     * 显示性能参数信息
     */
    public String showInfo() {
        return "射程：" + this.getRange() + "公里，重量：" + this.getWeight() + "吨";
    }

    /**
     * 开火
     */
    public void fire() {
        System.out.println("开火");
    }
}
```
2. `Tank.java` 类

```java
package org.lanqiao.entity;

/**
 * 坦克类
 */
public class Tank extends MarineEquipment {
    private double length; // 车长
    private double width; // 车宽
    private double maximumRoadSpeed; // 最大公路速度

    /**
     * get/set方法
     */
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getMaximumRoadSpeed() {
        return maximumRoadSpeed;
    }

    public void setMaximumRoadSpeed(double maximumRoadSpeed) {
        this.maximumRoadSpeed = maximumRoadSpeed;
    }

    /**
     * 构造方法
     */
    public Tank() {
    }

    public Tank(double length, double width, double maximumRoadSpeed) {
        this.length = length;
        this.width = width;
        this.maximumRoadSpeed = maximumRoadSpeed;
    }
    /**
     * 重写父类方法，显示性能参数信息
     */
    public String showInfo() {
        return "射程：" + this.getRange() + "公里，重量：" + this.getWeight() + "吨，车长：" + this.getLength() + "米，车宽："
                + this.getWidth() + "米，最在公路速度：" + this.getMaximumRoadSpeed() + "公里/小时";
    }
}
```
3. `Test.java` 类

```java
package org.lanqiao.test;

import org.lanqiao.entity.Tank;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        Tank tank = new Tank();
        tank.setRange(3);
        tank.setWeight(3);
        tank.setLength(8);
        tank.setWidth(4);
        tank.setMaximumRoadSpeed(80);
        System.out.println(tank.showInfo()); 
    }
}
```

# 二、现代海战装备

## 参考答案

1. `Warship.java` 类

```java
package org.lanqiao.entity;

/**
 * 战舰类
 */
public class Warship {
    private int draft; // 吃水
    private int length; // 舰长
    private int beam; // 舰宽
    private double speed; // 航速
    private String endurance; // 继航
    private String model; // 型号

    /** get/set方法 */
    public int getDraft() {
        return draft;
    }

    public void setDraft(int draft) {
        this.draft = draft;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getEndurance() {
        return endurance;
    }

    public void setEndurance(String endurance) {
        this.endurance = endurance;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBeam() {
        return beam;
    }

    public void setBeam(int beam) {
        this.beam = beam;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 空构造方法
     */
    public Warship() {
    }

    /**
     * 航行
     */
    public void navigation() {
        System.out.println("行驶");
    }

    /**
     * 开火
     */
    public void fire() {
        System.out.println("开火");
    }
}
```
2. `Fighter.java` 类

```java
package org.lanqiao.entity;
/**
 * 护卫舰类
 */
public class Frigate extends Warship {
    public void fire(){
        System.out.println("发射舰对空导弹");
    }
}

```
3. `Destroyer.java` 类

```java
package org.lanqiao.entity;
/**
 * 驱逐舰类
 */
public class Destroyer extends Warship {
    public void fire(){
        System.out.println("发射深水炸弹");
    }
}
```
4. `Submarine.java` 类

```java
package org.lanqiao.entity;
/**
 * 潜艇类
 */
public class Submarine extends Warship {
    public void fire(){
        System.out.println("发射鱼雷");
    }
}
```

# 三、现代空战装备（一）

## 参考答案

1. `Fighter.java` 类

```java
package org.lanqiao.entity;
/**
 * 战机类
 */
public class Fighter{
    private int range;  //最大航程
    private double speed;  //飞行速度
    private int crew;  //乘员数量
    private double maximumTakeoffWeight;  //起飞重量
    private double length;  //长度
    private double wingspan;  //翼展
    private double height;  //高度
    private double combatRadius;  //作战半径
    /**
     * get/set方法
     */
    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public double getMaximumTakeoffWeight() {
        return maximumTakeoffWeight;
    }

    public void setMaximumTakeoffWeight(double maximumTakeoffWeight) {
        this.maximumTakeoffWeight = maximumTakeoffWeight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getCombatRadius() {
        return combatRadius;
    }

    public void setCombatRadius(double combatRadius) {
        this.combatRadius = combatRadius;
    }
    /**
     * 构造方法
     */
    public Fighter(){}
    public Fighter(int range, double speed, int crew, double maximumTakeoffWeight, double length, double wingspan, double height, double combatRadius) {
        this.range = range;
        this.speed = speed;
        this.crew = crew;
        this.maximumTakeoffWeight = maximumTakeoffWeight;
        this.length = length;
        this.wingspan = wingspan;
        this.height = height;
        this.combatRadius = combatRadius;
    }

    /**
     * 开火
     */
    public void fire(){
        System.out.println("开火");
    }

    /**
     * 飞行
     */
    public void flight(){
        System.out.println("飞行");
    }

    /**
     * 用途描述
     */
    public void function (){
        System.out.println("战斗机");
    }

    public String toString() {
        return "Fighter [range="+range + ", speed=" + speed + ", crew=" + crew + ", maximumTakeoffWeight="
                + maximumTakeoffWeight + ", length=" + length + ", wingspan=" + wingspan + ", height=" 
                + height+ ", combatRadius=" + combatRadius + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fighter other = (Fighter) obj;
        if (range != other.range)
            return false;
        if (Double.doubleToLongBits(speed) != Double.doubleToLongBits(other.speed))
            return false;
        if (crew != other.crew)
            return false;
        if (Double.doubleToLongBits(maximumTakeoffWeight) != Double.doubleToLongBits(other.maximumTakeoffWeight))
            return false;
        if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
            return false;
        if (Double.doubleToLongBits(wingspan) != Double.doubleToLongBits(other.wingspan))
            return false;
        if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
            return false;
        if (Double.doubleToLongBits(combatRadius) != Double.doubleToLongBits(other.combatRadius))
            return false;
        return true;
    }
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + range;
        long temp;
        temp = Double.doubleToLongBits(speed);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + crew;
        temp = Double.doubleToLongBits(maximumTakeoffWeight);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(length);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(wingspan);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(combatRadius);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
```
2. `Test.java` 类

```java
package org.lanqiao.test;

import org.lanqiao.entity.Fighter;

/**
 * 测试类
 */
public class Test{
    public static void main(String[] args) {
        Fighter f1 = new Fighter(1000, 800, 2, 50, 15, 20, 5.2, 500);
        Fighter f2 = new Fighter(1200, 800, 2, 50, 15, 20, 5.2, 300);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f1.equals(f2));
    }
}
```

# 四、现代陆战装备（二）

## 参考答案

1. `MarineEquipment.java` 类

```java
package org.lanqiao.entity;

/**
 * 陆战装备类
 */
public class MarineEquipment {
    private int range;  //射程
    private double weight;  //重量

    /**
     * get/set方法
     */
    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * 构造方法
     */
    public MarineEquipment() {
    }

    public MarineEquipment(int range, double weight) {
        this.range = range;
        this.weight = weight;
    }

    /**
     * 显示性能参数信息
     */
    public String showInfo() {
        return "射程：" + this.getRange() + "公里，重量：" + this.getWeight() + "吨";
    }

    /**
     * 开火
     */
    public void fire() {
        System.out.println("开火");
    }
}
```
2. `Tank.java` 类

```java
package org.lanqiao.entity;

/**
 * 坦克类
 */
public class Tank extends MarineEquipment {
    private double length; // 车长
    private double width; // 车宽
    private double maximumRoadSpeed; // 最大公路速度

    /**
     * get/set方法
     */
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getMaximumRoadSpeed() {
        return maximumRoadSpeed;
    }

    public void setMaximumRoadSpeed(double maximumRoadSpeed) {
        this.maximumRoadSpeed = maximumRoadSpeed;
    }

    /**
     * 构造方法
     */
    public Tank() {
    }

    public Tank(int range, double weight, double length, double width, double maximumRoadSpeed) {
        // 调用父类的全参构造方法，为父类属性赋值
        super(range, weight);
        // 为属性赋值
        this.length = length;
        this.width = width;
        this.maximumRoadSpeed = maximumRoadSpeed;
    }

    /**
     * 重写父类方法，显示性能参数信息
     */
    public String showInfo() {
        return "射程：" + super.getRange() + "公里，重量：" + super.getWeight() + "吨，车长：" + this.getLength() + "米，车宽："
                + this.getWidth() + "米，最在公路速度：" + this.getMaximumRoadSpeed() + "公里/小时";
    }
}
```
3. `Test.java` 类

```java
package org.lanqiao.test;

import org.lanqiao.entity.Tank;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        Tank tank = new Tank(3, 3, 8, 4, 80);
        System.out.println(tank.showInfo());
    }
}
```

# 五、现代空战装备（二）

## 参考答案

1. `Warship.java` 类

```java
package org.lanqiao.entity;
/**
 * 战舰类
 */
public class Warship {
    private int draft;  //吃水
    private int length;  //舰长
    private int beam;  //舰宽
    private double speed;  //航速
    private String endurance;  //继航
    private String model;   //型号
    /**get/set方法*/
    public int getDraft() {
        return draft;
    }

    public void setDraft(int draft) {
        this.draft = draft;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getEndurance() {
        return endurance;
    }

    public void setEndurance(String endurance) {
        this.endurance = endurance;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBeam() {
        return beam;
    }

    public void setBeam(int beam) {
        this.beam = beam;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 构造方法
     */
    public Warship() {
    }
    
    public Warship(int draft, int length, int beam, double speed, String endurance, String model) {
        this.draft = draft;
        this.length = length;
        this.beam = beam;
        this.speed = speed;
        this.endurance = endurance;
        this.model = model;
    }

    /**
     * 航行
     */
    public void navigation(){
        System.out.println("行驶");
    }

    /**
     * 开火
     */
    public void fire(){
        System.out.println("开火");
    }

     @Override
    public String toString() {
        return "Warship [吃水=" + draft + "米, 舰长=" + length + "米, 舰宽=" + beam + "米, 航速=" + speed + "节, 续航="+ endurance + ", 型号=" + model + "]";
    }
}
```

2. `Destroyer.java` 类

```java
package org.lanqiao.entity;

/**
 * 驱逐舰类
 */
public class Destroyer extends Warship {
    public void fire() {
        super.fire();
        System.out.println("发射深水炸弹");
    }

    public String toString() {
        return super.toString() + "的驱逐舰";
    }
}
```

3. `Frigate.java` 类

```java
package org.lanqiao.entity;

/**
 * 护卫舰类
 */
public class Frigate extends Warship {
    public void fire() {
        super.fire();
        System.out.println("发射舰对空导弹");
    }

    public String toString() {
        return super.toString() + "的护卫舰";
    }
}
```

4. `Submarine.java` 类

```java
package org.lanqiao.entity;

/**
 * 潜艇类
 */
public class Submarine extends Warship {
    public void fire() {
        super.fire();
        System.out.println("发射鱼雷");
    }

    public String toString() {
        return super.toString() + "的潜艇";
    }
}
```

5. `Test.java` 类

```java
package org.lanqiao.test;

import org.lanqiao.entity.Destroyer;
import org.lanqiao.entity.Frigate;
import org.lanqiao.entity.Submarine;
/**
 * 测试类
 */
public class Test{
    public static void main(String[] args) {
        Destroyer d = new Destroyer();
        d.setDraft(6);
        d.setLength(163);
        d.setBeam(17);
        d.setSpeed(32);
        d.setEndurance("5000/18节");
        d.setModel("加尔各答级");
        Frigate f = new Frigate();
        f.setDraft(6);
        f.setLength(134);
        f.setBeam(16);
        f.setSpeed(27);
        f.setEndurance("4000/18节");
        f.setModel("国产054");
        Submarine s = new Submarine();
        s.setDraft(17);
        s.setLength(75);
        s.setBeam(10);
        s.setSpeed(17);
        s.setEndurance("6000/7节");
        s.setModel("基洛级");
        System.out.println(d.toString());
        d.fire();
        System.out.println(f.toString());
        f.fire();
        System.out.println(s.toString());
        s.fire();
    }
}
```

# 六、大厂笔试

## 参考答案

1. `Counter.java` 类

```java
package org.lanqiao.entity;

/**
 * 计数器类
 */
public class Counter {

    private String id; // 编号
    private String reserve; // 预留
    public static int count; // 计数

    /** get/set方法 */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    /** 构造方法 */
    public Counter() {
    }

    public Counter(String id, String reserve) {
        this.id = id;
        this.reserve = reserve;
        increment();
    }

    /**
     * 打印信息
     */
    public void show() {
        System.out.println("编号：" + this.id + "，预留：" + this.reserve);
    }

    /**
     * 计数累加
     */
    public static void increment() {
        count++;
        System.out.println("第 " + count + " 个Counter对象");
    }
}
```

2. `Test.java` 类

```java
package org.lanqiao.test;

import org.lanqiao.entity.Counter;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        // 创建2个Counter对象
        Counter c1 = new Counter("188944", "无");
        c1.show();
        Counter c2 = new Counter("4444444", "好消息");
        c2.show();
        // 显示Counter对象的个数
        System.out.println("Counter对象个数为：" + Counter.count);
    }
}
```
## 结束
