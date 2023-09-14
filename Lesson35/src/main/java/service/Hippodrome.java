package service;

import config.Benchmark;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class Hippodrome {
    private final RunService runService;
    private final ClientService clientService;

    @Benchmark
    public void game() {
        runService.printMassageInfo();
        int pairNumber = clientService.getPairNumber();
        int bet = clientService.getBet();
        runService.run();
        runService.printMassageFinish();
        clientService.getClient().
                setResultWallet(bet, runService.isVictory(pairNumber));
        clientService.printMassageClient(bet, pairNumber);
    }
}
