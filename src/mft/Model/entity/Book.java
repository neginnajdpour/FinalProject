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

public class Book {
    private int BOOK_ID;
    private String TITLE;
    private String EDITION;
    private String AUTHOR;
    private String GENRE;
    private String PUBLISHER;
    private String PUBLISHED_YEAR;
    private int AVAILABLE_COPIES;
    private String BDESCRIPTION;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
