package api.mal.models;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties({"Cells"})
public class DatasetLocationModel {
    @JsonProperty(value = "global_id")
    private int globalId;
    @JsonProperty(value = "Number")
    private int number;

    public int getGlobalId() {
        return globalId;
    }

    public void setGlobalId(int globalId) {
        this.globalId = globalId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "DatasetLocationModel{" +
                "id=" + globalId +
                ", number='" + number + '\'' +
                '}';
    }
}
