public class Matrix {
    private int size;
    private Complex[][] matrix;

    public int getSize() {
        return size;
    }

    public Complex[][] getMatrix() {
        return matrix;
    }

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

    public Matrix sum(Matrix b) {
        if (!this.isCorrect(b.getSize())) return null;

        Complex[][] data = new Complex[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                data[i][j] = matrix[i][j].sum(b.matrix[i][j]);
            }
        }
        Matrix new_Matrix = new Matrix(size);
        new_Matrix.setMatrix(data);
        return new_Matrix;
    }

    public Matrix sub(Matrix b) {
        if (!this.isCorrect(b.getSize())) return null;

        Complex[][] data = new Complex[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                data[i][j] = matrix[i][j].sub(b.matrix[i][j]);
            }
        }
        Matrix new_Matrix = new Matrix(size);
        new_Matrix.setMatrix(data);
        return new_Matrix;
    }

    public Matrix mul(Matrix b){
        if (!this.isCorrect(b.getSize())) return null;


        Complex[][] data = new Complex[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Complex elem_ij = new Complex();
                for (int k = 0; k < size; k++){
                    elem_ij = elem_ij.sum(matrix[i][k].mul(b.matrix[k][j]));
                }
                data[i][j] = elem_ij;
            }
        }
        Matrix new_Matrix = new Matrix(size);
        new_Matrix.setMatrix(data);
        return new_Matrix;
    }

    public Matrix transponse(){

        Complex[][] data = new Complex[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                data[i][j] = matrix[j][i];
            }
        }

        Matrix new_Matrix = new Matrix(size);
        new_Matrix.setMatrix(data);
        return new_Matrix;
    }
}
