public class Matrix {
    int size;
    Complex[][] matrix;


    public Matrix(int size) {
        this.size = size;
        this.matrix = new Complex[size][size];
    }

    public boolean isCorrect(int size_data) {
        if (this.size != size_data) {
            System.out.println("Different matrix sizes");
            return false;
        }
        return true;
    }

    public void print(){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public void setMatrix(Complex[][] new_matrix) {
        if (!isCorrect(new_matrix.length)) return;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = new Complex(new_matrix[i][j].getReal(), new_matrix[i][j].getImage());
            }
        }
    }

    public static Matrix sum(Matrix a, Matrix b) {
        if (!a.isCorrect(b.size)) return null;

        Matrix new_Matrix = new Matrix(a.size);
        for (int i = 0; i < new_Matrix.size; i++) {
            for (int j = 0; j < new_Matrix.size; j++) {
                new_Matrix.matrix[i][j] = a.matrix[i][j].sum(b.matrix[i][j]);
            }
        }
        return new_Matrix;
    }

    public static Matrix sub(Matrix a, Matrix b) {
        if (!a.isCorrect(b.size)) return null;

        Matrix new_Matrix = new Matrix(a.size);
        for (int i = 0; i < new_Matrix.size; i++) {
            for (int j = 0; j < new_Matrix.size; j++) {
                new_Matrix.matrix[i][j] = a.matrix[i][j].sub(b.matrix[i][j]);
            }
        }
        return new_Matrix;
    }

    public static Matrix mul(Matrix a, Matrix b){
        if (!a.isCorrect(b.size)) return null;

        Matrix new_Matrix = new Matrix(a.size);

        for (int i = 0; i < new_Matrix.size; i++) {
            for (int j = 0; j < new_Matrix.size; j++) {
                Complex elem_ij = new Complex();
                for (int k = 0; k < new_Matrix.size; k++){
                    elem_ij = elem_ij.sum(a.matrix[i][k].mul(b.matrix[k][j]));
                }
                new_Matrix.matrix[i][j] = elem_ij;
            }
        }
        return new_Matrix;
    }

    public static Matrix transponse(Matrix a){
        Matrix new_Matrix = new Matrix(a.size);

        for (int i = 0; i < new_Matrix.size; i++) {
            for (int j = 0; j < new_Matrix.size; j++){
                new_Matrix.matrix[i][j] = a.matrix[j][i];
            }
        }

        return new_Matrix;
    }
}
