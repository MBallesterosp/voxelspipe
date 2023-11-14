package nephewbob.voxelspipe;

import java.io.IOException;

/**
 *
 * @author Mario Alberto Ballesteros Plata <MBallesterosp at nephewbob>
 */
public class Voxelspipe {

    public static void main(String[] args) throws IOException, InterruptedException {
        World world = new World(40);
        Cube cube = new Cube(10);
        Translation translation = new Translation(20, 20, 20);
        Rotation rotation = new Rotation(0, 0, 0);
        world.draw(cube, translation, rotation);
        int angle = 0;
        while (true) {
            world.display();
            rotation = new Rotation(angle, angle, angle);
            angle++;
            world.draw(cube, translation, rotation);
            Thread.sleep(60);
        }
    }
}
