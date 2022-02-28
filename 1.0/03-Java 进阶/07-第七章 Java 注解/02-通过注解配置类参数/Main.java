package Car;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {

        CarIns ann = new CarIns();
        for(Field field : ann.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(MyTag.class)){  //如果存在MyTag标签
                MyTag myTag = field.getAnnotation(MyTag.class);
                ann.setCar(new Car(myTag.name(),myTag.size()));
            }
        }
        System.out.println(ann.getCar());

    }
}