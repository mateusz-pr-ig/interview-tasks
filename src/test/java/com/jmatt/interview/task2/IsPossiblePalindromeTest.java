package com.jmatt.interview.task2;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//Write the program using Java 8 features like streams to check if the word can be palindrome. Characters in words can be swapped. Examples
public class IsPossiblePalindromeTest {

  @Test
  public void isPalindromePossible() throws Exception {
    Assertions.assertTrue(IsPossiblePalindrome.check("oonn"));
    Assertions.assertFalse(IsPossiblePalindrome.check("abc"));
    Assertions.assertTrue(IsPossiblePalindrome.check("abcab"));
  }

}