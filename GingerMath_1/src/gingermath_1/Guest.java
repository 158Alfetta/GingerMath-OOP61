package gingermath_1;
import java.io.*;
import java.net.*;
import java.util.*;

public class Guest {

	private static Socket s;
	private static BufferedReader in;
	private static PrintWriter out;
	private static ObjectInputStream objIn;
	private static ObjectOutputStream objOut;
	private static int player;
	private static Scanner sc;
	private static ArrayList<Integer> num1 = new ArrayList<>();
	private static ArrayList<Integer> num2 = new ArrayList<>();
	private static int timer;
	private static Object obj;
	private static boolean ready = false;
	private static boolean start = false;
	private static String data;
	private static Game gg;
	private static String leaderboard;
	private static int score = 0;
	
	public ArrayList<Integer> getNumber1(){
		return num1;
	}
	
	public ArrayList<Integer> getNumber2(){
		return num2;
	}
	
	public static void main(String[] args) {
		try {
			s = new Socket("104.248.154.68", 8910);
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintWriter(s.getOutputStream(), true);
			
			System.out.println("Guest running..");
			
			out.println("");
			out.println("Guest-01");
			
			out.println("join");
			
			while(true) {
				data = in.readLine();
				if(data.equals("obj")) {
					for(int i = 1; i <= 40; i++) {
						int num = Integer.parseInt(in.readLine());
						num1.add(num);
					}
					for(int i = 1; i <= 40; i++) {
						int num = Integer.parseInt(in.readLine());
						num2.add(num);
					}					
				}
				else if(data.equals("start")) {
					gg = new Game();
					break;
				}
			}
			
			int tmp = 0;
			out.println("score");
			out.println(score);
			while(true) {
				score = gg.getScore();
				if(score != tmp || score == 0) {
					out.println("score");
					out.println(gg.getScore());
					tmp = score;
				}
				data = in.readLine();
				if(data.equals("timeout")) {
					System.out.println("time");
					System.out.println(leaderboard);
					break;
				}else {
					leaderboard = data;
				}
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
