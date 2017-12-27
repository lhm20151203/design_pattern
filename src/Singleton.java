//单例模式
public class Singleton {
    private static Singleton singleton;
    private Singleton() {
    }
    public static Singleton getInstance(){
        if (singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }
}
class SingletonA{
    private static SingletonA sa=new SingletonA();

    private SingletonA() {
    }
    public static SingletonA getInstance(){
        return sa;
    }
}
class SingletonSafe{
    private static volatile SingletonSafe ss;

    private SingletonSafe() {
    }
    public static SingletonSafe getInstance(){
        if (ss==null){
            synchronized (SingletonSafe.class){
                if (ss==null){
                    ss=new SingletonSafe();
                }
            }
        }
        return ss;
    }
}
