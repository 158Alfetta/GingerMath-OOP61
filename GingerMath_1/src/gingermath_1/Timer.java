/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gingermath_1;

import javax.swing.JLabel;

/**
 *
 * @author Corvette
 */
public class Timer extends JLabel implements Runnable{
    
    private int time = -1;
    
    public int getTime(){
        return time;
    }

    @Override
    public void run() {
        for(int t=60; t>=0; t--) {
            try {
                time = t;
                setText(t + "  ");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
    }
}
}
