package basic.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PaginationExample {

    public static void main(String[] args) {
        List<String> list = Stream.<String>empty()//.of("val1", "val2", "val3", "val4", "val5","val6","val7", "val8", "val9")
                .skip(3)
                .limit(7)
                .collect(Collectors.toList());

        System.out.println(list);
    }
}
