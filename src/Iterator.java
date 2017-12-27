//迭代器模式
public class Iterator {
    public static void main(String[] args) {
        Aggregate aggregate=new ConcreteAggregate();
        aggregate.add(1);
        aggregate.add(2);
        System.out.println(aggregate.size());
        IteratorT it=aggregate.createIter();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}

interface IteratorT{
    Object next();
    boolean hasNext();
}
class ConcreteIter implements IteratorT{
    private Aggregate Aggregate=null;
    private int index;

    public ConcreteIter(Aggregate aggregate) {
        Aggregate = aggregate;
    }

    public Aggregate getAggregate() {
        return Aggregate;
    }

    public void setAggregate(Aggregate aggregate) {
        Aggregate = aggregate;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public Object next() {
        Object o=Aggregate.get(index);
        index++;
        return o;
    }

    @Override
    public boolean hasNext() {
        if (index>=Aggregate.size()){
            return false;
        }else{
            return true;
        }
    }
}
//聚集接口
interface Aggregate {
    IteratorT createIter();
    Object get(int index);
    void add(Object o);
    int size();
}
class ConcreteAggregate implements Aggregate{
    private Object[] os;
    private int size;
    private int index;

    public ConcreteAggregate() {
        this.os = new Object[100];
        this.size = 0;
        this.index = 0;
    }

    @Override
    public IteratorT createIter() {
        return new ConcreteIter(this);
    }

    @Override
    public Object get(int index) {
        return os[index];
    }

    @Override
    public void add(Object o) {
        os[index++]=o;
        size++;
    }

    @Override
    public int size() {
        return size;
    }
}