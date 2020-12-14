/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hintinggame;

import java.util.Random;

/**
 *
 * @author pc
 */
public class Qlearning {
    
    public float[][] Qtable = new float[65][4];
    
    Qlearning() {
        initializeQtable();
    }
    
    private boolean initializeQtable() {
        for(float[] k : Qtable) {
            for(float l : k) {
                l = 0;
            }
        }
        return true;
    }
    
    public boolean Update(int st1, int st2, int a, float rwrd, float alpha, float gamma) {
        float maxQv = getMaxQv(st2);
        float qV = alpha*(rwrd+(gamma*maxQv)) + (1-alpha)*Qtable[st1][a];
        Qtable[st1][a] = qV;
        return true;
    }
    
    public int getMaxActionRwrd(int st) {
        int qMaxCount = 1;
        int[] qMaxIndex = new int[4];
        float qMax = Qtable[st][0];
        qMaxIndex[0] = 0;
        for(int k = 1; k <= 3; k++) {
            if(Qtable[st][k] > qMax) {
                qMax = Qtable[st][k];
                qMaxCount = 1;
                qMaxIndex[0] = k;
            } else if(Qtable[st][k] == qMax) {
                qMaxCount++;
                qMaxIndex[qMaxCount-1] = k;
            }
        }
        if(qMaxCount == 1) {
            return qMaxIndex[0];
        } else {
            Random rand = new Random();
            int rd = rand.nextInt(qMaxCount);
            return qMaxIndex[rd];
        }
    }
    
    private float getMaxQv(int st) {
        float qMax = Qtable[st][0];
        for(int k = 1; k <= 3; k++) {
            if(Qtable[st][k] > qMax) {
                qMax = Qtable[st][k];
            }
        }
        return qMax;
    }
    
}
