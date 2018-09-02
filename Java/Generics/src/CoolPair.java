public class CoolPair<T, R> {
	private T left;
	private R right;

	/**
	 * Setter
	 **/
	public void setLeft(T left) {
		this.left = left;
	}

	public void setRight(R right) {
		this.right = right;
	}

	/**
	 * Getter
	 **/
	public T getLeft() {
		return left;
	}

	public R getRight() {
		return right;
	}

	@Override
	public String toString() {
		return left + ", " + right;
	}
}
