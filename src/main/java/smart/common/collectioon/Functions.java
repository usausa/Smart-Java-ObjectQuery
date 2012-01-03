package smart.common.collectioon;

import java.math.BigDecimal;
import java.math.BigInteger;

import smart.common.functor.Func2;

/**
 *
 */
public final class Functions {

    // ------------------------------------------------------------
    // 加算
    // ------------------------------------------------------------

    public static final Func2<Integer, Integer, Integer> ADD_INTEGER = new Func2<Integer, Integer, Integer>() {
        @Override
        public Integer eval(final Integer value1, final Integer value2) {
            return value1 == null ? value2 : (value2 == null ? value1 : value1 + value2);
        }
    };

    public static final Func2<Long, Long, Long> ADD_LONG = new Func2<Long, Long, Long>() {
        @Override
        public Long eval(final Long value1, final Long value2) {
            return value1 == null ? value2 : (value2 == null ? value1 : value1 + value2);
        }
    };

    public static final Func2<Float, Float, Float> ADD_FLOAT = new Func2<Float, Float, Float>() {
        @Override
        public Float eval(final Float value1, final Float value2) {
            return value1 == null ? value2 : (value2 == null ? value1 : value1 + value2);
        }
    };

    public static final Func2<Double, Double, Double> ADD_DOUBLE = new Func2<Double, Double, Double>() {
        @Override
        public Double eval(final Double value1, final Double value2) {
            return value1 == null ? value2 : (value2 == null ? value1 : value1 + value2);
        }
    };

    public static final Func2<BigInteger, BigInteger, BigInteger> ADD_BIG_INTEGER = new Func2<BigInteger, BigInteger, BigInteger>() {
        @Override
        public BigInteger eval(final BigInteger value1, final BigInteger value2) {
            return value1 == null ? value2 : (value2 == null ? value1 : value1.add(value2));
        }
    };

    public static final Func2<BigDecimal, BigDecimal, BigDecimal> ADD_BIG_DECIMAL = new Func2<BigDecimal, BigDecimal, BigDecimal>() {
        @Override
        public BigDecimal eval(final BigDecimal value1, final BigDecimal value2) {
            return value1 == null ? value2 : (value2 == null ? value1 : value1.add(value2));
        }
    };

    // ------------------------------------------------------------
    // 除算
    // ------------------------------------------------------------

    public static final Func2<Integer, Integer, Integer> DIV_INTEGER = new Func2<Integer, Integer, Integer>() {
        @Override
        public Integer eval(final Integer value1, final Integer value2) {
            return value1 / value2;
        }
    };

    public static final Func2<Long, Integer, Long> DIV_LONG = new Func2<Long, Integer, Long>() {
        @Override
        public Long eval(final Long value1, final Integer value2) {
            return value1 / value2;
        }
    };

    public static final Func2<Float, Integer, Float> DIV_FLOAT = new Func2<Float, Integer, Float>() {
        @Override
        public Float eval(final Float value1, final Integer value2) {
            return value1 / value2;
        }
    };

    public static final Func2<Double, Integer, Double> DIV_DOUBLE = new Func2<Double, Integer, Double>() {
        @Override
        public Double eval(final Double value1, final Integer value2) {
            return value1 / value2;
        }
    };

    public static final Func2<BigInteger, Integer, BigInteger> DIV_BIG_INTEGER = new Func2<BigInteger, Integer, BigInteger>() {
        @Override
        public BigInteger eval(final BigInteger value1, final Integer value2) {
            return value1.divide(BigInteger.valueOf(value2));
        }
    };

    public static final Func2<BigDecimal, Integer, BigDecimal> DIV_BIG_DECIMAL = new Func2<BigDecimal, Integer, BigDecimal>() {
        @Override
        public BigDecimal eval(final BigDecimal value1, final Integer value2) {
            return value1.divide(BigDecimal.valueOf(value2));
        }
    };

    // ------------------------------------------------------------
    // Max
    // ------------------------------------------------------------

    public static final Func2<Integer, Integer, Integer> MAX_INTEGER = new Func2<Integer, Integer, Integer>() {
        @Override
        public Integer eval(final Integer value1, final Integer value2) {
            return value1 == null ? value2 : (value2 == null ? value1 : (value1 >= value2 ? value1 : value2));
        }
    };

    public static final Func2<Long, Long, Long> MAX_LONG = new Func2<Long, Long, Long>() {
        @Override
        public Long eval(final Long value1, final Long value2) {
            return value1 == null ? value2 : (value2 == null ? value1 : (value1 >= value2 ? value1 : value2));
        }
    };

    public static final Func2<Float, Float, Float> MAX_FLOAT = new Func2<Float, Float, Float>() {
        @Override
        public Float eval(final Float value1, final Float value2) {
            return value1 == null ? value2 : (value2 == null ? value1 : (value1 >= value2 ? value1 : value2));
        }
    };

    public static final Func2<Double, Double, Double> MAX_DOUBLE = new Func2<Double, Double, Double>() {
        @Override
        public Double eval(final Double value1, final Double value2) {
            return value1 == null ? value2 : (value2 == null ? value1 : (value1 >= value2 ? value1 : value2));
        }
    };

    public static final Func2<BigInteger, BigInteger, BigInteger> MAX_BIG_INTEGER = new Func2<BigInteger, BigInteger, BigInteger>() {
        @Override
        public BigInteger eval(final BigInteger value1, final BigInteger value2) {
            return value1 == null ? value2 : (value2 == null ? value1 : (value1.compareTo(value2) >= 0 ? value1 : value2));
        }
    };

    public static final Func2<BigDecimal, BigDecimal, BigDecimal> MAX_BIG_DECIMAL = new Func2<BigDecimal, BigDecimal, BigDecimal>() {
        @Override
        public BigDecimal eval(final BigDecimal value1, final BigDecimal value2) {
            return value1 == null ? value2 : (value2 == null ? value1 : (value1.compareTo(value2) >= 0 ? value1 : value2));
        }
    };

    // ------------------------------------------------------------
    // Min
    // ------------------------------------------------------------

    public static final Func2<Integer, Integer, Integer> MIN_INTEGER = new Func2<Integer, Integer, Integer>() {
        @Override
        public Integer eval(final Integer value1, final Integer value2) {
            return value1 == null ? value2 : (value2 == null ? value1 : (value1 < value2 ? value1 : value2));
        }
    };

    public static final Func2<Long, Long, Long> MIN_LONG = new Func2<Long, Long, Long>() {
        @Override
        public Long eval(final Long value1, final Long value2) {
            return value1 == null ? value2 : (value2 == null ? value1 : (value1 < value2 ? value1 : value2));
        }
    };

    public static final Func2<Float, Float, Float> MIN_FLOAT = new Func2<Float, Float, Float>() {
        @Override
        public Float eval(final Float value1, final Float value2) {
            return value1 == null ? value2 : (value2 == null ? value1 : (value1 < value2 ? value1 : value2));
        }
    };

    public static final Func2<Double, Double, Double> MIN_DOUBLE = new Func2<Double, Double, Double>() {
        @Override
        public Double eval(final Double value1, final Double value2) {
            return value1 == null ? value2 : (value2 == null ? value1 : (value1 < value2 ? value1 : value2));
        }
    };

    public static final Func2<BigInteger, BigInteger, BigInteger> MIN_BIG_INTEGER = new Func2<BigInteger, BigInteger, BigInteger>() {
        @Override
        public BigInteger eval(final BigInteger value1, final BigInteger value2) {
            return value1 == null ? value2 : (value2 == null ? value1 : (value1.compareTo(value2) < 0 ? value1 : value2));
        }
    };

    public static final Func2<BigDecimal, BigDecimal, BigDecimal> MIN_BIG_DECIMAL = new Func2<BigDecimal, BigDecimal, BigDecimal>() {
        @Override
        public BigDecimal eval(final BigDecimal value1, final BigDecimal value2) {
            return value1 == null ? value2 : (value2 == null ? value1 : (value1.compareTo(value2) < 0 ? value1 : value2));
        }
    };

    private Functions() {
    }
}
