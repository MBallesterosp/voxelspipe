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

    public Point3D convertIndexesToCordinates(int horizontal, int vertical, int depth){
        double x = horizontal + 1;
        double y = vertical + 1;
        double z = depth + 1;
        return new Point3D(x, y, z);
    }

    public Point2D xAxis(double x, double y, double z) {
        double phiRadians = Math.toRadians(- phi);
        double cosPhi = Math.cos(phiRadians);
        double sinPhi = Math.sin(phiRadians);
        double zSinPhi = z * sinPhi;
        double zCosPhi = z * cosPhi;
        double ySinPhi = y * sinPhi;
        double yCosPhi = y * cosPhi;
        xPrime = x;
        yPrime = yCosPhi - zSinPhi;
        zPrime = ySinPhi + zCosPhi;
        return new Point2D(yPrime, zPrime);
    }
    
    public Point2D yAxis(double x, double y, double z) {
        double thetaRadiants = Math.toRadians(theta);
        double cosTheta = Math.cos(thetaRadiants);
        double sinTheta = Math.sin(thetaRadiants);
        double xCosTheta = x * cosTheta;
        double xSinTheta = x * sinTheta;
        double zSinTheta = z * sinTheta;
        double zCosTheta = z * cosTheta;
        xPrime = xCosTheta + zSinTheta;
        yPrime = y;
        zPrime = -xSinTheta + zCosTheta;
        return new Point2D(xPrime, zPrime);
    }

    public Point2D zAxis(double x, double y, double z) {
        double psiRadians = Math.toRadians(psi);
        double cosPsi = Math.cos(psiRadians);
        double sinPsi = Math.sin(psiRadians);
        double xSinPsi = x * sinPsi;
        double xCosPsi = x * cosPsi;
        double ySinPsi = y * sinPsi;
        double yCosPsi = y * cosPsi;
        xPrime = xCosPsi - ySinPsi;
        yPrime = xSinPsi + yCosPsi;
        zPrime = z;
        return new Point2D(xPrime, yPrime);
    }

}
