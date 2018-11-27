package cs2340_64b.com.cs2340_project;

import org.junit.Before;
import org.junit.Test;

import static cs2340_64b.com.cs2340_project.model.DonationCategory.donationCategory;
import static junit.framework.TestCase.assertEquals;

@SuppressWarnings("ALL")
public class DonationCategoryTest {

    private String category;

    @Before
    public void createClothingCategory() {
        category = "Clothing";
    }
    @Test
    public void testClothingCategory() {
        assertEquals(donationCategory(category), "Clothing");
    }

    @Before
    public void createHatCategory() {
        category = "Hat";
    }
    @Test
    public void testHatCategory() {
        assertEquals(donationCategory(category), "Hat");
    }

    @Before
    public void createKitchenCategory() {
        category = "Kitchen";
    }
    @Test
    public void testKitchenCategory() {
        assertEquals(donationCategory(category), "Kitchen");
    }

    @Before
    public void createElectronicsCategory() {
        category = "Electronics";
    }
    @Test
    public void testElectronicsCategory() {
        assertEquals(donationCategory(category), "Electronics");
    }

    @Before
    public void createHouseHoldCategory() {
        category = "HouseHold";
    }
    @Test
    public void testHouseHoldCategory() {
        assertEquals(donationCategory(category), "HouseHold");
    }

    @Before
    public void createOtherCategory() {
        category = "Other";
    }
    @Test
    public void testOtherCategory() {
        assertEquals(donationCategory(category), "Other");
    }
}
