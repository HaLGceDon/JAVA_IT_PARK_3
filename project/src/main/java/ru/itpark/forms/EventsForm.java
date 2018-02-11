package ru.itpark.forms;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EventsForm {
    private Long id;
    private String name;
    private String text;
    private String date;
}
