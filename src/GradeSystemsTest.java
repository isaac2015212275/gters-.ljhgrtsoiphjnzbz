import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GradeSystemsTest {
	GradeSystems aGradeSystem;
	ByteArrayOutputStream outContent;
	@Before
	public void setUp() throws Exception {
		aGradeSystem = new GradeSystems();
		outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
	}

	@After
	public void tearDown() throws Exception {
		aGradeSystem = null;
	}

	@Test
	public void testShowGrade1() {
		System.setIn(new ByteArrayInputStream("975002021\r\n".getBytes()));
		aGradeSystem.showGrade(975002021);
		String testStr1 = "Student with ID 975002021 has Lab1 grade 81\r\n" + 
				"Student with ID 975002021 has Lab2 grade 97\r\n" + 
				"Student with ID 975002021 has Lab3 grade 90\r\n" + 
				"Student with ID 975002021 Midterm grade 82\r\n" + 
				"Student with ID 975002021 Final Exam grade 84\r\n" + 
				"Student with ID 975002021 has totalgrade 85\r\n";
		assertEquals(testStr1,outContent.toString());
	}
	@Test
	public void testShowGrade2() {
		System.setIn(new ByteArrayInputStream("985002011\r\n".getBytes()));
		aGradeSystem.showGrade(985002011);
		String testStr1 = "Student with ID 985002011 has Lab1 grade 92\r\n" + 
				"Student with ID 985002011 has Lab2 grade 88\r\n" + 
				"Student with ID 985002011 has Lab3 grade 90\r\n" + 
				"Student with ID 985002011 Midterm grade 99\r\n" + 
				"Student with ID 985002011 Final Exam grade 88\r\n" + 
				"Student with ID 985002011 has totalgrade 92\r\n";
		assertEquals(testStr1,outContent.toString());
	}
	@Test
	public void testShowRank1() {
		System.setIn(new ByteArrayInputStream("985002011\r\n".getBytes()));
		aGradeSystem.showRank(985002011);
		String testStr1 = "Student with ID 985002011 has rank 16\r\n";
		assertEquals(testStr1,outContent.toString());
	}
	@Test
	public void testShowRank2() {
		System.setIn(new ByteArrayInputStream("985002021\r\n".getBytes()));
		aGradeSystem.showRank(985002021);
		String testStr1 = "Student with ID 985002021 has rank 4\r\n";
		assertEquals(testStr1,outContent.toString());
	}
	@Test
	public void testContainsID1() {
		assertEquals(true,aGradeSystem.containsID(985002021));
	}
	@Test
	public void testContainsID2() {
		assertEquals(false,aGradeSystem.containsID(9850021));
	}
	@Test
	public void testGetName1() {
		assertEquals("³¯¬f¹ü",aGradeSystem.getName(985002021));
	}
	@Test
	public void testGetName2() {
		assertEquals(null,aGradeSystem.getName(95002021));
	}
	@Test
	public void testgetNewWeight1() {
		System.setIn(new ByteArrayInputStream("20\r\n20\r\n20\r\n20\r\n20\r\n".getBytes()));
		aGradeSystem.getNewWeights();
		float[] test = {0.2f,0.2f,0.2f,0.2f,0.2f};
		assertEquals((int)(test[0]*100),(int)(aGradeSystem.weights[0]*100));
		assertEquals((int)(test[1]*100),(int)(aGradeSystem.weights[1]*100));
		assertEquals((int)(test[2]*100),(int)(aGradeSystem.weights[2]*100));
		assertEquals((int)(test[3]*100),(int)(aGradeSystem.weights[3]*100));
		assertEquals((int)(test[4]*100),(int)(aGradeSystem.weights[4]*100));
	}
	@Test
	public void testgetNewWeight2() {
		System.setIn(new ByteArrayInputStream("30\r\n20\r\n20\r\n20\r\n20\r\n".getBytes()));
		aGradeSystem.getNewWeights();
		String test = "Lab1 10%\r\n" + 
				"Lab2 10%\r\n" + 
				"Lab3 10%\r\n" + 
				"Midterm 30%\r\n" + 
				"Final Exam 40%\r\n" + 
				"Please type in new weight of Lab1 :\r\n" + 
				"Please type in new weight of Lab2 :\r\n" + 
				"Please type in new weight of Lab3 :\r\n" + 
				"Please type in new weight of midTerm :\r\n" + 
				"Please type in new weight of finalExam :\r\n"+
				"Sum of the weight does not equal to 100!\r\n";
		assertEquals(test,outContent.toString());
	}
	@Test
	public void testShowAverage1() {
		aGradeSystem.showAverage();
		String testStr1 = "Average grade is : 89\r\n";
		assertEquals(testStr1,outContent.toString());
	}
}
