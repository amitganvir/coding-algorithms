package com.datastucture.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        generateCombination("(", 1, 0, n, resultList);
        return resultList;
    }

    private void generateCombination(String currentCombination, int numberOfOpeningBracketsUsed,
                                     int numberOfClosingBracketsUsed, int maxBrackets, List<String> resultList) {

        if (numberOfClosingBracketsUsed < numberOfOpeningBracketsUsed) {
            generateCombination(currentCombination + ")", numberOfOpeningBracketsUsed, numberOfClosingBracketsUsed + 1, maxBrackets, resultList);
        }

        if (numberOfOpeningBracketsUsed < maxBrackets) {
            generateCombination(currentCombination + "(", numberOfOpeningBracketsUsed + 1, numberOfClosingBracketsUsed, maxBrackets, resultList);
        }

        if (numberOfClosingBracketsUsed == maxBrackets && numberOfOpeningBracketsUsed == maxBrackets) {
            resultList.add(currentCombination);
        }
    }
}
