package ing;

import org.junit.Test;
import org.testng.Assert;

public class MainTest {
    @Test()
    public void MainTest() {
        Main.main(new String[0]);
        Assert.assertTrue(true);
    }
}
