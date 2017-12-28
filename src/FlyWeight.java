import java.util.Hashtable;

//享元模式
public class FlyWeight {
    public static void main(String[] args) {
        ChessFactory.getChess("black").display(new Coordinate());
        ChessFactory.getChess("red").display(new Coordinate());
    }

}

interface ChessFlyWeight{
    void display(Coordinate c);
}
class ConcreteChess implements ChessFlyWeight{
    private String color;

    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public void display(Coordinate c) {
        System.out.println(color+c.getX()+c.getY());
    }
}
class ChessFactory{
    private static Hashtable<String,ChessFlyWeight> table=new Hashtable<>();

    public static ChessFlyWeight getChess(String c){
        if (!table.contains(c)){
            table.put(c,new ConcreteChess(c));
        }
        return table.get(c);
    }
}
class Coordinate {
    private int x,y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
