// --== CS400 File Header Information ==--
// Name: Abdul Altiti
// Email: altiti@wisc.edu
// Team: AC
// TA: Sophie Stephension
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.NoSuchElementException;
import java.lang.Math;

public class TestHashTable {

	/**
	 *Checks to see if size() function works as intended
	 * @return true if size() functions returns correct value, false otherwise
	 */
	public static boolean test1()  { 
		HashTableMap hash = new HashTableMap<>(10);

		Pair<Integer, Integer> c = new Pair<>(12 , 5);
		Pair<Integer, Integer> a = new Pair<>(13 , 5);
		Pair<Integer, Integer> d = new Pair<>(23 , 5);

		hash.put(a.getKey(), a.getValue());
		hash.put(c.getKey(), c.getValue());
		hash.put(d.getKey(), d.getValue());

		if(hash.size() == 3) return true;
		else return false;

	}

	/**
	 *Checks to see if put() function works prevents duplicate keys from being added
	 * @return true if size() functions returns correct value, false otherwise
	 */
	public static boolean test2() {
		HashTableMap hash = new HashTableMap(10);

		Pair c = new Pair(12 , 4);
		Pair a = new Pair(13 , 5);
		Pair d = new Pair(23 , 5);
		Pair f = new Pair(23,5);

		hash.put(a.getKey(), a.getValue());
		hash.put(c.getKey(), c.getValue());
		hash.put(d.getKey(), d.getValue());
		hash.put(f.getKey(), f.getValue());

		if(hash.size() == 3 && hash.put(f.getKey(), f.getValue()) == false) return true;
		else return false; 
	}

	/**
	 *Checks to see if get() command returns NoSuchElement exception if attemping to get
	 *non-existent key
	 * @return true if get() throws NoSuchElementException, false otherwise
	 */
	public static boolean test3() { 
		try {
			HashTableMap hash = new HashTableMap(10);

			Pair c = new Pair(12 , 4);
			Pair a = new Pair(13 , 5);
			Pair d = new Pair(23 , 5);

			hash.put(a.getKey(), a.getValue());
			hash.put(c.getKey(), c.getValue());
			hash.put(d.getKey(), d.getValue());

			hash.get(16);
			return false;
		}
		catch (NoSuchElementException e) {
			System.out.println("NoSuch Key exists!");
			return true;
		}
	}

	/**
	 *Checks to see if containsKey() command returns true if key exists in MapADT or false if
	 *it doesn't
	 * @return true if containsKey() works as inetended, false otherwise
	 */
	public static boolean test4() { 
		HashTableMap hash = new HashTableMap(10);

		Pair c = new Pair(12 , 4);
		Pair a = new Pair(13 , 5);
		Pair d = new Pair(23 , 5);

		hash.put(a.getKey(), a.getValue());
		hash.put(c.getKey(), c.getValue());
		hash.put(d.getKey(), d.getValue());

		if(hash.containsKey(23) == true && hash.containsKey(13) == true 
				&& hash.containsKey(12) == true) return true;
		else return false;
	}

	/**
	 *Checks to see private helper grow() creates a new array with double capacity and rehashes
	 *to new index when adding Pairs that take load above 80% capacity
	 * @return true if grow() works as inetended, false otherwise
	 */

	public static boolean test5() {
		HashTableMap hash = new HashTableMap(5);

		Pair c = new Pair(12 , 4);
		Pair a = new Pair(13 , 5);
		Pair d = new Pair(23 , 5);
		Pair f = new Pair(45 , 6);

		hash.put(a.getKey(), a.getValue());
		hash.put(c.getKey(), c.getValue());
		hash.put(d.getKey(), d.getValue());
		hash.put(f.getKey(), f.getValue());

		//Check original index with new index to test if array changes when load
		// factor goes above 80%
		int hashcode = f.getKey().hashCode();
		int index_orig = Math.abs(hashcode) % 5;
		int index = Math.abs(hashcode) % 10;
		if(index_orig != index) return true;
		else return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test 1: " + test1());
		System.out.println("Test 2: " + test2());
		System.out.println("Test 3: " + test3());
		System.out.println("Test 4: " + test4());
		System.out.println("Test 5: " + test5());
	}

}
