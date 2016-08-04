
import java.util.Scanner;

/**
 *	@file
 *	
 *	BLM2562 Spring2014 Assignment 1 
 *	
 *	Prey And Predator Simulator
 *	
 *	@author
 *	
 *	Name: Mesut GOLCUK
 *	
 *	IDE: Eclipse Luna
 * 
 */
public class Main {
    /**
     * main method that simulates the simulation
     * @param args 
     */
    public static void main(String[] args) {
        Scanner in;
        in = new Scanner(System.in);
        int size = 0 ;
        int doodles = 0;
        int ants = 0;

        try{
            System.out.println("Pls enter the size of the world:");
            size= in.nextInt();
            if(size<=0)
            	illegalErr();
            System.out.println("Pls enter the number of doodlebugs");
            doodles = in.nextInt();
            if(doodles < 0)
            	illegalErr();
            System.out.println("Pls enter the number of ants");
            ants = in.nextInt();
            if(ants < 0)
				illegalErr();
            if( ants + doodles > size*size)
				placeErr();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }

        Terrain world = new Terrain(size,doodles,ants);
        Organism [][] lifeArea = world.getTerrain();       
        String exit = "";
        in.nextLine();
        // loop won't stop until the input is "0"
        while( !exit.equals("0") ){
            printTerrain(lifeArea);
            System.out.println();
            world.moveDoodles();
            world.moveAnts();
            world.starveAll();
            world.breedAll();
            world.nextTour();
            exit = in.nextLine();
        }
        in.close();

    }
	private static void illegalErr() throws Exception{
		throw new Exception("Illegal input");
	}
	private static void placeErr() throws Exception{
		throw new Exception("There isn't enough place");
	}
    /**
     * method that prints the ants and doodlebugs and their place
     * @param a 2d array contains ants and doodlebugs
     */
    public static void printTerrain( Organism[][] a){
        for (Organism[] a1 : a) {
            System.out.print("\n");
            for (Organism a11 : a1) {
                if (a11 instanceof Ant) {
                    System.out.print("|o|");
                } else if (a11 instanceof Doodlebug) {
                    System.out.print("|X|");
                    
                } else {
                    System.out.print("| |");
                }
            }
        }
    }
}
