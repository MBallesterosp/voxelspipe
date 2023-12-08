package nephewbob.voxelspipe.test;

import nephewbob.testframework.Input;
import nephewbob.voxelspipe.Cube;
import nephewbob.voxelspipe.Rotation;
import nephewbob.voxelspipe.Translation;
import nephewbob.voxelspipe.World;

/**
 *
 * @author Raul Verduzco Cruz <ztr4w at nephewbob>
 * @author Mario Alberto Ballesteros Plata <MBallesterosp at nephewbob>
 */
public class InputTestDraw implements Input {
    
    World world;
    Cube cube;
    Translation translation;
    Rotation rotation;    

    public World getWorld() {
        return world;
    }

    public Cube getCube() {
        return cube;
    }

    public Translation getTranslation() {
        return translation;
    }
    
    public Rotation getRotation(){
        return rotation;
    }

}
