package zam.dev.restapirelasi.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Supplier implements Serializable {

    @Id
    @Column(unique = true )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( length = 64)
    private String name;

    @Column()
    private String address;


    @Column(unique = true  , length = 64)
    private String email;

    /*
    membuat relasi many to many , dengan product
    supplier menyuplai banyak product dan product juga bisa di supplai banyak supplier
     */
    @ManyToMany(mappedBy = "suppliers")
    private Set<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Supplier supplier = (Supplier) o;
        return id != null && Objects.equals(id, supplier.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
