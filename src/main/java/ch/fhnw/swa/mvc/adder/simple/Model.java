package ch.fhnw.swa.mvc.adder.simple;

import java.util.ArrayList;
import java.util.List;

public final class Model {
	private int value1, value2, sumVal;
	private List<Listener> listeners = new ArrayList<>();

	public interface Listener {
		public void modelStateChanged();
	}

	public void addListener(Listener l) {
		listeners.add(l);
	}

	public void removeListener(Listener l) {
		listeners.remove(l);
	}

	public int getValue1() {
		return value1;
	}

	public void setValue1(int value1) {
		this.value1 = value1;
		update();
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
		update();
	}

	public int getSumVal() {
		return sumVal;
	}

	private void update() {
		int sum = value1 + value2;
		if (sum != sumVal) {
			sumVal = sum;
			for (Listener l : listeners.toArray(new Listener[listeners.size()])) {
				l.modelStateChanged();
			}
		}
	}
}
