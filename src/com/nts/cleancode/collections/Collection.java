package com.nts.cleancode.collections;

public interface Collection {
	public boolean isEmpty();
	public void add(Object element);
	public boolean remove(Object element);
	public boolean contains(Object element);
	public int size();
}
