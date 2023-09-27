import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"",1},
                {"",-1},
                {"",0},
                {"",(float)0.0001},
                {null,1},
                {null,-1},
                {null,0},
                {null, (float)0.0001},
                {"name",1},
                {"name",-1},
                {"name",0},
                {"name",(float)0.0001},
        };
    }

    @Test
    public void  differentParams() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
        Assert.assertEquals(price, bun.getPrice(), (float) 0.00001);
    }


}
