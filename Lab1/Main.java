import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // initial complex numbers
        Complex x = new Complex(12.0, 3.0);
        Complex y = new Complex(3.0, 4.0);

        // arithmetic operations on complex numbers
        System.out.println(x.sub(y));  // 9.0 + (-1.0i)
//        Complex.sum(x, y).print();  // 15.0 + (7.0i)
//        Complex.mul(x, y).print();  // 24.0 + (57.0i)
//        Complex.div(x, y).print();  // 1.92 + (-1.56i)

        // initial matrix of complex numbers
        int size = 3;
        Matrix matrix_a = new Matrix(size);
        Matrix matrix_b = new Matrix(size);

        Complex[][] data_a = new Complex[size][size];
        Complex[][] data_b = new Complex[size][size];

        Random random = new Random();

        for (int i = 0; i < size; i++){
            for (int j= 0; j < size; j++){
                data_a[i][j] = new Complex(random.nextDouble() * 10, random.nextDouble() * 10);
                data_b[i][j] = new Complex(random.nextDouble() * 10, random.nextDouble() * 10);
            }
        }

        matrix_a.setMatrix(data_a);
//        matrix_a.print();
        matrix_b.setMatrix(data_b);
//        matrix_b.print();

        // arithmetic operations on complex numbers
        Matrix sum = matrix_a.sum(matrix_b);
//        sum.print();
        Matrix sub = matrix_a.sub(matrix_b);
//        sub.print();
        Matrix mul = matrix_a.mul(matrix_b);
//        mul.print();
        Matrix trans = matrix_a.transponse();
//        trans.print();


    }
}
