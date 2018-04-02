import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class UI {
	/**
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * Pseudo code
	 * 1.while�j��
	 * 	�Y�|�����ϥΪ̡ApromtID()
	 * 	�Y�w�� �T�{�ϥΪ̬O�_�s�b�A�M������w��T����promptCommand
	 * 
	 * Time estimate: O(1)
	 */
	public UI() throws InterruptedException, IOException {
		aGradeSystem = new GradeSystems();
		while(true) {
			if(curUser == 0) promptID();
			else {
				if(checkID(curUser) == true) {
					this.showWelcomeMsg();
					this.promptCommand();
					this.command = "";
				}
			}
			if(this.fin == true) break;
		}
	}
	/**
	 * method checkID
	 * @param ID
	 * @return
	 * Pseudo code
	 * 1.�M��ID�O�_�s�b��Ƥ�
	 * 2.�]�wcurUser
	 * 
	 * Time estimate: O(1)
	 */
	private boolean checkID(int ID) {
		if(this.aGradeSystem.containsID(ID))
			return true;
		System.out.println("This ID is not in the list, please try again!");
		this.curUser = 0;
		return false;
	}
	/**
	 * method promptCommand
	 * Pseudo code
	 * 1.�L�X�ﶵ
	 * 2.Ū�J��H�çP�_
	 * 
	 * Time estimate: O(1)
	 */
	private void promptCommand() {
		this.printCommand();
		if(command.equals("G") || command.equals("g")) this.aGradeSystem.showGrade(curUser);
		else if(command.equals("R") || command.equals("r"))	this.aGradeSystem.showRank(curUser);
		else if(command.equals("A") || command.equals("a")) this.aGradeSystem.showAverage();
		else if(command.equals("W") || command.equals("w")) this.aGradeSystem.getNewWeights();
		else if(command.equals("E") || command.equals("e")) this.showFinishMsg();
		else System.out.println("Wrong Command!");
	}
	/**
	 * method printCommand
	 * Pseudo code
	 * 1.�L�X�ﶵ
	 * 2.Ū�����O
	 * 
	 * Time estimate: O(1)
	 */
	private void printCommand() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println(" Type in command");
			System.out.println(" 	1)G Show Grade");
			System.out.println("	2)R Show Rank");
			System.out.println(" 	3)A Show Average");
			System.out.println("	4)W Renew Grade Weight");
			System.out.println("	5)E Exit");
			this.command = sc.nextLine();
		}
		catch (NoSuchElementException e) {}
	}
	/**
	 * method promptID
	 * @throws InterruptedException
	 * Pseudo code
	 * 1.��ܰT��
	 * 2.�P�_��J�O�_��"Q"
	 * 	�Y��Q�h�����t��
	 * 	�_�h�N��J�s�icurUser
	 * 
	 * Time estimate: O(1)
	 */
	private void promptID() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your student ID to start or enter Q to quit : ");
		command = sc.nextLine();
		try {
			if(command.equals("Q") || command.equals("q")) {
				this.fin = true;
				System.out.println("Leaving System...");
				TimeUnit.SECONDS.sleep(2);
			}
			else
				this.curUser = Integer.parseInt(command);
		}
		catch (NumberFormatException e){
			System.out.println("Illegal input, please try again!");
		}
	}
	/**
	 * method showFinishMsg
	 * Pseudo code
	 * 1.��ܰT��
	 * 2.�M��curUser
	 * 
	 * Time estimate:O(1)
	 */
	private void showFinishMsg() {
		System.out.println("Bye bye, "+this.aGradeSystem.getName(curUser));
		this.curUser = 0;
	}
	/**
	 * method showWelcomeMsg
	 * Pseudo code
	 * 1.��ܰT��
	 * 
	 * Time estimate:O(1)
	 */
	private void showWelcomeMsg() {
		System.out.println("Welcome to grade system, "+this.aGradeSystem.getName(curUser));
	}

	GradeSystems aGradeSystem;
	
	public int curUser = 0;
	public String command;
	public boolean fin = false; 
}
