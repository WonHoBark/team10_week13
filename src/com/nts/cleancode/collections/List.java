package com.nts.cleancode.collections;

public class List extends AbstractCollection {
	private Object[] elements = new Object[10];
	private int size = 0;
	private boolean readOnly;

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(Object element) {
		if (readOnly)
			return;
		
		if (shouldGrow())
			grow();
			
		addElement(element);
	}

	protected Object addElement(Object element) {
		return elements[size++] = element;
	}

	protected boolean shouldGrow() {
		return size + 1 > elements.length;
	}

	protected void grow() {
		Object[] newElements =
			new Object[elements.length + 10];
		for (int i = 0; i < size; i++)
			newElements[i] = elements[i];
		elements = newElements;
	}

	public boolean contains(Object element) {
		for (int i=0; i<size; i++) 
			if (elements[i].equals(element))
				return true;
		return false;
	}

	public int size() {
		return size;
	}

	public boolean remove(Object element) {
		if (readOnly)
			return false;
		else 	
			for (int i = 0; i < size; i++)
				if (elements[i].equals(element)) {
					elements[i] = null;
					Object[] newElements = new Object[size - 1];
					int k = 0;
					for (int j = 0; j < size; j++) {
						if (elements[j] != null)
							newElements[k++] = elements[j];
					}
					size--;
					elements = newElements;
					return true;
				}
		return false;
	}
	
	public Object get(int i) {
		return elements[i];
	}

	public int capacity() {
		return elements.length;
	}

	public void set(int i, Object value) {
		if (!readOnly) {
			if (i >= size)
				throw new ArrayIndexOutOfBoundsException();
			elements[i] = value;
		}
	}

	public void setReadOnly(boolean b) {
		readOnly = b;
	}
}
