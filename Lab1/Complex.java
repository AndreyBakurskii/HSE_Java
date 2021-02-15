public class Complex {
    private double real, image;

    public double getReal() {
        return real;
    }

    public double getImage() {
        return image;
    }

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

    public Complex sum(Complex second_num) {
        return new Complex(this.real + second_num.getReal(), this.image + second_num.getImage());
    }

    public Complex sub(Complex second_num) {
        return new Complex(this.real - second_num.getReal(), this.image - second_num.getImage());
    }

    public Complex mul(Complex second_num) {
        return new Complex(this.real * second_num.getReal() - this.image * second_num.getImage(),
                this.image * second_num.getReal() + this.real * second_num.getImage());
    }

    public Complex div(Complex second_num) {
        return new Complex((this.real * second_num.getReal() + this.image * second_num.getImage()) /
                                   (second_num.getReal() * second_num.getReal() + second_num.getImage() * second_num.getImage()),
                          (this.image * second_num.getReal() - this.real * second_num.getImage()) /
                                   (second_num.getReal() * second_num.getReal() + second_num.getImage() * second_num.getImage()));
    }

    public String getTrigonometric() {
        double r = Math.sqrt(this.real * this.real + this.image * this.image);
        double f = Math.atan(this.image / this.real);

        return String.format("%.2f * (cos%.2f + i * sin%.2f)", r, f, f);
    }

    @Override
    public String toString () {
        return  String.format("%.2f", this.real) + " + (" + String.format("%.2f", this.image) + "i)";
    }
}