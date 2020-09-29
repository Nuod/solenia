package ru.dex.domain;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.dex.app.enums.Ingredients;

@Entity
@Data
@Table(name = "solenie")
@NoArgsConstructor
@ToString(exclude = "id")
public class Solenie {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    @ElementCollection
    private List<Ingredients> ingredients;

}
