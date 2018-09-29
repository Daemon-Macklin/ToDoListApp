package sample.Test;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import sample.User;

import static org.junit.Assert.*;

/**
 * Test for User Class
 *
 * @author Daemon-Macklin
 *
 */

public class UserTest {

    private User user1;
    private User userInvalid;


    /**
     * Set up test fixtures
     *
     * Called before every test method
     */
    @Before
    public void setUp() {
        user1 = new User ("Joe Blogs", "Ilikecake");
        userInvalid = new User("thelimitforthenamevariableis30ANYTHINGINCAPSSHOULDBECUTOFF", "Something with a space");
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
        assertNotNull(user1); //will test these in testGetters()
        assertEquals("thelimitforthenamevariableis30", userInvalid.getName());
        assertEquals("Somethingwithaspace", userInvalid.getPassword());
    }

    /**
     * Test all getters using valid data
     */
    @Test
    public void testGetters() {
        assertEquals("Joe Blogs", user1.getName());
        assertEquals("Ilikecake", user1.getPassword());
    }

    /**
     * Test all setters for Bed
     */
    @Test
    public void testSetters() {
        user1.setName("Joey Blogs"); //Valid change
        assertEquals("Joey Blogs", user1.getName());
    }
}
