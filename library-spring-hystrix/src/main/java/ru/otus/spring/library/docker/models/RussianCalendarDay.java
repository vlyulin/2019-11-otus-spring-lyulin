package ru.otus.spring.library.docker.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RussianCalendarDay {
    private boolean holiday;
    private Date date;
}
