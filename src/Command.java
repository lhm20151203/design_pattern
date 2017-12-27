//用来声明执行操作的接口。
public abstract class Command {
    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }
    public abstract void execute();
}
//将一个接收者对象绑定一个动作，调用接收者相应的操作，以实现Execute。
class ConcreteCommand extends Command{
    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
//知道如何实施与执行一个与请求相关的操作，任何类都可能作为一个接收者
class Receiver{
    public void action(){
        System.out.println("do action");
    }
}
//要求该命令执行这个请求。
class  Invoker{
    private Command command;
    public void executeCommand(){
        command.execute();
    }
    public Invoker(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
class Test{
    public static void main(String[] args) {
        Receiver receiver=new Receiver();
        Command com=new ConcreteCommand(receiver);
        Invoker invoker=new Invoker(com);
        invoker.executeCommand();
    }
}
