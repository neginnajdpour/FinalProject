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
    private int RESOURCE_ID;
    private String ISBN;
    private String RESOURCE_TYPE;
    private String TITLE;
    private String EDITION;
    private String AUTHOR;
    private String CATEGORY;
    private String PUBLISHER;
    private String LANGUAGE;
    private int QUANTITY;
    private String DESCRIPTION;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
