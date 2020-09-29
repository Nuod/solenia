package ru.dex.domain;

import java.util.concurrent.TimeUnit;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Demo {
    private final PogrebService pogrebService;

    @SneakyThrows
    public void start() {
        Pogreb anyPogreb = pogrebService.getAnyPogreb();
        anyPogreb.getTitlesOfSolenia().forEach(it -> {
            Solenie solenie = anyPogreb.getByTitle(it);
            System.out.println(solenie);
        });
        TimeUnit.SECONDS.sleep(3);
        throw new RuntimeException("(ノಠ益ಠ)ノ彡┻━┻");
    }
}
