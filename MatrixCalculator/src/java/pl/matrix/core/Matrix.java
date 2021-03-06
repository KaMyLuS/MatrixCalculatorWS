/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.matrix.core;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

/**
 *
 * @author KaMyLuS
 */
public class Matrix {
    private double[][] data;

    public Matrix() {
       data = null; 
    }
    
    public Matrix(double[][] data) {
        this.data = data;
    }
    
    public Matrix(RealMatrix rm) {
        data = rm.getData();
    }
    
    public double[][] getData() {
        return data;
    }

    public void setData(double[][] data) {
        this.data = data;
    }
   
    public RealMatrix toRealMatrix() {
        return new Array2DRowRealMatrix(data);
    }
    
    @Override
    public boolean equals(Object other) {
        if(other instanceof Matrix) {
            Matrix oth = (Matrix)other;
            double[][] otherData = oth.getData();
            
            if(data.length != otherData.length) {
                return false;
            }
            
            for(int i = 0; i < data.length; i++) {
                if(data[i].length != otherData[i].length){
                    return false;
                }
                
                for(int j = 0; j < data[i].length; j++) {
                    if(Double.compare(data[i][j], otherData[i][j]) != 0) {
                        return false;
                    }
                }
            }
            
            return true;
        }
        return false;
    }
}
