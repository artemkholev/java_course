public class Matrix<T> {
    private final T[][] elemsMatrix;

    public Matrix(int x, int y) {
        elemsMatrix = (T[][])(new Object[x][y]);
    }

    public void fillMatrix(T[][] data) {
        if (data.length != this.lenCols() || data[0].length != this.lenRows()) {
            System.out.println("Problem with fill matrix");
            System.exit(0);
        }
        for (int i = 1; i <= this.lenRows(); i++) {
            for (int j = 1; j <= this.lenCols(); j++) {
                this.set(i, j, data[i - 1][j - 1]);
            }
        }
    }
    public int lenRows() {
        return elemsMatrix.length;
    }

    public int lenCols() {
        return elemsMatrix[0].length;
    }

    public void set(int x, int y, T elem) {
        if((x < 1) || (x > lenRows()) || (y < 1) || (y > lenCols())) {
            System.out.println("problem with set elem");
            return;
        }
        elemsMatrix[x-1][y-1] = elem;
    }

    public T get(int x, int y) {
        if((x < 1) || (x > lenRows()) || (y < 1) || (y > lenCols())) {
            System.out.println("problem with get elem");
            System.exit(0);
        }
        return elemsMatrix[x-1][y-1];
    }

    public Matrix<T> transpose() {
        Matrix<T> newMatrix = new Matrix<>(lenCols(), lenRows());
        for(int i = 1; i <= lenCols(); i++) {
            for(int j = 1; j <= lenRows(); j++) {
                newMatrix.set(i, j, get(j, i));
            }
        }
        return newMatrix;
    }

    public Matrix<T> minorMatrix(int row, int col) {
        Matrix<T> t_matrix = new Matrix<>(this.lenRows() - 1, this.lenCols() - 1);
        for (int i = 1, t_i = 1; i <= this.lenRows(); i++) {
            if (i != row) {
                for (int j = 1, t_j = 1; j <= this.lenCols(); j++) {
                    if (j != col)
                        t_matrix.set(t_i, t_j++, this.get(i, j));
                }
                ++t_i;
            }
        }
        return t_matrix;
    }

    public Double determinant() {
        if (this.lenRows() != this.lenCols()) {
            System.out.println("Problem with determinant matrix");
            System.exit(0);
        }
        Double result = 0.0;

        if (this.lenRows() == 1) {
            result = (Double) this.get(1, 1);
        } else if (this.lenRows() == 2) {
            result = ((Double) this.get(1, 1) * (Double) this.get(2, 2)) - ((Double) this.get(1, 2) * (Double) this.get(2, 1));
        } else {
            for (int i = 1; i <= this.lenRows(); i++) {
                Matrix<T> minor = minorMatrix(i, 1);
                Double det = minor.determinant();
                result += (Double) this.get(i, 1) * Math.pow(-1.0, i) * det;
            }
        }
        return result;
    }
    public ComplexNum determinantCom() {
        if (this.lenRows() != this.lenCols()) {
            System.out.println("Problem with determinant matrix");
            System.exit(0);
        }
        ComplexNum result = new ComplexNum();

        if (this.lenRows() == 1) {
            result = (ComplexNum) this.get(1, 1);
        } else if (this.lenRows() == 2) {
            result = (((ComplexNum) this.get(1, 1)).mul((ComplexNum) this.get(2, 2))).sub(((ComplexNum) this.get(1, 2)).mul((ComplexNum) this.get(2, 1)));
        } else {
            for (int i = 1; i <= this.lenRows(); i++) {
                Matrix<T> minor = minorMatrix(i, 1);
                ComplexNum det = minor.determinantCom();
                result = result.sum(((ComplexNum) this.get(i, 1)).mulNum(Math.pow(-1.0, i)).mul(det));
            }
        }
        return result;
    }

    //multiply
    public Matrix<Double> mulNum(Double elem) {
        Matrix<Double> newMatrix = new Matrix<>(lenRows(), lenCols());
        for(int i = 1; i <= lenRows(); i++) {
            for(int j = 1; j <= lenCols(); j++) {
                newMatrix.set(i, j, elem * (Double) get(i, j));
            }
        }
        return newMatrix;
    }
    public Matrix<ComplexNum> mulNum(ComplexNum elem) {
        Matrix<ComplexNum> newMatrix = new Matrix<>(lenRows(), lenCols());
        for(int i = 1; i <= lenRows(); i++) {
            for(int j = 1; j <= lenCols(); j++) {
                newMatrix.set(i, j, elem.mul((ComplexNum) get(i, j)));
            }
        }
        return newMatrix;
    }

    //division
    public Matrix<Double> divNum(Double elem) {
        Matrix<Double> newMatrix = new Matrix<>(lenRows(), lenCols());
        for(int i = 1; i <= lenRows(); i++) {
            for(int j = 1; j <= lenCols(); j++) {
                newMatrix.set(i, j, (Double) get(i, j) / elem);
            }
        }
        return newMatrix;
    }
    public Matrix<ComplexNum> divNum(ComplexNum elem) {
        Matrix<ComplexNum> newMatrix = new Matrix<>(lenRows(), lenCols());
        for(int i = 1; i <= lenRows(); i++) {
            for(int j = 1; j <= lenCols(); j++) {
                newMatrix.set(i, j, ((ComplexNum) get(i, j)).div(elem));
            }
        }
        return newMatrix;
    }

    public Matrix<Double> mulMatrix(Matrix<Double> secondMatrix) {
        Matrix<Double> newMatrix = new Matrix<>(lenRows(), secondMatrix.lenCols());
        Double firstElemM, secondElemM;

        if(lenCols()!= secondMatrix.lenRows()) {
            System.out.println("Problem with multiply matrix");
            System.exit(0);
        }

        for(int i = 1; i <= lenRows(); i++) {
            for(int j = 1; j <= secondMatrix.lenCols(); j++) {
                double sum = 0;
                for(int k = 1; k <= lenCols(); k++) {
                    firstElemM = (Double) get(i, k);
                    secondElemM = secondMatrix.get(k, j);
                    sum += firstElemM * secondElemM;
                }
                newMatrix.set(i, j, sum);
            }
        }
        return newMatrix;
    }

    public Matrix<ComplexNum> mulMatrixCom(Matrix<ComplexNum> secondMatrix) {
        Matrix<ComplexNum> newMatrix = new Matrix<>(lenRows(), secondMatrix.lenCols());
        ComplexNum firstElemM, secondElemM;

        if(lenCols()!= secondMatrix.lenRows()) {
            System.out.println("Problem with multiply matrix");
            System.exit(0);
        }

        for(int i = 1; i <= lenRows(); i++) {
            for(int j = 1; j <= secondMatrix.lenCols(); j++) {
                ComplexNum sum = new ComplexNum();
                for(int k = 1; k <= lenCols(); k++) {
                    firstElemM = (ComplexNum) get(i, k);
                    secondElemM = secondMatrix.get(k, j);
                    sum = sum.sum(firstElemM.mul(secondElemM));
                }
                newMatrix.set(i, j, sum);
            }
        }
        return newMatrix;
    }

    //sum
    public Matrix<Double> sumMatrix(Matrix<Double> secondMatrix) {
        if((lenRows()!= secondMatrix.lenRows()) || (lenCols()!= secondMatrix.lenCols())) {
            System.out.println("problem with sum matrix");
            System.exit(0);
        }

        Matrix<Double> newMatrix = new Matrix<>(lenRows(), lenCols());
        Double elem;
        for(int i = 1; i <= lenRows(); i++) {
            for(int j = 1; j <= lenCols(); j++) {
                elem = (Double) get(i, j);
                newMatrix.set(i, j, elem + secondMatrix.get(i, j));
            }
        }
        return newMatrix;
    }
    public Matrix<ComplexNum> sumMatrixCom(Matrix<ComplexNum> secondMatrix) {
        if((lenRows()!= secondMatrix.lenRows()) || (lenCols()!= secondMatrix.lenCols())) {
            System.out.println("problem with sum matrix");
            System.exit(0);
        }

        Matrix<ComplexNum> newMatrix = new Matrix<>(lenRows(), lenCols());
        ComplexNum elem;
        for(int i = 1; i <= lenRows(); i++) {
            for(int j = 1; j <= lenCols(); j++) {
                elem = (ComplexNum) get(i, j);
                newMatrix.set(i, j, elem.sum(secondMatrix.get(i, j)));
            }
        }
        return newMatrix;
    }

    public Matrix<Double> sumNum(Double elem) {
        Matrix<Double> newMatrix= new Matrix<>(lenRows(), lenCols());

        for(int i = 1; i <= lenRows(); i++) {
            for(int j = 1; j <= lenCols(); j++) {
                newMatrix.set(i, j, Double.sum(elem, (Double) get(i, j)));
            }
        }
        return newMatrix;
    }
    public Matrix<ComplexNum> sumNum(ComplexNum elem) {
        Matrix<ComplexNum> newMatrix= new Matrix<>(lenRows(), lenCols());

        for(int i = 1; i <= lenRows(); i++) {
            for(int j = 1; j <= lenCols(); j++) {
                newMatrix.set(i, j, elem.sum((ComplexNum) get(i, j)));
            }
        }
        return newMatrix;
    }

    //subtraction
    public Matrix<Double> subMatrix(Matrix<Double> secondMatrix) {
        if(lenCols()!= secondMatrix.lenCols() || lenRows() != secondMatrix.lenRows()) {
            System.out.println("Problem with subtraction matrix");
            System.exit(0);
        }

        Matrix<Double> newMatrix = new Matrix<>(lenRows(), secondMatrix.lenCols());
        for(int i = 1; i <= lenRows(); i++) {
            for(int j = 1; j <= secondMatrix.lenCols(); j++) {
                newMatrix.set(i, j, (Double) this.get(i, j) - secondMatrix.get(i, j));
            }
        }
        return newMatrix;
    }
    public Matrix<ComplexNum> subMatrixCom(Matrix<ComplexNum> secondMatrix) {
        if(lenCols()!= secondMatrix.lenCols() || lenRows() != secondMatrix.lenRows()) {
            System.out.println("Problem with subtraction matrix");
            System.exit(0);
        }

        Matrix<ComplexNum> newMatrix = new Matrix<>(lenRows(), secondMatrix.lenCols());
        for(int i = 1; i <= lenRows(); i++) {
            for(int j = 1; j <= secondMatrix.lenCols(); j++) {
                newMatrix.set(i, j, ((ComplexNum) this.get(i, j)).sub(secondMatrix.get(i, j)));
            }
        }
        return newMatrix;
    }

    public Matrix<Double> subNum(Double elem) {
        Matrix<Double>  newMatrix= new Matrix<>(lenRows(), lenCols());

        for(int i = 1; i <= lenRows(); i++) {
            for(int j = 1; j <= lenCols(); j++) {
                newMatrix.set(i, j, Double.sum((Double) get(i, j), -elem));
            }
        }
        return newMatrix;
    }

    public Matrix<ComplexNum> subNum(ComplexNum elem) {
        Matrix<ComplexNum>  newMatrix= new Matrix<>(lenRows(), lenCols());

        for(int i = 1; i <= lenRows(); i++) {
            for(int j = 1; j <= lenCols(); j++) {
                newMatrix.set(i, j, ((ComplexNum) get(i, j)).sub(elem));
            }
        }
        return newMatrix;
    }

    public void toStr()  {
        T elem;
        for(int i = 1; i <= lenRows(); i++) {
            System.out.format("[");
            for(int j = 1; j <= lenCols(); j++) {
                if(j > 1)
                    System.out.format(" ");
                elem = get(i, j);
                System.out.print(elem.toString());
            }
            System.out.print("]\n");
        }
    }
}