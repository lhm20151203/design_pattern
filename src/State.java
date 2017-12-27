public class State {
    public static void main(String[] args) {
        Context c=new Context(new StateA());
        c.stateChange();
        c.stateChange();
    }
}

class Context{
    private IState iState;
    public IState getiState() {
        return iState;
    }
    public void setiState(IState iState) {
        this.iState = iState;
    }
    public Context(IState iState) {
        this.iState = iState;
    }

    public void stateChange(){
        iState.action(this);
    }
}
interface IState{
    void action(Context context);
}
class StateA implements IState{
    @Override
    public void action(Context context) {
        System.out.println("AAA");
        context.setiState(new StateB());
    }
}
class StateB implements IState{
    @Override
    public void action(Context context) {
        System.out.println("BBB");
        context.setiState(new StateA());
    }
}
