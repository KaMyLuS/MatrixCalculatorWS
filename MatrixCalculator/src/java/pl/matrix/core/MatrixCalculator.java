/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.matrix.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.linear.*;

/**
 *
 * @author KaMyLuS
 */
public class MatrixCalculator {
    
    public Matrix addMatrices(Matrix a, Matrix b) {
        RealMatrix aRealMatrix = a.toRealMatrix();
        RealMatrix bRealMatrix = b.toRealMatrix();
        
        Matrix result = new Matrix(aRealMatrix.add(bRealMatrix));
        return result;
    }
    
    public Matrix multiplyMatrices(Matrix a, Matrix b) {
        RealMatrix aRealMatrix = a.toRealMatrix();
        RealMatrix bRealMatrix = b.toRealMatrix();
        
        Matrix result = new Matrix(aRealMatrix.multiply(bRealMatrix));
        return result;
    }
    
    public Matrix multiplyByScalar(Matrix a, double s) {
       RealMatrix aRealMatrix = a.toRealMatrix();
       
       Matrix result = new Matrix(aRealMatrix.scalarMultiply(s));
       return result;
    }
    
    public Matrix transposeMatrix(Matrix a) {
       RealMatrix aRealMatrix = a.toRealMatrix();
       
       Matrix result = new Matrix(aRealMatrix.transpose());
       return result;
    }
    
    public double calculateTrace(Matrix a) {
       RealMatrix aRealMatrix = a.toRealMatrix();
       
       double result = aRealMatrix.getTrace();
       return result;
    }
    
    public List<Double> calculateEigenValues(Matrix a) {
        RealMatrix aRealMatrix = a.toRealMatrix();
        
        EigenDecomposition eigen = new EigenDecomposition(aRealMatrix);
        List<Double> result = new ArrayList<>();
        
        double[] eigenValues = eigen.getRealEigenvalues();
        for(double x : eigenValues) {
            result.add(x);
        }

        return result;
    }
    
    public double calculateDeterminant(Matrix a) {
        RealMatrix aRealMatrix = a.toRealMatrix();
        
        LUDecomposition lud = new LUDecomposition(aRealMatrix);
        double result = lud.getDeterminant();

        return result;
    }
    
    public Matrix transformToTriangularUpperMatrix(Matrix a) {
        RealMatrix aRealMatrix = a.toRealMatrix();
        
        if(aRealMatrix.getRowDimension() != aRealMatrix.getColumnDimension()) {
            return null;
        }
        
        int n = aRealMatrix.getRowDimension();
        // iteracja (zerowanie i-tej kolumny)
        for(int i = 0; i < n-1; i++) {
            // po wierszach
            for(int j = i+1; j < n; j++) {
                double factor = aRealMatrix.getEntry(j, i)/aRealMatrix.getEntry(i, i);
                
                // po kolumnach
                for(int k = i; k < n; k++) {
                    double newValue = aRealMatrix.getEntry(j, k) - 
                            factor*aRealMatrix.getEntry(i, k);
                    aRealMatrix.setEntry(j, k, newValue);
                }
            }
        }
        Matrix result = new Matrix(aRealMatrix);

        return result;
    }
    
    public List<Matrix> calculateLUDecomposition(Matrix a) {
        RealMatrix aRealMatrix = a.toRealMatrix();
        
        LUDecomposition lu = new LUDecomposition(aRealMatrix);
        List<Matrix> result = new ArrayList<>();
        
        result.add(new Matrix(lu.getL()));
        result.add(new Matrix(lu.getU()));
        
        return result;
    }
    
    public Matrix solveLinearEquation(Matrix a, Matrix b) {
        RealMatrix aRealMatrix = a.toRealMatrix();
        RealMatrix bRealMatrix = b.toRealMatrix();
        
        DecompositionSolver decompositionSolver = new LUDecomposition(aRealMatrix).getSolver();
        Matrix result = new Matrix(decompositionSolver.solve(bRealMatrix));
        
        return result;
    }
  
    
}
