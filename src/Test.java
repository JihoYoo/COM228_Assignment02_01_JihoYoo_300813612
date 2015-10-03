/* 
 * Name : JihoYoo StudentNumber: 300813612
 */
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Test {

	Scanner scanner = new Scanner(System.in);
	//Random +++++++++++++++++++++++++++++++++++++++++++++++++++++++
	Random rnd = new Random();
	
	//private variable +++++++++++++++++++++++++++++++++++++++++++++++++
	private int total = 0;
	
	//HashMap Method +++++++++++++++++++++++++++++++++++++++++++++++++
	HashMap<Integer,String> askMap = new HashMap<Integer,String>();
	
	HashMap<Integer,Integer> ansMap = new HashMap<Integer,Integer>();
	

	//create a method to simulate the questions – simulateQuestion
	public void simulateQuestion(int interger)
	{
		System.out.println(askMap.get(interger));
		askMap.remove(interger);
	}

	//create a method to check the answer – checkAnswer
	public void checkAnswer(int interger, String answer)
	{
		if(answer.equals(ansMap.get(interger).toString()))
		{
			simulateMessage(true,interger);
			total++;
			
		}else
		{
			simulateMessage(false,interger);
		}
	}
	//create a method to display a random message for the user – simulateMessage
	public void simulateMessage(boolean rightAns, int interger)
	{
		if(rightAns)
		{
			switch ( rnd.nextInt(4))
			{
			case 0:
				System.out.println("Excellent!");
				break;
			case 1:
				System.out.println("Good!");
				break;
			case 2:
				System.out.println("Keep up the good work!");
				break;
			case 3:
				System.out.println("Nice work!");
				break;			
			}
		}else
		{
			switch ( rnd.nextInt(4))
			{
			case 0:
				System.out.println("No. Please try again, answer is " + ansMap.get(interger));
				break;
			case 1:
				System.out.println("Wrong. Try once more, answer is " + ansMap.get(interger));
				break;
			case 2:
				System.out.println("Don't give up!, answer is " + ansMap.get(interger));
				break;
			case 3:
				System.out.println("No. Keep trying..., answer is " + ansMap.get(interger));
				break;			
			}
		}
		
			
	}
	//create a method to interact with the user - inputAnswer
		public void inputAnswer(int questionNumber, String answer)
		{
			checkAnswer(questionNumber, answer);
		}
		
		
	public Test()
	{
		askMap.put(1, "What is exaple of providing the tools for managing open source projects?\n" + "1.Eclipse 2.Githup 3.Window 4.Mozilla");
		ansMap.put(1, 2);
		askMap.put(2, "What is used to develop large-scale enterprise application?\n" + "1.Java 2.C++ 3.C# 4.Oracle");
		ansMap.put(2, 1);
		askMap.put(3, "Which Text Editors does OSX provide?\n" + "1.vi 2.emacs 3.Notepad 4.TextEdit");
		ansMap.put(3, 4);
		askMap.put(4, "What is called an 'escape character'?\n" + "1.slash 2.comma 3.backslash 4.colon");
		ansMap.put(4, 3);
		askMap.put(5, "What is Operator called?\n" + "1.assignment operator 2.Arithmetic 3.binary operator  4.Variables");
		ansMap.put(5, 3);
		
	}
	// To show up transcription in Test Driver
	public void testResult()
	{
		Test test = new Test();
		int firstQuestion = 1;
		int lastQuestion = 6;
		
		//while loop for 5 questions+++++++++++++++++++++++++++++
		while(firstQuestion < lastQuestion)
		{
			System.out.println("");
			System.out.printf("%d. ",firstQuestion);
			test.simulateQuestion(firstQuestion);
			System.out.println("-----------------------------------------------");
			System.out.printf("Answer: ");
			test.inputAnswer(firstQuestion,scanner.nextLine());
			firstQuestion++;
		}
		//At the end of the test display the number of correct and incorrect answers, and the percentage of the correct answers.
		System.out.println("");
		System.out.println("       ----------TRANSCRIPTION----------       ");
		System.out.printf("You got '%d' correct answer and '%d' incorrect answer !\n", test.total, 5 - test.total);
		System.out.println("The percentage of correct answers is "+ (((double)test.total / 5) * 100 + "% !"));
	}

	
}
