package api.mal.services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import api.mal.builders.DatasetRequestBuilder;
import api.mal.models.*;
import java.util.Properties;

public class DatasetsService extends BaseService{
    public DatasetsService(Properties properties) {
        super(properties);
    }

    public DatasetRequestBuilder request() {
        return new DatasetRequestBuilder(baseRequest());
    }

    public DatasetLocationModel[] executeForLocation(RequestSpecification requestSpecification, String path) {
        return requestSpecification.post(path).then()
                .extract()
                .body().as(DatasetLocationModel[].class);
    }

    public DatasetDescriptionModel executeForDescription(RequestSpecification requestSpecification, String path) {
        return requestSpecification.post(path).then()
                .extract()
                .body().as(DatasetDescriptionModel.class);
    }

    public Response executeRow(RequestSpecification requestSpecification, String path) {
        return requestSpecification.post(path);
    }
}
