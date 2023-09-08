package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class Horse {
    private String nameHorse;

    @Override
    public String toString() {
        return "Horse: " + nameHorse;
    }
}
