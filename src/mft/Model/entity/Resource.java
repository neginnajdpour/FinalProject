package mft.Model.entity;

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

    private String ISBN;
    private ResourceType RESOURCE_TYPE;
    private String TITLE;
    private String EDITION;
    private String AUTHOR;
    private Category CATEGORY;
    private String PUBLISHER;
    private Language LANGUAGE;
    private int QUANTITY;
    private String DESCRIPTION;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
