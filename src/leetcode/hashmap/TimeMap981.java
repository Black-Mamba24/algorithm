package leetcode.hashmap;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
 *
 * 1. set(string key, string value, int timestamp)
 *
 * 存储键 key、值 value，以及给定的时间戳 timestamp。
 * 2. get(string key, int timestamp)
 *
 * 返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。
 * 如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
 * 如果没有值，则返回空字符串（""）。
 * */
public class TimeMap981 {
    public static void main(String[] args) {
        TimeMap981 timeMap981 = new TimeMap981();
        timeMap981.set("love", "high", 10);
        timeMap981.set("love", "low", 20);
        System.out.println(timeMap981.get("love", 5));
        System.out.println(timeMap981.get("love", 10));
        System.out.println(timeMap981.get("love", 15));
        System.out.println(timeMap981.get("love", 20));
        System.out.println(timeMap981.get("love", 25));
    }

    int len = 10000;

    Item[] array;

    /** Initialize your data structure here. */
    public TimeMap981() {
        array = new Item[len];
    }

    public void set(String key, String value, int timestamp) {
        int index = Math.abs(key.hashCode() % len);
        if (array[index] == null) {
            array[index] = new Item(key, value, timestamp);
        } else {
            Item p = array[index];
            Item pre = null;
            while (p != null) {
                if (p.key.equals(key)) {
                    p.add(value, timestamp);
                    return;
                } else {
                    pre = p;
                    p = p.next;
                }
                pre.next = new Item(key, value, timestamp);
            }
        }
    }

    public String get(String key, int timestamp) {
        int index = Math.abs(key.hashCode() % len);
        if (array[index] == null) {
            return "";
        } else {
            Item p = array[index];
            while (p != null) {
                if (p.key.equals(key)) {
                    SortedMap<Integer, String> sub = p.sortedMap.headMap(timestamp + 1);
                    if (sub.isEmpty()) {
                        return "";
                    } else {
                        return sub.get(sub.lastKey());
                    }
                } else {
                    p = p.next;
                }
            }
            return "";
        }
    }

    class Item {
        String key;
        SortedMap<Integer, String> sortedMap;
        Item next;

        Item(String key, String value, int timestamp) {
            this.key = key;
            sortedMap = new TreeMap<>();
            sortedMap.put(timestamp, value);
        }

        void add(String value, int timestamp) {
            sortedMap.put(timestamp, value);
        }
    }
}
