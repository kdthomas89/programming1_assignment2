/*
 * The ComputerAssistedInstruction program generates a random multiplication, subtraction, or addition method consisting of two random numbers between 0 and 10.
 * The user is then asked to input the answer to the question. The program will then output a random response to let the user know if they've guessed correctly
 * or incorrectly. The program asks 10 questions before letting the user know the percentage of questions answered correctly. The program implements the use of 8
 * methods that the main method calls to pose the questions, validate the response, and respond to the user appropriately.
 * 
 * Kyle Thomas, Eclipse 4.7, program last updated 11/3/17 at 11:12pm.
 */
import java.util.Scanner;
public class ComputerAssistedInstruction {

	public static void main(String[] args) {
		
		//declare and initialize variables
		int num1, num2, answer, question;
		double successRate, count = 0, countRight = 0;
		Scanner input = new Scanner (System.in);
		
		//for loop that runs 10 times, generates two random numbers and chooses randomly either the multiplication, addition, or subtraction 
		//question and passes those two random numbers to the chosen method and outputs the question to the user, calling either the correct 
		//answer method or the incorrect answer method based on how the user answers the question.
		for (int i = 0; i < 10; i++) {
			
			//generate two random numbers from 0 to 10 (inclusive)
			num1 = (int)(Math.random() * 11);
			num2 = (int)(Math.random() * 11);
			
			//generate random number from 0-2 that, when chosen, will call one of three methods to pose either a multiplication, addition, or subtraction question
			question = (int)(Math.random() * 3);
			
			//switch statement that will call one of the question methods, depending on the value of the "question" variable
			switch (question) {
			case 0:
				displayMultiplicationQuestion(num1, num2);
				break;
			case 1:
				displayAdditionQuestion(num1, num2);
				break;
			case 2:
				displaySubtractionQuestion(num1, num2);
				break;
			default:
				System.out.println("Error");
				System.exit(0);
			}
			
			//prompt user to input answer
			answer = input.nextInt();
			
			//switch statement with nested if-else statements to check whether the answer is correct and call the appropriate method based on how the user answered
			//also appropriately increments the count and countRight variable which is used to calculate the successRate
			switch (question) {
			case 0:
				if (validateMultiplicationAnswer (num1, num2, answer) == true) {
					System.out.println(getResponseToCorrectAnswer());
					count++;
					countRight++;
				}
				else {
					System.out.println(getResponseToIncorrectAnswer());
					count++;
				}
				break;
			case 1:
				if (validateAdditionAnswer (num1, num2, answer) == true) {
					System.out.println(getResponseToCorrectAnswer());
					count++;
					countRight++;
				}
				else {
					System.out.println(getResponseToIncorrectAnswer());
					count++;
				}
				break;
			case 2:
				if (validateSubtractionAnswer (num1, num2, answer) == true) {
					System.out.println(getResponseToCorrectAnswer());
					count++;
					countRight++;
				}
				else {
					System.out.println(getResponseToIncorrectAnswer());
					count++;
				}
				break;
			default:
				System.out.println("Error");
				System.exit(0);
			}
			
		}
		
		//calculate percentage of correct answers
		successRate = (countRight / count) * 100;
		
		//output percentage of correct answers to user
		System.out.println("One attempt success rate is " + (int)successRate + "%");
		
		//two way if statement that will print a response based on whether the user answered 70 percent or more correctly
		if (successRate >= 70) {
			System.out.println("Congratulations. You are ready to go to the next level!");
		}
		else if (successRate < 70) {
			System.out.println("Please ask your teacher for extra help.");
		}

	}
	
	//method that poses a multiplication question to user when called
	public static void displayMultiplicationQuestion(int num1, int num2) {
		
		System.out.println("What is the result of " + num1 + " x " + num2 + "?");
		
	}
	
	//method that poses a addition question to user when called
	public static void displayAdditionQuestion(int num1, int num2) {
		
		System.out.println("What is the result of " + num1 + " + " + num2 + "?");
		
	}
	
	//method that poses a subtraction question to user when called
	public static void displaySubtractionQuestion(int num1, int num2) {
		
		System.out.println("What is the result of " + num1 + " - " + num2 + "?");
		
	}
	
	//method that, when called, implements a switch statement to returns a random output to the user to let them know they answered correctly
	//based on a random number between 0 and 3
	public static String getResponseToCorrectAnswer() {
		int choice = (int)(Math.random() * 4);
		String response = "Response";
		
		switch (choice) {
		
			case 0:
				response = "Very good!";
				break;
			case 1:
				response = "Excellent!";
				break;
			case 2:
				response = "Nice work!";
				break;
			case 3:
				response = "Keep up the good work!";
				break;
		}
		
		return response;
	}
	
	//method that, when called, implements a switch statement to returns a random output to the user to let them know they answered incorrectly
	//based on a random number between 0 and 3
	public static String getResponseToIncorrectAnswer() {
		int choice = (int)(Math.random() * 4);
		String response = "Response";
		
		switch (choice) {
		
			case 0: 
				response = "No. Please try again.";
				break;
			case 1:
				response = "Wrong. Try once more.";
				break;
			case 2:
				response = "Don't give up. Keep trying.";
				break;
			case 3:
				response = "Incorrect. Please answer again";
				break;
		}
		
		return response;
		
	}
	
	//boolean method that, when called, checks to see whether the user has input the correct answer to a multiplication question
	public static boolean validateMultiplicationAnswer(int num1, int num2, int answer) {
		if (num1 * num2 == answer) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//boolean method that, when called, checks to see whether the user has input the correct answer to an addition question
	public static boolean validateAdditionAnswer (int num1, int num2, int answer) {
		if (num1 + num2 == answer) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//boolean method that, when called, checks to see whether the user has input the correct answer to a multiplication question
	public static boolean validateSubtractionAnswer (int num1, int num2, int answer) {
		if (num1 - num2 == answer) {
			return true;
		}
		else {
			return false;
		}
	}

}
