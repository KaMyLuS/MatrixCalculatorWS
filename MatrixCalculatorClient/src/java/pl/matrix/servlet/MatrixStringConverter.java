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

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            lines.add(line);
        }

        return lines;
    }

    private DoubleArray splitLineIntoDouble(String s) {
        DoubleArray result = new DoubleArray();
        String[] splitted = s.split(",");

        for (String elem : splitted) {
            Double dElem = Double.parseDouble(elem);
            result.getItem().add(dElem);
        }

        return result;
    }

    public Matrix stringToMatrix(String s) throws IOException {
        Matrix result = new Matrix();

        List<String> lines = this.splitStringIntoLines(s);
        for (String line : lines) {
            DoubleArray row = this.splitLineIntoDouble(line);
            result.getData().add(row);
        }

        return result;
    }

    public String matrixToString(Matrix m) {
        StringBuilder builder = new StringBuilder();
        List<DoubleArray> ldaMatrix = m.getData();

        builder.append('{');
        for (DoubleArray daRow : ldaMatrix) {
            List<Double> row = daRow.getItem();
            builder.append('{');
            for (Double elem : row) {
                builder.append(elem);

                if (elem != row.get(row.size() - 1)) {
                    builder.append(", ");
                }
            }
            builder.append("},<br />");
        }
        builder.append("};");

        return builder.toString();
    }

    public Matrix doubleArrayToMatrix(double[][] array) {
        Matrix result = new Matrix();

        for (int i = 0; i < array.length; i++) {
            DoubleArray row = new DoubleArray();
            
            for(int j = 0; j < array[i].length; j++){
                row.getItem().add(array[i][j]);
            }
            
            result.getData().add(row);
        }

        return result;
    }
}
