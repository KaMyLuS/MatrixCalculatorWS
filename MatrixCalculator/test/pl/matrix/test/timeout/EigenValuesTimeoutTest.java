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
import static pl.matrix.test.timeout.Config.TIMEOUT;

/**
 *
 * @author Mateusz Renes
 */
public class EigenValuesTimeoutTest {
    
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
     Testy wartosci wlasnych
     */
    @Test(timeout = TIMEOUT)
    public void calculateEigenValuesTest1() {
        Matrix a = new Matrix(data_1);
        calculator.calculateEigenValues(a);
    }

    @Test(timeout = TIMEOUT)
    public void calculateEigenValuesTest2() {
        Matrix a = new Matrix(data_2);
        calculator.calculateEigenValues(a);
    }

    @Test(timeout = TIMEOUT)
    public void calculateEigenValuesTest3() {
        Matrix a = new Matrix(data_3);
        calculator.calculateEigenValues(a);
    }

    @Test(timeout = TIMEOUT)
    public void calculateEigenValuesTest4() {
        Matrix a = new Matrix(data_4);
        calculator.calculateEigenValues(a);
    }

    
}
