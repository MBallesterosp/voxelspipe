package nephewbob.voxelspipe;

/**
 *
 * @author Mario Alberto Ballesteros Plata <MBallesterosp at nephewbob>
 * @author Raul Verduzco Cruz <ztr4w at nephewbob>
 */
class Rotation {

    int phi;
    int theta;
    int psi;
    double xPrime;
    double yPrime;
    double zPrime;

    public Rotation(int phi, int theta, int psi) {
        this.phi = phi;
        this.theta = theta;
        this.psi = psi;
    }    

    Point3D convertIndexesToCordinates(int i, int j, int k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void yAxis(double xPrime, double yPrime, double zPrime) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void zAxis(double xPrime, double yPrime, double zPrime) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
