package net.bouzuya.junit;

import java.util.ArrayList;
import java.util.List;

public class StackImpl<T> implements Stack<T> {
	private final List<T> list;

	public StackImpl() {
		list = new ArrayList<T>();
	}

	public void push(T value) {
		list.add(value);
	}

	public T pop() {
		if (list.isEmpty())
			throw new IllegalStateException();
		return list.remove(list.size() - 1);
	}
}
