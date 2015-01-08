/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.matrix.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import pl.matrix.client.ws.DoubleArray;
import pl.matrix.client.ws.Matrix;

/**
 *
 * @author KaMyLuS
 */
public class MatrixStringConverter {
    
    private List<String> splitStringIntoLines(String s) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(s));
        List<String> lines = new ArrayList();
        
        for(String line = reader.readLine(); line != null; line = reader.readLine()) {
            lines.add(line);
        }
        
        return lines;
    }
    
    private DoubleArray splitLineIntoDouble(String s) {
        DoubleArray result = new DoubleArray();
        String[] splitted = s.split(";");
        
        for(String elem : splitted) {
            Double dElem = Double.parseDouble(elem);
            result.getItem().add(dElem);
        }

        return result;
    }
    
    public Matrix stringToMatrix(String s) throws IOException {
        Matrix result = new Matrix();
        
        List<String> lines = this.splitStringIntoLines(s);
        for(String line : lines) {
            DoubleArray row = this.splitLineIntoDouble(line);
            result.getData().add(row);
        }

        return result;
    }
    
    public String matrixToString(Matrix m) {
        StringBuilder builder = new StringBuilder();
        List<DoubleArray> ldaMatrix = m.getData();
        
        for(DoubleArray daRow : ldaMatrix) {
            List<Double> row = daRow.getItem();
            for(Double elem : row) {
                builder.append(elem + "; ");
            }
            builder.append("<br />");
        }
        
        return builder.toString();
    }
}
