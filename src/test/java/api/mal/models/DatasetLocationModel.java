package api.mal.models;

import com.fasterxml.jackson.annotation.*;
import java.util.Map;

public class DatasetLocationModel {
    @JsonProperty(value = "global_id")
    private int globalId;
    @JsonProperty(value = "Number")
    private int number;
    @JsonProperty(value = "Cells")
    private Map<String,String> cells;

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

    public Map<String,String> getCells() {
        return cells;
    }

    public void setCells(Map<String,String> cells) {
        this.cells = cells;
    }

    @Override
    public String toString() {
        return "DatasetLocationModel{" +
                "id=" + globalId +
                ", number='" + number + '\'' +
                ", admArea='" + cells.get("AdmArea") + '\'' +
                ", district='" + cells.get("District") + '\'' +
                ", location='" + cells.get("Location") + '\'' +
                '}';
    }
}
