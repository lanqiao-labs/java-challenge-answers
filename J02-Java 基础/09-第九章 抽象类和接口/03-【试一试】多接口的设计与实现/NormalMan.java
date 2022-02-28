package multi;

public class NormalMan implements Man,Animal,Biology{
    private String name;

    NormalMan(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    @Override
    public void breath(){
        System.out.println(name +" breathes with lungs");
    }

    @Override
    public void hasSex(){
        System.out.println(name+" has sex");
    }

    @Override
    public void eat(){
        System.out.println(name+" eats food");
    }

    @Override
    public void think(){
        System.out.println(name+" think with brain");
    }

    @Override
    public void study(){
        System.out.println(name+" read books");
    }

    public static void main(String[] args) {
        NormalMan nm = new NormalMan("Tom");
        nm.breath();
        nm.hasSex();
        nm.eat();
        nm.think();
        nm.study();
    }
}