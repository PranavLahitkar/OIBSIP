package codsoft;
import java.util.*;

public class number_game_OIBSIP{
	
	
	public number_game_OIBSIP(int ch){
		
		Scanner sc=new Scanner(System.in);
		int score=0;
		Random r=new Random();
		int random_no=r.nextInt(100)+1;//one is added because random function will guess between 1-99 here we can take range of 101 also
		System.out.println(random_no);
		int remainig_ch=ch;//counting remaining chanses
		
		while(true) {
		
			System.out.println("Guess The number between (1-100=)");
			System.out.println("You have "+remainig_ch+" chances");
			int guess=sc.nextInt();
			score++;
			remainig_ch--;
			//equals or not
			if(score==ch) {
			
			System.out.println("Sorry you have reached the max attempts:(\n try again later");
			System.out.println("The number was :\t"+random_no);
			break;
			
			
			}
		
			if(guess==random_no) {
			
				System.out.println("Congratulations your guess is correct....!");
				System.out.println("Your score is:"+score);
				break;
			
			}//greater check
			else if(random_no > guess) {
				System.out.println("The number is greater than your guess");
				
				
			
			}//smaller check
			else if(random_no < guess) {
				System.out.println("The number is smaller than your guess");
			
			}
		
	
		}
		
	}

	public static void main(String[] args) {
		
		number_game_OIBSIP ob=new number_game_OIBSIP(5);//passed the number of chances to constructore
		
	}

}
