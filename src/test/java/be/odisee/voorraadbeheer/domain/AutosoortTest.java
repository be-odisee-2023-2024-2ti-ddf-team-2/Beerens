package be.odisee.voorraadbeheer.domain;

import be.odisee.ti2.se4.timesheet.controllers.HomeController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class AutosoortTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void home()  throws Exception {

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(content().string(containsString("Welcome to Timesheet")))
        ;
    }

    /**
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
    **/
}
