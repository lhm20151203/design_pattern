//中介模式
public class Mediator {
    public static void main(String[] args) {
        ConcreteMediator mediatorT=new ConcreteMediator();
        ConcreteColleague1 c=new ConcreteColleague1(mediatorT);
        ConcreteColleague2 c1=new ConcreteColleague2(mediatorT);
        mediatorT.setC1(c);
        mediatorT.setC2(c1);
        c.send("hello");
        c1.send("world");
    }
}
//为 Colleague 对象定义一个交流接口。
abstract class MediatorT{
    public abstract void send(String mess,Colleague colleague);
}
//实现 Mediator 中的交流接口。 这个类中需要了解并维护所有的 colleague 对象
class ConcreteMediator extends MediatorT{
    private ConcreteColleague1 c1;
    private ConcreteColleague2 c2;

    public void setC1(ConcreteColleague1 c1) {
        this.c1 = c1;
    }

    public void setC2(ConcreteColleague2 c2) {
        this.c2 = c2;
    }

    @Override
    public void send(String mess,Colleague colleague) {
        if (colleague==c1){
            c2.notify(mess);
        }else if (colleague==c2){
            c1.notify(mess);
        }
    }
}
//每个 Colleague 对象应该知道它的 Mediator 对象，但不知道其他同事对象。它只能联系 Mediator 对象。
abstract class Colleague{
    protected MediatorT mediatorT;
    public void send(String mess){
        mediatorT.send(mess,this);
    }
    public abstract void notify(String mess);

    public Colleague(MediatorT mediatorT) {
        this.mediatorT = mediatorT;
    }
}
class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(MediatorT mediatorT) {
        super(mediatorT);
    }

    @Override
    public void notify(String mess) {
        System.out.println("coll1得到消息"+mess);
    }
}
class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(MediatorT mediatorT) {
        super(mediatorT);
    }

    @Override
    public void notify(String mess) {
        System.out.println("coll2得到消息"+mess);
    }
}