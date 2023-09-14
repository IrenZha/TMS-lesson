package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Horse {
    private String nameHorse;

    @Override
    public String toString() {
        return "Horse: " + nameHorse;
    }
}
