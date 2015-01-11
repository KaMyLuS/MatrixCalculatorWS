/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.matrix.servlet.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pl.matrix.servlet.MatrixCalculatorServlet;

/**
 *
 * @author KaMyLuS
 */
public class MatrixCalculatorServletTest {
    
    MatrixCalculatorServlet servlet = new MatrixCalculatorServlet();
    
    public MatrixCalculatorServletTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void calculateTrace1Test() {
        servlet.callSampleMatrix(5);
        System.out.println(servlet.callSampleMatrix(5));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
