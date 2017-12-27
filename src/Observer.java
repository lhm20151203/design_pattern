import java.util.ArrayList;
import java.util.List;

public class Observer {
    public static void main(String[] args) {
        Notice notice=new NoticeImpl();
        notice.add(new Observer1());
        notice.notice();
    }
}
//通知者抽象
interface Notice{
    void add(IObserver iObserver);
    void delete(IObserver iObserver);
    void notice();
}
class NoticeImpl implements Notice{
    List<IObserver> iObservers=new ArrayList<>();
    @Override
    public void add(IObserver iObserver) {
        iObservers.add(iObserver);
    }

    @Override
    public void delete(IObserver iObserver) {
        iObservers.remove(iObserver);
    }

    @Override
    public void notice() {
        for (IObserver io:iObservers
             ) {
            io.notice();
        }

    }
}
//观察者抽象
interface IObserver{
    void notice();
}
class Observer1 implements IObserver{
    @Override
    public void notice() {
        System.out.println("收到通知");
    }
}