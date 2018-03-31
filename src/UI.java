import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class UI {
	public UI() throws InterruptedException, IOException {
		aGradeSystem = new GradeSystems();
		sc = new Scanner(System.in);
		while(true) {
			if(curUser == 0) promptID();
			else {
				if(checkID(curUser) == true) {
					this.showWelcomeMsg();
					this.promptCommand();
				}
			}
			if(this.fin == true) break;
		}
	}
	
	public boolean checkID(int ID) {
		if(this.aGradeSystem.containsID(ID))
			return true;
		System.out.println("This ID is not in the list, please try again!");
		this.curUser = 0;
		return false;
	}
	
	public void promptCommand() {
		this.printCommand();
		if(command.equals("G") || command.equals("g")) this.aGradeSystem.showGrade(curUser);
		else if(command.equals("R") || command.equals("r"))	this.aGradeSystem.showRank(curUser);
		else if(command.equals("A") || command.equals("a")) this.aGradeSystem.showAverage();
		else if(command.equals("W") || command.equals("w")) this.aGradeSystem.getNewWeights();
		else if(command.equals("E") || command.equals("e")) this.showFinishMsg();
		else System.out.println("Wrong Command!");
	}
	
	public void printCommand() {
		System.out.println(" Type in command");
		System.out.println(" 	1)G Show Grade");
		System.out.println("	2)R Show Rank");
		System.out.println(" 	3)A Show Average");
		System.out.println("	4)W Renew Grade Weight");
		System.out.println("	5)E Exit");
		this.command = sc.nextLine();
	}
	
	public void promptID() throws InterruptedException {
		System.out.println("Please enter your student ID to start or enter Q to quit : ");
		command = sc.nextLine();
		if(command.equals("Q") || command.equals("q")) {
			this.fin = true;
			System.out.println("Leaving System...");
			TimeUnit.SECONDS.sleep(2);
		}
		else
			this.curUser = Integer.parseInt(command);
	}
	
	public void showFinishMsg() {
		System.out.println("Bye bye, "+this.aGradeSystem.getName(curUser));
		this.curUser = 0;
	}
	
	public void showWelcomeMsg() {
		System.out.println("Welcome to grade system, "+this.aGradeSystem.getName(curUser));
	}
	
	GradeSystems aGradeSystem;
	Scanner sc;
	public int curUser = 0;
	public String command;
	public boolean fin = false; 
}
