import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;



public class InitRestAssured {

    static RequestSpecification rspec;
    static RequestSpecBuilder build;


    public void setBaseUri() {
        RestAssured.baseURI = InitTest.baseUri;
        System.out.println(InitTest.baseUri);
    }

    public RequestSpecification setRequestSpecGroup() {
        build = new RequestSpecBuilder();
        build.setBasePath("api/groups");
        build.setContentType(ContentType.JSON);
        rspec = build.build();

        return  rspec;
    }
}
