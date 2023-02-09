package com.datastucture.binarysearch;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Optional;
import java.util.TreeMap;

public class TimeMap {

    private HashMap<String, TreeMap<Integer, String>> treeMap = new HashMap<>();
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap.get("foo", 1);         // return "bar"
        timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        timeMap.get("foo", 4);         // return "bar2"
        timeMap.get("foo", 5);         // return "bar2"
    }

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> treeMapOrDefault = treeMap.getOrDefault(key, new TreeMap<>());
        treeMapOrDefault.put(timestamp, value);
        treeMap.put(key, treeMapOrDefault);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> stringTreeMap = treeMap.get(key);

        if (stringTreeMap.containsKey(timestamp)) {
            return stringTreeMap.get(timestamp);
        }

        Optional<Integer> lastKey = stringTreeMap.descendingKeySet().stream().filter(timestampFilter -> timestampFilter <= timestamp).findFirst();

        return lastKey.isPresent() ? stringTreeMap.get(lastKey.get()) : "";
    }
}
