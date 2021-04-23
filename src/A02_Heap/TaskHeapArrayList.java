package A02_Heap;

import java.util.ArrayList;

public class TaskHeapArrayList {

	/**
	 * Internes Task-Array für den Heap
	 * Ansonsten keine anderen Variablen verwenden!
	 */
	private ArrayList<Task> tasks;

	/**
	 * Konstruktor
	 */
	public TaskHeapArrayList() {
		tasks = new ArrayList<Task>();
		tasks.add(null);	// Erstes Element ist dummy-Element, damit Index bei 1 anfängt
	}

	/**
	 * Neuen Task in den Heap einfügen
	 * @param t Einzufügender Task
	 */
	public void insert(Task t) {
		// TODO: Your implementation
		tasks.add(t);
		swim(tasks.size() - 1);
	}

	/**
	 * Das oberste Element (mit kleinster Priorität entfernen)
	 * @return Task mit kleinster Priorität
	 */
	public Task remove() {
		// TODO: Your implementation
		Task result;
		int last = tasks.size() - 1;
		if (last == 0) {	// nur noch Dummy-Element enthalten
			return null;
		}

		result = tasks.get(1);
		tasks.set(1, tasks.get(last));
		tasks.remove(last);
		sink(1);
		return result;
	}

	private void swim(int pos) {
		// TODO: Your implementation of swim
	}

	private void sink(int pos) {
		// TODO: Your implementation of sink
	}

	private int parent(int pos) {
		return pos / 2;
	}

	private int left(int pos) {
		return pos * 2;
	}

	private int right(int pos) {
		return (pos * 2) + 1;
	}

	private boolean exists(int pos) {
		return (pos < tasks.size() && pos > 0);
	}

	private int prio(int pos) {
		return tasks.get(pos).getPriority();
	}

	private void exchange(int pos1, int pos2) {
		Task temp;
		temp = tasks.get(pos1);
		tasks.set(pos1, tasks.get(pos2));
		tasks.set(pos2, temp);
	}

	private boolean hasChildren(int pos) {
		return exists(left(pos));
	}

	private int minChild(int pos) {
		int min, l, r;
		l = left(pos);
		r = right(pos);
		min = l;
		if (exists(r) && prio(r) < prio(l)) {
			min = r;
		}
		return min;
	}

}
