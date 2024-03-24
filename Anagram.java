package interviewPrograms;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Anagram {
    public static void main(String[] args) {
        String[] items = {"eat", "ate", "tea", "nat", "tan"};
        new HashSet<>(
                (Stream.of(items)
                        .collect(Collectors.toMap(item -> item, item -> Stream.of(item.split("")).sorted().collect(Collectors.joining())))
                )
                        .values()).stream().collect(Collectors.toMap(key -> key, val ->
                (Stream.of(items).collect(Collectors.toMap(item -> item, item -> Stream.of(item.split("")).sorted().collect(Collectors.joining())))).entrySet().stream().filter(entry -> entry.getValue().equalsIgnoreCase(val)).map(Map.Entry::getKey).collect(Collectors.toList()))).forEach((b, n) -> System.out.println(b + "  " + n));
        System.out.println("I am Ok");
    }
}


