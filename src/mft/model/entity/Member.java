package mft.model.entity;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Member {
    private Integer nationalID;
    private String FirstName;
    private String LastName;
    private Date dateOfBirth;
    private Gender Gender;
    private boolean active;
    private String PhoneNumber;
    private String Email;
    private String AddressLine1;
    private String AddressLine2;
    private String City;
    private String State;
    private String Country;
    private String Postalcode;
    private String Photo;
    private Date JoinDate;

    @Override
    public java.lang.String toString() {
        return new Gson().toJson(this);
    }
}
