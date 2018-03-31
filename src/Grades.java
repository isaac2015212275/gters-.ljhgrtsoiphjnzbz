
public class Grades {
	public Grades (int ID, String name, int lab1, int lab2, int lab3, int midTerm, int finalExam) {
		this.ID = ID;
		this.name = name;
		this.lab1 = lab1;
		this.lab2 = lab2;
		this.lab3 = lab3;
		this.midTerm = midTerm;
		this.finalExam = finalExam;
	}
	
	public void calculateTotalGrade(float[] weights) {
		float total = this.lab1 * weights[0] +
					  this.lab2 * weights[1] +
					  this.lab3 * weights[2] +
					  this.midTerm * weights[3] +
					  this.finalExam * weights[4];
		this.totalGrade = (int)(total+0.5);
	}
	
	public int ID;
	public String name;
	public int lab1;
	public int lab2;
	public int lab3;
	public int midTerm;
	public int finalExam;
	public int totalGrade;
}
