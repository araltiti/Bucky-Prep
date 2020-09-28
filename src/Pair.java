// --== CS400 File Header Information ==--
// Name: Abdul Altiti
// Email: altiti@wisc.edu
// Team: AC
// TA: Sophie Stephension
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

public class Pair<KeyType, ValueType> {

	private KeyType key;
	private ValueType value;
	private Pair<KeyType, ValueType> next;

	/**
	 * Constructor initializing pair with key and value
	 * @param key of Pair
	 * @param value of Pair
	 */
	public Pair(KeyType key, ValueType value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}

	/**
	 *Sets next pair object
	 * @param pair to set next
	 */
	public void setNext(Pair<KeyType, ValueType> pair) {
		this.next = pair;
	}

	/**
	 *Checks what the next Pair is
	 * @return the next Pair object
	 */
	public Pair<KeyType, ValueType> getNext(){
		return this.next;
	}

	/**
	 *Checks what the key is associated with pair
	 * @return key associated with pair
	 */
	public KeyType getKey() {
		return this.key;
	}

	/**
	 *Checks what the value is associated with pair
	 * @return value associated with pair
	 */
	public ValueType getValue() {
		return this.value;
	}

}
