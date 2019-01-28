package leetcode.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek() 操作的顶端迭代器 --
 * 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
 * Created by zhaiyi on 2019/1/27.
 */
class PeekingIterator implements Iterator<Integer> {
//普通解法，使用list
//    List<Integer> list = new ArrayList<>();
//    int head = 0;
//
//    public PeekingIterator(Iterator<Integer> iterator) {
//        // initialize any member here.
//        while (iterator.hasNext()) {
//            list.add(iterator.next());
//        }
//    }
//
//    // Returns the next element in the iteration without advancing the iterator.
//    public Integer peek() {
//        return list.get(head);
//    }
//
//    // hasNext() and next() should behave the same as in the Iterator interface.
//    // Override them if needed.
//    @Override
//    public Integer next() {
//        return list.get(head++);
//    }
//
//    @Override
//    public boolean hasNext() {
//        return head < list.size();
//    }
//最优解，用一个变量存放peek
    Integer peek = null;
    Iterator<Integer> it;

    public PeekingIterator(Iterator<Integer> iterator) {

        it = iterator;

    }

    public Integer peek() {

        if (peek == null && it.hasNext())
            peek = it.next();
        return peek;
    }

    public Integer next() {

        if (peek == null)
            return it.next();
        else {
            int temp = peek;
            peek = null;
            return temp;
        }
    }

    public boolean hasNext() {

        if (peek == null)
            return it.hasNext();
        return true;
    }
}
