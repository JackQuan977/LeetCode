package Singleton;

public class Singleton3 {
    public static void main(String[] args) {
        Singleton3 instance1 = Singleton3.getInstance();
        Singleton3 instance2 = Singleton3.getInstance();
        System.out.println(instance1 == instance2);

    }

    private Singleton3(){}
    private static class SingletonInstance{
        private static final Singleton3 instance = new Singleton3();
    }

    public static Singleton3 getInstance(){
        return SingletonInstance.instance;
    }

}
