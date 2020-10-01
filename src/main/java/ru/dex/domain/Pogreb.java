package ru.dex.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jeasy.random.EasyRandom;

@Entity
@Data
@Table(name = "pogreb")
@NoArgsConstructor
public class Pogreb {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany
    private Collection<Solenie> solenies;

    public Solenie getByTitle(String title) {
        Optional<Solenie> solenie = solenies.stream().filter(solenia -> solenia.getTitle().equalsIgnoreCase(title)).findAny();
        if (solenie.isPresent() && generator(0)) {
            return solenie.get();
        } else {
            try {
                foo(0);
            } catch (RuntimeException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public List<String> getTitlesOfSolenia() {
        return solenies.stream().map(Solenie::getTitle).collect(Collectors.toList());
    }


    public List<String> generateSolenia() {
        List<Solenie> solenies = new ArrayList<>();
        EasyRandom easyRandom = new EasyRandom();
        for (int i = 0; i < 72; i++) {
            solenies.add(easyRandom.nextObject(Solenie.class));
        }
        this.solenies = solenies;
        return solenies.stream().map(Solenie::getTitle).collect(Collectors.toList());
    }


    private boolean generator(int variant) {
        Random rnd = new Random();
        int nextInt = rnd.nextInt(100);
        switch (variant) {
            case 0: {
                return nextInt % 20 != 0;
            }
            case 1: {
                return nextInt != 69 && nextInt != 96;
            }
            default:
                throw new RuntimeException("read manual");
        }
    }

    private int foo(int integer) {
        if (integer == 100) {
            throw new RuntimeException("FUUUUUUUUUUUUUUUUUK!!!!!!!!!! JAR JAR BINGS");
        }
        integer++;
        return foo(integer);
    }
}