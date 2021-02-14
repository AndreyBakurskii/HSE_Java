public class Complex {
    double real, image;

    public Complex() {
        this.real = 0;
        this.image = 0;
    }

    public Complex(double new_real, double new_image){
        this.real = new_real;
        this.image = new_image;
    }

    public Complex(double new_real){
        this.real = new_real;
        this.image = 0;
    }

    public static Complex sum(Complex first_num, Complex second_num) {
        return new Complex(first_num.real + second_num.real, first_num.image + second_num.image);
    }

    public static Complex sub(Complex first_num, Complex second_num) {
        return new Complex(first_num.real - second_num.real, first_num.image - second_num.image);
    }

    public static Complex mul(Complex first_num, Complex second_num) {
        return new Complex(first_num.real * second_num.real - first_num.image * second_num.image,
                first_num.image * second_num.real + first_num.real * second_num.image);
    }

    public static Complex div(Complex first_num, Complex second_num) {
        return new Complex((first_num.real * second_num.real + first_num.image * second_num.image) /
                                   (second_num.real * second_num.real + second_num.image * second_num.image),
                          (first_num.image * second_num.real - first_num.real * second_num.image) /
                                   (second_num.real * second_num.real + second_num.image * second_num.image));
    }

    public static String getTrigonometric(Complex num) {
        double r = Math.sqrt(num.real * num.real + num.image * num.image);
        double f = Math.atan(num.image / num.real);

        return String.format("%.2f * (cos%.2f + i * sin%.2f)", r, f, f);
    }

    @Override
    public String toString () {
        return  String.format("%.2f", this.real) + " + (" + String.format("%.2f", this.image) + "i)";
    }
}