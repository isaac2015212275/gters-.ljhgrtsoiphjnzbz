import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

public class GradeSystems {
	public GradeSystems ( ) throws IOException {
		this.aList = new LinkedList<Grades>();
		this.readFile("./src/gradeinput.txt");

		for(int i=0; i<this.aList.size(); i++) {
			this.aList.get(i).calculateTotalGrade(this.weights);
			System.out.println(this.aList.get(i).totalGrade+" ");
		}
	}
	
	public void readFile(String fileName) throws IOException{
		this.file = new FileInputStream(fileName);
		this.buff = new BufferedReader(new InputStreamReader(file, "UTF-8"));
		char c = (char) buff.read();
		while ( (temp1 = buff.readLine()) != null) {
			this.temp2 = this.temp1.trim().split("\\s");
			this.aGrade = new Grades(Integer.valueOf(temp2[0]), temp2[1], Integer.valueOf(temp2[2]), Integer.valueOf(temp2[3]), Integer.valueOf(temp2[4]), Integer.valueOf(temp2[5]), Integer.valueOf(temp2[6]));
			System.out.println(temp2[1]);
			this.aList.add(aGrade);
		}
	}
	
	public void showGrade (int ID) {
		for(int i=0; i<this.aList.size(); i++) {
			if (this.aList.get(i).ID == ID)
				System.out.println("Student with ID "+ID+" has totalgrade "+this.aList.get(i).totalGrade);
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
	
	
	
	public float[] weights = {0.1f, 0.1f, 0.1f, 0.3f, 0.4f};
	public LinkedList<Grades> aList;
	public Grades aGrade;
	public String temp1;
	public String[] temp2;
	public FileInputStream file;
	public BufferedReader buff;
	int tempGrade;
}
