package igor.kiselev.task;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.*;
import java.util.Map;

public class Parallel {
    public Map<Object,Long> Count(String source) {
        Map<Object,Long> result = Arrays.stream(
                source.split("")).collect(
                Collectors.groupingBy(c -> c, Collectors.counting()));
        return result;
    }
}
