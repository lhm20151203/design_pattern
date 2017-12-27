//策略模式
public class Strategy {

    public static void main(String[] args) {
        UserStrategy userStrategy=new UserStrategy(new DetailStrategy1());
        userStrategy.useStra();
        UserStrategy userStrategy2=new UserStrategy(new DetailStrategy2());
        userStrategy2.useStra();
    }
}

interface StrategyInterface{
    void action();
}
//具体的策略<离间计>
class DetailStrategy1 implements StrategyInterface{
    @Override
    public void action() {
        System.out.println("hi gay,给你个离间计");
    }
}
//具体的策略<美男计>
class DetailStrategy2 implements StrategyInterface{
    @Override
    public void action() {
        System.out.println("hi gay,给你个美男计");
    }
}

class UserStrategy{
    private StrategyInterface strategyInterface;

    public UserStrategy(StrategyInterface strategyInterface) {
        this.strategyInterface = strategyInterface;
    }
    public void useStra(){
        strategyInterface.action();
    }
}
