
/**
 *
 * @author Mesut GOLCUK
 */
public abstract class Organism {

    protected int x;
    protected int y;
    protected int age;
    protected boolean moved;
    protected Terrain world;
    protected int lastBreed;
    protected Organism[][] lifeArea;
    
    /**
     * 
     * Constructor of abstract Organism Class
     * @param x index of the row where it lives
     * @param y index od the column where it lives
     * @param world terrain that doodlebug lives
     *
     */
    public Organism( int x, int y,Terrain world ){
        this.x = x;
        this.y = y;
        this.world = world;
        lifeArea = world.getTerrain();
        age = 1;
        moved = false;
        lastBreed = 1;
    }
    
    /**
     * method that provides the movement talent for organism
     */
    public abstract void move();
    
    /**
     * method that provides reproduce talent for organism
     */   
    public abstract void breed();
    /**
     * getter method for organism's cell's row index
     * @return row index of organism
     */
    public int getX() {
        return x;
    }
    /**
     * getter method for organism's cell's column index
     * @return column index of organism
     */
    public int getY() {
        return y;
    }
    /**
     * getter method for age attribute
     * @return age of organism
     */
    public int getAge() {
        return age;
    }
    /**
     * getter method for organism's movement condition
     * @return movement situation of organism
     */
    public boolean getMoved(){
        return moved;
    }
    /**
     * setter method for organism's movement condition
     * @param moved movement situation of organism true/false
     */
    public void setMoved(boolean moved) {
        this.moved = moved;
    }
    /**
     * getter method for last Breed
     * @return last breed 
     */
    public int getLastBreed() {
        return lastBreed;
    }
    /**
     * setter method for breed
     * @param lastBreed last breed
     */
    public void setLastBreed(int lastBreed) {
        this.lastBreed = lastBreed;
    }
        
    /**
     * method that increase the age of organism
     */
    public void increaseAge(){
        age++;
    }
    /**
     * checks for a cell whether it is occupied or not
     * @param x row index
     * @param y column index
     * @return whether it can move or not
     */
    public boolean canMove( int x,int y){
        if( x>=0 && x<world.getN() && y>=0 && y<world.getN() )
            return lifeArea[x][y] == null;
        else
            return false;
    }
    /**
     * method that sets new cell for that organism
     * @param x row index
     * @param y column index
     * @param newX new row index
     * @param newY new column index
     */
    public void moveToNewPlace( int x, int y, int newX, int newY){
        if(newX >= 0 && newX <world.getN() 
                && newY >= 0 && newY < world.getN()){
            lifeArea[x][y] = null;
            lifeArea[newX][newY] = this;
            this.x = newX;
            this.y = newY;
            moved = true;
        }
    }
    /** 
     * starve situation for organisms
     * 
     */
    public void starve(){           
        // Overriden in Doodlebug class
    }
    
    @Override
    public String toString() {
        return x + "-" + y;
    }
        
}
