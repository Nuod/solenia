package ru.dex.domain;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PogrebService {
    private final PogrobRepository pogrobRepository;

    public Pogreb getAnyPogreb() {
        Optional<Pogreb> pogreb = pogrobRepository.findAll().stream().findAny();
        return pogreb.orElseGet(this::generatePogreb);
    }

    private Pogreb generatePogreb() {
        Pogreb pogreb = new Pogreb();
        pogreb.generateSolenia();
        return pogreb;
    }
}
