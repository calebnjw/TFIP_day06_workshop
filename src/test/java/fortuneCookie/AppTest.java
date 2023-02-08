package fortuneCookie;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.fortuneCookie.server.Cookie;

/**
 * Unit test for simple App.
 */
public class AppTest {
    // initialise variables that will run in the @Before
    List<String> cookies;

    @Before // define things that will run before tests
    public void init() {
        cookies = Cookie.getCookiesFromFile("cookies.txt");
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testCookieRandomCookie() {
        assertTrue(cookies != null);
    }

    @Test
    public void testCookieListLength() {
        assertTrue(cookies.size() == 27);
    }
}
