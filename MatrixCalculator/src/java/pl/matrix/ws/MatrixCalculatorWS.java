/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.matrix.ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.apache.commons.math3.linear.*;
import pl.matrix.core.Matrix;

/**
 *
 * @author KaMyLuS
 */
@WebService
public interface MatrixCalculatorWS {

    @WebMethod
    public Matrix addMatrices(Matrix a, Matrix b);
    
    @WebMethod
    public Matrix multiplyMatrices(Matrix a, Matrix b);
    
    @WebMethod
    public Matrix multiplyByScalar(Matrix a, double s);
    
    @WebMethod
    public Matrix transposeMatrix(Matrix a);
    
    @WebMethod
    public double calculateTrace(Matrix a);
    
    @WebMethod
    public List<Double> calculateEigenValues(Matrix a);
    
    @WebMethod
    public double calculateDeterminant(Matrix a);
    
    @WebMethod
    public Matrix transformToTriangularUpperMatrix(Matrix a) throws Exception;
    
    @WebMethod
    public List<Matrix> calculateLUDecomposition(Matrix a);
    
    @WebMethod
    public Matrix solveLinearEquation(Matrix a, Matrix b);
    
    @WebMethod
    public Matrix sampleMatrix(double x);
}