package Singleton;

public class Singleton {
    private enum SingletonInstance{
        INSTANCE;
        private final Singleton instance;

        SingletonInstance(){
            instance = new Singleton();
        }

        private Singleton getInstance(){
            return instance;
        }
    }

    public static Singleton getInstance(){
        return SingletonInstance.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
    }
}
