package stringWeights;

import java.util.Set;
import java.util.TreeSet;

public class WeightedStrings {

	private Set<String> setOfStrings;
	private final int requiredWeight;

	/**
	 * Create a WeightedStrings object that will hold Strings of the specified
	 * "weight"
	 * 
	 * @param weight
	 *            0 <= weight < 1013
	 * @throws IllegalArgumentException
	 *             if the argument violates requirements.
	 */
	public WeightedStrings(int weight) throws IllegalArgumentException {
		if (weight >= 0 && weight < 1013) {
			this.requiredWeight = weight;
			this.setOfStrings = new TreeSet<String>();
		} else {
			throw new IllegalArgumentException("Error: The weight is not within the required range.");
		}
	}

	/**
	 * Create a WeightedStrings object using the given array of Strings. All Strings
	 * should be of the same weight and the array should not be empty otherwise an
	 * IllegalArgumentException should be thrown.
	 * 
	 * @param strArray
	 *            strArray.length > 0 and all Strings in this array should have the
	 *            same "weight"
	 * @throws IllegalArgumentException
	 *             if the input arguments do not satisfy the requirements
	 */
	public WeightedStrings(String[] strArray) throws IllegalArgumentException {
		this.setOfStrings = new TreeSet<String>();
		this.requiredWeight = getStringWeight(strArray[0]);

		for (String eachString : strArray) {
			if (getStringWeight(eachString) == requiredWeight) {
				setOfStrings.add(eachString);
			} else {
				throw new IllegalArgumentException("Error: All strings are not of the same length.");
			}
		}
	}

	/**
	 * Compute the "weight" of a given String. The weight is computed as the sum
	 * over i in [0, str.length()-1] of (i+1)*(weight of character at position i)
	 * modulo 1013 for all characters that are alphabets and other characters are
	 * ignored. The weight of a character is its ASCII value: weight(A) = 65,
	 * weight(B) = 66, ..., weight(Z) = 90, and weight(a) = 97, ..., weight(z) =
	 * 122.
	 * 
	 * @param str
	 *            is not null
	 * @return weight of the given string
	 */
	public static int getStringWeight(String str) {
		int strWeight = 0;

		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i)) == true) {
				strWeight = (strWeight + (i + 1) * str.charAt(i));
			}
		}
		strWeight = strWeight % 1013;
		return strWeight;
	}

	/**
	 * Add a new String to the WeightedStrings object. The new string should have
	 * the same weight as other strings in this collection. Adding the same String
	 * multiple times makes no difference when compared with adding that String
	 * once.
	 * 
	 * @param str
	 *            to add to WeightedStrings. It should not be null and its weight
	 *            should match the weight of other Strings in this object.
	 * @returns true if str was added to this object (matches weight) and false
	 *          otherwise.
	 */
	public boolean add(String str) {
		if (getStringWeight(str) == this.requiredWeight) {
			this.setOfStrings.add(str);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Compare two WeightedString objects. Two WeightedString objects are equal if
	 * they contain the same Strings. Note, as with the add() method, that adding
	 * the same string multiple times has no impact on equality relative to adding
	 * the string once.
	 * 
	 */
	@Override
	public boolean equals(Object other) {
		if (this.hashCode() == other.hashCode()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		// Struggling to implement hashCode.
		return (int) (100 * Math.random());
	}

	/**
	 * Verify if two WeightedStrings are equivalent. Two WeightedStrings are
	 * equivalent if they are intended to contain Strings of the same weight even if
	 * the actual strings they contain are different. One of the WeightedStrings may
	 * not even contain any strings; only its weight may be set but that is
	 * sufficient to perform the equivalence test.
	 * 
	 * @param other
	 * @return true if the other WeightedString is equivalent to this.
	 */
	public boolean equivalent(WeightedStrings other) {
		if (this.requiredWeight == other.requiredWeight) {
			return true;
		}
		return false;
	}

}