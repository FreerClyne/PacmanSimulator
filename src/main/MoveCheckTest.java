package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoveCheckTest
{

	@Test
	public void test()
	{
		Pacman test = new Pacman();
		
		boolean output1 = test.moveCheck(0, 0);
		assertEquals(true, output1);
		
		boolean output2 = test.moveCheck(3, 4);
		assertEquals(true, output2);
		
		boolean output3 = test.moveCheck(1, 4);
		assertEquals(true, output3);
		
		boolean output4 = test.moveCheck(-1, 0);
		assertEquals(false, output4);
		
		boolean output5 = test.moveCheck(5, 2);
		assertEquals(false, output5);
		
		boolean output6 = test.moveCheck(4, -1);
		assertEquals(false, output6);
		
		boolean output7 = test.moveCheck(0, 9);
		assertEquals(false, output7);
		
		boolean output8 = test.moveCheck(-1, -1);
		assertEquals(false, output8);
		
		boolean output9 = test.moveCheck(10, 10);
		assertEquals(false, output9);
	}

}
