package by.it.sgolovach.jd01_07;

class Scalar extends AbstractVar{

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    public Scalar(String str) {
        value=Double.parseDouble(str);
    }

    public Scalar(Scalar otherScalar) {
        this.value=otherScalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
