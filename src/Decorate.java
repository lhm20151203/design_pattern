public class Decorate {

    public static void main(String[] args) {
        Fight fight=new DecorateFight();
        fight.boxing();

        OnePerson onePerson=new OnePerson();
        PersonA a=new PersonA();
        PersonB b=new PersonB();
        a.setPerson(onePerson);
        b.setPerson(a);
        onePerson.eat();

    }
}
//这次学习装饰模式我们就举一个小混混打了一个小孩，突然遇见小孩的妈妈看见了，这肯定不能说在打她儿子呀，
// 只能说跟她儿子玩一玩，小孩子害怕小混混肯定也会说是的，妈妈我们在玩呢，但是实际情况是在被打
abstract class Fight{
    public abstract void boxing();
}

class TrueFight extends Fight{
    @Override
    public void boxing() {
        System.out.println("打一拳");
    }
}

class DecorateFight extends TrueFight{
    private void say(){
        System.out.println("阿姨，我在跟小明玩一玩呢");
    }

    @Override
    public void boxing() {
        this.say();
        super.boxing();
    }
}
//DEMO 2
interface Person{
    void eat();
}
class OnePerson implements Person{
    @Override
    public void eat() {
        System.out.println("一个人在吃");
    }
}
class DecoratePerson implements Person{
    protected Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public void eat() {
        if (person!=null){
            person.eat();
        }
    }
}
class PersonA extends DecoratePerson{
    @Override
    public void eat() {
        super.eat();
        //扩展其他
    }
}
class PersonB extends DecoratePerson{
    @Override
    public void eat() {
        super.eat();
        //扩展其他
    }
}
