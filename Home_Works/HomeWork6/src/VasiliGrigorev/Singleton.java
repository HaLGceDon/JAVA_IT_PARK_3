package VasiliGrigorev;

public class Singleton {

    private final static Singleton instance;

    private Singleton() {
        
    }

    static {

        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }
}