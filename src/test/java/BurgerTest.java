import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    public Bun bun;
    @Mock
    public Ingredient firstIngredient;
    @Mock
    public Ingredient secondIngredient;
    @Mock
    public Ingredient thirdIngredient;
    private final float BUN_PRICE = (float) 1;
    private final float FIRST_INGREDIENT_PRICE = (float) 2;
    private final float SECOND_INGREDIENT_PRICE = (float) 3;
    private final float THIRD_INGREDIENT_PRICE = (float) 4;
    private final String FIRST_INGREDIENT_NAME = "first ingredient name";
    private final String SECOND_INGREDIENT_NAME = "second ingredient name";
    private final String THIRD_INGREDIENT_NAME = "thrid ingredient name";
    private final String BUN_NAME = "bun name";

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);
        Mockito.when(firstIngredient.getPrice()).thenReturn(FIRST_INGREDIENT_PRICE);
        Mockito.when(secondIngredient.getPrice()).thenReturn(SECOND_INGREDIENT_PRICE);
        Mockito.when(thirdIngredient.getPrice()).thenReturn(THIRD_INGREDIENT_PRICE);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Assert.assertEquals(
                BUN_PRICE * 2
                        + FIRST_INGREDIENT_PRICE
                        + SECOND_INGREDIENT_PRICE
                        + THIRD_INGREDIENT_PRICE, burger.getPrice(), (float) 0.00001);
        Mockito.verify(bun, Mockito.times(1)).getPrice();
        Mockito.verify(firstIngredient, Mockito.times(1)).getPrice();
        Mockito.verify(secondIngredient, Mockito.times(1)).getPrice();
        Mockito.verify(thirdIngredient, Mockito.times(1)).getPrice();
    }

    @Test
    public void emptyBurger() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        String receipt = "(==== " + BUN_NAME + " ====)"+ System.lineSeparator() +
                "(==== " + BUN_NAME + " ====)"+ System.lineSeparator() +
                System.lineSeparator() +
                "Price: " + String.format("%f", BUN_PRICE * 2) + System.lineSeparator();
        Assert.assertEquals(receipt, burger.getReceipt());
        Mockito.verify(bun, Mockito.times(1)).getPrice();
        Mockito.verify(bun, Mockito.times(2)).getName();

    }

    @Test
    public void fullBurger() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);
        Mockito.when(firstIngredient.getPrice()).thenReturn(FIRST_INGREDIENT_PRICE);
        Mockito.when(secondIngredient.getPrice()).thenReturn(SECOND_INGREDIENT_PRICE);
        Mockito.when(thirdIngredient.getPrice()).thenReturn(THIRD_INGREDIENT_PRICE);
        Mockito.when(firstIngredient.getName()).thenReturn(FIRST_INGREDIENT_NAME);
        Mockito.when(secondIngredient.getName()).thenReturn(SECOND_INGREDIENT_NAME);
        Mockito.when(thirdIngredient.getName()).thenReturn(THIRD_INGREDIENT_NAME);
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(thirdIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        String receipt = "(==== " + BUN_NAME + " ====)"+ System.lineSeparator() +
                "= " + IngredientType.SAUCE.toString().toLowerCase() + " " + FIRST_INGREDIENT_NAME + " ="+ System.lineSeparator() +
                "= " + IngredientType.FILLING.toString().toLowerCase() + " " + SECOND_INGREDIENT_NAME + " ="+ System.lineSeparator() +
                "= " + IngredientType.SAUCE.toString().toLowerCase() + " " + THIRD_INGREDIENT_NAME + " ="+ System.lineSeparator() +
                "(==== " + BUN_NAME + " ====)"+ System.lineSeparator() +
                System.lineSeparator() +
                "Price: " + String.format("%f", BUN_PRICE * 2
                + FIRST_INGREDIENT_PRICE
                + SECOND_INGREDIENT_PRICE
                + THIRD_INGREDIENT_PRICE) + System.lineSeparator();
        Assert.assertEquals(receipt, burger.getReceipt());
        burger.removeIngredient(0);
        burger.moveIngredient(0,1);
        receipt = "(==== " + BUN_NAME + " ====)"+ System.lineSeparator() +
                "= " + IngredientType.SAUCE.toString().toLowerCase() + " " + THIRD_INGREDIENT_NAME + " ="+ System.lineSeparator() +
                "= " + IngredientType.FILLING.toString().toLowerCase() + " " + SECOND_INGREDIENT_NAME + " ="+ System.lineSeparator() +
                "(==== " + BUN_NAME + " ====)"+ System.lineSeparator() +
                System.lineSeparator() +
                "Price: " + String.format("%f", BUN_PRICE * 2
                + SECOND_INGREDIENT_PRICE
                + THIRD_INGREDIENT_PRICE) + System.lineSeparator();
        Assert.assertEquals(receipt, burger.getReceipt());
        Mockito.verify(bun, Mockito.times(2)).getPrice();
        Mockito.verify(bun, Mockito.times(4)).getName();
        Mockito.verify(firstIngredient, Mockito.times(1)).getPrice();
        Mockito.verify(secondIngredient, Mockito.times(2)).getPrice();
        Mockito.verify(thirdIngredient, Mockito.times(2)).getPrice();
        Mockito.verify(firstIngredient, Mockito.times(1)).getName();
        Mockito.verify(secondIngredient, Mockito.times(2)).getName();
        Mockito.verify(thirdIngredient, Mockito.times(2)).getName();
        Mockito.verify(firstIngredient, Mockito.times(1)).getType();
        Mockito.verify(secondIngredient, Mockito.times(2)).getType();
        Mockito.verify(thirdIngredient, Mockito.times(2)).getType();
    }

}
