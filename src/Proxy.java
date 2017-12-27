import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
//代理模式
public class Proxy {
    public static void main(String[] args) {
        ProxyRole proxyRole=new ProxyRole(new XiaoA());
        proxyRole.buyTicket();

        PersonTest personTest=new XiaoA();
        DynamicProxy dynamicProxy=new DynamicProxy(personTest);
        PersonTest proxy= (PersonTest) dynamicProxy.getProxy();
        proxy.buyTicket();

    }
}

interface PersonTest{
    void buyTicket();
}
class XiaoA implements PersonTest{
    @Override
    public void buyTicket() {
        System.out.println("买票");
    }
}
class ProxyRole implements PersonTest{
    private PersonTest personTest;
    //默认代理小A
    public ProxyRole() {
        this.personTest=new XiaoA();
    }
    //也可以代理其他子类
    public ProxyRole(PersonTest personTest) {
        this.personTest=personTest;
    }

    @Override
    public void buyTicket() {
        personTest.buyTicket();
    }
}
//使用JDK的动态代理
//实现自己的InvocationHandler
class DynamicProxy implements InvocationHandler{
    //目标对象
    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }
    //执行目标对象的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //before
        Object result = method.invoke(object, args);
        //after
        return result;
    }

    public Object getProxy(){
        return java.lang.reflect.Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),this.object.getClass().getInterfaces(),this);
    }

}
