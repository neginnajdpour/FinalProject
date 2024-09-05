package mft.Model.entity;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Member {
    private String memberID;
    private String FirstName;
    private String LastName;
    private String PhoneNumber;
    private String Email;
    private MemberAddress Address;
    private String Photo;

    @Override
    public java.lang.String toString() {
        return new Gson().toJson(this);
    }
}
