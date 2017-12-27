public class FactoryMethod {
    public static void main(String[] args) {

        SenderFactory2.createEmai().send();
        SenderFactory3 senderFactory3=new EmaiFactory();
        senderFactory3.createSender().send();
    }
}
//简单工厂开始
interface Sender{
    void send();
}
class Email implements Sender{
    @Override
    public void send() {
        System.out.println("email send");
    }
}
class Message implements Sender{
    @Override
    public void send() {
        System.out.println("message send");
    }
}
class SenderFactory{
    public static Sender getSender(int type){
        Sender sender=null;
        switch (type){
            case 1:
                sender=new Email();
                break;
            case 2:
                sender=new Message();
                break;
            default:
                break;
        }
        return sender;
    }
}
//简单工厂END
//多个工厂方法模式开始
class SenderFactory2{
    public static Sender createEmai(){
        return new Email();
    }
    public static Sender createMess(){
        return new Message();
    }
}
//工厂方法模式开始
interface SenderFactory3{
    public Sender createSender();
}
class EmaiFactory implements SenderFactory3{
    @Override
    public Sender createSender() {
        return new Email();
    }
}
class MessFactory implements SenderFactory3{
    @Override
    public Sender createSender() {
        return new Message();
    }
}

