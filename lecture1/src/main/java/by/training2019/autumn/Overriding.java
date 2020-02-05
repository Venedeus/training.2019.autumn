package by.training2019.autumn;

public class Overriding {
    public static void main(String[] args) {
        Animal cat = new Cat();

        System.out.println("Cat says: " + cat.saySmth());
        System.out.println(cat.doVoice());
        ((Cat) cat).doVoice("I'm a cat!");
    }
}

abstract class Animal{
    public abstract String saySmth();

    protected String doVoice(){
        return "Hello animal-world!";
    }
}

class Cat extends Animal{
    @Override
    public String saySmth() {
        return "Meow!";
    }

    public void doVoice(String voice){
        System.out.println(voice);
    }

//    public String doVoice(){
//        return "Hello cat-world!";
//    }
}
