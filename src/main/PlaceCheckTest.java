package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlaceCheckTest
{

	@Test
	public void test()
	{
		Pacman test = new Pacman();
		
		boolean output1 = test.placeCheck(new String[]{"0", "0", "north"});
		assertEquals(true, output1);
		
		boolean output2 = test.placeCheck(new String[]{"2", "3", "wEst"});
		assertEquals(true, output2);
		
		boolean output3 = test.placeCheck(new String[]{" 4", "3 ", "NoRtH"});
		assertEquals(true, output3);
		
		boolean output4= test.placeCheck(new String[]{"3", "0", " north"});
		assertEquals(true, output4);
		
		boolean output5 = test.placeCheck(new String[]{"", "0", "north"});
		assertEquals(false, output5);
		
		boolean output6 = test.placeCheck(new String[]{"3", "-1", "south"});
		assertEquals(false, output6);
		
		boolean output7 = test.placeCheck(new String[]{"-1", "5", "northsouth"});
		assertEquals(false, output7);
		
		boolean output8 = test.placeCheck(new String[]{"", "", ""});
		assertEquals(false, output8);
	}

}
