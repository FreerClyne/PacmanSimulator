package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class DirectionCheckTest
{

	@Test
	public void test()
	{
		Pacman test = new Pacman();
		
		boolean output1 = test.directionCheck("south");
		assertEquals(true, output1);
		
		boolean output2 = test.directionCheck("SOUTH");
		assertEquals(true, output2);
		
		boolean output3 = test.directionCheck(" south  ");
		assertEquals(true, output3);
		
		boolean output4 = test.directionCheck("sou");
		assertEquals(false, output4);
		
		boolean output5 = test.directionCheck("");
		assertEquals(false, output5);
		
		boolean output6 = test.directionCheck("   ");
		assertEquals(false, output6);
	}

}
