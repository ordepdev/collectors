import java.text.MessageFormat;

public class Result {
    private long a;
    private long b;
    private long c;

    Result() {}

    Result(long a, long b, long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Result combine(Result result) {
        return new Result(this.a += result.a, this.b += result.b, this.c += result.c);
    }

    @Override
    public String toString() {
        return MessageFormat.format("a:{0},b:{1},c:{2}", this.a, this.b, this.c);
    }
}