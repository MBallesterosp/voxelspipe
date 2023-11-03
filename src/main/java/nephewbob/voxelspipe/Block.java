package nephewbob.voxelspipe;

/**
 *
 * @author Raul Verduzco Cruz <ztr4w at nephewbob>
 */
public enum Block {
    SOLID('\u2588'), TRANSPARENT('\u2591');
    char value;
    
    private Block(char value){
        this.value = value;
    }
    
    @Override
    public String toString(){
        return value + "";
    }    
}
