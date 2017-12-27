//职责链
public class ChainOfResponsibility {
    public static void main(String[] args) {
        Handler handler=new ConcreteHandlerA();
        Handler handler1=new ConcreteHandlerB();
        handler.setHandler(handler1);
        int [] req={2, 29, 9, 15, 4, 19};
        for (int i:req
             ) {
            handler.handReq(i);
        }

    }
}
//定义一个处理请求的接口。（可选的）实现设置后继者的方法
abstract class Handler{
    protected Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public abstract void handReq(int req);
}
class ConcreteHandlerA extends Handler{
    @Override
    public void handReq(int req) {
        if (req>=0&&req<10){
            System.out.println("deal req:"+req);
        }else if (handler!=null){
            handler.handReq(req);
        }
    }
}
class ConcreteHandlerB extends Handler{
    @Override
    public void handReq(int req) {
        if (req>=10&&req<20){
            System.out.println("deal req:"+req);
        }else if (handler!=null){
            handler.handReq(req);
        }
    }
}

