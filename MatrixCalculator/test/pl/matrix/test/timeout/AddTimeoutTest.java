/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.matrix.test.timeout;

import java.util.Random;
import org.junit.After;
import org.junit.Test;
import org.junit.BeforeClass;
import pl.matrix.core.Matrix;
import pl.matrix.core.MatrixCalculator;
import static pl.matrix.test.timeout.Config.data_1;
import static pl.matrix.test.timeout.Config.data_2;
import static pl.matrix.test.timeout.Config.data_3;
import static pl.matrix.test.timeout.Config.data_4;

/**
 *
 * @author Mateusz Renes
 */
public class AddTimeoutTest {
    
    MatrixCalculator calculator = new MatrixCalculator();
    
    
    
    @BeforeClass 
    public static void beforeClass() {
        Config.beforeClass();
    }
    
    @After
    public void after(){
        System.gc();
    }
    
    /*
     Testy dodawania macierzy
     */
    @Test(timeout = Config.TIMEOUT)
    public void addMatricesTest1() {
        Matrix a = new Matrix(data_1);
        Matrix b = new Matrix(data_1);
        calculator.addMatrices(a, b);
    }
    
    @Test(timeout = Config.TIMEOUT)
    public void addMatricesTest2() {
        Matrix a = new Matrix(data_2);
        Matrix b = new Matrix(data_2);
        calculator.addMatrices(a, b);
    }
    
    @Test(timeout = Config.TIMEOUT)
    public void addMatricesTest3() {
        Matrix a = new Matrix(data_3);
        Matrix b = new Matrix(data_3);
        calculator.addMatrices(a, b);
    }
    
    @Test(timeout = Config.TIMEOUT)
    public void addMatricesTest4() {
        Matrix a = new Matrix(data_4);
        Matrix b = new Matrix(data_4);
        calculator.addMatrices(a, b);
    }
    
}
