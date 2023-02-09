package com.datastucture.tries;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private TrieNode mainNode;

    public Trie() {
        mainNode = new TrieNode('*');
    }

    public void insert(String word) {

        TrieNode currentNode = mainNode;
        for (char currentChar : word.toCharArray()) {
            TrieNode trieNode = currentNode.hasCharacter(currentChar);
            if (trieNode == null) {
                currentNode.addCharacter(currentChar);
            }
            currentNode = currentNode.hasCharacter(currentChar);
        }
        if (currentNode != null) currentNode.addEndOfWordChar('.');
    }

    public boolean search(String word) {
        TrieNode currentNode = mainNode;
        for (char currentChar : word.toCharArray()) {
            TrieNode trieNode = currentNode.hasCharacter(currentChar);
            if (trieNode == null) return false;
            currentNode = trieNode;
        }

        if (currentNode != null) {
            return currentNode.hasCharacter('.') != null;
        }

        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = mainNode;
        for (char currentChar : prefix.toCharArray()) {
            TrieNode trieNode = currentNode.hasCharacter(currentChar);
            if (trieNode == null) return false;
            currentNode = trieNode;
        }

        return currentNode != null;
    }

    public static class TrieNode {
        private Character nodeCharacter;
        private Map<Character, TrieNode> nodeMap;

        public TrieNode(Character nodeCharacter) {
            this.nodeCharacter = nodeCharacter;
            this.nodeMap = new HashMap<>();
        }

        public TrieNode(Character nodeCharacter, Map<Character, TrieNode> nodeMap) {
            this.nodeCharacter = nodeCharacter;
            this.nodeMap = nodeMap;
        }

        public TrieNode addCharacter(Character character) {
            return nodeMap.put(character, new TrieNode(character));
        }

        public TrieNode hasCharacter(Character stringChar) {
            return nodeMap.get(stringChar);
        }

        public void addEndOfWordChar(char endOfWordChar) {
            nodeMap.put(endOfWordChar, new TrieNode(endOfWordChar, null));
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
