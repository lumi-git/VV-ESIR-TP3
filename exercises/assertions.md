# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1)
```java
assertEquals(3 * .4, 1.2);
```

2)

here an example where the result will be identical

```java

// Work
int a = 5, b = 4;
// a.equals(b)
assertEquals(a,b); // pass

// if(a == b)
assertSame(a, b); // pass

```


here an example where the result will be different

```java

// Don't Work
float a = 3*.4, b = 1.2;
// a.equals(b)
assertEquals(a,b); // will pass

// if(a == b)
assertSame(a, b); // THIS TEST WILL FAIL

```

3)

another use of fail can be testing a flow command 

```java
@Test
public void testingCondition() {
    int result = randomInteger();
    if(result > Integer.MAX_VALUE) {
        fail("Result cannot exceed integer max value");
    }
    // more testing code
}
```

this code verify if you pass in a particular flow command

4)
assertThrows() -> test multiple exceptions within the same test and handle lambdas function.

