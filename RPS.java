package schoolwork;

import java.util.Scanner;
import java.util.Random;

public class RPS {

	public enum Attack {
		ROCK,
		PAPER,
		SCISSORS
	}

	public static Attack pick = null, compPick = null;
	public static int win = 0, lose = 0, draw = 0;
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		
		String input, yesnoInput;
		boolean keepPlaying = false, rpsBool = true;
		
		try {

		System.out.println("Would you like to play Rock, Paper, Scissors?");
		yesnoInput = sc.nextLine();
		
		if(yesnoInput.equalsIgnoreCase("yes"))
			keepPlaying = true;
		else if (yesnoInput.equalsIgnoreCase("no"))
			keepPlaying = false;
		
		} catch (IllegalArgumentException e) {
			System.out.println("Couldn't read input!");
		}
		
		while (keepPlaying == true) {
			rpsBool = true;

			while (rpsBool == true) {	
			System.out.println("Rock, Paper, or Scissors?");
			input = sc.next();		
		
				switch (input) {
				case "rock":
				case "ROCK":
				case "Rock":
					pick = Attack.ROCK;	
					rpsBool = false;
					break;
				case "Scissors":
				case "scissors":
				case "SCISSORS":
					pick = Attack.SCISSORS;
					rpsBool = false;
					break;
				case "PAPER":
				case "paper":
				case "Paper":
					pick = Attack.PAPER;
					rpsBool = false;
					break;
			
				default:
					System.out.println("oops, couldn't read your choice! try again!");
					break;
				}}
		
		
			compPick = randomAttack();
			
			RPSTest();
		
			System.out.println("Would you like to play again? \n You have won " + win + " games, the computer has won " + lose + " games, and you have drawn " + draw + " games.");	
			yesnoInput = sc.next();
			if(yesnoInput.equalsIgnoreCase("yes")) {
				keepPlaying = true;
			}else if (yesnoInput.equalsIgnoreCase("no")) 
				break;
		
		}	
		System.out.println("Thanks for playing!");
		}
		
		
		
		
	





private static Attack randomAttack() {
    int pick = new Random().nextInt(Attack.values().length);
    return Attack.values()[pick];
}

public static void RPSTest() {
	if ((compPick == Attack.SCISSORS && pick == Attack.SCISSORS) || 
			(compPick == Attack.ROCK && pick == Attack.ROCK) ||
			(compPick == Attack.PAPER && pick == Attack.PAPER)) {
			System.out.println("Draw! \nYou Picked: " + pick + "\nComputer Picked: " + compPick);
			draw++;
		}
	if ((compPick == Attack.SCISSORS && pick == Attack.ROCK) || 
			(compPick == Attack.ROCK && pick == Attack.PAPER) ||
			(compPick == Attack.PAPER && pick == Attack.SCISSORS)) {
			System.out.println("You Win! \nYou Picked: " + pick + "\nComputer Picked: " + compPick);
			win++;
		}
	if ((compPick == Attack.SCISSORS && pick == Attack.PAPER) || 
			(compPick == Attack.ROCK && pick == Attack.SCISSORS) ||
			(compPick == Attack.PAPER && pick == Attack.ROCK)) {
			System.out.println("You Lose! \nYou Picked: " + pick + "\nComputer Picked: " + compPick);
			lose++;
	}
}

}
