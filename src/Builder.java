public class Builder {
    public static void main(String[] args) {
        PeopleDirector pd=new PeopleDirector();
        pd.buildPeople(new BoyBuilder());
    }
}
//人类
class People{
    private String head;
    private String body;
    private String foot;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }
}
class Boy extends People{
    public Boy() {
        System.out.println("build boy");
    }
}
class Giry extends People{
    public Giry() {
        System.out.println("buile girl");
    }
}
//人类创建接口
interface PeopleBuilder{
    void buildHead();
    void buildBody();
    void buildFoot();
    People buildPeople();
}
class BoyBuilder implements PeopleBuilder{
    People people=new Boy();

    @Override
    public void buildHead() {
        //
    }

    @Override
    public void buildBody() {
        //
    }

    @Override
    public void buildFoot() {
        //
    }

    @Override
    public People buildPeople() {
        return people;
    }
}
class PeopleDirector{
    public People buildPeople(PeopleBuilder peopleBuilder){
        peopleBuilder.buildBody();
        peopleBuilder.buildHead();
        peopleBuilder.buildFoot();
        return peopleBuilder.buildPeople();
    }
}
