package api.mal.tests;



import api.mal.models.DatasetDescriptionModel;
import io.restassured.response.Response;
import api.mal.models.DatasetLocationModel;
import api.mal.services.DatasetsService;
import api.mal.builders.Attribute;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
public class PrimaryTest extends BaseTest {
    @Test(groups = "test")
    public void dataProjectionQuery() {
        DatasetsService datasetsService = new DatasetsService(properties);
        String id = getDatasetId();
        checkDataLocation(datasetsService, "datasets/" + id + "/rows", "AdmArea","District","Location");
        checkDataDescription(datasetsService, "datasets/" + id + "/", "Caption","Description");
    }
    private void checkDataLocation(DatasetsService datasetsService, String path, String... fields) {
        RequestSpecification requestSpecification = datasetsService.request()
                .top(2)
                .orderBy("global_id")
                .getFields(fields)
                .build();

        DatasetLocationModel[] model = datasetsService.executeForLocation(requestSpecification,path);
        for (int i = 0; i < model.length; i++)
        {
            assertThat(model[i].getGlobalId(),notNullValue());
            assertThat(model[i].getNumber(),notNullValue());
        }
        assertThat(model[0].getGlobalId(),lessThan(model[1].getGlobalId()));
    }

    private void checkDataDescription(DatasetsService datasetsService, String path, String... fields) {
        RequestSpecification requestSpecification = datasetsService.request()
                .getFields(fields)
                .build();

        DatasetDescriptionModel model = datasetsService.executeForDescription(requestSpecification,path);
        assertThat(model.getCaption(),not(isEmptyOrNullString()));
        assertThat(model.getDescription(),not(isEmptyOrNullString()));
    }

    @Test(groups = "id")
    public void gettingDatasetId()
    {
        assertThat(getDatasetId(),not("null"));
    }


    private String getDatasetId()
    {
        DatasetsService datasetsService = new DatasetsService(properties);
        RequestSpecification requestSpecification = datasetsService.request()
                .attrubutesEq(new Attribute("CategoryId","21"),
                                new Attribute("Caption","'Данные передвижной лаборатории контроля загрязнения атмосферного воздуха'"))
                .getFields("Id")
                .build();
        Response response = datasetsService.executeRow(requestSpecification, "datasets");
        String id = response.getBody().jsonPath().getString("Id");
        id = id.substring(1,id.length()-1);
        return id;
    }
}
