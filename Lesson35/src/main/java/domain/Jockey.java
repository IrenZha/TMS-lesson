package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class Jockey {
    private String nameJockey;

    @Override
    public String toString() {
        return "Jockey: " + nameJockey;
    }
}
