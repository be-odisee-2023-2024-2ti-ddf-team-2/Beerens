package be.odisee.voorraadbeheer.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutosoortDTO {
    private int id;
    private String status;
    private String naam;
    private String merk;
    private int huidigVoorraadniveau;
    private int minimumpeiler;
    private int maximumpeiler;
    private boolean verkooptSlecht;
}