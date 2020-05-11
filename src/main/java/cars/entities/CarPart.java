package cars.entities;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "CarPart.findAll", query = "select a from CarPart as a")
})
@Table(name = "CARPART")
@Getter @Setter
public class CarPart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "carParts")
    private List<Model> models = new ArrayList<>();

    public CarPart() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPart carPart = (CarPart) o;
        return Objects.equals(id, carPart.id) &&
                Objects.equals(name, carPart.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
