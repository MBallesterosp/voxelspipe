package nephewbob.voxelspipe;

import java.util.LinkedList;

/**
 *
 * @author Mario Alberto Ballesteros Plata <MBallesterosp at nephewbob>
 * @author Raul Verduzco Cruz <ztr4w at nephewbob>
 */
class World {

    boolean[][][] voxels;
    LinkedList<Cube> objects;
    int size;

    public World(int size) {
        voxels = new boolean[size][size][size];
        objects = new LinkedList<>();
        this.size = size;
    }    

    void draw(Cube cube, Translation translation, Rotation rotation) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void display() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
