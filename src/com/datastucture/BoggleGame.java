package com.datastucture;

import java.util.*;

public class BoggleGame {

    public static void main(String[] args) {
        BoggleGame game = new BoggleGame();
        char[][] matrix = new char[][]{
                {'D', 'A', 'T', 'H'},
                {'C', 'G', 'O', 'A'},
                {'S', 'A', 'T', 'L'},
                {'B', 'E', 'D', 'G'}
        };

        List<String> strings = game.validWords(matrix, List.of("DATA", "HALO", "HALT", "SAG", "BEAT", "TOTAL", "GLOT", "DAG", "DOG", "DAGCD", "DOT"));
        System.out.println(strings.toString());
    }

    public List<String> validWords(char[][] matrix, List<String> dictionary) {
        List<String> validWords = new ArrayList<>();

        Map<Character, Map<String, Map<String, Character>>> trie = new HashMap<>();

        //Build a trie
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Character mainCharacter = matrix[i][j];
                String mainCharKey = i + ":" + j;
                returnValidCharacter(i, j - 1, matrix, mainCharKey, trie, mainCharacter);
                returnValidCharacter(i, j + 1, matrix, mainCharKey, trie, mainCharacter);
                returnValidCharacter(i - 1, j, matrix, mainCharKey, trie, mainCharacter);
                returnValidCharacter(i + 1, j, matrix, mainCharKey, trie, mainCharacter);
                returnValidCharacter(i - 1, j - 1, matrix, mainCharKey, trie, mainCharacter);
                returnValidCharacter(i - 1, j + 1, matrix, mainCharKey, trie, mainCharacter);
                returnValidCharacter(i + 1, j - 1, matrix, mainCharKey, trie, mainCharacter);
                returnValidCharacter(i + 1, j + 1, matrix, mainCharKey, trie, mainCharacter);
            }
        }

        for (String word: dictionary) {
            Map<String, Map<String, Character>> stringMapMap = trie.get(word.charAt(0));

            if (stringMapMap.isEmpty()) {
                continue;
            }

            Map<String, Map<String, Character>> map = trie.get(word.charAt(0));

            for (String key: map.keySet()) {
                Set<String> visited = new HashSet<>();
                visited.add(key);
                if (wordExists(word, map.get(key), trie, word.substring(0, 1), visited)) {
                    validWords.add(word);
                    break;
                }
            }
        }

        return validWords;
    }

    private boolean wordExists(String word,
                               Map<String, Character> children,
                               Map<Character, Map<String, Map<String, Character>>> trie,
                               String wordTillNow, Set<String> visited) {

        if (wordTillNow.length() >= word.length() && !word.equals(wordTillNow)) {
            return false;
        } else if (wordTillNow.equals(word)) {
            return true;
        }


        for (Map.Entry<String, Character> childEntry: children.entrySet()) {

            if (visited.contains(childEntry.getKey())) {
                continue;
            }

            Map<String, Map<String, Character>> stringMapMap = trie.get(childEntry.getValue());
            Map<String, Character> stringCharacterMap = stringMapMap.get(childEntry.getKey());

            if (stringCharacterMap == null ||  stringCharacterMap.isEmpty()) {
                continue;
            } else {
                visited.add(childEntry.getKey());
                if (wordExists(word, stringCharacterMap, trie, wordTillNow+childEntry.getValue().charValue(), visited)) {
                    return true;
                }
                visited.remove(childEntry.getKey());
            }
        }

        return false;
    }

    private void returnValidCharacter(int row, int col,
                                      char[][] matrix,
                                      String mainCharKey,
                                      Map<Character, Map<String, Map<String, Character>>> trie,
                                      Character mainCharacter) {

        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length) {
            return;
        }

        String mapKey = row + ":" + col;

        Character childChar = matrix[row][col];
        Map<String, Map<String, Character>> trieOrDefault = trie.getOrDefault(mainCharacter, new HashMap<>());

        if (trieOrDefault.isEmpty()) {
            Map<String, Map<String, Character>> innerMap = new HashMap<>();
            Map<String, Character> tempMap = new HashMap<>();
            tempMap.put(mapKey, childChar);
            innerMap.put(mainCharKey, tempMap);
            trie.put(mainCharacter, innerMap);
        } else {
            Map<String, Character> stringCharacterMap = trieOrDefault.getOrDefault(mainCharKey, new HashMap<>());
            if (stringCharacterMap.isEmpty()) {
                Map<String, Character> tempMap = new HashMap<>();
                tempMap.put(mapKey, childChar);
                trieOrDefault.put(mainCharKey, tempMap);
            } else {
                stringCharacterMap.put(mapKey, childChar);
            }
        }
    }
}
