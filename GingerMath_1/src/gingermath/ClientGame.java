package gingermath;

import java.util.ArrayList;
public class ClientGame extends GameGUI implements Runnable{

    private ArrayList<Integer> num1; // First pack of number
    private ArrayList<Integer> num2; // Second pack of number
    protected static int time = -1;
    protected static boolean to = false; //to = timeout
    protected int score; 
    private int ans; // correctly answer
    private int guess; // number that player has input;
    private int no = 0; // index in pack of number (use both)
    
    public ClientGame() {
        
    }
    
    public ClientGame(ArrayList<Integer> num1, ArrayList<Integer> num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    
    public int getScore() {
        return score;
    }
    
    public int getTime() {
        return time;
    }
    
    public boolean check(int answer){
        int ans = num1.get(no)+num2.get(no);
        if(answer == ans){
            no++;
            score++;
            problemLabel.setText(num1.get(no)+" + "+num2.get(no));
            return true;
        }else{
            return false;
        }
    }
    
    public void run() {
      if((num1 == null && num2 == null) || (num1.size() == 0 && num2.size() == 0)) {
          num1 = new ArrayList<>();
          num2 = new ArrayList<>();
          NumberGenerator.genNum(num1);
          NumberGenerator.genNum(num2);
      }
      
      problemLabel.setText(num1.get(no)+" + "+num2.get(no));
      
      new Thread(new Timer()).start();
        
    }
    
    
    
}