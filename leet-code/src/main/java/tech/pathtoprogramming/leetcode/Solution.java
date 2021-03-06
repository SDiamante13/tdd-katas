package tech.pathtoprogramming.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int[] shuffle(int[] nums, int n) {
        if (n == 0) return new int[0];
        int[] shuffledArray = new int[n * 2];
        shuffledArray[0] = nums[0];
        shuffledArray[nums.length - 1] = nums[nums.length - 1];
        int yPointer = n;
        int xPointer = 2;
        for (int index = 1, count = 1; index < nums.length - 2; index++, count++) {
            shuffledArray[index] = nums[yPointer];
            yPointer++;
            index++;
            shuffledArray[index] = nums[xPointer - count];
            xPointer += 2;
        }
        return shuffledArray;
    }

    public int[] finalPrices(int[] prices) {
        int[] finalPrices = new int[prices.length];
        List<Integer> pricesList = IntStream.of(prices).boxed().collect(Collectors.toList());
        for (int i = 0; i < prices.length; i++) {
            int currentPrice = pricesList.remove(0);
            finalPrices[i] = pricesList.stream()
                    .filter(price -> currentPrice >= price)
                    .findFirst()
                    .map(p -> currentPrice - p)
                    .orElse(currentPrice);
        }
        return finalPrices;
    }

    // #1496
    public boolean isPathCrossing(String path) {
        List<String> destinations = new ArrayList<>();
        String position = "0,0";
        String[] positionArray;
        destinations.add(position);
        for (char dir : path.toCharArray()) {
            positionArray = position.split(",");
            switch (dir) {
                case 'N':
                    position = positionArray[0] + "," + (Integer.parseInt(positionArray[1]) + 1);
                    break;
                case 'S':
                    position = positionArray[0] + "," + (Integer.parseInt(positionArray[1]) - 1);
                    break;
                case 'E':
                    position = (Integer.parseInt(positionArray[0]) + 1) + "," + positionArray[1];
                    break;
                case 'W':
                    position = (Integer.parseInt(positionArray[0]) - 1) + "," + positionArray[1];
                    break;
            }
            if (destinations.contains(position)) {
                return true;
            }
            destinations.add(position);
        }
        return false;
    }

    // July challenge #5
    public int hammingDistance(int x, int y) {
        return (int) Integer.toBinaryString(x ^ y).chars()
                .boxed()
                .map(Character::getNumericValue)
                .filter(number -> number == 1)
                .count();
    }

    // July challenge #1 // 5 is 2 rows // 1 2 3 4 5 6
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }

    // July challenge #6
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length];
        int i = digits.length - 1;
        int carry = 1;
        while (i >= 0) {
            if (digits[i] == 9 && (i == digits.length - 1 || carry == 1)) {
                result[i] = 0;
                carry = 1;
            } else {
                result[i] = digits[i] + carry;
                carry = 0;
            }
            i--;
            if (i == -1 && carry == 1) {
                List<Integer> integers = Arrays.stream(result).boxed().collect(Collectors.toList());
                integers.add(0, 1);
                result = integers.stream().mapToInt(num -> num).toArray();
            }
        }
        return result;
    }

    // July Challenge #7
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) count++;
            }
        }

        return 2 * count + 2;
    }

    // #38
    public String countAndSay(int n) {
        if (n <= 1) {
            return "1";
        }

        String lastResult = countAndSay(n - 1);
        String output = "";
        int count = 1;
        int i = 1;
        while (i < lastResult.length() + 1) {
            if (i < lastResult.length() && lastResult.charAt(i) == lastResult.charAt(i - 1)) {
                count++;
            } else {
                output += String.valueOf(count) + String.valueOf(lastResult.charAt(i - 1));
            }
            i++;
        }
        return output;
    }

    // #994 BFS optimize later, should be using Sets to store
    public int orangesRotting(int[][] grid) {
        // need to deal with -1 case
        int count = 0;

        int[][] newGrid = copyGrid(grid);

        while (!isFullyRotten(newGrid)) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1 && isRottenOrangeAdjacent(grid, i, j)) {
                        newGrid[i][j] = 2;
                    }
                }
            }
            if (areGridsEqual(grid, newGrid)) {
                return -1;
            }
            count++;
            grid = copyGrid(newGrid);
        }
        return count;
    }

    private boolean areGridsEqual(int[][] grid, int[][] newGrid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != newGrid[i][j]) return false;
            }
        }
        return true;
    }

    private int[][] copyGrid(int[][] grid) {
        int[][] copiedGrid = new int[grid.length][];
        for (int i = 0; i < grid.length; ++i) {
            copiedGrid[i] = new int[grid[i].length];
            System.arraycopy(grid[i], 0, copiedGrid[i], 0, copiedGrid[i].length);
        }
        return copiedGrid;
    }

    private boolean isRottenOrangeOnLeft(int[][] grid, int i, int j) {
        return j > 0 && grid[i][j - 1] == 2;
    }

    private boolean isRottenOrangeOnTop(int[][] grid, int i, int j) {
        return i > 0 && grid[i - 1][j] == 2;
    }

    private boolean isRottenOrangeOnRight(int[][] grid, int i, int j) {
        return j < grid[0].length - 1 && grid[i][j + 1] == 2;
    }

    private boolean isRottenOrangeOnBottom(int[][] grid, int i, int j) {
        return i < grid.length - 1 && grid[i + 1][j] == 2;
    }

    private boolean isRottenOrangeAdjacent(int[][] grid, int i, int j) {
        return isRottenOrangeOnLeft(grid, i, j) || isRottenOrangeOnTop(grid, i, j) || isRottenOrangeOnRight(grid, i, j) || isRottenOrangeOnBottom(grid, i, j);
    }

    private boolean isFullyRotten(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

}

