package nephewbob.voxelspipe.test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import nephewbob.testframework.Expected;
import nephewbob.testframework.Input;
import nephewbob.testframework.Test;

/**
 *
 * @author Mario Alberto Ballesteros Plata <MBallesterosp at nephewbob>
 * @author Raul Verduzco Cruz <ztr4w at nephewbob>
 */
class TestDraw extends Test {

    public TestDraw(boolean boundary, Expected expected, Input input) {
        super(boundary, expected, input);
        this.input = (InputTestDraw) input;
    }

    @Override
    public boolean getResult() {
        System.out.println("boundary " + boundary);
        boolean[][][] output;
        boolean result;
        try {
            output = input.getWorld().draw(input.getCube(), input.getTranslation(), input.getRotation());
        } catch (ArrayIndexOutOfBoundsException ex) {
            result = !boundary;
            System.out.println("result" + " " + result);
            return result;
        }
        result = equals(output, expected.getValue());
        try {
            expected.display();
            input.getWorld().display();
        } catch (IOException ex) {
            Logger.getLogger(TestDraw.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestDraw.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("result" + " " + result);
        return result;
    }

    @Override
    public boolean output() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
