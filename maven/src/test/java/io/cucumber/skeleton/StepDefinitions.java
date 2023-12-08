package io.cucumber.skeleton;

import java.util.List;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;
import java.lang.reflect.Type;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

class CukeLocation {
	public int count; 
	public String where; 
}
class Time {
	public int amount;
	public String measure; 
}

public class StepDefinitions {
// Below is needed to get transformation of field names to attributes
    private final ObjectMapper objectMapper = new ObjectMapper();
    @DefaultParameterTransformer
    @DefaultDataTableEntryTransformer
    @DefaultDataTableCellTransformer
    public Object transformer(Object fromValue, Type toValueType) {
        return objectMapper.convertValue(fromValue, objectMapper.constructType(toValueType));
    }

@Given("I have cukes")
public void i_have_cukes(List<CukeLocation> dataTable) {
	 for ( CukeLocation item : dataTable) {
		 System.out.println("Cukes " + item.count + " location " + item.where); 
	 }
	 }
@When("I wait")
// public void i_wait(io.cucumber.datatable.DataTable dataTable) {
public void i_wait(List<Time>dataTable) {
	 for ( Time item : dataTable) {
		 System.out.println("Cukes " + item.amount + " measure " + item.measure); 
	 }
 }

@Then("my belly should growl")
public void my_belly_should_growl() {
    System.out.println("Done");
}


}

