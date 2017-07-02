import java.util.Comparator;
import java.util.Optional;
import java.util.stream.IntStream;

public class Collectors {

    public static void main(String[] args) {

        Long duration = IntStream.range(0, 10)
                .mapToObj(i -> processWithReduce())
                .min(Long::compare)
                .orElse(0L);

        System.out.println("Fastest was done in " + duration + "ms");
    }

    private static long processWithReduce() {

        long start = System.nanoTime();

        IntStream.range(0, 1_000_000)
                .mapToObj(i -> new Result(1, 2, 3))
                .reduce(Result::combine);

        return (System.nanoTime() - start) / 1_000_000;
    }

    private static long processWithCollector() {

        long start = System.nanoTime();

        IntStream.range(0, 1_000_000)
                .mapToObj(i -> new Result(1, 2, 3))
                .collect(new ResultCollector<>());

        return (System.nanoTime() - start) / 1_000_000;
    }
}
