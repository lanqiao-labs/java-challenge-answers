public class Triangle {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }

    /**
     * 求取周长
     * @return 三角形的周长
     */
    public double getPerimeter(){
        return this.side1+this.side2+this.side3;
    }

    /**
     * 求取三角形面积
     * @return 三角形的面积
     */
    public double getArea(){
        double p = (side1+side2+side3) / 2;
        double result = Math.sqrt(p*((p-side1)*(p-side2)*(p-side3)));
        return result;
    }
}