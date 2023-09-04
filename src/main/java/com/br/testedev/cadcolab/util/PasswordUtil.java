package com.br.testedev.cadcolab.util;

import com.br.testedev.cadcolab.enums.ValidationType;

public class PasswordUtil {

	public static int calculateScore(String password) {
		int score = calculateAdditions(password) - calculateDeductions(password);
		
		
		return score;
	}
	
	public static int calculateAdditions(String password) {
		int passwordLength = password.length();
		int additions = passwordLength * 4;
		
		additions += ((passwordLength - StringUtil.count(password, ValidationType.UPPER_CASE)*2));
		additions += ((passwordLength - StringUtil.count(password, ValidationType.LOWER_CASE)*2));
		additions += StringUtil.count(password, ValidationType.NUMBER) * 4;
		additions += StringUtil.count(password, ValidationType.SYMBOL) * 6;
		
		if(password.length() > 2)
			additions += (StringUtil.count(password.substring(1, password.length()-1), ValidationType.SYMBOL) + StringUtil.count(password.substring(1, password.length()-1), ValidationType.LETTER)) * 2;
		
		additions += calculateRequirements(password) * 2;
		
		
		
		return additions;
	}
	
	public static int calculateDeductions(String password) {
		int deductions = 0;
		
		if(password.matches("[a-zA-Z]+")) {
			deductions += password.length();
		}
		
		if(password.matches("[0-9]+")) {
			deductions += password.length();
		}
		
		deductions += StringUtil.countRepeated(password, false);
		deductions += StringUtil.countRepeated(password, ValidationType.UPPER_CASE) * 2;
		deductions += StringUtil.countRepeated(password, ValidationType.LOWER_CASE) * 2;
		deductions += StringUtil.countRepeated(password, ValidationType.NUMBER) * 2;
		deductions += validateSequence(password, ValidationType.LETTER) * 3;
		deductions += validateSequence(password, ValidationType.NUMBER) * 3;
		deductions += validateSequence(password, ValidationType.SYMBOL) * 3;
		
		
		return deductions;
		
	}
	
	
	public static int calculateRequirements(String password) {
		int requirements = 0;
		
		if(password.length() >= 8) {
			requirements++;
		}
		
		if(password.matches("(.*)[a-z](.*)")) {
			requirements++;
		}
		
		if(password.matches("(.*)[A-Z](.*)")) {
			requirements++;
		}
		
		if(password.matches("(.*)[0-9](.*)")) {
			requirements++;
		}
		
		if(password.matches("(.*)[^A-Za-z0-9 ](.*)")) {
			requirements++;
		}
		
		return requirements;
	}
	
	public static int validateSequence(String password, ValidationType validation) {
		int occurrences = 0;
		
		for (int index = 0; index < password.length(); index++) {
			if(index >=2) {
				char character = password.charAt(index);
				char lower = password.charAt(index-1);
				char lowest = password.charAt(index-2);
				
				if(validation.equals(ValidationType.LETTER)) {
					if(Character.isLetter(character) && 
							Character.isLetter(lower) &&
								Character.isLetter(lowest)	) {
						if(character > lower && lower > lowest) {
							occurrences++;
						}
					}
				} else if(validation.equals(ValidationType.NUMBER)) {
					if(Character.isDigit(character) && 
							Character.isDigit(lower) &&
								Character.isDigit(lowest)	) {
						if(character > lower && lower > lowest) {
							occurrences++;
						}
					}
				} else if(validation.equals(ValidationType.SYMBOL)) {
					if((!Character.isDigit(character) && !Character.isLetter(character)) && 
							(!Character.isDigit(lower) && !Character.isLetter(lower)) &&
							(!Character.isDigit(lowest) && !Character.isLetter(lowest))	) {
						if(character > lower && lower > lowest) {
							occurrences++;
						}
					}
				}
			}
		}
		return occurrences;
	}
	
}
