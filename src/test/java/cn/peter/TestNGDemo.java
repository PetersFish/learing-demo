package cn.peter;

import org.testng.annotations.*;

/**
 * @author Peter Yu 2018/8/30 17:24
 */
public class TestNGDemo {
    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }

    @Test(groups = { "fast" })
    public void aFastTest() {
        System.out.println("Fast test");
    }

    @Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println("Slow test");
    }

}
