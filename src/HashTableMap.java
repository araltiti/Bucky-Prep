// --== CS400 File Header Information ==--
// Name: Abdul Altiti
// Email: altiti@wisc.edu
// Team: AC
// TA: Sophie Stephenson
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.NoSuchElementException;
import java.lang.Math;

public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
	private int capacity;
	private int load;
	private int size;
	private Pair<KeyType, ValueType>[] array;

	/**
	 * Default Constructor initializes the array and size
	 */
	public HashTableMap() {
		this.capacity = 10;
		this.size = 0;
		this.load = size/capacity;
		this.array = new Pair[this.capacity];
	}

	/**
	 * Initializes the array and size
	 * @param Capacity of the array
	 */
	public HashTableMap(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.load = size/capacity;
		this.array = new Pair[capacity];
	}

	/* (non-Javadoc)
	 * @see MapADT#put()
	 */
	public boolean put(KeyType key, ValueType value) {
		if(containsKey(key)) return false;

		if(this.load >= 80) grow();

		Pair<KeyType, ValueType> pair = new Pair<>(key,value);
		int hash = key.hashCode();	
		int index = Math.abs(hash) % this.capacity;

		//Check to see if there is a list at the index, if no then assign Pair to that index
		if(array[index] == null) {
			array[index] = pair;
			this.load = ++size*100/capacity;
		}
		else {
			Pair<KeyType, ValueType> curr = array[index];

			while(curr.getNext() != null) {
				curr = curr.getNext();

			}
			curr.setNext(pair);
			this.load = ++size*100/capacity;
		}	

		return true;	
	}

	/* (non-Javadoc)
	 * @see MapADT#get()
	 */
	public ValueType get(KeyType key) throws NoSuchElementException{

		if(!containsKey(key)) throw new NoSuchElementException();

		int hash = key.hashCode();
		int index = Math.abs(hash) % this.capacity;

		//Checks to see if first Pair in list contains key
		if(array[index].getKey().equals(key)) {return array[index].getValue();}
		else {
			Pair<KeyType,ValueType> curr = array[index];
			while(!curr.getKey().equals(key)) {
				curr = curr.getNext();
			}
			return curr.getValue();
		}
	}

	/* (non-Javadoc)
	 * @see MapADT#size()
	 */
	public int size() {
		return this.size;
	}

	/* (non-Javadoc)
	 * @see MapADT#containsKey()
	 */
	public boolean containsKey(KeyType key) {
		int hash = key.hashCode();
		int index = Math.abs(hash) % this.capacity;

		//If nothing is there then key doesn't exist
		if(array[index] == null) return false;

		//Checks to see if first Pair contains key
		if(array[index].getKey().equals(key)) return true;
		//Checks to see if there even is a list at the index or just one pair
		else if(array[index].getNext() == null) return false;
		else {
			Pair<KeyType, ValueType> curr = array[index];

			while(curr.getNext() != null) {
				curr = curr.getNext();
				if(curr.getKey().equals(key)) {return true;}
			}

			return false;
		}
	}

	/* (non-Javadoc)
	 * @see MapADT#remove()
	 */
	public ValueType remove(KeyType key) {
		if(!containsKey(key)) return null;

		int hash = key.hashCode();
		int index = Math.abs(hash) % this.capacity;

		Pair<KeyType, ValueType> curr = array[index];
		Pair<KeyType, ValueType> prev = null;

		//Case 1: Check first node
		if(curr.getKey().equals(key)) {
			array[index] = curr.getNext();
			this.load = --size*100/capacity;
		}

		//Case 2 Traverse List until key is found
		while(curr.getNext() != null) {
			prev = curr;
			curr = curr.getNext();

			if(curr.getKey().equals(key)) {
				prev.setNext(curr.getNext());
				this.load = --size*100/capacity;
				return curr.getValue();
			}

		}
		return null;
	}

	/* (non-Javadoc)
	 * @see MapADT#clear()
	 */
	public void clear() {
		this.array =  new Pair[this.capacity];
		this.size = 0;
	}

	/**
	 * Doubles the capacity of the array and rehases Pairs to new indexes if 
	 * load capacity reaches 80% or greater in original array
	 */
	private void grow() {

		//Update capacity by multiplying it to two
		this.capacity *= 2;

		Pair<KeyType, ValueType>[] tmparray =  new Pair[this.capacity];
		//Traverse each list in original array
		for(Pair<KeyType, ValueType> p: array) { 
			if(p != null) {
				int hash = p.getKey().hashCode();
				int index = Math.abs(hash) % this.capacity;
				tmparray[index] = p;
			}
		}
		array = tmparray;
	}
}
