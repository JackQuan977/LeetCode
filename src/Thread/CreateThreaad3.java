package Thread;

public class CreateThreaad3{
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("hello");
        } ).start();

    }


}
