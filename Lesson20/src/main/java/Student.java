import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private boolean is_man;
    private Integer city_id;
}
