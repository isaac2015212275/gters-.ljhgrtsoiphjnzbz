import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;
import java.util.stream.IntStream;
import java.io.FileInputStream;

public class GradeSystems {
	/**
	 * 建構子
	 * @throws IOException
	 * Pseudo code
	 * 1.readFile()
	 * 2.loop
	 * 	calculateTotalgrade
	 * 
	 * Time estimate: O(n)
	 */
	public GradeSystems ( ) throws IOException {
		this.aList = new LinkedList<Grades>();
		this.readFile("./src/gradeinput.txt");
		for(int i=0; i<this.aList.size(); i++) {
			this.aList.get(i).calculateTotalGrade(this.weights);
		}
	}
	/**
	 * method readFile
	 * @param fileName
	 * @throws IOException
	 * Pseudo code
	 * 1.while not EOF
	 * 	readline
	 * 	分割input
	 * 	建立Grades並加到aList
	 * 
	 * Time estimate: O(n)
	 */
	private void readFile(String fileName) throws IOException{
		this.file = new FileInputStream(fileName);
		this.buff = new BufferedReader(new InputStreamReader(file, "UTF-8"));
		char c = (char) buff.read();
		while ( (temp1 = buff.readLine()) != null) {
			this.temp2 = this.temp1.trim().split("\\s");
			this.aGrade = new Grades(Integer.valueOf(temp2[0]), temp2[1], Integer.valueOf(temp2[2]), Integer.valueOf(temp2[3]), Integer.valueOf(temp2[4]), Integer.valueOf(temp2[5]), Integer.valueOf(temp2[6]));
			this.aList.add(aGrade);
		}
	}
	/**
	 * Method showGrade
	 * @param ID
	 * Pseudo code
	 * print grades
	 * 
	 * Time estimate: O(1)
	 */
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
	/**
	 * method showRank
	 * @param ID
	 * Pseudo code
	 * 1.rank = 1
	 * 2.find the total grade of the ID
	 * 3.loop aList
	 * 	if aList[i].totalGrade > ID.totalGrade: rank+1
	 * 
	 * Time estimate: O(n)
	 */
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
	/**
	 * method updateWeights
	 * Pseudo code
	 * 1.loop aList
	 * 	calculateTotalGrade
	 * 
	 * Time estimate:O(n)
	 */
	private void updateWeights(int[] newWeight) {
		for(int i=0; i<5; i++) {
			this.weights[i] = (float)(newWeight[i])/100;
		}
		for(int i=0; i<this.aList.size(); i++) {
			this.aList.get(i).calculateTotalGrade(this.weights);
		}
	}
	/**
	 * 
	 * @param ID
	 * @return boolean
	 * Pseudo code
	 * 1.find if ID is in aList
	 * 
	 * Time estimate: O(n)
	 * Example: UI物件.checkID(962001044) ; 傳回結果為 true
	 */
	public boolean containsID(int ID) {
		for(int i=0; i<this.aList.size(); i++) 
			if (this.aList.get(i).ID == ID)
				return true;
		return false;
	}
	/**
	 * method getName
	 * @param ID
	 * @return name
	 * Pseudo code
	 * 1.find if ID is in aList
	 * 2.if so, return ID's name
	 * 3.else return null
	 * 
	 * Time estimate: O(n)
	 * Example: UI物件.getName(955002056) ; 傳回結果為"許文馨"
	 */
	public String getName(int ID) {
		for(int i=0; i<this.aList.size(); i++) 
			if (this.aList.get(i).ID == ID)
				return this.aList.get(i).name;
		return null;
	}
	/**
	 * method showOldWeights
	 * Pseudo code
	 * 1.print weight
	 * 
	 * Time estimate: O(1)
	 */
	private void showOldWeights() {
		System.out.println("Lab1 "+(int)(this.weights[0]*100)+"%");
		System.out.println("Lab2 "+(int)(this.weights[1]*100)+"%");
		System.out.println("Lab3 "+(int)(this.weights[2]*100)+"%");
		System.out.println("Midterm "+(int)(this.weights[3]*100)+"%");
		System.out.println("Final Exam "+(int)(this.weights[4]*100)+"%");
	}
	/**
	 * method getNewWeights()
	 * Pseudo code
	 * 1.show original weight
	 * 2.get new weight
	 * 3.show new weights
	 * 4.calculate new total grade
	 * 
	 * Time estimate: O(n)
	 */
	public void getNewWeights() {
		this.showOldWeights();
		int[] newWeight =  this.enterWeight();
		if(IntStream.of(newWeight).sum() == 100) {
			System.out.println("This is new weight you just typ in, please check :");
			this.updateWeights(newWeight);
			this.showOldWeights();
		}else {
			System.out.println("Sum of the weight does not equal to 100!");
		}
	}
	/**
	 * method enterWeight
	 * Pseudo code
	 * 1.迴圈要求輸入
	 * 	1.印出要求訊息
	 * 	2.讀取輸入值
	 * 
	 * Time estimate: O(1)
	 */
	private int[] enterWeight() {
		int[] newWeight = new int[5];
		Scanner sc = new Scanner(System.in);
		String[] str = {"Lab1", "Lab2", "Lab3", "midTerm", "finalExam"};
		for(int i = 0; i<5; i++) {
			System.out.println("Please type in new weight of "+ str[i] +" :");
			newWeight[i] = Integer.parseInt(sc.nextLine());
		}
		return newWeight;
	}
	/**
	 * method showAverage
	 * Pseudo code
	 * 1.迴圈加總totaslGrade
	 * 2.計算平均
	 * 
	 * Time estimate: O(n)
	 */
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
