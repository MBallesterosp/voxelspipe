package nephewbob.voxelspipe.test;

/**
 *
 * @author Mario Alberto Ballesteros Plata <MBallesterosp at nephewbob>
 * @author Raul Verduzco Cruz <ztr4w at nephewbob>
 */
class DataProviderDraw {

    static Iterable<Object[]> getInstanceDraw() {
        if (dataProviderDraw == null) {
            dataProviderDraw = new DataProviderDraw();
        }
        return dataProviderDraw;
    }
}
