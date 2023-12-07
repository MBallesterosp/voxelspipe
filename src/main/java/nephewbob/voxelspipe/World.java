package nephewbob.voxelspipe;

import java.io.IOException;
import java.util.LinkedList;
import static nephewbob.voxelspipe.Block.SOLID;
import static nephewbob.voxelspipe.Block.TRANSPARENT;

/**
 *
 * @author Mario Alberto Ballesteros Plata <MBallesterosp at nephewbob>
 * @author Raul Verduzco Cruz <ztr4w at nephewbob>
 */
public class World {

    boolean[][][] voxels;
    LinkedList<Cube> objects;
    int size;

    public World(int size) {
        voxels = new boolean[size][size][size];
        objects = new LinkedList<>();
        this.size = size;
    }    

    public int[] convertCordinatesToIndex(double x, double y, double z) {
        int[] indexes = new int[3];
        indexes[0] = (int) Math.floor(x) - 1;
        if (x < 0) {
            indexes[0] = (int) Math.ceil(x) - 1;
        }
        indexes[1] = (int) Math.floor(y) - 1;
        if(y < 0){
            indexes[1] = (int) Math.ceil(y) - 1;
        }
        indexes[2] = (int) Math.floor(z) - 1;
        if(z < 1){
            indexes[2] = (int) Math.ceil(z) - 1;
        }
        return indexes;
    }

    public boolean[][][] draw(
            Cube cube, Translation translation, Rotation rotation) {
        voxels = new boolean[size][size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (cube.getSize() >= 1
                            && i < cube.getSize()
                            && j < cube.getSize()
                            && k < cube.getSize()) {
                        // Use first the rotation and then the translation in case the cube get placed out of the frustum.
                        Point3D cordinates = rotation.convertIndexesToCordinates(i, j, k);
                        rotation.xAxis(cordinates.x, cordinates.y, cordinates.z);
                        rotation.yAxis(rotation.xPrime, rotation.yPrime, rotation.zPrime);
                        rotation.zAxis(rotation.xPrime, rotation.yPrime, rotation.zPrime);
                        int[] indexes = convertCordinatesToIndex(rotation.xPrime, rotation.yPrime, rotation.zPrime);
                        int iPrime = indexes[0] + translation.x;
                        int jPrime = indexes[1] + translation.y;
                        int kPrime = indexes[2] + translation.z;
                        voxels[iPrime][jPrime][kPrime] = true;
                    }
                }
            }
        }
        return voxels;
    }

    public String display() throws IOException, InterruptedException {
        boolean[][] raster = rasterize();
        String myWorld = "";
        for (int i = 0; i < raster[0].length; i++) {
            for (int j = 0; j < raster.length; j++) {
                boolean current = raster[j][i];
                myWorld += current ? SOLID + "" : TRANSPARENT + "";
            }
            myWorld += '\n';
        }
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println(myWorld);
        return myWorld;
    }

    public boolean[][] rasterize() {
        //Save the raster
        boolean[][] raster = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    raster[i][j] = voxels[i][j][k] || raster[i][j];
                }
            }
        }
        return raster;
    }

}
