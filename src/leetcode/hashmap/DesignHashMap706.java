package leetcode.hashmap;

import java.util.ArrayList;
import java.util.List;

public class DesignHashMap706 {
    class MyHashMap {
        int len = 1000;
        ArrayList<Item>[] array = new ArrayList[len];

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {

        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            int index = key % len;
            if (array[index] == null) {
                ArrayList<Item> list = new ArrayList<>();
                list.add(new Item(key, value));
                array[index] = list;
            } else {
                ArrayList<Item> list = array[index];
                for (Item item : list) {
                    if (item.key == key) {
                        item.value = value;
                        return;
                    }
                }
                list.add(new Item(key, value));
            }
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            int index = key % len;
            if (array[index] == null) {
                return -1;
            } else {
                ArrayList<Item> list = array[index];
                for (Item item : list) {
                    if (item.key == key) {
                        return item.value;
                    }
                }
                return -1;
            }
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            int index = key % len;
            if (array[index] != null) {
                ArrayList<Item> list = array[index];
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).key == key) {
                        list.remove(i);
                        return;
                    }
                }
            }
        }
    }

    class Item {
        int key;
        int value;

        public Item(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
