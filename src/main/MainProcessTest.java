package main;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class MainProcessTest
{

	@Test
	void test()
	{
		String input = "0,0,north";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Pacman test1 = new Pacman();
		test1.place();
		test1.move();
		assertEquals("0, 1, NORTH", test1.report());
		
		input = "0,0,  north  ";
		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Pacman test2 = new Pacman();
		test2.place();
		test2.left();
		assertEquals("0, 0, WEST", test2.report());
		
		input = "1,2,east";
		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Pacman test3 = new Pacman();
		test3.place();
		test3.move();
		test3.move();
		test3.left();
		test3.move();
		assertEquals("3, 3, NORTH", test3.report());
		
		input = "3,3,south";
		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Pacman test4 = new Pacman();
		test4.place();
		test4.move();
		test4.left();
		test4.move();
		test4.right();
		test4.move();
		test4.move();
		assertEquals("4, 0, SOUTH", test4.report());
		
		input = "0,4,north";
		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Pacman test5 = new Pacman();
		test5.place();
		test5.right();
		test5.move();
		test5.move();
		test5.left();
		test5.move();
		test5.right();
		test5.right();
		test5.move();
		test5.move();
		test5.left();
		test5.move();
		test5.move();
		assertEquals("4, 2, EAST", test5.report());
	}

}
