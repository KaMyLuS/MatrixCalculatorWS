/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.matrix.servlet.test;

import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pl.matrix.client.ws.DoubleArray;
import pl.matrix.client.ws.Matrix;
import pl.matrix.servlet.MatrixStringConverter;

/**
 *
 * @author KaMyLuS
 */
public class MatrixStringConverterTest {

    private MatrixStringConverter matrixConverter = new MatrixStringConverter();

    public boolean areEquals(Matrix a, double[][] b) {
        List<DoubleArray> ldaMatrix = a.getData();
        
        if (b.length != ldaMatrix.size()) {
            return false;
        }

        for (int i = 0; i < ldaMatrix.size(); i++) {
            List<Double> row = ldaMatrix.get(i).getItem();

            if (b[i].length != row.size()) {
                return false;
            }

            for (int j = 0; j < row.size(); j++) {
                if (Double.compare(b[i][j], row.get(j)) != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void matrixToStringTest1() {
        double[][] mArray = {{1, 2}};
        Matrix m = matrixConverter.doubleArrayToMatrix(mArray);
        String mString = matrixConverter.matrixToString(m);
        assertEquals("{{1.0, 2.0},<br />};", mString);
    }

    @Test
    public void matrixToStringTest2() {
        double[][] mArray = {{}};
        Matrix m = matrixConverter.doubleArrayToMatrix(mArray);
        String mString = matrixConverter.matrixToString(m);
        assertEquals("{{},<br />};", mString);
    }

    @Test(expected = Exception.class)
    public void matrixToStringTest3() {
        double[][] mArray = null;
        Matrix m = matrixConverter.doubleArrayToMatrix(mArray);
        String mString = matrixConverter.matrixToString(m);
    }

    @Test
    public void matrixToStringTest4() {
        double[][] mArray = {{1.278}};
        Matrix m = matrixConverter.doubleArrayToMatrix(mArray);
        String mString = matrixConverter.matrixToString(m);
        assertEquals("{{1.278},<br />};", mString);
    }

    @Test
    public void matrixToStringTest5() {
        double[][] mArray = {{1.5, -0.67, 12}, {0, 0, 0}, {4324.112, 56.89, -565.89}};
        Matrix m = matrixConverter.doubleArrayToMatrix(mArray);
        String mString = matrixConverter.matrixToString(m);
        assertEquals("{{1.5, -0.67, 12.0},<br />{0.0, 0.0, 0.0},<br />{4324.112, 56.89, -565.89},<br />};", mString);
    }

    @Test
    public void stringToMatrixTest1() throws IOException {
        String mString = "0";
        Matrix m = matrixConverter.stringToMatrix(mString);

        double[][] mArray = {{0}};
        assertEquals(true, areEquals(m, mArray));
    }

    @Test
    public void stringToMatrixTest2() throws IOException {
        String mString = "0.454, -67435.214234";
        Matrix m = matrixConverter.stringToMatrix(mString);

        double[][] mArray = {{0.454, -67435.214234}};
        assertEquals(true, areEquals(m, mArray));
    }

    @Test
    public void stringToMatrixTest3() throws IOException {
        String mString = "1, 2 \n 3, 4";
        Matrix m = matrixConverter.stringToMatrix(mString);

        double[][] mArray = {{1, 2}, {3, 4}};
        assertEquals(true, areEquals(m, mArray));
    }

    @Test
    public void stringToMatrixTest4() throws IOException {
        String mString = "-546546.3253, -4564.2342, 0,\n-0.9999, 777, -1 \n324, 242.111, -435.0066";
        Matrix m = matrixConverter.stringToMatrix(mString);

        double[][] mArray = {{-546546.3253, -4564.2342, 0}, {-0.9999, 777, -1},
        {324, 242.111, -435.0066}};
        assertEquals(true, areEquals(m, mArray));
    }

    @Test
    public void stringToMatrixTest5() throws IOException {
        String mString = "4566546.3253, -45646.2342, 0, 4535.231\n-0.9999, 777, -1, 634543 \n324, 242.111, -435.0066, -35234.4567546";
        Matrix m = matrixConverter.stringToMatrix(mString);

        double[][] mArray = {{4566546.3253, -45646.2342, 0, 4535.231},
        {-0.9999, 777, -1, 634543},
        {324, 242.111, -435.0066, -35234.4567546}};
        assertEquals(true, areEquals(m, mArray));
    }

    @Test(expected = Exception.class)
    public void stringToMatrixTest6() throws IOException {
        String mString = "sdfsdfdsf";
        Matrix m = matrixConverter.stringToMatrix(mString);
    }

    @Test(expected = Exception.class)
    public void stringToMatrixTest7() throws IOException {
        String mString = "1.2; 345";
        Matrix m = matrixConverter.stringToMatrix(mString);
    }

    @Test(expected = Exception.class)
    public void stringToMatrixTest8() throws IOException {
        String mString = "{{1, 2}, {3, 4}}";
        Matrix m = matrixConverter.stringToMatrix(mString);
    }

    @Test
    public void stringToMatrixTest9() throws IOException {
        String mString = "";
        Matrix m = matrixConverter.stringToMatrix(mString);

        double[][] mArray = {};
        assertEquals(true, areEquals(m, mArray));
    }
}
