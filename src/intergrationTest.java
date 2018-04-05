import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class intergrationTest {
	UI ui;
	ByteArrayOutputStream outContent;
	@Before
	public void setUp() throws Exception {
		this.ui = new UI();
		this.outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(this.outContent));
	}

	@After
	public void tearDown() throws Exception {
		this.ui= null;
	}

	@Test
	public void test1() {
		System.setIn(new ByteArrayInputStream("975002021\r\n".getBytes()));
		String testStr1 = 
				"Please enter your student ID to start or enter Q to quit :\r\n"+
				"Student with ID 975002021 has Lab1 grade 81\r\n" + 
				"Student with ID 975002021 has Lab2 grade 97\r\n" + 
				"Student with ID 975002021 has Lab3 grade 90\r\n" + 
				"Student with ID 975002021 Midterm grade 82\r\n" + 
				"Student with ID 975002021 Final Exam grade 84\r\n" + 
				"Student with ID 975002021 has totalgrade 85\r\n";
		assertEquals(testStr1,outContent.toString());
	}

}
