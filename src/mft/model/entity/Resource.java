package mft.model.entity;

import com.google.gson.Gson;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString

public class Resource {

    private Integer ISBN;
    private mft.model.entity.ResourceType RESOURCE_TYPE;
    private String title;
    private String EDITION;
    private String AUTHOR;
    private mft.model.entity.Category CATEGORY;
    private String PUBLISHER;
    private mft.model.entity.Language LANGUAGE;
    private int QUANTITY;
    private String DESCRIPTION;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
