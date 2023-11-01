# cd-warehouse

Test-drive some code that manages the stock and orders of a CD warehouse. Customers can buy CDs, searching on the title and the artist. Record labels send batches of CDs to the warehouse. Keep a stock count of how many copies of each title are in the warehouse. Customers can only order titles that are in stock. Use dependency injection to fake credit card payment processing, so we can get on with our CD warehouse design without worrying about how that will be done.

Customers can leave reviews for CDs they’ve bought through the warehouse, which gives each title an integer rating from 1- 10 and the text of their review if they want to say more.

As well as applying all of the ideas we’ve covered about TDD so far, make sure your code is:

* Working
* Easy to understand
* Has minimal duplication 
* Is as simple as possible

... and is made from classes that:

* Tell, don’t ask
* Have one distinct responsibility
* Can be composed from the outside 
* Expose client-specific interfaces
* Use contract tests for shared abstractions