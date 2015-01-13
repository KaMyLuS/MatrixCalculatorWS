/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.matrix.ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import org.apache.commons.math3.linear.*;
import pl.matrix.core.Matrix;
import pl.matrix.core.MatrixCalculator;

/**
 *
 * @author KaMyLuS
 */
@WebService(endpointInterface = "pl.matrix.ws.MatrixCalculatorWS")
public class MatrixCalculatorWSImpl implements MatrixCalculatorWS {
    
    private MatrixCalculator matrixCalculator = new MatrixCalculator();

    @Override
    public Matrix addMatrices(Matrix a, Matrix b) {
        Matrix result = matrixCalculator.addMatrices(a, b);
        return result;
    }

    @Override
    public Matrix multiplyMatrices(Matrix a, Matrix b) {
        Matrix result = matrixCalculator.multiplyMatrices(a, b);
        return result;
    }

    @Override
    public Matrix multiplyByScalar(Matrix a, double s) {
       Matrix result = matrixCalculator.multiplyByScalar(a, s);
       return result; 
    }

    @Override
    public Matrix transposeMatrix(Matrix a) {
        Matrix result = matrixCalculator.transposeMatrix(a);
        return result;
    }

    @Override
    public double calculateTrace(Matrix a) {
        double result = matrixCalculator.calculateTrace(a);
        return result;
    }

    @Override
    public List<Double> calculateEigenValues(Matrix a) {
        List<Double> result = matrixCalculator.calculateEigenValues(a);
        return result;
    }

    @Override
    public double calculateDeterminant(Matrix a) {
        double result = matrixCalculator.calculateDeterminant(a);
        return result;
    }

    @Override
    public Matrix transformToTriangularUpperMatrix(Matrix a) throws Exception {
        Matrix result = matrixCalculator.transformToTriangularUpperMatrix(a);
        return result;
    }

    @Override
    public List<Matrix> calculateLUDecomposition(Matrix a) {
        List<Matrix> result = matrixCalculator.calculateLUDecomposition(a);
        return result;
    }

    @Override
    public Matrix solveLinearEquation(Matrix a, Matrix b) {
        Matrix result = matrixCalculator.solveLinearEquation(a, b);
        return result;
    }

    @Override
    public Matrix sampleMatrix(double x) {
        double[][] dArray = {{1, 2}, {3, 4}, {x, 2*x}};
        RealMatrix rm = new Array2DRowRealMatrix(dArray);
        return new Matrix(rm);
    }

    
}
