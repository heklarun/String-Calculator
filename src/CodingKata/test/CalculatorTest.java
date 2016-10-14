package CodingKata;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
	
	@Test
	public void testEmptyString() throws Exception {
		assertEquals(0, StringCalculator.add(""));
	}
	
	@Test
	public void testOneNumber() throws Exception{
		assertEquals(1, StringCalculator.add("1"));
	}
	
	@Test
	public void testTwoNumber() throws Exception{
		assertEquals(3, StringCalculator.add("1,2"));
	}
	
	@Test
	public void testMultibleNumbers() throws Exception {
		assertEquals(6, StringCalculator.add("1,2,3"));
	}
	
	@Test
	public void testNewLineDilimitedNumber() throws Exception   {
		assertEquals(6, StringCalculator.add("1\n2,3"));
	}
	
	
	@Test
	public void NumGreaterThan1000AreIgnored() throws Exception {
		assertEquals(15, StringCalculator.add("10,5,1100"));
	}
	
	
	@Test
	public void DifferentDelimiter() throws Exception {
		assertEquals(8, StringCalculator.add("//;\n4;4"));
	}
	@Test(expected=IllegalArgumentException.class)
	public void negativeNumberWillThrowException() throws Exception{
		StringCalculator.add("-1");
		StringCalculator.add("2, -6, 5, -4");
	}
	
}	