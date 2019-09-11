# cat-sfds

Thank you for your time reviewing! A couple notes as your get started:
* I have a lot to learn for frontend implementation! I intentionally kept the frontend basic, and focused on displaying my backend capability. I would look forward to learning more about accessibility, responsive design, and all other things frontend.
* There is a branch called `separate-response-objects-from-domain-object` that describes a refactor I would like to do to better separate our application's domain from Socrata's response formats.
* With more time, I would refactor the fields I am fetching from Socrata to be more meaningful to the user. This represents a first pass to get everything wired together.

This application fetches data from the [DataSF portal](https://data.sfgov.org/Housing-and-Buildings/Mayor-s-Office-of-Housing-and-Community-Developmen/9rdx-httc) and displays it in a more accessible way.

## Developer Setup
### Running the application
The base files for this code came from Pivotal's tutorial about how to serve webcontent using spring boot. You can see the original repository [here](https://github.com/spring-guides/gs-serving-web-content) and the tutorial [here](https://spring.io/guides/gs/serving-web-content/#initial)

To run this application, from root directory you can run `./gradlew bootRun`. This will have the application running on `localhost:8080`

### Running the tests
To run the associated tests from the command line, run `./gradlew test`

## Documentation of Note
The Socrata API docs are [here](https://dev.socrata.com/foundry/data.sfgov.org/9rdx-httc)