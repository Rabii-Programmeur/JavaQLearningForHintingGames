/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hintinggame;

/**
 *
 * @author pc
 */
public class Environnement {
    
    private int mazeWidth, mazeLength, initXPos, initYPos, xTrgt, yTrgt;
    private float smReward, cReward, pReward;
    private int[][] verticalObs, horizontalObs;
    public int[][] states, cordOfStates;
    public int stCount = 0;
    
    public int actualState;
  
    Environnement(int mWidth, int mLength, int initX, int initY, int trgtX, int trgtY, int[][] vObs, int[][] hObs, float smR, float cR, float pR) {
        
        mazeWidth = mWidth;
        mazeLength = mLength;
        initXPos = initX;
        initYPos = initY;
        xTrgt = trgtX;
        yTrgt = trgtY;
        verticalObs = vObs;
        horizontalObs = hObs;
        smReward = smR;
        cReward = cR;
        pReward = pR;
        
        states = new int[9][9];
        cordOfStates = new int[65][3];
        
        generateStates();
        
        actualState = states[initX][initY];
    }
    
    private boolean generateStates() {
        
        for(int j = 1; j <= mazeLength; j++) {
            for(int i = 1; i <= mazeWidth; i++) {
                stCount++;
                states[i][j] = stCount;
                cordOfStates[stCount][1] = i;
                cordOfStates[stCount][2] = j;
            }
        }
        
        return true;
    }
    
    public float moveRobot(int dir) {
        
        int xActSt = cordOfStates[actualState][1];
        int yActSt = cordOfStates[actualState][2];
        
        switch (dir) {
            case 0:
                if(xActSt < mazeWidth) {
                    if(verticalObs[xActSt][yActSt] == 0) {
                        xActSt++;
                        actualState = states[xActSt][yActSt];
                        if(xTrgt == xActSt && yTrgt == yActSt) {
                            return cReward;
                        } else {
                            return smReward;
                        }
                    }
                }
                break;
            case 1:
                if(xActSt > 1) {
                    if(verticalObs[xActSt-1][yActSt] == 0) {
                        xActSt--;
                        actualState = states[xActSt][yActSt];
                        if(xTrgt == xActSt && yTrgt == yActSt) {
                            return cReward;
                        } else {
                            return smReward;
                        }
                    }
                }
                break;
            case 2:
                if(yActSt > 1) {
                    if(horizontalObs[xActSt][yActSt-1] == 0) {
                        yActSt--;
                        actualState = states[xActSt][yActSt];
                        if(xTrgt == xActSt && yTrgt == yActSt) {
                            return cReward;
                        } else {
                            return smReward;
                        }
                    }
                }
                break;
            case 3:
                if(yActSt < mazeLength) {
                    if(horizontalObs[xActSt][yActSt] == 0) {
                        yActSt++;
                        actualState = states[xActSt][yActSt];
                        if(xTrgt == xActSt && yTrgt == yActSt) {
                            return cReward;
                        } else {
                            return smReward;
                        }
                    }
                }
                break;
            default:
                break;
        }
        
        return pReward;
    }
    
}
