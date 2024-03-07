package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {
	
	@Test
	public void testGetSecondsGood()
	{
	int seconds =
	Time.getSeconds("03:15:30:08");
	assertTrue("The Seconds are calculated properly", seconds==30);
	}
	

	@Test
	public void testGetSecondsBad()
	{
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()-> {Time.getSeconds("10:00");});
	}


	@Test
	public void testGetSecondsBoundary()
	{
	int seconds =
	Time.getSeconds("03:59:01:08");
	assertTrue("The Seconds are calculated in boundary", seconds==01);
	}

	@Test
	public void testGetTotalSecondsGood()
	{
	int seconds =
	Time.getTotalSeconds("05:05:05:08");
	assertTrue("The seconds are calculated properly", seconds==18305);
	}

	@Test
	public void testGetTotalSecondsBad()
	{
	assertThrows(
	StringIndexOutOfBoundsException.class,
	()-> {Time.getTotalSeconds("10:00");});
	}
	
	@Test
	public void testGetTotalSecondsBoundary()
	{
	int seconds =
	Time.getTotalSeconds("05:59:59:08");
	assertTrue("The seconds are calculated on boundary", seconds==21599);
	}

	

	@Test
	public void testGetTotalMinutesGood()
	{
	int minutes =
	Time.getTotalMinutes("03:15:00:08");
	assertTrue("The Minutes are calculated properly", minutes==15);
	}

	

	@Test
	public void testGetTotalMinutesBad()
	{

		assertThrows(
				StringIndexOutOfBoundsException.class,
				()-> {Time.getSeconds("10:00");});
	}
	
	@Test
	public void testGetTotalMinutesBoundary()
	{
	int minutes =
	Time.getTotalMinutes("03:00:00:08");
	assertTrue("The Minutes are in boundary", minutes==0);
	}
	

	@Test
	public void testGetTotalHoursGood()
	{
	int hours =
	Time.getTotalHours("03:00:00:08");
	assertTrue("The Minutes are in boundary", hours==3);
	}
	
	@Test
	public void testGetTotalHoursBoundary()
	{
	int hours =
	Time.getTotalHours("00:59:59:08");
	assertTrue("The Minutes are in boundary", hours==0);
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15:15","05:59:59" })
	void testGetTotalHoursBad(String candidate) {
	int hours = Time.getTotalHours(candidate);
	assertTrue("The hours were not calculated properly",hours ==5);
	}
	
	
	@Test
	public void testGetMilliSecondsGood()
	{
	int milliSeconds =
	Time.getMilliSeconds("03:15:15:05");
	assertTrue("The Milliseconds are Good", milliSeconds==5);
	}
	
	@Test
	public void testGetMilliSecondsBoundary()
	{
	int milliSeconds =
	Time.getMilliSeconds("03:00:00:01");
	assertTrue("The Milliseconds are Good", milliSeconds==1);
	}
	
	@Test
	public void testGetMilliSecondsBad()
	{

		assertThrows(
				StringIndexOutOfBoundsException.class,
				()-> {Time.getMilliSeconds("10:00:00");});
	}
	
	
	
}
