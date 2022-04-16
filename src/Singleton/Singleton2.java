package Singleton;

public class Singleton2 {
    public static void main(String[] args) {
        Singleton2 instance1 = Singleton2.getInstance();
        Singleton2 instance2 = Singleton2.getInstance();
        System.out.println(instance1 == instance2);

    }
    private Singleton2(){}
    private static Singleton2 instance = new Singleton2();
    public static Singleton2 getInstance(){

        return instance;
    }
}
