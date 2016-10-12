package bmnn.armorcalc;

/**
 * baumann
 * 6/14/16
 */
public class Params {

    private double weight;
    private int p1;
    private int p2;

    private boolean average;

    public boolean isAverage() {
        return average;
    }

    public void setAverage(boolean average) {
        this.average = average;
    }

    public Params() {
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public int getP2() {
        return p2;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }
}
