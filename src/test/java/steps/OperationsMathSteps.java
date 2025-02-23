package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.datafaker.Faker;
import utilities.Logs;

public class OperationsMathSteps {

    private final Faker faker = new Faker();
    private int a, b, sum, product;
    private double aCubo, bCubo, aRoot, bRoot;
    @Given("The user generate two random values")
    public void generateValues() {
        a = faker.number().numberBetween(5,10);
        b = faker.number().numberBetween(5,10);

        Logs.info("Number generated for a: %d", a);
        Logs.info("Number generated for b: %d", b);
    }


    @When("The user adds both values")
    public void sumValues() {
        sum = a+b;
    }

    @Then("The user display sum in console")
    public void displaySum() {
        Logs.info("The result of sum is: %d ", sum);
    }

    @When("The user multiplies two values")
    public void productMultiplies() {
     product = a*b;
    }

    @Then("The user display product in console")
    public void displayProduct() {
        //Logs.info("The result of product is: %d ", product);
        System.out.println("The result of product is: " + product);
    }

    @When("The user cubes both values")
    public void cubesValues() {
        aCubo = Math.pow(a, 3);
        bCubo = Math.pow(b, 3);
    }

    @Then("The user display both powers in console")
    public void displayPowers() {
        System.out.println("The result of product A is: " + aCubo);
        System.out.println("The result of product B is: " + bCubo);
    }

    @When("The user make root square of both values")
    public void rootSquare() {
        aRoot = Math.sqrt(a);
        bRoot = Math.sqrt(b);
    }

    @Then("The user display both roots in console")
    public void displayRoot() {
        System.out.println("The result of root A is: " + aRoot);
        System.out.println("The result of root B is: " + bRoot);
    }

}
