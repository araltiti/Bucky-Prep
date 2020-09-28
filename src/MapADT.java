// --== CS400 File Header Information ==--
// Name: Abdul Altiti
// Email: altiti@wisc.edu
// Team: AC
// TA: Sophie Stephension
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.NoSuchElementException;

public interface MapADT<KeyType, ValueType> {

	/**
	 * Adds a Pair to the MapADT. Prohibits duplicate keys from being added
	 * @param key value which is used to hash the pair into the MapADT
	 * @param value which contains information pertaining to the key
	 * @return true if a pair is succesfully added, return false if 
	 * attempting to add duplicate key
	 */
	public boolean put(KeyType key, ValueType value);  

	/**
	 * Retrieves the value associated with a key from the MapADT
	 * @param key associated with the value
	 * @return value assoicated with provided key
	 * @throws NoSuchElementException when the Pair associated with given key doesn't exist.
	 */
	public ValueType get(KeyType key) throws NoSuchElementException; 

	/**
	 * Returns the number of pairs in the MapADT
	 * @return size of the MapADT
	 */
	public int size(); 

	/**
	 *Checks to see if a Pair associated with given key exists
	 * @param key associated with Pair trying to find
	 * @return true if Pair is found, false otherwise
	 */
	public boolean containsKey(KeyType key);   

	/**
	 * Removes a pair associated with the given key from the MapADT.
	 * @return value associated with given key
	 */
	public ValueType remove(KeyType key);  

	/**
	 * Emptys the array and removes all Pairs
	 */
	public void clear();

}
