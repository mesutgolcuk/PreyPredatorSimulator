
import java.util.Random;

/**
 *
 * @author Mesut GOLCUK
 */
public class Terrain {

    private final int n;
    private int numberOfAnts;
    private int numberOfDoodlebugs;
    private Organism[][] terrain;
    Random rand = new Random();
    /**
     * Constructor of Terrain class
     * @param n length of 2d square array 's length
     * @param numbOfAnts number of Ants in the terrain
     * @param numbOfDoodlebugs number of doodle bugs in the terrain
     */
    public Terrain( int n, int numbOfAnts, int numbOfDoodlebugs){
        
        this.n = n;
        this.numberOfAnts = numbOfAnts;
        this.numberOfDoodlebugs = numbOfDoodlebugs;
        
        terrain = new Organism[n][n];
        initializeTerrain();

        placeAnts( numbOfDoodlebugs);
        placeDoodles( numbOfAnts );
        
    }
    /**
     * Setter Method for 2d Organism array
     * @param terrain 
     */
    public void setTerrain(Organism[][] terrain) {
        this.terrain = terrain;
    }
    /**
     * Getter method for 2d array 's length
     * @return 2d array 's length
     */
    public int getN() {
        return n;
    }
    /**
     * Getter method for ant number in the terrain
     * @return Ant number in the terrain 
     */
    public int getNumberOfAnts() {
        return numberOfAnts;
    }
    /**
     * Getter method for doodle bug number in the terrain
     * @return Doodle bug number in the terrain
     */
    public int getNumberOfDoodlebugs() {
        return numberOfDoodlebugs;
    }
    /**
     * getter method for 2d Organism array
     * @return 2d Organism array
     */
    public Organism[][] getTerrain() {
        return terrain;
    }
    
    
    /**
     *  method which initializes the 2d array with spaces
     * 
     */
    private void initializeTerrain(){
        for (Organism[] terrain1 : terrain) {
            for (int j = 0; j < terrain1.length; j++) {
                terrain1[j] = null;
            }
        }
    }
    /**
     * method which places Ants to the random empty areas
     * @param numberOfOrganism is the number of Ants that will take place
     *                         in terrain
     */
    private void placeAnts( int numberOfOrganism ){

        for( int i=0; i<numberOfOrganism; i++){
            
            int x = rand.nextInt(n);
            int y = rand.nextInt(n);
            // only placing to the null places
            while( terrain[x][y] != null){
                x = rand.nextInt(n);
                y = rand.nextInt(n);
            }         
                
             terrain[x][y] = new Ant(x,y,this);              
                                       
        }
    }
     /**
     * method which places Doodles to the random empty areas
     * @param numberOfOrganism is the number of Ants that will take place
     *                         in terrain
     */
    private void placeDoodles( int numberOfOrganism ){
        

        for( int i=0; i<numberOfOrganism; i++){
            
            int x = rand.nextInt(n);
            int y = rand.nextInt(n);
            // only placing to the null places
            while( terrain[x][y] != null){
                x = rand.nextInt(n);
                y = rand.nextInt(n);
            }         
                
             terrain[x][y] = new Doodlebug(x,y,this);              
                                       
        }
    }
    /**
     * Sets a new Ant for a given coordinate
     * @param x row index
     * @param y column index
     */
    public void setNewAnt( int x, int y ){
        terrain[x][y] = new Ant(x,y,this);
    }
    
    /**
     * Sets a new doodlebug for a given coordinate
     * @param x row index
     * @param y column index
     */
    public void setNewDoodle( int x, int y ){
        terrain[x][y] = new Doodlebug(x,y,this);
    }
    /**
     * method that moves all doodle bugs in the terrain
     */
    public void moveDoodles(){
        for( Organism[] each1 : terrain){
            for( Organism each11 : each1){
                if( each11 instanceof Doodlebug )
                        each11.move();
            }
        }
    }
    /**
     * method that moves all ants in the terrain
     */
    public void moveAnts(){
        for( Organism[] each1 : terrain){
            for( Organism each11 : each1){
                if( each11 instanceof Ant)
                    each11.move();
            }
        }
    }
    /**
     * methods that sets attributes for the new tour
     */
    public void nextTour(){
        for( Organism[] each1 : terrain){
            for( Organism each11 : each1){
                if( each11 instanceof Ant || each11 instanceof Doodlebug){
                    each11.setMoved(false);
                    each11.increaseAge();
                }

            }
        }
    }
    /**
     * methods that breed all organisms in the terrain
     */
    public void breedAll(){
        for( Organism[] each1 : terrain){
            for( Organism each11 : each1){
                if( each11 instanceof Ant || each11 instanceof Doodlebug){
                    each11.breed();
                }

            }
        }
    }
    /**
     * methods that checks the starving situation of all doodlebugs
     */
    public void starveAll(){
        for( Organism[] each1 : terrain){
            for( Organism each11 : each1){
                if( each11 instanceof Doodlebug){
                    each11.starve();
                }

            }
        }
    }
}
