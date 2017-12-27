public class Memento {
    public static void main(String[] args) {
        GameRole lhm=new GameRole();
        lhm.init();
        RoleStateMange roleStateMange=new RoleStateMange();
        roleStateMange.setRoleStateMemo(lhm.saveState());
        System.out.println(roleStateMange.getRoleStateMemo().getVit());
    }
}

class GameRole{
    private int vit;
    private int attack;

    public void init(){
        this.vit=100;
        this.attack=100;
    }
    public RoleStateMemo saveState(){
        return new RoleStateMemo(vit,attack);
    }

    public int getVit() {
        return vit;
    }
    public void setVit(int vit) {
        this.vit = vit;
    }
    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
}
class RoleStateMemo{
    private int vit;
    private int accack;

    public RoleStateMemo(int vit, int accack) {
        this.vit = vit;
        this.accack = accack;
    }

    public int getVit() {
        return vit;
    }
    public void setVit(int vit) {
        this.vit = vit;
    }
    public int getAccack() {
        return accack;
    }
    public void setAccack(int accack) {
        this.accack = accack;
    }
}
class RoleStateMange{
    private RoleStateMemo roleStateMemo;

    public RoleStateMemo getRoleStateMemo() {
        return roleStateMemo;
    }

    public void setRoleStateMemo(RoleStateMemo roleStateMemo) {
        this.roleStateMemo = roleStateMemo;
    }
}