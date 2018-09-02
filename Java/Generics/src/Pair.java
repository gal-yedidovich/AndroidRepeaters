public class Pair<T> {
	private T left, right;

	/**
	 * Setter
	 **/
	public void setLeft(T left) {
		this.left = left;
	}

	public void setRight(T right) {
		this.right = right;
	}

	/**
	 * Getter
	 **/
	public T getLeft() {
		return left;
	}

	public T getRight() {
		return right;
	}

	@Override
	public String toString() {
		return left + ", " + right;
	}
}
