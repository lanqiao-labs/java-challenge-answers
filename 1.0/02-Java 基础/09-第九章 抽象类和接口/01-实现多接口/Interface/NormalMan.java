interface Biology{  //生物接口 
    abstract void breath();
}

interface Animal{   //动物接口
    abstract void hasSex();
    abstract void eat();
}

interface Man{  //人类接口
    abstract void think();
    abstract void study();
}

public class NormalMan implements Man,Animal,Biology{
    private String name;
    NormalMan(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void breath(){
        System.out.println(name +" breathes with lungs");
    }
    public void hasSex(){
        System.out.println(name+" has sex");
    }
    public void eat(){
        System.out.println(name+" eats food");
    }
    public void think(){
        System.out.println(name+" think with brain");
    }
    public void study(){
        System.out.println(name+" read books");
    }

}