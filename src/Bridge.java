//桥接
public class Bridge {
    public static void main(String[] args) {

        Implementor implementor=new ConcreteImplA();
        RefinedAbstaration refinedAbstaration=new RefinedAbstaration(implementor);
        refinedAbstaration.opertaion();
        refinedAbstaration.otherOperation();

    }
}
//接口
interface Implementor{
    void operation();//
}
class ConcreteImplA implements Implementor{
    @Override
    public void operation() {
        System.out.println("do....A");
    }
}
class ConcreteImplB implements Implementor{
    @Override
    public void operation() {
        System.out.println("do...B");
    }
}
//抽象类
abstract class Abstration{
    protected Implementor implementor;//有一个 Implementor 对象，形成聚合关系

    public Abstration(Implementor implementor) {
        this.implementor = implementor;
    }
    //可能需要转调实现部分的具体实现
    void opertaion(){
        implementor.operation();
    }
}
//扩展类，扩展实现
class RefinedAbstaration extends Abstration{
    public RefinedAbstaration(Implementor implementor) {
        super(implementor);
    }
    public void otherOperation(){
        System.out.println("do other...");
    }
}
