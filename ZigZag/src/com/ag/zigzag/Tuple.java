package com.ag.zigzag;

public class Tuple<T, V> {

	public final T key;
	public final V value;
	
	public Tuple(T t, V v) {
		this.key = t;
		this.value = v;
	}
}
