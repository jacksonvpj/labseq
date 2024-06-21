package altice.lab

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class LabSeqResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
            .`when`().get("/labseq/0")
            .then()
            .statusCode(200)
            .body(`is`("0"))
    }

}