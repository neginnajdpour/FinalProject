package mft.model.entity;

import com.google.gson.Gson;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class Borrow {
    private int id;
    private Member member;
    private Resource resource;
    private LocalDate issueDate;
    private LocalDate dueDate;

    @Override
    public java.lang.String toString() {
        return new Gson().toJson(this);
    }

}
