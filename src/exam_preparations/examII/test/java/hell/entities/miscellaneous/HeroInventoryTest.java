package exam_preparations.examII.test.java.hell.entities.miscellaneous;

import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Chilly on 20.12.2017 г..
 */
public class HeroInventoryTest {
    private Inventory inventory;

    @Before
    public void setUp() throws Exception {
        this.inventory = new HeroInventory();
        this.seedItems();
    }

    @Test
    public void getTotalStrengthBonus() throws Exception {
        // Arrange
        long expectedStrength = 5;
        // Act
        long actualStrengthBonus = this.inventory.getTotalStrengthBonus();
        //Assert
        Assert.assertEquals("Invalid strength total bonus sum", expectedStrength, actualStrengthBonus);
    }

    @Test
    public void getTotalAgilityBonus() throws Exception {
        // Arrange
        long expectedAgility = 5;
        // Act
        long actualAgilityBonus = this.inventory.getTotalAgilityBonus();
        //Assert
        Assert.assertEquals("Invalid agility total bonus sum", expectedAgility, actualAgilityBonus);
    }

    @Test
    public void getTotalIntelligenceBonus() throws Exception {
        // Arrange
        long expectedSIntelligence = 5;
        // Act
        long actualIntelligenceBonus = this.inventory.getTotalIntelligenceBonus();
        //Assert
        Assert.assertEquals("Invalid strength total bonus sum", expectedSIntelligence, actualIntelligenceBonus);
    }

    @Test
    public void getTotalHitPointsBonus() throws Exception {
        // Arrange
        long expectedHitPoints = 5;
        // Act
        long actualHitPoints = this.inventory.getTotalHitPointsBonus();
        //Assert
        Assert.assertEquals("Invalid strength total bonus sum", expectedHitPoints, actualHitPoints);
    }

    @Test
    public void getTotalDamageBonus() throws Exception {
        // Arrange
        long expectedDamage = 5;
        // Act
        long actualDamageBonus = this.inventory.getTotalDamageBonus();
        //Assert
        Assert.assertEquals("Invalid strength total bonus sum", expectedDamage, actualDamageBonus);
    }

    @Test
    @SuppressWarnings(value = "unchecked")
    public void addCommonItemAndTryToCreateNewCommonItem() throws Exception {
        // Arrange
        seedRecipeItem();
        Item testCommonMock = mock(Item.class);
        when(testCommonMock.getName()).thenReturn("testCommonItem");
        long expectedCommonItemsSize = 2;
        // Act
        this.inventory.addCommonItem(testCommonMock);
        Field commonItemsField = this.inventory.getClass().getDeclaredField("commonItems");
        commonItemsField.setAccessible(true);
        Map<String, Item> commonItems = (Map<String, Item>) commonItemsField.get(this.inventory);

        long actualCommonItemsSize = commonItems.size();
        //Assert
        Assert.assertEquals("invalid commonItems size", expectedCommonItemsSize, actualCommonItemsSize);
    }

    @Test
    @SuppressWarnings(value = "unchecked")
    public void addRecipeItem() throws Exception {
        // Arrange
        this.seedRecipeItem();
        Recipe testRecipeMock = mock(Recipe.class);
        long expectedRecipeItemsSize = 2;
        // Act
        this.inventory.addRecipeItem(testRecipeMock);

        Field recipeItemsField = this.inventory.getClass().getDeclaredField("recipeItems");
        recipeItemsField.setAccessible(true);
        Map<String, Recipe> recipeItems = (Map<String, Recipe>) recipeItemsField.get(this.inventory);
        int actualSize = recipeItems.size();
        //Assert
        Assert.assertEquals("invalid recipeItems size", expectedRecipeItemsSize, actualSize);
    }

    @SuppressWarnings(value = "unchecked")
    private void seedItems() throws NoSuchFieldException, IllegalAccessException {
        Field commonItemsFields = this.inventory.getClass().getDeclaredField("commonItems");
        commonItemsFields.setAccessible(true);
        Map<String, Item> commonItems = (Map<String, Item>) commonItemsFields.get(this.inventory);

        Item commonItemMock1 = mock(Item.class);
        when(commonItemMock1.getName()).thenReturn("commonItemMock1");
        when(commonItemMock1.getHitPointsBonus()).thenReturn(5);
        when(commonItemMock1.getAgilityBonus()).thenReturn(5);
        when(commonItemMock1.getDamageBonus()).thenReturn(5);
        when(commonItemMock1.getIntelligenceBonus()).thenReturn(5);
        when(commonItemMock1.getStrengthBonus()).thenReturn(5);

        Item commonItemMock2 = mock(Item.class);
        when(commonItemMock2.getName()).thenReturn("commonItemMock2");
        when(commonItemMock2.getHitPointsBonus()).thenReturn(-5);
        when(commonItemMock2.getAgilityBonus()).thenReturn(-5);
        when(commonItemMock2.getDamageBonus()).thenReturn(-5);
        when(commonItemMock2.getIntelligenceBonus()).thenReturn(-5);
        when(commonItemMock2.getStrengthBonus()).thenReturn(-5);

        Item commonItemMock3 = mock(Item.class);
        when(commonItemMock3.getName()).thenReturn("commonItemMock3");
        when(commonItemMock3.getHitPointsBonus()).thenReturn(5);
        when(commonItemMock3.getAgilityBonus()).thenReturn(5);
        when(commonItemMock3.getDamageBonus()).thenReturn(5);
        when(commonItemMock3.getIntelligenceBonus()).thenReturn(5);
        when(commonItemMock3.getStrengthBonus()).thenReturn(5);

        commonItems.put(commonItemMock1.getName(), commonItemMock1);
        commonItems.put(commonItemMock2.getName(), commonItemMock2);
        commonItems.put(commonItemMock3.getName(), commonItemMock3);
    }

    @SuppressWarnings(value = "unchecked")
    private void seedRecipeItem() throws NoSuchFieldException, IllegalAccessException {
        Field recipeItemsFields = this.inventory.getClass().getDeclaredField("recipeItems");
        recipeItemsFields.setAccessible(true);
        Map<String, Recipe> recipeItems = (Map<String, Recipe>) recipeItemsFields.get(this.inventory);

        Recipe recipeItemMock1 = mock(Recipe.class);
        when(recipeItemMock1.getName()).thenReturn("commonItemMock1");

        String[] requiredItems = new String[] {"commonItemMock1", "commonItemMock2", "commonItemMock3"};
        when(recipeItemMock1.getRequiredItems()).thenReturn(Arrays.asList(requiredItems));
        when(recipeItemMock1.getHitPointsBonus()).thenReturn(50);
        when(recipeItemMock1.getAgilityBonus()).thenReturn(50);
        when(recipeItemMock1.getDamageBonus()).thenReturn(50);
        when(recipeItemMock1.getIntelligenceBonus()).thenReturn(50);
        when(recipeItemMock1.getStrengthBonus()).thenReturn(50);

        recipeItems.put(recipeItemMock1.getName(), recipeItemMock1);
    }
}