package nephewbob.voxelspipe.test;

import nephewbob.testframework.Expected;
import nephewbob.testframework.Input;
import nephewbob.testframework.TestSuite;

/**
 *
 * @author Mario Alberto Ballesteros Plata <MBallesterosp at nephewbob>
 */
public class TestRasterizeSuite extends TestSuite {

    @Override
    public boolean executeTest(int testNumber) {
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName() + "(" + testNumber + ")");
        Input input = dataProvider.getInput(testNumber);
        Expected expected = dataProvider.getExpected(testNumber);
        boolean boundary = dataProvider.getBoundary(testNumber);
        TestDraw testDraw = new TestDraw(boundary, expected, (InputTestDraw) input);
        return testDraw.getResult();
    }

    @Override
    public boolean getResult() {
        TestDraw testDraw;
        int testNumber = 0;
        boolean result = true;
        for (Object[] datum : DataProviderDraw.getInstanceDraw()) {
            testDraw = new TestDraw((Boolean) datum[0], (Expected) datum[1], (Input) datum[2]);
            result = result && testDraw.getResult();
            System.out.println("testnumber" + " " + testNumber);
            testNumber++;
        }
        return result;
    }
    
}
