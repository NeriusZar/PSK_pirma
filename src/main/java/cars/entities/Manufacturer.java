package cars.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Manufacturer.findAll", query = "select a from Manufacturer as a")
})

@Table(name = "MANUFACTURER")
@Getter
@Setter
public class Manufacturer {
    public Manufacturer(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "manufacturer")
    private List<Model> carParts = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer model = (Manufacturer) o;
        return Objects.equals(name, model.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
