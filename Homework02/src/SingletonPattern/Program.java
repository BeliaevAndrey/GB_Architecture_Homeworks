package SingletonPattern;

public class Program {

    public static void main(String[] args) {
        Singleton s1 = Singleton.createInstance();
        System.out.println(s1.getCreated());

        Singleton s2 = Singleton.createInstance();
        System.out.println(s2.getCreated());

        System.out.println(s1.equals(s2));
    }
}
