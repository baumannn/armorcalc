package bmnn.armorcalc;

/**
 * baumann
 * 6/14/16
 */
public class Armor {

    private Head head;
    private Chest chest;
    private Arms arms;
    private Legs legs;


    public Armor() {


    }

    public double get(int n){
        switch (n){
            case 0:
                return head.getValue() + chest.getValue() + arms.getValue() + legs.getValue();
            case 1:
                return head.getPhysical() + chest.getPhysical() + arms.getPhysical() + legs.getPhysical();
            case 2:
                return head.getStrike() + chest.getStrike() + arms.getStrike() + legs.getStrike();
            case 3:
                return head.getSlash() + chest.getSlash() + arms.getSlash() + legs.getSlash();
            case 4:
                return head.getThrust() + chest.getThrust() + arms.getThrust() + legs.getThrust();
            case 5:
                return head.getMagic() + chest.getMagic() + arms.getMagic() + legs.getMagic();
            case 6:
                return head.getFire() + chest.getFire() + arms.getFire() + legs.getFire();
            case 7:
                return head.getLightning() + chest.getLightning() + arms.getLightning() + legs.getLightning();
            case 8:
                return head.getDark() + chest.getDark() + arms.getDark() + legs.getDark();
            case 9:
                return head.getBleed() + chest.getBleed() + arms.getBleed() + legs.getBleed();
            case 10:
                return head.getPoison() + chest.getPoison() + arms.getPoison() + legs.getPoison();
            case 11:
                return head.getFrost() + chest.getFrost() + arms.getFrost() + legs.getFrost();
            case 12:
                return head.getCurse() + chest.getCurse() + arms.getCurse() + legs.getCurse();
            case 13:
                return head.getPoise() + chest.getPoise() + arms.getPoise() + legs.getPoise();
            case 14:
                return head.getWeight() + chest.getWeight() + arms.getWeight() + legs.getWeight();
            default:
                return 0;
        }
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Chest getChest() {
        return chest;
    }

    public void setChest(Chest chest) {
        this.chest = chest;
    }

    public Arms getArms() {
        return arms;
    }

    public void setArms(Arms arms) {
        this.arms = arms;
    }

    public Legs getLegs() {
        return legs;
    }

    public void setLegs(Legs legs) {
        this.legs = legs;
    }
}
