package api.mal.models;

import com.fasterxml.jackson.annotation.JsonProperty;

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
        return "DatasetDescriptionModel{" +
                "caption=" + caption +
                ", description='" + description + '\'' +
                '}';
    }
}
