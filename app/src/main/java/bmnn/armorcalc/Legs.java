package bmnn.armorcalc;

/**
 * baumann
 * 6/13/16
 */
public class Legs {

    private int id;
    private String name;
    private double physical;
    private double strike;
    private double slash;
    private double thrust;
    private double magic;
    private double fire;
    private double lightning;
    private double dark;
    private int bleed;
    private int poison;
    private int frost;
    private int curse;
    private double poise;
    private int durability;
    private double weight;

    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(int p1, int p2, boolean average) {

        double val = 0;

        double valp = 0;
        double vale = 0;
        double valr = 0;
        double pois = 0;

        double[] aves = {5.50, 4.95, 5.46, 5.18, 6.06, 6.35, 5.76, 6.61, 29.05, 32.04, 28.34, 28.07, 4.48, 316.81, 5.45};

        if (p1 == 0 && p2 == 0){
            //no priorities, all stats considered

            valp+=(physical/aves[0]);
            valp+=(strike/aves[1]);
            valp+=(slash/aves[2]);
            valp+=(thrust/aves[3]);
            vale+=(magic/aves[4]);
            vale+=(fire/aves[5]);
            vale+=(lightning/aves[6]);
            vale+=(dark/aves[7]);
            valr+=(bleed/aves[8]);
            valr+=(poison/aves[9]);
            valr+=(frost/aves[10]);
            valr+=(curse/aves[11]);
            pois+=(poise/aves[12]);

            valp /= 4;
            vale /= 4;
            valr /= 4;

            val = valp + vale + 0.5*valr + 0.5*pois;

        } else if(p2 == 0){
            //1 priority

            if(average) {

                //consider all stats

                valp += (physical / aves[0]);
                valp += (strike / aves[1]);
                valp += (slash / aves[2]);
                valp += (thrust / aves[3]);
                vale += (magic / aves[4]);
                vale += (fire / aves[5]);
                vale += (lightning / aves[6]);
                vale += (dark / aves[7]);
                valr += (bleed / aves[8]);
                valr += (poison / aves[9]);
                valr += (frost / aves[10]);
                valr += (curse / aves[11]);
                pois += (poise / aves[12]);

                switch (p1) {
                    case 1:
                        valp += (physical / aves[0]);
                        break;
                    case 2:
                        valp += (strike / aves[1]);
                        break;
                    case 3:
                        valp += (slash / aves[2]);
                        break;
                    case 4:
                        valp += (thrust / aves[3]);
                        break;
                    case 5:
                        vale += (magic / aves[4]);
                        break;
                    case 6:
                        vale += (fire / aves[5]);
                        break;
                    case 7:
                        vale += (lightning / aves[6]);
                        break;
                    case 8:
                        vale += (dark / aves[7]);
                        break;
                    case 9:
                        valr += (bleed / aves[8]);
                        break;
                    case 10:
                        valr += (poison / aves[9]);
                        break;
                    case 11:
                        valr += (frost / aves[10]);
                        break;
                    case 12:
                        valr += (curse / aves[11]);
                        break;
                    case 13:
                        pois += (poise / aves[12]);
                        break;
                }

                valp /= 4;
                vale /= 4;
                valr /= 4;

                val = valp + vale + (0.5 * valr) + (0.5 * pois);

            } else {

                //only consider priority

                switch (p1){
                    case 1:
                        val = (physical/aves[0]);
                        break;
                    case 2:
                        val = (strike/aves[1]);
                        break;
                    case 3:
                        val = (slash/aves[2]);
                        break;
                    case 4:
                        val = (thrust/aves[3]);
                        break;
                    case 5:
                        val = (magic/aves[4]);
                        break;
                    case 6:
                        val = (fire/aves[5]);
                        break;
                    case 7:
                        val = (lightning/aves[6]);
                        break;
                    case 8:
                        val = (dark/aves[7]);
                        break;
                    case 9:
                        val = (bleed/aves[8]);
                        break;
                    case 10:
                        val = (poison/aves[9]);
                        break;
                    case 11:
                        val = (frost/aves[10]);
                        break;
                    case 12:
                        val = (curse/aves[11]);
                        break;
                    case 13:
                        val = (poise/aves[12]);
                        break;
                    default:
                        val = 0;
                }


            }

        } else{
            //2 priorities

            if(average) {
                //consider all stats

                valp += (physical / aves[0]);
                valp += (strike / aves[1]);
                valp += (slash / aves[2]);
                valp += (thrust / aves[3]);
                vale += (magic / aves[4]);
                vale += (fire / aves[5]);
                vale += (lightning / aves[6]);
                vale += (dark / aves[7]);
                valr += (bleed / aves[8]);
                valr += (poison / aves[9]);
                valr += (frost / aves[10]);
                valr += (curse / aves[11]);
                pois += (poise / aves[12]);

                switch (p1) {
                    case 1:
                        valp += (physical / aves[0]);
                        break;
                    case 2:
                        valp += (strike / aves[1]);
                        break;
                    case 3:
                        valp += (slash / aves[2]);
                        break;
                    case 4:
                        valp += (thrust / aves[3]);
                        break;
                    case 5:
                        vale += (magic / aves[4]);
                        break;
                    case 6:
                        vale += (fire / aves[5]);
                        break;
                    case 7:
                        vale += (lightning / aves[6]);
                        break;
                    case 8:
                        vale += (dark / aves[7]);
                        break;
                    case 9:
                        valr += (bleed / aves[8]);
                        break;
                    case 10:
                        valr += (poison / aves[9]);
                        break;
                    case 11:
                        valr += (frost / aves[10]);
                        break;
                    case 12:
                        valr += (curse / aves[11]);
                        break;
                    case 13:
                        pois += (poise / aves[12]);
                        break;
                }

                switch (p2) {
                    case 1:
                        valp += 0.5 * (physical / aves[0]);
                        break;
                    case 2:
                        valp += 0.5 * (strike / aves[1]);
                        break;
                    case 3:
                        valp += 0.5 * (slash / aves[2]);
                        break;
                    case 4:
                        valp += 0.5 * (thrust / aves[3]);
                        break;
                    case 5:
                        vale += 0.5 * (magic / aves[4]);
                        break;
                    case 6:
                        vale += 0.5 * (fire / aves[5]);
                        break;
                    case 7:
                        vale += 0.5 * (lightning / aves[6]);
                        break;
                    case 8:
                        vale += 0.5 * (dark / aves[7]);
                        break;
                    case 9:
                        valr += 0.5 * (bleed / aves[8]);
                        break;
                    case 10:
                        valr += 0.5 * (poison / aves[9]);
                        break;
                    case 11:
                        valr += 0.5 * (frost / aves[10]);
                        break;
                    case 12:
                        valr += 0.5 * (curse / aves[11]);
                        break;
                    case 13:
                        pois += 0.5 * (poise / aves[12]);
                        break;
                }

                valp /= 4;
                vale /= 4;
                valr /= 4;

                val = valp + vale + (0.5 * valr) + (0.5 * pois);

            } else {

                //only consider priorities

                switch (p1){
                    case 1:
                        valp += (physical/aves[0]);
                        break;
                    case 2:
                        valp += (strike/aves[1]);
                        break;
                    case 3:
                        valp += (slash/aves[2]);
                        break;
                    case 4:
                        valp += (thrust/aves[3]);
                        break;
                    case 5:
                        vale += (magic/aves[4]);
                        break;
                    case 6:
                        vale += (fire/aves[5]);
                        break;
                    case 7:
                        vale += (lightning/aves[6]);
                        break;
                    case 8:
                        vale += (dark/aves[7]);
                        break;
                    case 9:
                        valr += (bleed/aves[8]);
                        break;
                    case 10:
                        valr += (poison/aves[9]);
                        break;
                    case 11:
                        valr += (frost/aves[10]);
                        break;
                    case 12:
                        valr += (curse/aves[11]);
                        break;
                    case 13:
                        pois += (poise/aves[12]);
                        break;
                    default:
                        val += 0;
                }

                switch (p2){
                    case 1:
                        valp += 0.5 * (physical/aves[0]);
                        break;
                    case 2:
                        valp += 0.5 * (strike/aves[1]);
                        break;
                    case 3:
                        valp += 0.5 * (slash/aves[2]);
                        break;
                    case 4:
                        valp += 0.5 * (thrust/aves[3]);
                        break;
                    case 5:
                        vale += 0.5 * (magic/aves[4]);
                        break;
                    case 6:
                        vale += 0.5 * (fire/aves[5]);
                        break;
                    case 7:
                        vale += 0.5 * (lightning/aves[6]);
                        break;
                    case 8:
                        vale += 0.5 * (dark/aves[7]);
                        break;
                    case 9:
                        valr += 0.5 * (bleed/aves[8]);
                        break;
                    case 10:
                        valr += 0.5 * (poison/aves[9]);
                        break;
                    case 11:
                        valr += 0.5 * (frost/aves[10]);
                        break;
                    case 12:
                        valr += 0.5 * (curse/aves[11]);
                        break;
                    case 13:
                        pois += 0.5 * (poise/aves[12]);
                        break;
                    default:
                        val += 0.5 * 0;
                }

                val = valp + vale + (0.5 * valr) + (0.5 * pois);


            }

        }

        this.value = val;
    }

    public Legs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPhysical() {
        return physical;
    }

    public void setPhysical(double physical) {
        this.physical = physical;
    }

    public double getStrike() {
        return strike;
    }

    public void setStrike(double strike) {
        this.strike = strike;
    }

    public double getSlash() {
        return slash;
    }

    public void setSlash(double slash) {
        this.slash = slash;
    }

    public double getThrust() {
        return thrust;
    }

    public void setThrust(double thrust) {
        this.thrust = thrust;
    }

    public double getMagic() {
        return magic;
    }

    public void setMagic(double magic) {
        this.magic = magic;
    }

    public double getFire() {
        return fire;
    }

    public void setFire(double fire) {
        this.fire = fire;
    }

    public double getLightning() {
        return lightning;
    }

    public void setLightning(double lightning) {
        this.lightning = lightning;
    }

    public double getDark() {
        return dark;
    }

    public void setDark(double dark) {
        this.dark = dark;
    }

    public int getBleed() {
        return bleed;
    }

    public void setBleed(int bleed) {
        this.bleed = bleed;
    }

    public int getPoison() {
        return poison;
    }

    public void setPoison(int poison) {
        this.poison = poison;
    }

    public int getFrost() {
        return frost;
    }

    public void setFrost(int frost) {
        this.frost = frost;
    }

    public int getCurse() {
        return curse;
    }

    public void setCurse(int curse) {
        this.curse = curse;
    }

    public double getPoise() {
        return poise;
    }

    public void setPoise(double poise) {
        this.poise = poise;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
