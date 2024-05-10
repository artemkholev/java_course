public class Main {
    public static void main(String[] args) {
        System.out.println("Create matrix:");
        Matrix<Double> myMatrix = new Matrix<>(2, 2);
        myMatrix.fillMatrix(new Double[][] {{1.0, 2.0}, {3.0, 4.0}});
        myMatrix.toStr();

        System.out.println("\nOperations with the first matrix");
        System.out.println("action + 5");
        myMatrix = myMatrix.sumNum(5.0);
        myMatrix.toStr();
        System.out.println("\naction - 5");
        myMatrix = myMatrix.subNum(5.0);
        myMatrix.toStr();
        System.out.println("\naction * 5");
        myMatrix = myMatrix.mulNum(5.0);
        myMatrix.toStr();
        System.out.println("\naction / 5");
        myMatrix = myMatrix.divNum(5.0);
        myMatrix.toStr();

        System.out.println("\nOperations with two matrices");
        Matrix<Double> myMatrixSecond = new Matrix<>(2, 2);
        myMatrixSecond.fillMatrix(new Double[][] {{4.0, 3.0}, {2.0, 1.0}});
        myMatrixSecond.toStr();

        System.out.println("\naction + matrix");
        myMatrix = myMatrix.sumMatrix(myMatrixSecond);
        myMatrix.toStr();
        System.out.println("\naction - matrix");
        myMatrix = myMatrix.subMatrix(myMatrixSecond);
        myMatrix.toStr();
        System.out.println("\naction * matrix");
        myMatrix = myMatrix.mulMatrix(myMatrixSecond);
        myMatrix.toStr();

        System.out.println("\ntranspose matrix");
        myMatrix = myMatrix.transpose();
        myMatrix.toStr();

        System.out.println("\ndeterminant matrix");
        System.out.println(myMatrix.determinant());

        Matrix<Double> myMatrixThird = new Matrix<>(4, 4);
        myMatrixThird.fillMatrix(new Double[][] {{4.0, 3.0, 1.0, 2.0}, {2.0, 1.0, 6.0, 7.0}, {1.0, 2.0, 3.0, 4.0}, {7.0, 7.0, 7.0, 8.0}});
        System.out.println("\ndeterminant matrix");
        myMatrixThird.toStr();
        System.out.println(myMatrixThird.determinant());

        System.out.println("\noperations with complex numbers");
        System.out.println("Create matrix:");
        Matrix<ComplexNum> myMatrixComplex = new Matrix<>(2, 2);
        myMatrixComplex.fillMatrix(new ComplexNum[][] {{new ComplexNum(1, 2), new ComplexNum(3, 4)}, {new ComplexNum(1), new ComplexNum(5)}});
        myMatrixComplex.toStr();
        System.out.println("\naction + " + new ComplexNum(1, 2));
        myMatrixComplex = myMatrixComplex.sumNum(new ComplexNum(1, 2));
        myMatrixComplex.toStr();
        System.out.println("\naction - " + new ComplexNum(1, 2));
        myMatrixComplex = myMatrixComplex.subNum(new ComplexNum(1, 2));
        myMatrixComplex.toStr();
        System.out.println("\naction * " + new ComplexNum(1, 2));
        myMatrixComplex = myMatrixComplex.mulNum(new ComplexNum(1, 2));
        myMatrixComplex.toStr();
        System.out.println("\naction / " + new ComplexNum(1, 2));
        myMatrixComplex = myMatrixComplex.divNum(new ComplexNum(1, 2));
        myMatrixComplex.toStr();
        System.out.println("\nOperations with two complex matrices");
        Matrix<ComplexNum> myMatrixComplex2 = new Matrix<>(2, 2);
        myMatrixComplex2.fillMatrix(new ComplexNum[][] {{new ComplexNum(2, 7), new ComplexNum(3, 1)}, {new ComplexNum(3, 10), new ComplexNum(5)}});
        myMatrixComplex2.toStr();
        System.out.println("\naction + matrix");
        myMatrixComplex = myMatrixComplex.sumMatrixCom(myMatrixComplex2);
        myMatrixComplex.toStr();
        System.out.println("\naction - matrix");
        myMatrixComplex = myMatrixComplex.subMatrixCom(myMatrixComplex2);
        myMatrixComplex.toStr();
        System.out.println("\naction * matrix");
        myMatrixComplex = myMatrixComplex.mulMatrixCom(myMatrixComplex2);
        myMatrixComplex.toStr();
        System.out.println("\ntranspose matrix");
        myMatrixComplex = myMatrixComplex.transpose();
        myMatrixComplex.toStr();
        System.out.println("\ndeterminant matrix");
        System.out.println(myMatrixComplex.determinantCom());

        Matrix<ComplexNum> myMatrixComplex3 = new Matrix<>(4, 4);
        myMatrixComplex3.fillMatrix(new ComplexNum[][] {
                {new ComplexNum(2, 7), new ComplexNum(2, 2347), new ComplexNum(2, 7), new ComplexNum(3452, 7)},
                {new ComplexNum(2234, 7), new ComplexNum(2, 7), new ComplexNum(342, 7), new ComplexNum(2, 7)},
                {new ComplexNum(2, 7), new ComplexNum(2, 743), new ComplexNum(2, 7), new ComplexNum(2, 7)},
                {new ComplexNum(552, 7), new ComplexNum(332, 7), new ComplexNum(22, 7), new ComplexNum(1, 7)}});
        System.out.println("\ndeterminant matrix");
        myMatrixComplex3.toStr();
        System.out.println(myMatrixComplex3.determinantCom());
    }
}
