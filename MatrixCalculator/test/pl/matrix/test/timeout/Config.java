/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.matrix.test.timeout;

import java.util.Random;

/**
 *
 * @author Mateusz
 */
public class Config {
    
    static final int TIMEOUT = 3000;
    
    static final int size1 = 1024;
    static final int size2 = 2048;
    static final int size3 = 4096;
    static final int size4 = 8192;
    
    
    static double[][] data_1 = new double[Config.size1][Config.size1];
    static double[][] data_2 = new double[Config.size2][Config.size2];
    static double[][] data_3 = new double[Config.size3][Config.size3];
    static double[][] data_4 = new double[Config.size4][Config.size4];
    
    public static void beforeClass() {
        Random rand = new Random();
        
        //size 1
        for(int i=0; i<Config.size1; i++){
            for(int j = 0; j<Config.size1; j++){
                data_1[i][j] = rand.nextDouble();
                data_2[i][j] = rand.nextDouble();
                data_3[i][j] = rand.nextDouble();
                data_4[i][j] = rand.nextDouble();
            }
        }
        //size 2
        for(int i=Config.size1; i<Config.size2; i++){
            for(int j = Config.size1; j<Config.size2; j++){
                data_2[i][j] = rand.nextDouble();
                data_3[i][j] = rand.nextDouble();
                data_4[i][j] = rand.nextDouble();
            }
        }
        //size 3
        for(int i=Config.size2; i<Config.size3; i++){
            for(int j = Config.size2; j<Config.size3; j++){
                data_3[i][j] = rand.nextDouble();
                data_4[i][j] = rand.nextDouble();
            }
        }
        //size 4
        for(int i=Config.size3; i<Config.size4; i++){
            for(int j = Config.size3; j<Config.size4; j++){
                data_4[i][j] = rand.nextDouble();
            }
        }
    }
}
