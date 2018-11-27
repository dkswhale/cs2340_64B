package cs2340_64b.com.cs2340_project;

import org.junit.Before;
import org.junit.Test;
import static cs2340_64b.com.cs2340_project.model.Type.DROP_OFF;
import static cs2340_64b.com.cs2340_project.model.Type.STORE;
import static cs2340_64b.com.cs2340_project.model.Type.WAREHOUSE;
import static cs2340_64b.com.cs2340_project.model.Type.type;
import static junit.framework.TestCase.assertEquals;

public class TypeTest {

    private String type;

    @Before
    public void dropOffSetUp() { type = "Drop Off"; }
    @Test
    public void testDropOff() {
        assertEquals(type(type), DROP_OFF);
    }

    @Before
    public void storeSetUp() { type = "Store"; }
    @Test
    public void testStore() {
        assertEquals(type(type), STORE);
    }

    @Before
    public void warehouseSetUp() { type = "Warehouse"; }
    @Test
    public void testWarehouse() {
        assertEquals(type(type), WAREHOUSE);
    }
}