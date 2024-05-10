public class ComplexNum {
    private final double r, i;

    //constructors
    public ComplexNum() {
        r = 0;
        i = 0;
    }

    public ComplexNum(double x) {
        r = x;
        i = 0;
    }

    public ComplexNum(double x, double y) {
        r = x;
        i = y;
    }

    public double r() {
        return r;
    }
    public double i() {
        return i;
    }

    //operations
    public ComplexNum sum(ComplexNum secondNum) {
        double newR = this.r + secondNum.r;
        double newI = this.i + secondNum.i;
        return new ComplexNum(newR, newI);
    }

    public ComplexNum sub(ComplexNum secondNum) {
        double newR = this.r - secondNum.r;
        double newI = this.i - secondNum.i;
        return new ComplexNum(newR, newI);
    }

    public ComplexNum mulNum(Double secondNum) {
        double newR = this.r * secondNum;
        double newI = this.i * secondNum;
        return new ComplexNum(newR, newI);
    }

    public ComplexNum div(ComplexNum secondNum) {
        return this.mul(secondNum.revCom());
    }
    public ComplexNum  revCom() {
        double s = this.r * this.r + this.i * this.i;
        return new ComplexNum(r / s, -i / s);
    }
    public ComplexNum mul(ComplexNum secondNum) {
        double newR = this.r * secondNum.r - this.i * secondNum.i;
        double newI = this.r * secondNum.i + this.i * secondNum.r;
        return new ComplexNum(newR, newI);
    }

    public String toString() {
        if (i == 0) return r + "";
        if (r == 0) return i + "i";
        if (i > 0) return r + " + " + i + "i";
        return r + " - " + (-i) + "i";
    }
}
