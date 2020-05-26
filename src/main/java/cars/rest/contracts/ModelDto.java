package cars.rest.contracts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelDto {
    private String name;
    private Integer manufacturerId;
}
