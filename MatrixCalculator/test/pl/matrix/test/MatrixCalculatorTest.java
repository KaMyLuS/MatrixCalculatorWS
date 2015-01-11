/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.matrix.test;

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
        Testy wyznacznika
    */
    
    @Test(expected = Exception.class)
    public void calculateDeterminantTest1() {
        double dataA[][] = {{-111111111}, {-56}, {-0}};
        Matrix a = new Matrix(dataA);
        
        double res = calculator.calculateDeterminant(a);
    }
    
    public void calculateDeterminantTest2() {
        double dataA[][] = {{3.14444}};
        Matrix a = new Matrix(dataA);
        
        double res = calculator.calculateDeterminant(a);
        assertEquals(3.14444, res, 0.0001);
    }
    
    public void calculateDeterminantTest3() {
        double dataA[][] = {{1, 2}, {-2, 2.5}};
        Matrix a = new Matrix(dataA);
        
        double res = calculator.calculateDeterminant(a);
        assertEquals(6.5, res, 0.0001);
    }
    
    public void calculateDeterminantTest4() {
        double dataA[][] = {{1, 1234, 564.4334, -6.76, -44}, {0, 2, 23.1, 54.121, 65.132}, 
            {0, 0, 3, 7, 3}, {0, 0, 0, 4, 123.4}, {0, 0, 0, 0, 5}};
        Matrix a = new Matrix(dataA);
        
        double res = calculator.calculateDeterminant(a);
        assertEquals(120, res, 0.0001);
    }
}
