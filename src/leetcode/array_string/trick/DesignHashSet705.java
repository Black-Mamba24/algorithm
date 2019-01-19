package leetcode.array_string.trick;

public class DesignHashSet705 {
    // 声明一个数组用于存放数据
    private int[] dataSet = new int[1000005];

    public void add(int key) {
        if (key != 0) {
            dataSet[key] = key;
        } else {
            dataSet[key] = -1;
        }
    }

    public void remove(int key) {
        dataSet[key] = 0;
    }

    public boolean contains(int key) {
        // 由于我们的判断是否包含该数据的依据是该数据是否等于0
        // 0 是Java中数组中元素的默认值
        // 所以此处需要区别对待
        if (key != 0) {
            return dataSet[key] != 0;
        } else {
            return dataSet[key] == -1;
        }
    }
}
