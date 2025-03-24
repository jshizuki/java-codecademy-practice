/*A test suite allows you to group multiple test classes and
run them together. Instead of running each test class separately,
you can execute them all at once. */

package src;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;
// import org.junit.platform.suite.api.SelectPackages;

@Suite
// @SelectPackages("src")

@SelectClasses({
  FactorialTest.class,
  JUnitExample.class,
  JUnitExample2.class,
  JUnitExample3.class,
})

public class AllTests {

}
