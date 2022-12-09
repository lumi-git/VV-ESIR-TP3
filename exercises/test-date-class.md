# Test the Date class

Implement a class `Date` with the interface shown below:

```java
class Date implements Comparable<Date> {

    public Date(int day, int month, int year) { ... }

    public static boolean isValidDate(int day, int month, int year) { ... }

    public static boolean isLeapYear(int year) { ... }

    public Date nextDate() { ... }

    public Date previousDate { ... }

    public int compareTo(Date other) { ... }

}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null` 

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point. 
Also, feel free to add any extra method you may need to the `Date` class.


Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer
1) 
 |  Cas                                                               |     Input               |  Output    |
 |:------------------------------------------------------------------:|:-----------------------:|:----------:|
 | nextDate end of the year                                           | 31/12/2017              | 01/01/2018 |
 | nextDate end of month 31 (1,3,5,7,8,10)                            | 31/01/2017              | 01/02/2017 |
 | nextDate end of month 30 (4,6,9,11)                                | 30/04/2017              | 01/05/2017 |
 | nextDate end of month 29 (2 in NotLeapYear)                        | 29/02/2017              | 01/02/2017 |
 | nextDate end of month 28 (2 in LeapYear)                           | 28/02/2016              | 01/02/2016 |
 | nextDate invalid date                                              | 45/02/2016              | null       |
 | PreviousDate beginning of year                                     | 01/01/2017              | 31/12/2016 |
 | PreviousDate beginning of month before one of 31 (2,4,6,8,9,11)    | 01/02/2017              | 31/01/2017 |
 | PreviousDate beginning of month before one of 30 (5,7,10,12)       | 01/05/2017              | 30/04/2017 |
 | PreviousDate beginning of month before one of 29 (3 in NotLeapYear)| 01/03/2017              | 29/02/2017 |
 | PreviousDate beginning of month before one of 28 (2 in LeapYear)   | 01/03/2016              | 28/02/2016 |
 | PreviousDate invalid date                                          | 45/02/2016              | null       |
 | D1 < D2  different year                                            | 01/01/2017 ? 01/01/2018 | -1         |
 | D2 < D1  different year                                            | 01/01/2018 ? 01/01/2017 |  1         |
 | D1 < D2  different months                                          | 01/01/2017 ? 01/02/2017 | -1         |
 | D2 < D1  different months                                          | 01/02/2017 ? 01/01/2017 |  1         |
 | D1 < D2  different day                                             | 01/01/2017 ? 02/01/2017 | -1         |
 | D2 < D1  different day                                             | 02/01/2017 ? 01/01/2017 |  1         |
 | D1 == D2                                                           | 01/01/2017 ? 01/01/2017 |  0         |
 | isLeapYear                                                         | 2016                    | True       |
 | isNotLeapYear                                                      | 2017                    | False      |
 | D1 == D2 equals                                                    | 01/01/2016 ? 01/01/2016 | True       |
 | D1 != D2 equals (not the right day)                                | 01/01/2016 ? 02/01/2016 | False      |
 | D1 != D2 equals (not the right month)                              | 01/01/2016 ? 01/02/2016 | False      |
 | D1 != D2 equals (not the right year)                               | 01/01/2016 ? 01/01/2017 | False      |
 | D1 == D1 equals (same object)                                      | 01/01/2016 ? 01/01/2016 | true       |
 | D1 == null equals                                                  | 01/01/2016 ? null       | false      |
 | D1 == 9 equals  (not the same type of object)                      | 01/01/2016 ? 6          | false      |
 | Invalid date (day < 1)                                             | 00/01/2016              | false      |
 | Invalid date (day > 32)                                            | 00/01/2016              | false      |
 | Invalid date (month < 1)                                           | 01/00/2016              | false      |
 | Invalid date (month > 12)                                          | 01/13/2016              | false      |
 | Invalid date (year < 0)                                            | 01/01/-500              | false      |
 | Invalid date (month = 12, day > 28, LeapYear)                      | 01/13/2016              | false      |
 | Invalid date (month= = 2, day > 29, NotLeapYear)                   | 29/2/2017               | false      |
 | Valid date (month = 2, day < 29, NotLeapYear)                      | 28/2/2017               | True       |
 | Invalid date (month = 2, day > 29, LeapYear)                       | 30/2/2016               | false      |
 | Valid date (month = 2, 0 day < 30, LeapYear)                       | 29/2/2016               | True       |
 | Invalid date (month = (4, 6, 9, 11), day > 30)                     | 31/6/2016               | false      |
 | Valid date (month = (4, 6, 9, 11), day < 31)                       | 30/2/2016               | True       |
 | Invalid date (month = (1, 3, 5, 7, 8, 10 ,12), day > 31)           | 32/5/2016               | false      |
 | Valid date (month = (1, 3, 5, 7, 8, 10 ,12), day < 32)             | 31/5/2016               | True       |

2) Evaluation approx. 90%.
3) Each test was made in such a way that only one value changes in the predica with several boolean values
4)
![](DatePIT.png)