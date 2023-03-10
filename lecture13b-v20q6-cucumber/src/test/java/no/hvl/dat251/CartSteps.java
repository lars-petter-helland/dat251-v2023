package no.hvl.dat251;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {
    
    Cart cart;
    
    @Given("I have an empty cart")
    public void i_have_an_empty_cart() {
        cart = new Cart();
    }

    @When("I add a {string} with the price of {int} kr")
    public void i_add_a_item_with_the_price_of_kr(String name, int price) {
        cart.addItem(new Item(name, price));
    }

    @When("I add an {string} with the price of {int} kr")
    public void i_add_an_item_with_the_price_of_kr(String name, int price) {
        cart.addItem(new Item(name, price));
    }
    
    @Then("The number of {string}s should be {int}")
    public void the_number_of_items_of_this_type_should_be(String name, int number) {
        assertEquals(number, cart.numberOf(name));
    }

    @Then("The total for the {string}s should be {int}")
    public void the_total_for_the_bananas_should_be(String name, int total) {
        assertEquals(total, cart.totalFor(name));
    }

    @Then("The total for the cart should be {int}")
    public void the_total_for_the_cart_should_be(Integer total) {
        assertEquals(total, cart.total());
    }




}
