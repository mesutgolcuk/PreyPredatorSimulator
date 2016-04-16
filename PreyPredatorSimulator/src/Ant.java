
import java.util.Random;

/**
 *
 * @author Mesut GOLCUK
 */
public class Ant extends Organism{
    
    Random rand = new Random();
    /**
     * Constructor of Ant Class
     * @param x index of the row where it lives
     * @param y index od the column where it lives
     * @param world terrain that doodlebug lives
     */
    public Ant(int x, int y, Terrain world) {
        super(x, y, world);
    }

    @Override
    public void move() {
        // checks for whether it moved this tour or not
        if( !moved ){
            int choosePath = rand.nextInt(4)+1;
            // if choosen path is available it ll move
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

    @Override
    public void breed() {
        // if there is an available cell and passed 3 tour since last 
        // breed it will breed
        if( getAge()-getLastBreed() > 2){
            if( canMove(x+1,y)){
                world.setNewAnt(x+1, y);
                setLastBreed(getAge());
            }
            else if(canMove(x-1,y)){
                world.setNewAnt(x-1, y);   
                setLastBreed(getAge());
            }
            else if(canMove(x,y+1)){
                 world.setNewAnt(x, y+1);    
                 setLastBreed(getAge());
            }
            else if(canMove(x,y-1)){
                world.setNewAnt(x, y-1);                   
                setLastBreed(getAge());
            }
        }
    }    
}