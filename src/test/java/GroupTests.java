import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


@Listeners(LogListener.class)
public class GroupTests extends InitTest {

    RequestSpecification rspec;
    JsonPath jsonPathEvaluator;

    @BeforeClass
    public void beforeClass() {
        InitRestAssured init = new InitRestAssured();
        init.setBaseUri();
        rspec = init.setRequestSpecGroup();
    }

    @Test
    public void first() {
        given().spec(rspec).when().get("").then()
                .assertThat().body(matchesJsonSchemaInClasspath("statusSchema.json"));

//        Response response = given().spec(rspec).when().get("");
//        jsonPathEvaluator = response.jsonPath();
//        jsonPathEvaluator.get("data.name");
//        Assert.assertEquals(jsonPathEvaluator.get("data.name"), "Неречевые упражнения, Речевые упражнения");


    }

    @Test
    public void second() {
        given().spec(rspec).when().get("").then()
                .assertThat().body("data.name[0]", equalTo("Неречевые упражнения"));
    }
}
