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
        this("", new ArrayList<>(), new ArrayList<>(), 0, new Integer[]{5, 10, 25});
    }

    public VendingMachine(String display, List<Integer> coins, List<Integer> returns, Integer balance, Integer[] acceptedCoins) {
        this.display = display;
        this.coins = coins;
        this.returns = returns;
        this.balance = balance;
        this.acceptedCoins = acceptedCoins;

        displayBalance();
    }

    private void displayBalance() {
        this.display = this.balance != 0 ?
                formatAsDollars(this.balance) :
                "INSERT COIN";
    }

    private String formatAsDollars(int cents) {
        return "$" + cents / 100.0;
    }

    public void insertCoin(Integer coin) {
        if (Arrays.asList(acceptedCoins).contains(coin)) {
            this.coins.add(coin);
            this.balance += coin;
            this.displayBalance();
        } else {
            this.returns.add(coin);
        }
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
