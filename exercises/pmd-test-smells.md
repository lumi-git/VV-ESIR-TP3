# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer
In commons-math with JUnitAssertionsShouldIncludeMessage :

```
/.../commons-math/commons-math-transform/src/test/java/org/apache/commons/math4/transform/FastHadamardTransformerTest.java:119:	JUnitAssertionsShouldIncludeMessage:	JUnit assertions should include a message
```

code :
```java
private void checkInverseDoubleTransform(int[]x, int[] y) {
        // Initiate the transformer
        final FastHadamardTransform transformer = new FastHadamardTransform(true);

        // check double transform
        final double[] dY = new double[y.length];
        for (int i = 0; i < dY.length; ++i) {
            dY[i] = y[i];
        }
        final double[] dResult = transformer.apply(dY);
        for (int i = 0; i < dResult.length; i++) {
            // compare computed results to precomputed results
            Assert.assertTrue(Precision.equals(x[i], dResult[i], 1));
        }
    }
```

Besoin d'un message avec l'assertion.