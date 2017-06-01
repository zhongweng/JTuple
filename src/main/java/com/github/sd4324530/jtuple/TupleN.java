package com.github.sd4324530.jtuple;

import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * 表示有N个元素的元组类型
 * 可迭代
 * 不可变，线程安全
 *
 * @author peiyu
 */
public final class TupleN extends Tuple {

    private TupleN(final Object... args) {
        super(args);
    }

    @Override
    public TupleN swap() {
        final int size = this.size();
        final Object[] array = new Object[size];
        this.forEachWithIndex((index, obj) -> array[size - 1 - index] = obj);
        return TupleN.with(array);
    }

    public static TupleN with(final Object... args) {
        requireNonNull(args, "args is null");
        return new TupleN(args);
    }

    public static TupleN withList(final List<Object> list) {
        requireNonNull(list, "list is null");
        return TupleN.with(list.toArray());
    }
}
