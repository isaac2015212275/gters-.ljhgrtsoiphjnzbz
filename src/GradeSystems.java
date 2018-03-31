import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;
import java.io.FileInputStream;

public class GradeSystems {
	public GradeSystems ( ) throws IOException {
		this.aList = new LinkedList<Grades>();
		this.readFile("./src/gradeinput.txt");
		for(int i=0; i<this.aList.size(); i++) {
			this.aList.get(i).calculateTotalGrade(this.weights);
		}
	}
	
	public void readFile(String fileName) throws IOException{
		this.file = new FileInputStream(fileName);
		this.buff = new BufferedReader(new InputStreamReader(file, "UTF-8"));
		char c = (char) buff.read();
		while ( (temp1 = buff.readLine()) != null) {
			this.temp2 = this.temp1.trim().split("\\s");
			this.aGrade = new Grades(Integer.valueOf(temp2[0]), temp2[1], Integer.valueOf(temp2[2]), Integer.valueOf(temp2[3]), Integer.valueOf(temp2[4]), Integer.valueOf(temp2[5]), Integer.valueOf(temp2[6]));
			this.aList.add(aGrade);
		}
	}
	
	public void showGrade (int ID) {
		for(int i=0; i<this.aList.size(); i++) {
			if (this.aList.get(i).ID == ID)
			{
				System.out.println("Student with ID "+ID+" has Lab1 grade "+this.aList.get(i).lab1);
				System.out.println("Student with ID "+ID+" has Lab2 grade "+this.aList.get(i).lab2);
				System.out.println("Student with ID "+ID+" has Lab3 grade "+this.aList.get(i).lab3);
				System.out.println("Student with ID "+ID+" Midterm grade "+this.aList.get(i).midTerm);
				System.out.println("Student with ID "+ID+" Final Exam grade "+this.aList.get(i).finalExam);
				System.out.println("Student with ID "+ID+" has totalgrade "+this.aList.get(i).totalGrade);
			}
		}
	}
	
	public void showRank (int ID) {
		int rank = 1;
		for(int i=0; i<this.aList.size(); i++) 
			if (this.aList.get(i).ID == ID)
				this.tempGrade = this.aList.get(i).totalGrade;
		for(int i=0; i<this.aList.size(); i++) 
			if (this.aList.get(i).totalGrade > this.tempGrade)
				rank = rank+1;
		System.out.println("Student with ID "+ID+" has rank "+rank);
	}
	
	public void updateWeights() {
		for(int i=0; i<this.aList.size(); i++) {
			this.aList.get(i).calculateTotalGrade(this.weights);
		}
	}
	
	public boolean containsID(int ID) {
		for(int i=0; i<this.aList.size(); i++) 
			if (this.aList.get(i).ID == ID)
				return true;
		return false;
	}
	
	public String getName(int ID) {
		for(int i=0; i<this.aList.size(); i++) 
			if (this.aList.get(i).ID == ID)
				return this.aList.get(i).name;
		return null;
	}
	
	public void showOldWeights() {
		System.out.println("Lab1 "+(int)(this.weights[0]*100)+"%");
		System.out.println("Lab2 "+(int)(this.weights[1]*100)+"%");
		System.out.println("Lab3 "+(int)(this.weights[2]*100)+"%");
		System.out.println("Midterm "+(int)(this.weights[3]*100)+"%");
		System.out.println("Final Exam "+(int)(this.weights[4]*100)+"%");
	}
	
	public void getNewWeights() {
		Scanner sc = new Scanner(System.in);
		this.showOldWeights();
		this.enterWeight();
		System.out.println("This is new weight you just typ in, please check :");
		this.showOldWeights();
		this.updateWeights();
		sc.close();
	}
	
	public void enterWeight() {
		Scanner sc = new Scanner(System.in);
		String[] str = {"Lab1", "Lab2", "Lab3", "midTerm", "finalExam"};
		for(int i = 0; i<5; i++) {
			System.out.println("Please type in new weight of "+ str[i] +" :");
			this.weights[i] = (float)(sc.nextInt())/100;
		}
		sc.close();
	}
	
	public void showAverage() {
		int total = 0;
		float average;
		for(int i=0; i<this.aList.size(); i++) {
			total = total+aList.get(i).totalGrade;
		}
		average = total / this.aList.size();
		System.out.println("Average grade is : "+(int)(average+0.5));
	}
	
	public float[] weights = {0.1f, 0.1f, 0.1f, 0.3f, 0.4f};
	public LinkedList<Grades> aList;
	public Grades aGrade;
	public String temp1;
	public String[] temp2;
	public FileInputStream file;
	public BufferedReader buff;
	int tempGrade;
}
