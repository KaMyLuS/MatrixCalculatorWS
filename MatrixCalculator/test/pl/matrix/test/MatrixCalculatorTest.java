/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.matrix.test;

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pl.matrix.core.Matrix;
import pl.matrix.core.MatrixCalculator;

/**
 *
 * @author KaMyLuS
 */
public class MatrixCalculatorTest {

    MatrixCalculator calculator = new MatrixCalculator();

    /*
     Testy dodawania macierzy
     */
    @Test
    public void addMatricesTest1() {
        double dataA[][] = {{1}};
        double dataB[][] = {{2}};
        double dataOk[][] = {{3}};

        Matrix a = new Matrix(dataA);
        Matrix b = new Matrix(dataB);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.addMatrices(a, b);
        assertEquals(ok, res);
    }

    @Test
    public void addMatricesTest2() {
        double dataA[][] = {{0.5, 12}, {0.67, -3}, {123, 0.01}};
        double dataB[][] = {{-3, 1}, {2, 1.0002}, {0, 5465}};
        double dataOk[][] = {{-2.5, 13}, {2.67, -1.9998}, {123, 5465.01}};

        Matrix a = new Matrix(dataA);
        Matrix b = new Matrix(dataB);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.addMatrices(a, b);
        assertEquals(ok, res);
    }

    @Test
    public void addMatricesTest3() {
        double dataA[][] = {{-111111111}, {-56}, {-0}};
        double dataB[][] = {{-5}, {-1.2}, {-3}};
        double dataOk[][] = {{-111111116}, {-57.2}, {-3}};

        Matrix a = new Matrix(dataA);
        Matrix b = new Matrix(dataB);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.addMatrices(a, b);
        assertEquals(ok, res);
    }

    @Test(expected = Exception.class)
    public void addMatricesTest4() {
        double dataA[][] = {{-111111111}, {-56}, {-0}};
        double dataB[][] = {{-5}, {-1.2}, {-3}, {3}};
        double dataOk[][] = {{-111111116}, {-57.2}, {-3}};

        Matrix a = new Matrix(dataA);
        Matrix b = new Matrix(dataB);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.addMatrices(a, b);
    }

    /* 
     Testy mnożenia
     */
    @Test
    public void multiplyMatricesTest1() {
        double dataA[][] = {{1}};
        double dataB[][] = {{2}};
        double dataOk[][] = {{2}};

        Matrix a = new Matrix(dataA);
        Matrix b = new Matrix(dataB);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.multiplyMatrices(a, b);
        assertEquals(ok, res);
    }

    @Test
    public void multiplyMatricesTest2() {
        double dataA[][] = {{0.5, 12}, {0.67, -3}, {123, 0.01}};
        double dataB[][] = {{-3, 1, 0.5}, {2, 1.0002, -3}};
        double dataOk[][] = {{22.5, 12.5024, -35.75},
        {-8.01, -2.3306, 9.335},
        {-368.98, 123.010002, 61.47}};

        Matrix a = new Matrix(dataA);
        Matrix b = new Matrix(dataB);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.multiplyMatrices(a, b);
        assertEquals(ok, res);
    }

    @Test
    public void multiplyMatricesTest3() {
        double dataA[][] = {{0.5, 12, -6},
        {0.67, -3, 0.001},
        {123, 0.01, 2.32}};

        double dataB[][] = {{6.234, -56, 0.5},
        {10002, -51.0002, -3},
        {432434.325, 3457.123, -4324}};

        double dataOk[][] = {{-2474578.833, -21382.740400000002, 25908.25},
        {-29569.388895, 118.93772299999998, 5.011000000000001},
        {1004114.436, 1132.0153579999997, -9970.21}
        };

        Matrix a = new Matrix(dataA);
        Matrix b = new Matrix(dataB);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.multiplyMatrices(a, b);
        assertEquals(ok, res);
    }

    @Test(expected = Exception.class)
    public void multiplyMatricesTest4() {
        double dataA[][] = {{-111111111}, {-56}, {-0}};
        double dataB[][] = {{-5}, {-1.2}, {-3}, {3}};
        double dataOk[][] = {{-111111116}, {-57.2}, {-3}};

        Matrix a = new Matrix(dataA);
        Matrix b = new Matrix(dataB);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.multiplyMatrices(a, b);
    }

    /*
     Testy wyznacznika
     */
    @Test(expected = Exception.class)
    public void calculateDeterminantTest1() {
        double dataA[][] = {{-111111111}, {-56}, {-0}};
        Matrix a = new Matrix(dataA);

        double res = calculator.calculateDeterminant(a);
    }

    @Test
    public void calculateDeterminantTest2() {
        double dataA[][] = {{3.14444}};
        Matrix a = new Matrix(dataA);

        double res = calculator.calculateDeterminant(a);
        assertEquals(3.14444, res, 0.0001);
    }

    @Test
    public void calculateDeterminantTest3() {
        double dataA[][] = {{1, 2}, {-2, 2.5}};
        Matrix a = new Matrix(dataA);

        double res = calculator.calculateDeterminant(a);
        assertEquals(6.5, res, 0.0001);
    }

    @Test
    public void calculateDeterminantTest4() {
        double dataA[][] = {{1, 1234, 564.4334, -6.76, -44}, {0, 2, 23.1, 54.121, 65.132},
        {0, 0, 3, 7, 3}, {0, 0, 0, 4, 123.4}, {0, 0, 0, 0, 5}};
        Matrix a = new Matrix(dataA);

        double res = calculator.calculateDeterminant(a);
        assertEquals(120, res, 0.0001);
    }

    /* 
     Testy sladu
     */
    @Test(expected = Exception.class)
    public void calculateTraceTest1() {
        double dataA[][] = {{-111111111}, {-56}, {-0}};
        Matrix a = new Matrix(dataA);

        double res = calculator.calculateTrace(a);
    }

    @Test
    public void calculateTraceTest2() {
        double dataA[][] = {{3.14444}};
        Matrix a = new Matrix(dataA);

        double res = calculator.calculateTrace(a);
        assertEquals(3.14444, res, 0.0001);
    }

    @Test
    public void calculateTraceTest3() {
        double dataA[][] = {{1, 2}, {-2, 2.5}};
        Matrix a = new Matrix(dataA);

        double res = calculator.calculateTrace(a);
        assertEquals(3.5, res, 0.0001);
    }

    @Test
    public void calculateTraceTest4() {
        double dataA[][] = {{1, 1234, 564.4334, -6.76, -44}, {0, 2, 23.1, 54.121, 65.132},
        {0, 0, 3, 7, 3}, {0, 0, 0, 4, 123.4}, {0, 0, 0, 0, 5}};
        Matrix a = new Matrix(dataA);

        double res = calculator.calculateTrace(a);
        assertEquals(15, res, 0.0001);
    }

    /* 
     Testy mnożenia przez skalar
     */
    @Test
    public void multiplyByScalarTest1() {
        double dataA[][] = {{1}};
        double b = 2;
        double dataOk[][] = {{2}};

        Matrix a = new Matrix(dataA);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.multiplyByScalar(a, b);
        assertEquals(ok, res);
    }

    @Test
    public void multiplyByScalarTest2() {
        double dataA[][] = {{0.5, 12}, {0.67, 3}, {123, 0.01}};
        double b = 0;
        double dataOk[][] = {{0, 0},
        {0, 0},
        {0, 0}};

        Matrix a = new Matrix(dataA);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.multiplyByScalar(a, b);
        assertEquals(ok, res);
    }

    @Test
    public void multiplyByScalarTest3() {
        double dataA[][] = {{0.5, 12, -6},
        {0.67, -3, 0.001},
        {123, 0.01, 2.32}};

        double b = -2.56;

        double dataOk[][] = {{-1.28, -30.72, 15.36},
        {-1.7152, 7.68, -0.00256},
        {-314.88, -0.0256, -5.9392}
        };

        Matrix a = new Matrix(dataA);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.multiplyByScalar(a, b);
        assertEquals(ok, res);
    }

    @Test
    public void multiplyByScalarTest4() {
        double dataA[][] = {{-111111111}, {-56}, {-0}};
        double b = 1;
        double dataOk[][] = {{-111111116}, {-56}, {0}};

        Matrix a = new Matrix(dataA);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.multiplyByScalar(a, b);
    }

    /*
     Testy transpozycji
     */
    @Test
    public void transposeMatrixTest1() {
        double dataA[][] = {{1}};
        double dataOk[][] = {{1}};

        Matrix a = new Matrix(dataA);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.transposeMatrix(a);
        assertEquals(ok, res);
    }

    @Test
    public void transposeMatrixTest2() {
        double dataA[][] = {{0.5, 12}, {0.67, 3}, {123, 0.01}};
        double dataOk[][] = {{0.5, 0.67, 123},
        {12, 3, 0.01}};

        Matrix a = new Matrix(dataA);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.transposeMatrix(a);
        assertEquals(ok, res);
    }

    @Test
    public void transposeMatrixTest3() {
        double dataA[][] = {{0.5, 12, -6},
        {0.67, -3, 0.001},
        {123, 0.01, 2.32}};

        double dataOk[][] = {{0.5, 0.67, 123},
        {12, -3, 0.01},
        {-6, 0.001, 2.32}
        };

        Matrix a = new Matrix(dataA);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.transposeMatrix(a);
        assertEquals(ok, res);
    }

    @Test
    public void transposeMatrixTest4() {
        double dataA[][] = {{-111111111}, {-56}, {-0}};
        double dataOk[][] = {{-111111111, -56, -0}};

        Matrix a = new Matrix(dataA);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.transposeMatrix(a);
        assertEquals(ok, res);
    }

    @Test(expected = Exception.class)
    public void transposeMatrixTest5() {
        double dataA[][] = null;

        Matrix a = new Matrix(dataA);

        Matrix res = calculator.transposeMatrix(a);
    }

    /*
     Testy wartosci wlasnych
     */
    @Test
    public void calculateEigenValuesTest1() {
        double dataA[][] = {{1}};

        Matrix a = new Matrix(dataA);
        List<Double> ok = Arrays.asList(1.0);

        List<Double> res = calculator.calculateEigenValues(a);
        assertEquals(ok, res);
    }

    @Test
    public void calculateEigenValuesTest2() {
        double dataA[][] = {{0.5, 12}, {0.67, 3}};

        Matrix a = new Matrix(dataA);
        List<Double> ok = Arrays.asList(-1.3487900864692337, 4.848790086469233);

        List<Double> res = calculator.calculateEigenValues(a);
        assertEquals(ok, res);
    }

    @Test
    public void calculateEigenValuesTest3() {
        double dataA[][] = {{0.5, 12, -6},
        {0.67, -3, 0.001},
        {123, 0.01, 2.32}};

        Matrix a = new Matrix(dataA);
        List<Double> ok = Arrays.asList(1.437592246454379, 1.437592246454379, -3.055184492908866);

        List<Double> res = calculator.calculateEigenValues(a);
        assertEquals(ok, res);
    }

    @Test(expected = Exception.class)
    public void calculateEigenValuesTest4() {
        double dataA[][] = {{-111111111}, {-56}, {-0}};

        Matrix a = new Matrix(dataA);

        List<Double> res = calculator.calculateEigenValues(a);
    }

    @Test(expected = Exception.class)
    public void calculateEigenValuesTest5() {
        double dataA[][] = null;

        Matrix a = new Matrix(dataA);

        List<Double> res = calculator.calculateEigenValues(a);
    }

    /*
     Testy sprowadzania do macierzy trojkatnej gornej
     */
    @Test
    public void transformToTriangularUpperMatrixTest1() throws Exception {
        double dataA[][] = {{1}};
        double dataOk[][] = {{1}};

        Matrix a = new Matrix(dataA);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.transformToTriangularUpperMatrix(a);
        assertEquals(ok, res);
    }

    @Test
    public void transformToTriangularUpperMatrixTest2() throws Exception {
        double dataA[][] = {{0.5, 12, -433}, {0.67, 3, 321}, {123, 0.01, 0}};
        double dataOk[][] = {{0.5, 12.0, -433.0},
        {0.0, -13.080000000000002, 901.22},
        {0.0, 0.0, -96875.9164984709},};

        Matrix a = new Matrix(dataA);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.transformToTriangularUpperMatrix(a);
        assertEquals(ok, res);
    }

    @Test
    public void transformToTriangularUpperMatrixTest3() throws Exception {
        double dataA[][] = {{0.5, 12, -6},
        {0.67, -3, 0.001},
        {123, 0.01, 2.32}};

        double dataOk[][] = {{0.5, 12.0, -6.0},
        {0.0, -19.080000000000002, 8.041},
        {0.0, 0.0, 234.24496907756816},};

        Matrix a = new Matrix(dataA);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.transformToTriangularUpperMatrix(a);
        assertEquals(ok, res);
    }

    @Test(expected = Exception.class)
    public void transformToTriangularUpperMatrixTest4() throws Exception {
        double dataA[][] = {{-111111111}, {-56}, {-0}};

        Matrix a = new Matrix(dataA);

        Matrix res = calculator.transformToTriangularUpperMatrix(a);
    }

    @Test(expected = Exception.class)
    public void transformToTriangularUpperMatrixTest5() throws Exception {
        double dataA[][] = null;

        Matrix a = new Matrix(dataA);

        Matrix res = calculator.transformToTriangularUpperMatrix(a);
    }

    /*
     Testy uklad rownan
     */
    @Test
    public void solveLinearEquationTest1() {
        double dataA[][] = {{1.34}};
        double dataB[][] = {{2}};
        double dataOk[][] = {{1.4925373134328357}};

        Matrix a = new Matrix(dataA);
        Matrix b = new Matrix(dataB);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.solveLinearEquation(a, b);
        assertEquals(ok, res);
    }

    @Test
    public void solveLinearEquationTest2() {
        double dataA[][] = {{0.5, 12, 23}, {0.67, -3, 0}, {123, 0, 0.01135}};
        double dataB[][] = {{-3}, {1.0002}, {5465}};
        double dataOk[][] = {{44.43145715995167},
        {9.589625432389205},
        {-6.099618859506361}};

        Matrix a = new Matrix(dataA);
        Matrix b = new Matrix(dataB);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.solveLinearEquation(a, b);
        assertEquals(ok, res);
    }

    @Test
    public void solveLinearEquationTest3() {
        double dataA[][] = {{4, -2, 4, -2}, {3, 1, 4, 2}, {2, 4, 2, 1}, {2, -2, 4, 2}};
        double dataB[][] = {{8}, {7}, {10}, {2}};
        double dataOk[][] = {{-1.0},
        {2.0},
        {3.0},
        {-2.0}};

        Matrix a = new Matrix(dataA);
        Matrix b = new Matrix(dataB);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.solveLinearEquation(a, b);
        assertEquals(ok, res);
    }

    @Test(expected = Exception.class)
    public void solveLinearEquationTest4() {
        double dataA[][] = {{-111111111}, {-56}, {-0}};
        double dataB[][] = {{-5}, {-1.2}, {-3}, {3}};
        double dataOk[][] = {{-111111116}, {-57.2}, {-3}};

        Matrix a = new Matrix(dataA);
        Matrix b = new Matrix(dataB);
        Matrix ok = new Matrix(dataOk);

        Matrix res = calculator.solveLinearEquation(a, b);
    }

    @Test(expected = Exception.class)
    public void solveLinearEquationTest5() {
        Matrix res = calculator.solveLinearEquation(null, null);
    }

    @Test(expected = Exception.class)
    public void solveLinearEquationTest6() {
        double dataA[][] = {{0}};
        double dataB[][] = {{0}};

        Matrix a = new Matrix(dataA);
        Matrix b = new Matrix(dataB);

        Matrix res = calculator.solveLinearEquation(a, b);
    }

    @Test(expected = Exception.class)
    public void solveLinearEquationTest7() {
        double dataA[][] = {{0}};
        double dataB[][] = {{1}};

        Matrix a = new Matrix(dataA);
        Matrix b = new Matrix(dataB);

        Matrix res = calculator.solveLinearEquation(a, b);
    }

    /*
     Testy LU
     */
    @Test
    public void calculateLUDecompositionTest1() {
        double dataA[][] = {{1.0}};

        double dataOkL[][] = {{1.0}};
        double dataOkU[][] = {{1.0}};

        Matrix a = new Matrix(dataA);
        Matrix okL = new Matrix(dataOkL);
        Matrix okU = new Matrix(dataOkU);

        List<Matrix> res = calculator.calculateLUDecomposition(a);
        assertEquals(okL, res.get(0));
        assertEquals(okU, res.get(1));
    }

    @Test
    public void calculateLUDecompositionTest2() {
        double dataA[][] = {{1, 2, 3},
        {4, 5, 6},
        {7, 4, 9}};

        double dataOkL[][] = {{1.0, 0.0, 0.0},
        {0.5714285714285714, 1.0, 0.0},
        {0.14285714285714285, 0.5263157894736842, 1.0}};
        double dataOkU[][] = {{7.0, 4.0, 9.0},
        {0.0, 2.7142857142857144, 0.8571428571428577},
        {0.0, 0.0, 1.263157894736842}};

        Matrix a = new Matrix(dataA);
        Matrix okL = new Matrix(dataOkL);
        Matrix okU = new Matrix(dataOkU);

        List<Matrix> res = calculator.calculateLUDecomposition(a);
        assertEquals(okL, res.get(0));
        assertEquals(okU, res.get(1));
    }

    @Test
    public void calculateLUDecompositionTest3() {
        double dataA[][] = {{0.5, 12, -6},
        {0.67, -3, 0.001},
        {123, 0.01, 2.32}};

        double dataOkL[][] = {{1.0, 0.0, 0.0},
        {0.0040650406504065045, 1.0, 0.0},
        {0.005447154471544716, -0.2500053861971077, 1.0}
        };
        double dataOkU[][] = {{123.0, 0.01, 2.32},
        {0.0, 11.999959349593496, -6.009430894308943},
        {0.0, 0.0, -1.5140274899305215}
        };

        Matrix a = new Matrix(dataA);
        Matrix okL = new Matrix(dataOkL);
        Matrix okU = new Matrix(dataOkU);

        List<Matrix> res = calculator.calculateLUDecomposition(a);
        assertEquals(okL, res.get(0));
        assertEquals(okU, res.get(1));
    }

    @Test(expected = Exception.class)
    public void calculateLUDecompositionTest4() {
        double dataA[][] = {{-111111111}, {-56}, {-0}};

        Matrix a = new Matrix(dataA);

        List<Matrix> res = calculator.calculateLUDecomposition(a);
    }

    @Test(expected = Exception.class)
    public void calculateLUDecompositionTest5() {
        double dataA[][] = null;

        Matrix a = new Matrix(dataA);

        calculator.calculateLUDecomposition(a);
    }
}
