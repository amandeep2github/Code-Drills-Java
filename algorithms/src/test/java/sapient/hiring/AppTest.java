package sapient.hiring;

//import junit

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testOneType1OneType2Move () {
        Bot bot = new Bot(new Point(1,4), new Point(5, 9));
        while (bot.isValid() && !bot.reached())
            bot.move();
        Assert.assertTrue(bot.reached() );
    }
}
