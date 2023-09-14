package service;

import domain.Client;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Data
@Service
public class ClientService {
    Scanner scanner = new Scanner(System.in);
    Client client;

    public ClientService(Client client) {
        this.client = client;
    }

    public int getBet() {
        System.out.println("Place a bet");
        int bet = scanner.nextInt();
        while (bet < 1 || client.getWallet() < bet) {
            System.out.println("Incorrect amount! Place a bet");
            bet = scanner.nextInt();
        }
        return bet;
    }

    public int getPairNumber() {
        System.out.println("Choose a pair number from 1 to 3");
        int pairNumber = scanner.nextInt();
        while (pairNumber < 1 || pairNumber > 3) {
            System.out.println("Invalid number! Choose a pair number from 1 to 3");
            pairNumber = scanner.nextInt();
        }
        return pairNumber;
    }

    public void printMassageClient(int bet, int pairNumber) {
        System.out.println("Pair number:  " + pairNumber + ", Bet: " + bet + ", Wallet: " + client.getWallet());
    }
}
