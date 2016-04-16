
import java.util.Random;


/**
 *
 * @author Mesut GOLCUK
 */
public class Doodlebug extends Organism{
    
    Random rand = new Random();
    private int lastMeal;
    /**
     * Constructor of Doodlebug Class
     * @param x index of the row where it lives
     * @param y index od the column where it lives
     * @param world terrain that doodlebug lives
     */
    public Doodlebug(int x, int y, Terrain world) {
        super(x, y, world);
        lastMeal = 0;
    }

    @Override
    public void move() {
        // checks for whether it moved this tour or not
        if(!moved){
            // if there is ant in the way
            if( antRadar(x+1,y) ){
                moveToNewPlace(x, y, x+1, y);
                lastMeal = getAge();
            }
            else if( antRadar(x-1,y) ){
                moveToNewPlace(x, y, x-1, y);
                lastMeal = getAge();
            }
            else if( antRadar(x,y+1) ){
                moveToNewPlace(x, y, x, y+1);
                lastMeal = getAge();
            }
            else if( antRadar(x,y-1) ){
                moveToNewPlace(x, y, x, y-1);
                lastMeal = getAge();
            }
            // if there isn't any ant in the way then random movement
            else{
                int choosePath = rand.nextInt(4)+1;
                switch( choosePath ){
                    case 1 : 
                        if( canMove(x+1,y))
                            moveToNewPlace(x, y, x+1, y);
                        break;
                    case 2 : 
                        if( canMove(x-1,y))
                            moveToNewPlace(x, y, x-1, y);
                        break;
                    case 3 :
                        if( canMove(x,y+1))
                            moveToNewPlace(x, y, x, y+1);
                        break;
                    case 4 :
                        if( canMove(x,y-1))
                            moveToNewPlace(x, y, x, y-1);
                        break;
                }
            }           
        }
            
    }
    /**
     * checks up,down,right,left cells for ant
     * @param x cell's row index
     * @param y cell's column index
     * @return there is ant or there is not
     */
    public boolean antRadar( int x,int y){
        if( x>=0 && x<world.getN() && y>=0 && y<world.getN() )
            return lifeArea[x][y] instanceof Ant;
        else 
            return false;
    }

    @Override
    public void breed() {
        if( getAge()-getLastBreed() > 7){
            if( canMove(x+1,y)){
                world.setNewDoodle(x+1, y);
                setLastBreed(getAge());
            }
            else if(canMove(x-1,y)){
                world.setNewDoodle(x-1, y);   
                setLastBreed(getAge());
            }
            else if(canMove(x,y+1)){
                 world.setNewDoodle(x, y+1);    
                 setLastBreed(getAge());
            }
            else if(canMove(x,y-1)){
                world.setNewDoodle(x, y-1);                   
                setLastBreed(getAge());
            }
        }
            
    }
    
    @Override
    public void starve(){
        if( getAge() - lastMeal > 3)
            lifeArea[x][y] = null;
    }
    
}