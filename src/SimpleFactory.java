public class SimpleFactory {

    public static void main(String[] args) {
        HumanFactory.getHuman("1").say();
        HumanFactory1.getHuman(Man.class).say();
    }
}

interface Human{
    void say();
}
class Man implements Human{
    @Override
    public void say() {
        System.out.println("this is man");
    }
}
class Woman implements Human{
    @Override
    public void say() {
        System.out.println("this is woman");
    }
}
//使用逻辑判断生产对象
class HumanFactory {
    public static Human getHuman(String type){
        Human human=null;
        switch (type){
            case "1":
                human=new Man();
                break;
            case "2":
                human=new Woman();
                break;
             default:
                 break;
        }
        return human;
    }
}
//使用JAVA反射机制
class HumanFactory1{
    public static Human getHuman(Class c){
        Human human=null;
        try {
            human=(Human)Class.forName(c.getName()).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return human;
    }
}
