package mft.Model.entity;

import com.google.gson.Gson;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Profile {

    private String username;
    private String password;
    private String name;
    private String family;
    private int active;

    public String toString() {
        return new Gson().toJson(this);
    }
}
