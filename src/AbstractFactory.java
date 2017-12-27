//抽象工厂
public class AbstractFactory {
    public static void main(String[] args) {
        FactoryAbstract factoryAbstract=new FactoryBMW320();
        factoryAbstract.creEngine().createEngine();
    }
}
interface Engine{
    void createEngine();
}
class EngineA implements Engine{
    @Override
    public void createEngine() {
        System.out.println("生产A型号");
    }
}
class EngineB implements Engine{
    @Override
    public void createEngine() {
        System.out.println("生产B型号");
    }
}
interface Wheel{
    void createWheel();
}
class WheelA implements Wheel{
    @Override
    public void createWheel() {
        System.out.println("生产A号轮胎");
    }
}
class WheelB implements Wheel{
    @Override
    public void createWheel() {
        System.out.println("生产B号轮胎");
    }
}
interface FactoryAbstract{
    public Engine creEngine();
    public Wheel creWheel();
}
class FactoryBMW320 implements FactoryAbstract{
    @Override
    public Engine creEngine() {
        return new EngineA() ;
    }

    @Override
    public Wheel creWheel() {
        return new WheelA();
    }
}
class FactoryBMW523 implements FactoryAbstract{
    @Override
    public Engine creEngine() {
        return new EngineB();
    }

    @Override
    public Wheel creWheel() {
        return new WheelB();
    }
}

