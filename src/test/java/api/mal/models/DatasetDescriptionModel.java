package api.mal.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"Cells"})
public class DatasetDescriptionModel {
    @JsonProperty(value = "Caption")
    private String caption;
    @JsonProperty(value = "Description")
    private String description;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DatasetModel{" +
                "caption=" + caption +
                ", description='" + description + '\'' +
                '}';
    }
}
