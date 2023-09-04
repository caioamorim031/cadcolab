package com.br.testedev.cadcolab.util;

import java.util.HashSet;

import com.br.testedev.cadcolab.enums.ValidationType;

/**
 * This class was created to easily manipulate String values.
 * @author Caio Amorim
 *
 */
public class StringUtil {
	
	/**
	 * This method returns the number of occurrences that something appear in the string based on the validation type.
	 * 
	 * @param pString
	 * @param validation
	 * @return number of occurrences
	 */
	public static int count(String pString, ValidationType validation) {
		int occurrences = 0;
		for (int index = 0; index < pString.length(); index++) {
			
			if(validation.equals(ValidationType.UPPER_CASE)) {
				if(Character.isUpperCase(pString.charAt(index))) {
					occurrences++;
				}
			} else if(validation.equals(ValidationType.LOWER_CASE)) {
				if(Character.isLowerCase(pString.charAt(index))) {
					occurrences++;
				}
			} else if(validation.equals(ValidationType.NUMBER)) {
				if(Character.isDigit(pString.charAt(index))) {
					occurrences++;
				}
			} else if(validation.equals(ValidationType.SYMBOL)) {
				if(!Character.isLetter(pString.charAt(index)) &&
						!Character.isDigit(pString.charAt(index))) {
					occurrences++;
				}
			} else if(validation.equals(ValidationType.LETTER)) {
				if(Character.isLetter(pString.charAt(index))) {
					occurrences++;
				}
			} else {
				break;
			}
		}
		return occurrences;
	}
	
	/**
	 * Returns how many times every character is repeated in a string
	 * @param pString
	 * @param isCaseSensitive
	 * @return occurrences
	 */
	public static int countRepeated(String pString, boolean isCaseSensitive) {
		int occurrences = 0;
		HashSet<Character> characters = new HashSet<Character>();
		for (int index = 0; index < pString.length(); index++) {
			char character = pString.charAt(index);
			
			if(!characters.contains(character)) {
				if(Character.isLetter(character) && !isCaseSensitive) {
					characters.add(Character.toLowerCase(character));
					characters.add(Character.toUpperCase(character));
				} else {
					characters.add(character);
				}
				
			} else {
				occurrences++;
			}
			
		}
		return occurrences;
	}
	
	/**
	 * Returns how many times every character is repeated in a string
	 * @param pString
	 * @param validation
	 * @return occurrences
	 */
	public static int countRepeated(String pString, ValidationType validation) {
		int occurrences = 0;
		HashSet<Character> characters = new HashSet<Character>();
		for (int index = 0; index < pString.length(); index++) {
			char character = pString.charAt(index);
			if(validation.equals(ValidationType.UPPER_CASE)) {
				if(Character.isUpperCase(character)) {
					if(characters.contains(character)) {
						occurrences++;
					} else {
						characters.add(character);
					}
				}
			} else if(validation.equals(ValidationType.LOWER_CASE)) {
				if(Character.isLowerCase(character)) {
					if(characters.contains(character)) {
						occurrences++;
					} else {
						characters.add(character);
					}
				}
			} else if(validation.equals(ValidationType.NUMBER)) {
				if(Character.isDigit(character)) {
					if(characters.contains(character)) {
						occurrences++;
					} else {
						characters.add(character);
					}
				}
			} else {
				break;
			}
			
		}
		return occurrences;
	}
	
	
	public static boolean hasAny(String pString, ValidationType validation) {
		
		for (int index = 0; index < pString.length(); index++) {
			if(validation.equals(ValidationType.UPPER_CASE)) {
				if(Character.isUpperCase(pString.charAt(index))) {
					return true;
				}
			} else if(validation.equals(ValidationType.LOWER_CASE)) {
				if(Character.isLowerCase(pString.charAt(index))) {
					return true;
				}
			} else if(validation.equals(ValidationType.NUMBER)) {
				if(Character.isDigit(pString.charAt(index))) {
					return true;
				}
			} else if(validation.equals(ValidationType.SYMBOL)) {
				if(!Character.isLetter(pString.charAt(index)) &&
						!Character.isDigit(pString.charAt(index))) {
					return true;
				}
			} else if(validation.equals(ValidationType.LETTER)) {
				if(Character.isLetter(pString.charAt(index))) {
					return true;
				}
			}
		}
		return false;
	}
}
