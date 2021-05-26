package com.wartsila.camelcase;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

class CamelCase {

  static final List<String> SEPARATORS = Arrays.asList("-", "_");

  static String toCamelCase(String s) {
    if (s == null || s.isEmpty()) {
      throw new IllegalArgumentException("String cannot be null or empty");
    }

    String delimiter = SEPARATORS.stream().filter(s::contains).findFirst().orElse(null);

    if (delimiter == null) {
      return s;
    }

    var words = s.split(delimiter);

    var result = Arrays.stream(words)
        .skip(1)
        .map(value -> Character.toUpperCase(value.charAt(0)) + value.substring(1).toLowerCase(Locale.ROOT))
        .collect(Collectors.joining(""));

    return words[0] + result;
  }
}