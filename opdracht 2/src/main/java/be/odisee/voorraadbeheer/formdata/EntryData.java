package be.odisee.voorraadbeheer.formdata;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class EntryData {

    // id is needed for updating
    private long id=0;

    @NotBlank(message="Date must be specified ")
    private String entryDatum;

    @NotBlank(message="Time must be specified ")
    private String startTime, endTime;

    private long[] projectIds;
    private long objectiveId;

    @NotBlank(message="Description must be filled in ")
    private String description;
}
