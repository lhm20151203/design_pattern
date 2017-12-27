import java.util.ArrayList;
import java.util.List;

public class Composite {
    public static void main(String[] args) {
        Component c=new CompositeT("根节点");
        Component c1=new CompositeT("一级");
        Component c2=new CompositeT("二级");
        Component l=new Leaf("另一级");
        Component l1=new Leaf("另二级");
        c.add(c1);
        c.add(c2);
        c1.add(l);
        c1.add(l1);

        c.foreach();


    }
}

abstract class Component{
    private String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract void foreach();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class CompositeT extends Component{
    private List<Component> list=new ArrayList<>();

    public CompositeT(String name) {
        super(name);
    }

    public List<Component> getList() {
        return list;
    }

    public void setList(List<Component> list) {
        this.list = list;
    }

    @Override
    public void add(Component component) {
        list.add(component);
    }

    @Override
    public void remove(Component component) {
        list.remove(component);
    }

    @Override
    public void foreach() {
        for (Component c:list
             ) {
            System.out.println(c.getName());
            c.foreach();
        }
    }
}
class Leaf extends Component{
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public void remove(Component component) {

    }

    @Override
    public void foreach() {
        System.out.println(this.getName());
    }
}