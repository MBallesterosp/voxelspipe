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
class World {

    boolean[][][] voxels;
    LinkedList<Cube> objects;
    int size;

    public World(int size) {
        voxels = new boolean[size][size][size];
        objects = new LinkedList<>();
        this.size = size;
    }    

    private int[] convertCordinatesToIndex(double xPrime, double yPrime, double zPrime) {
        throw new UnsupportedOperationException("Not supported yet.");
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
                        // Usar primero la rotación y después la traslación por si se sale el cubo.
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

    private boolean[][] rasterize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
