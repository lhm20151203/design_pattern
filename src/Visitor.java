//访问者模式
public class Visitor {
    public static void main(String[] args) {
        ComputerPart computerPart=new Computer();
        computerPart.accept(new ComputerPartDisplayVisitor());
    }
}
interface ComputerPart{
    void accept(ComputerPartVisit computerPartVisit);
}
class Keyboard implements ComputerPart{
    @Override
    public void accept(ComputerPartVisit computerPartVisit) {
        computerPartVisit.visit(this);
    }
}
class Mouse implements ComputerPart{
    @Override
    public void accept(ComputerPartVisit computerPartVisit) {
        computerPartVisit.visit(this);
    }
}
class Computer implements ComputerPart{
    ComputerPart[] part;

    public Computer() {
        part=new ComputerPart[]{new Mouse(),new Keyboard()};
    }

    @Override
    public void accept(ComputerPartVisit computerPartVisit) {
        for (ComputerPart partV:part
             ) {
            partV.accept(computerPartVisit);
        }
        computerPartVisit.visit(this);
    }
}
interface ComputerPartVisit{
    void visit(Computer computer);
    void visit(Mouse mouse);
    void visit(Keyboard keyboard);
}
class ComputerPartDisplayVisitor  implements ComputerPartVisit{
    @Override
    public void visit(Mouse mouse) {
        System.out.println("display mouse");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("display keyboard");
    }

    @Override
    public void visit(Computer computer) {
        System.out.println("display computer");
    }
}
