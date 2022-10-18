package basicRestAssured;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class CreateProjectTest {

    /**
     * given() ---> configuracion
     * when() ---> metodo de peticion que usaremos : put(url), get(url), method
     * then() ---> cuando respuesta ---> verificaciones
     * -- log /verificacion / extraccion
     */

    @Test
    public void verifyCreateProject(){
        given()
                .auth()
                .preemptive()
                .basic("ucb2022@ucb2022.com","12345")
                .body("{\n" +
                        "  \"Content\":\"Janeth\",\n" +
                        "  \"Icon\":4\n" +
                        "}")
                .log().all()
        .when()
                .post("https://todo.ly/api/projects.json")
        .then()
                .log().all();

    }

    @Test
    public void verifyCreateProjectJSONObject(){
        JSONObject body = new JSONObject();
        body.put("Content","JanethJSON");
        body.put("Icon",1);
        given()
                .auth()
                .preemptive()
                .basic("ucb2022@ucb2022.com","12345")
                .body(body.toString())
                .log().all()
        .when()
                .post("https://todo.ly/api/projects.json")
                .then()
                .log().all();

    }

    @Test
    public void verifyCreateProjectJSONFile(){
        String jsonFile = new File("").getAbsolutePath()+"/src/test/resources/createProject.json";
        JSONObject body = new JSONObject();
        given()
                .auth()
                .preemptive()
                .basic("ucb2022@ucb2022.com","12345")
                .body(new File(jsonFile))
                .log().all()
        .when()
                .post("https://todo.ly/api/projects.json")
                .then()
                .log().all();

    }


}
