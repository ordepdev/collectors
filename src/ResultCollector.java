import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

public class ResultCollector<T> implements Collector<Result, Result, Result> {

    @Override
    public Supplier<Result> supplier() {
        return Result::new;
    }

    @Override
    public BiConsumer<Result, Result> accumulator() {
        return Result::combine;
    }

    @Override
    public BinaryOperator<Result> combiner() {
        return Result::combine;
    }

    @Override
    public Function<Result, Result> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(IDENTITY_FINISH);
    }
}