//适配器
public class Adapter {
    public static void main(String[] args) {
        SmallPort smallPort=new SmallPort() {
            @Override
            public void useSmallPort() {
                System.out.println("使用自己smallProt");
            }
        };
        AdapterFor adapterFor=new AdapterFor();
        adapterFor.setSmallPort(smallPort);
        adapterFor.useBigProt();

    }
}

interface BigPort{
    void useBigProt();
}
interface SmallPort{
    void useSmallPort();
}
class AdapterFor implements BigPort{
    private SmallPort smallPort;

    public SmallPort getSmallPort() {
        return smallPort;
    }

    public void setSmallPort(SmallPort smallPort) {
        this.smallPort = smallPort;
    }

    @Override
    public void useBigProt() {
        smallPort.useSmallPort();
    }
}