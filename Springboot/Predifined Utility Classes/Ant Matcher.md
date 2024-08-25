// Ant Matcher

import org.springframework.util.AntPathMatcher;

public class Example {
  public static void main(String[] args) {
    AntPathMatcher matcher = new AntPathMatcher();

    // Match a single path segment
    boolean result1 = matcher.match("foo", "foo");
    System.out.println(result1); // true

    // Match a path with a wildcard
    boolean result2 = matcher.match("foo/*", "foo/bar");
    System.out.println(result2); // true

    // Match a path with multiple wildcards
    boolean result3 = matcher.match("foo/**/baz", "foo/bar/baz");
    System.out.println(result3); // true

    // Match a path with a file extension
    boolean result4 = matcher.match("*.txt", "example.txt");
    System.out.println(result4); // true
  }
}
