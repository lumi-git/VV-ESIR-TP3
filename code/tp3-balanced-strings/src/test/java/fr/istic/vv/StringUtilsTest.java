package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
 
  //create tests for the App.isBalanced method
  @Test
  public void testIsBalanced() {
    String s = "((()))";
    boolean expResult = true;
    boolean result = App.isBalanced(s);
    assertEquals(expResult, result);
  }

  //test with all symbols

  @Test
  public void testIsBalanced_AllSymbols() {

    String s = "(([]{}))";
    boolean expResult = true;
    boolean result = App.isBalanced(s);
    assertEquals(expResult, result);
  }

  //test with all symbols and extra symbols

  @Test
  public void testIsBalanced_allSymbolsAndExtraSymbols() {

    String s = "(([]{}))a";
    boolean expResult = true;
    boolean result = App.isBalanced(s);
    assertEquals(expResult, result);
  }

  //test with two symbols

  @Test
  public void testIsBalanced4() {

    String s = "(([]{}))a";
    boolean expResult = true;
    boolean result = App.isBalanced(s);
    assertEquals(expResult, result);
  }

  //test with only brackets

  @Test
  public void testIsBalanced5() {

    String s = "(([]{}))";
    boolean expResult = true;
    boolean result = App.isBalanced(s);
    assertEquals(expResult, result);
  }

  //test with opposite fermeture

  @Test
  public void testIsBalanced6() {
    String s = ")([]{})(";
    boolean expResult = false;
    boolean result = App.isBalanced(s);
    assertEquals(expResult, result);
  }


  @Test
  public void testIsBalancedFirstCroché() {
    String s = "]([]{})(";
    boolean expResult = false;
    boolean result = App.isBalanced(s);
    assertEquals(expResult, result);
  }


  //test with empty string

  @Test
  public void testIsBalanced7() {

    String s = "";
    boolean expResult = true;
    boolean result = App.isBalanced(s);
    assertEquals(expResult, result);
  }

  //test with only text

  @Test
  public void testIsBalanced8_() {

    String s = "hello";
    boolean expResult = true;
    boolean result = App.isBalanced(s);
    assertEquals(expResult, result);
  }


  //test with only opening brackets

  @Test
  public void testIsBalanced9() {
    System.out.println("9test of isBalanced");
    String s = "([{";
    boolean expResult = false;
    boolean result = App.isBalanced(s);
    assertEquals(expResult, result);
  }


}