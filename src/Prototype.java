import java.io.*;
//原型模式
public class Prototype {

    public static void main(String[] args) throws CloneNotSupportedException {
        //浅复制复制
        Address address=new Address("jx","gz");
        Programmer a=new Programmer("liaowp",address);
        a.setAddress(new Address("jx", "gz"));
        a.setName("liaowp");
        Programmer b=(Programmer) a.clone();
        b.setName("pwl");
        b.getAddress().setProvince("bj");
        System.err.println(b.getName()+b.getAddress().getProvince());
        System.err.println(a.getName()+a.getAddress().getProvince());

    }

    public Object deepClone(Object object) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oss=new ObjectOutputStream(bos);
        oss.writeObject(object);

        ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois=new ObjectInputStream(bis);
        return ois.readObject();
    }
}

class Programmer implements Cloneable{
    private String name;
    private Address address;

    public Programmer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Programmer clone() throws CloneNotSupportedException {
        Programmer programmer=(Programmer)super.clone();
        programmer.setAddress(address.clone());
        return programmer;
    }
}
class Address implements Cloneable {
    private String province;
    private String city;

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }

    public Address(String province, String city) {
        this.province = province;
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

