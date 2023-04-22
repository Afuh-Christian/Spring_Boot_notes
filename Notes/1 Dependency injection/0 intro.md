If you intantiate a class e.g qaulification inside another class e.g doctor ... 
Everytime we get a doctor , we get a qualification ... this is tight coupling , and is not good for  large projects ... 

- We should be able to instantiate docker and qualification differently 

- we will use Dependency injection for this ... 

# Advantage 
- Makes the application loosely coupled 
- Facilitates unit testing since we can test them differently 



# Dependency injection ... 
- Creates a reference graph for a class so we don't have to use the new keyword everytime ..



# Dependency injection methods .... 
- via xml configuration 
- via anotation base configuration
- via java configuration 
