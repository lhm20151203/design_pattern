public class Facade {
    public static void main(String[] args) {
        ModuleFacade moduleFacade=new ModuleFacade();
        moduleFacade.test();
    }
}

class ModuleFacade{
    public void test(){
        ModuleA a=new ModuleA();
        a.testA();
        ModuleB b=new ModuleB();
        b.testB();
        ModuleC c=new ModuleC();
        c.testC();
    }
}

class ModuleA {
    public void testA(){
        System.out.println("AAA");
    }

}
class ModuleB {
    public void testB(){
        System.out.println("BBB");
    }
}
class ModuleC {
    public void testC(){
        System.out.println("CCC");
    }
}
