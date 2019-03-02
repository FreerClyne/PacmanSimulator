package main;

import java.util.Scanner;

/**
 * @author Clyne Shi 
 * @version 02-Mar-2017
 */

public class Pacman
{
	private int xPos;
	private int yPos;
	private String direction;
	private Scanner console;
	private static final int UPPER_BOUNDARY = 5;
	private static final int LOWER_BOUNDARY = 0;
	private static final String[] DIRECTION = {"NORTH", "SOUTH", "WEST", "EAST"};
	
	public Pacman()
	{
		xPos = 0;
		yPos = 0;
		direction = "NORTH";
		console = new Scanner(System.in);
	}
	
	public int getXPos()
	{
		return xPos;
	}
	
	public int getYPos()
	{
		return yPos;
	}
	
	public String getDirection()
	{
		return direction;
	}
	
	public void setXPos(int newX)
	{
		xPos = newX;
	}
	
	public void setYPos(int newY)
	{
		yPos = newY;
	}
	
	public void setDirection(String newDirect)
	{
		direction = newDirect;
	}
	
	/**
     * @return if the movement is valid
     */
	public boolean moveCheck(int newX, int newY)
	{
		if ( newX < LOWER_BOUNDARY || newX >= UPPER_BOUNDARY)
		{
			System.out.println("Error, out of boundary! operation canceled");
			return false;
		}
		if ( newY < LOWER_BOUNDARY || newY >= UPPER_BOUNDARY)
		{
			System.out.println("Error, out of boundary! operation canceled");
			return false;
		}
		return true;
	}
	
	/**
     * @return if the direction is valid
     */
	public boolean directionCheck(String newDirect)
	{
		if (newDirect == null || newDirect.trim().isEmpty()) // check if input is empty
        {
        	System.out.println("Error, empty direction");
            return false;
        }
		for (String dir : DIRECTION)
		{
			if (dir.equals(newDirect.toUpperCase().trim()))
					return true;
		}
		
		System.out.println("Error, wrong direction");
		return false;
	}
	
	/**
     * @return if the input of a place is valid
     */
	public boolean placeCheck(String[] input)
	{
		if (input.length != 3) // check if input meets format requirement
        {
            System.out.println("Error, invalid input!\n");
            return false;
        }
		if (!numberInputCheck(input[0]) || !numberInputCheck(input[1])) // check if the first two input
		{																// is numeric
			System.out.println("Error, invalid position");
			return false;
		}
		int newX = Integer.parseInt(input[0].trim());
		int newY = Integer.parseInt(input[1].trim());
		if (!moveCheck(newX, newY)) // check if the position is inside the matrix
		{
			return false;
		}
		if (!directionCheck(input[2].trim())) // check if the direction is valid
		{
			return false;
		}
		
		return true;
	}
	
	/**
     * Initialise a new start place
     * @return if the new place is successfully added
     */
	public boolean place()
	{
		System.out.print("Please input a new position f.g. 0,0,NORTH: ");
		String[] input = null;
		input = console.nextLine().split(",");
		for (int i = 0; i < input.length; i++)
			input[i] = input[i].trim();
		
		if (!placeCheck(input)) // check if the place is valid
		{
			return false;
		}
		
		setXPos(Integer.parseInt(input[0]));
		setYPos(Integer.parseInt(input[1]));
		setDirection(input[2].toUpperCase());
		
		return true;
		
	}

	/**
     * Move 1 unit towards current direction
     */
	public void move()
	{
		int currentX = getXPos();
		int currentY = getYPos();
		switch(getDirection())
		{
			case "NORTH": currentY += 1; break;
			case "WEST": currentX -= 1; break;
			case "SOUTH": currentY -= 1; break;
			case "EAST": currentX += 1; break;
		}
		if (moveCheck(currentX, currentY))
		{
			setXPos(currentX);
			setYPos(currentY);
		}

	}
	
	/**
     * Rotate 90 degree to left
     */
	public void left()
	{
		switch(getDirection())
		{
			case "NORTH": setDirection("WEST"); break;
			case "WEST": setDirection("SOUTH"); break;
			case "SOUTH": setDirection("EAST"); break;
			case "EAST": setDirection("NORTH"); break;
		}
	}
	
	/**
     * Rotate 90 degree to right
     */
	public void right()
	{
		switch(getDirection())
		{
			case "NORTH": setDirection("EAST"); break;
			case "WEST": setDirection("NORTH"); break;
			case "SOUTH": setDirection("WEST"); break;
			case "EAST": setDirection("SOUTH"); break;
		}
	}
	
	/**
     * Display current position and direction
     */
	public String report()
	{
		String output = getXPos() + ", " + getYPos() + ", " + getDirection();
		System.out.println(output);
		return output;
	}
	
	/**
     * @return whether the input string is 
     * a valid number
     */
	public boolean numberInputCheck(String input)
    {
        if (input == null || input.trim().isEmpty()) // check if input is empty
        {
        	System.out.println("Error, invalid input");
            return false;
        }
        input = input.trim();
        for (int i = 0 ; i < input.length(); i++) // check if input is numeric
        {
            if (input.charAt(i) < '0' || input.charAt(i) > '9')
            {
            	System.out.println("Error, invalid input");
                return false;
            }
        }
        return true;
    }
	
	/**
     * Display game menu
     */
	public void gameDisplay()
	{
		System.out.println("\n*********PACMAN SIMULATOR**********");
		System.out.println("1. Place");
		System.out.println("2. Move");
		System.out.println("3. Left");
		System.out.println("4. Right");
		System.out.println("5. Report");
		System.out.println("6. Exit");
	}
	
	/**
     * Main game process
     */
	public void mainProcess()
	{
		String input = "0"; // store player's input
		boolean init = false;
		while (!init) // let user init birth place
		{
			System.out.println("\n*********PACMAN SIMULATOR**********");
			init = place();
		}
		
		while (Integer.parseInt(input) != 6) // display menu in a indefinite loop
		{
			gameDisplay();
			input = console.nextLine().trim();
			if (numberInputCheck(input))
            {
                switch(Integer.parseInt(input))
                {
                    case 1: place(); break;
                    case 2: move(); break;
                    case 3: left(); break;
                    case 4: right(); break;
                    case 5: report(); break;
                    case 6: break;
                    default: System.out.println("\nError, invalid number!");
                }
            }
            else
            {
                System.out.println("\nError, invalid number!");
                input = "0";
            }
		}
	}
	
	static public void main(String[] args)
	{
		Pacman game= new Pacman();
		game.mainProcess();
	}

}
