package be.odisee.voorraadbeheer.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosoortAcceptanceTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testListAutosoorten() {
        driver.get("http://localhost:8080/autosoorten");
        // Voeg hier de asserties en interacties toe.
    }

    // Implementeer andere testmethoden voor CRUD operaties

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
