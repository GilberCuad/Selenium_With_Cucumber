package hooks;

import io.cucumber.java.*;
import utilities.Logs;

public class Hooks {
    @BeforeAll
    public static void beforeAll() {
        Logs.info("se ejecuta el info");
        System.out.println("Executing beforeAll");
    }

    @AfterAll
    public static void afterAll() {
        Logs.info("Executing afterAll");
        System.out.println("Executing afterAll");
    }

  @Before
  public static void before(Scenario scenario) {
      Logs.info("Executing before: %s", scenario.getName());
  }


    @After
    public static void after(Scenario scenario) {
        Logs.info("Executing before finalized of scenario: %s, status: %s", scenario.getName(), scenario.getStatus());
    }
}
