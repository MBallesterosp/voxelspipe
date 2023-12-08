package nephewbob.voxelspipe.test;

import nephewbob.testframework.DataProvider;

/**
 *
 * @author Mario Alberto Ballesteros Plata <MBallesterosp at nephewbob>
 * @author Raul Verduzco Cruz <ztr4w at nephewbob>
 */
public class DataProviderDraw<T> extends DataProvider<Object[]> {
    
    static DataProviderDraw<Object[]> dataProviderDraw;

    static Iterable<Object[]> getInstanceDraw() {
        if (dataProviderDraw == null) {
            dataProviderDraw = new DataProviderDraw();
        }
        return dataProviderDraw;
    }
}
