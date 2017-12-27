//模板方法模式
public class TemplateMethod {

    public static void main(String[] args) {

        AbstractPerson abstractPerson=new Student();
        abstractPerson.prepareGoSchool();

    }
}

abstract class AbstractPerson{

    public void prepareGoSchool(){
        dressUp();
        eat();
    }

    protected abstract void dressUp();
    protected abstract void eat();
}

class Student extends AbstractPerson{
    @Override
    protected void dressUp() {
        System.out.println("穿校服");
    }

    @Override
    protected void eat() {
        System.out.println("吃妈妈做的饭");
    }
}
class Teacher extends AbstractPerson{
    @Override
    protected void dressUp() {
        System.out.println("穿工作服");
    }

    @Override
    protected void eat() {
        System.out.println("买早餐");
    }
}
