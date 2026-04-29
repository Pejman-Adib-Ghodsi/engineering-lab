package be.computershop.computershopapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ToString.Include
    @Column(nullable = false, unique = true)
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

    public Category(String name) {
        this.name = name;
    }
}
