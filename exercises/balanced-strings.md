# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
public static boolean isBalanced(String str) {
    ...
}
```

`isBalanced` returns `true` if `str` is balanced according to the rules explained above. Otherwise, it returns `false`.

Use the coverage criteria studied in classes as follows:

1. Use input space partitioning to design an initial set of inputs. Explain below the characteristics and partition blocks you identified.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written so far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Write below the actions you took on each step and the results you obtained.
Use the project in [tp3-balanced-strings](../code/tp3-balanced-strings) to complete this exercise.

## Answer

1 - principals cases :

- a void string 

- a only text string

- not the good order of brackets

- no enclosed parenthesis


2 - coverage with eclipse (pass everywhere in the function)
class test used can be found at :
> code/tp3-balanced-strings/src/test/java/fr/istic/vv/StringUtilsTest?java

to do this, we just implemented tests that will pass to a way unpassed by others tests, in a way to increment coverage

the test class bellow, cover 100% of the code according to the statment coverage



3 - logic coverage

the only statment concerned in our methode is :

```java
if (l == '(' || l == '{' || l == '[') 
```

we have only 4 cases to test to have all cases of this methode :


> l = '('
or
l = '{'
or
l = '['


4 - 



