import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    public IngredientType type;
    public String name;
    public float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {IngredientType.FILLING, "", 1},
                {IngredientType.FILLING, "", -1},
                {IngredientType.FILLING, "", 0},
                {IngredientType.FILLING, "", (float) 0.0001},
                {IngredientType.FILLING, null, 1},
                {IngredientType.FILLING, null, -1},
                {IngredientType.FILLING, null, 0},
                {IngredientType.FILLING, null, (float) 0.0001},
                {IngredientType.FILLING, "name", 1},
                {IngredientType.FILLING, "name", -1},
                {IngredientType.FILLING, "name", 0},
                {IngredientType.FILLING, "name", (float) 0.0001},
                {IngredientType.SAUCE, "", 1},
                {IngredientType.SAUCE, "", -1},
                {IngredientType.SAUCE, "", 0},
                {IngredientType.SAUCE, "", (float) 0.0001},
                {IngredientType.SAUCE, null, 1},
                {IngredientType.SAUCE, null, -1},
                {IngredientType.SAUCE, null, 0},
                {IngredientType.SAUCE, null, (float) 0.0001},
                {IngredientType.SAUCE, "name", 1},
                {IngredientType.SAUCE, "name", -1},
                {IngredientType.SAUCE, "name", 0},
                {IngredientType.SAUCE, "name", (float) 0.0001},
        };
    }

    @Test
    public void differentParams() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
        Assert.assertEquals(name, ingredient.getName());
        Assert.assertEquals(price, ingredient.getPrice(), (float) 0.00001);
    }

}
