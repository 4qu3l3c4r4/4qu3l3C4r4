Feature: Automated - Examples 



# The first example has two steps
@Test1 
Scenario: Google place 
	Given user is on Home Page 
	Then he search for "Cucumber - Automação framework automação - O2M" 
	

# The second example has two steps
@Test2 
Scenario Outline: Google place 
	Given user is on Home Page 
	Then he search for "<param>"
	
Examples:
	|param						    |
	|Automação framework automação 1|
	|Automação framework automação 2|
	|Automação framework automação 3|