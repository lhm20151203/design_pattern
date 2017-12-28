import com.sun.org.apache.xpath.internal.SourceTree;

//解释器模式
public class Interpreter {
    public static void main(String[] args) {
        Expression e1=new TerminalExp("hello");
        Expression e2=new TerminalExp("world");
        Expression e3=new OrExp(e1,e2);
        System.out.println(e3.interpret("bbb"));
    }
}
interface Expression{
    boolean interpret(String context);
}
class TerminalExp implements Expression{
    private String data;

    public TerminalExp(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(data))
            return true;
        return false;
    }
}
class OrExp implements Expression{
    private Expression e1=null;
    private Expression e2=null;

    public OrExp(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public boolean interpret(String context) {
        return e1.interpret(context)||e2.interpret(context);
    }
}
class AndExp implements Expression{
    private Expression e1=null;
    private Expression e2=null;

    public AndExp(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public boolean interpret(String context) {
        return e1.interpret(context)&&e2.interpret(context);
    }
}
