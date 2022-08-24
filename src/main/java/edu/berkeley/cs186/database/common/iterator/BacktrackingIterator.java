package edu.berkeley.cs186.database.common.iterator;

import java.util.Iterator;

/**
 * backtracking:回溯
 * A BacktrackingIterator supports marking a point in iteration, and resetting the
 * state of the iterator back to that mark. For example, if you had a backtracking
 * iterator with the values [1,2,3]:
 *
 * BackTrackingIterator<Integer> iter = new BackTrackingIteratorImplementation();
 * iter.next();     // returns 1
 * iter.next();     // returns 2
 * iter.markPrev(); // marks the previously returned value, 2
 * iter.next();     // returns 3
 * iter.hasNext();  // returns false
 * iter.reset();    // reset to the marked value (line 5)
 * iter.hasNext();  // returns true
 * iter.next();     // returns 2
 * iter.markNext(); // mark the value to be returned next, 3
 * iter.next();     // returns 3
 * iter.hasNext();  // returns false
 * iter.reset();    // reset to the marked value (line 11)
 * iter.hasNext();  // returns true
 * iter.next();     // returns 3
 */
public interface BacktrackingIterator<T> extends Iterator<T> {
    /**
     * markPrev() marks the last returned value of the iterator, which is the last
     * returned value of next().
     *
     * Calling markPrev() on an iterator that has not yielded a record yet,
     * or that has not yielded a record since the last reset() call does nothing.
     */
    void markPrev();

    /**
     * markNext() marks the next returned value of the iterator, which is the
     * value returned by the next call of next().
     *
     * Calling markNext() on an iterator that has no records left does nothing.
     */
    void markNext();

    /**
     * reset() 将迭代器重置到最后标记的位置。随后对 next() 的调用应返回被标记的值。
     * 如果没有任何标记，reset() 什么也不做。您可以根据需要多次 reset() 到同一点，直到设置新标记
     *
     * reset() resets the iterator to the last marked location. The subsequent
     * call to next() should return the value that was marked. If nothing has
     * been marked, reset() does nothing. You may reset() to the same point as
     * many times as desired until a new mark is set.
     */
    void reset();
}

