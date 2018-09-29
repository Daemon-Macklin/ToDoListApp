package sample.Test;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import sample.Activity;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Test for Activity Class
 *
 * @author Daemon-Macklin
 *
 */

public class ActivityTest {

    private Activity activity1;
    private Activity activityInvalid;


    /**
     * Set up test fixtures
     *
     * Called before every test method
     */
    @Before
    public void setUp() {
        activity1 = new Activity ("Walk", LocalDate.of(2018,9,29), "Go for a nice relaxing walk");
        activityInvalid = new Activity("thelimitforthenamevariableis30ANYTHINGINCAPSSHOULDBECUTOFF", LocalDate.of(2018,8,29), "thelimitforthedescriptionvariableis40!!!ANYTHINGINCAPSSHOULDBECUTOFF");
    }

    /**
     * Teardown test fixtures
     *
     * Called after each test method
     */
    @After
    public void tearDown() {

    }

    /**
     * Test the contsructor
     */
    @Test
    public void testConstructor() {
        assertNotNull(activity1); //will test these in testGetters()
        assertFalse(activity1.getFinished());
        assertEquals(LocalDate.now(), activity1.getDateStarted());
        assertEquals("thelimitforthenamevariableis30", activityInvalid.getName());
        assertEquals("thelimitforthedescriptionvariableis40!!!", activityInvalid.getDescription());
    }

    /**
     * Test all getters using valid data
     */
    @Test
    public void testGetters() {
        assertEquals("Walk", activity1.getName());
        assertEquals("Go for a nice relaxing walk", activity1.getDescription());

    }

    /**
     * Test all setters for Bed
     */
    @Test
    public void testSetters() {
        assertFalse(activity1.getFinished());
        activity1.setFinished(true); //Valid change
        assertTrue(activity1.getFinished());
    }
}

