package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Jockey {
    private String nameJockey;

    @Override
    public String toString() {
        return "Jockey: " + nameJockey;
    }
}
