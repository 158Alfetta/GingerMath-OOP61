package gingermath_1;

import java.util.*;

public class Game{
	
	private ArrayList<Integer> num1;
	private ArrayList<Integer> num2;
	private Scanner sc = new Scanner(System.in);
	protected static int time = -1;
	protected static boolean to = false; //to = timeout
	private int score;
	private int ans;
	private int guess;
	private int no = 0;
        private Timer cTime;
        
	
	public Game() {
            
	}
	
	public Game(ArrayList<Integer> num1, ArrayList<Integer> num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public int getScore() {
		return score;
	}
        
	public int getTime() {
            return cTime.getTime();
	}
        
	public boolean getTO() {
		return to;
	}
        
        public boolean check(int res){
            guess = res;
            ans = num1.get(no) + num2.get(no);
            if(guess == ans) {
		score++;
		no++;
                return true;
            }else{
                return false;
            }
        }
        
        public int getNum1(){
            if(num1 == null){
                num1 = new ArrayList<>();
                NumberGenerator.genNum(num1);
                return num1.get(no);
            }else{
                return num1.get(no);
            }
        }
        
        public int getNum2(){
            if(num2 == null){
                num2 = new ArrayList<>();
                NumberGenerator.genNum(num2);
                 return num2.get(no);
            }else{
                return num2.get(no);
            }
        }
        
}
