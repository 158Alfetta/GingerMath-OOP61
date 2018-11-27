/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gingermath;

import javax.swing.JLabel;

/**
 *
 * @author Corvette
 */
public class Timer extends ClientGame implements Runnable{
    
    public void run() {
        for(int t=3; t>=0; t--) {
            try {
                time = t;
                timeLabel.setText(t + "   ");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
//        TimeOutDialog tod = new TimeOutDialog(this, (int)getSize().getWidth(), (int)getSize().getHeight());
}

}
