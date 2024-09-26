package mft.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Borrow {
    private int id;
    private Member member;
    private Resource resource;
    private LocalDateTime issueDate;
    private LocalDateTime dueDate;
}
