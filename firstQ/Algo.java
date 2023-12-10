package firstQ;


import java.util.Scanner;

public class Algo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter grid size (rows columns): ");
	        int rows = scanner.nextInt();
	        int columns = scanner.nextInt();
	        int[][] grid = new int[rows][columns];

	        System.out.print("Enter target position (row column): ");
	        int targetRow = scanner.nextInt();
	        int targetColumn = scanner.nextInt();
	        grid[targetRow][targetColumn] = 1;
	        
	        Pos targetPos = new Pos(targetRow,targetColumn);

	        Pos[] drones = {
	                new Pos(0,0), // Drone 1
	               new Pos(0,columns-1), // Drone 2
	                new Pos(rows-1,0), // Drone 3
	                new Pos(rows-1,columns-1) // Drone 4
	        };

	        for(int drone = 0; drone < drones.length; drone++) {
	            Pos dronePos = drones[drone];
	            System.out.println("Searching with Drone " + (drone + 1) + "...");
	            if (findPath(grid, targetPos, dronePos)) {
	                System.out.println("Target found by Drone " + (drone + 1) + "!");
	                continue;
	            }
	        }
	        scanner.close();
		
	}
	
	
	
	public static boolean findPath(int[][] grid,Pos targetPos,Pos dronePos){
		
		int currPosx = dronePos.x;
		int currPosy = dronePos.y;
        while (currPosx != targetPos.x || currPosy != targetPos.y) {

            if (currPosx < targetPos.x) {
                currPosx++;
            } else if (currPosx > targetPos.x) {
                currPosx--;
            }
            if (currPosy < targetPos.y) {
                currPosy++;
            } else if (currPosy > targetPos.y) {
                currPosy--;
            }

            System.out.println("Drone at position: (" + currPosx + ", " + currPosy + ")");
        }
        return true;
       
		
		
	}
	

}

	
	

