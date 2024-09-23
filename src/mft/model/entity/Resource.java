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
    private int RESOURCE_ID;
    private String TITLE;
    private ResourceType RESOURCE_TYPE;
    private String SUBJECT;
    private Category CATEGORY;
    private int QUANTITY;
    private Integer ISBN;
    private String AUTHOR1;
    private String EDITION;
    private String CONTENT;
    private String PUBLISHER;
    private Language LANGUAGE;
    private int SERIES;
    private int COST;
    private String AUTHOR2;
    private Status STATUS;
    private String KEYWORD;






    private String DESCRIPTION;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
