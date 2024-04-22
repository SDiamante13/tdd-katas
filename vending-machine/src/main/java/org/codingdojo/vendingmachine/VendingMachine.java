package org.codingdojo.vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachine {

    private String display;
    private final List<Integer> coins;
    private final List<Integer> returns;
    private Integer balance;
    private final Integer[] acceptedCoins;

    public VendingMachine() {
        this(new ArrayList<>(), new ArrayList<>(), 0, new Integer[]{5, 10, 25});
    }

    public VendingMachine(List<Integer> coins, List<Integer> returns, Integer balance, Integer[] acceptedCoins) {
        this.coins = coins;
        this.returns = returns;
        this.balance = balance;
        this.acceptedCoins = acceptedCoins;
        this.display = formatBalance();
    }

    public void insertCoin(Integer coin) {
        if (Arrays.asList(acceptedCoins).contains(coin)) {
            this.coins.add(coin);
            this.balance += coin;
            this.display = formatBalance();
        } else {
            this.returns.add(coin);
        }
    }

    private String formatBalance() {
        return this.balance != 0 ?
                "$%.2f".formatted(this.balance/100.0) :
                "INSERT COIN";
    }

    public Integer balance() {
        return balance;
    }

    public Integer[] coins() {
        return coins.toArray(new Integer[0]);
    }

    public String display() {
        return display;
    }
}
