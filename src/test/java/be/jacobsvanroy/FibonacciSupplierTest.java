package be.jacobsvanroy;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.fest.assertions.api.Assertions.assertThat;


/**
 * Copyright (C) 2014  Davy Van Roy
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

public class FibonacciSupplierTest {

    private FibonacciSupplier fibonacciSupplier;

    @Before
    public void setUp() throws Exception {
        fibonacciSupplier = new FibonacciSupplier();
    }

    @Test
    public void testSupplier() throws Exception {
        assertThat(fibonacciSupplier.get()).isEqualTo(BigInteger.ZERO);
        assertThat(fibonacciSupplier.get()).isEqualTo(BigInteger.ONE);
        assertThat(fibonacciSupplier.get()).isEqualTo(BigInteger.ONE);
        assertThat(fibonacciSupplier.get()).isEqualTo(new BigInteger("2"));
        assertThat(fibonacciSupplier.get()).isEqualTo(new BigInteger("3"));
        assertThat(fibonacciSupplier.get()).isEqualTo(new BigInteger("5"));
        assertThat(fibonacciSupplier.get()).isEqualTo(new BigInteger("8"));
    }

    @Test
    public void testWithinStream() throws Exception {
        Stream<BigInteger> fibonacciStream = Stream.generate(fibonacciSupplier);
        List<Long> result = fibonacciStream
                .limit(10)
                .mapToLong(BigInteger::longValue).boxed()
                .collect(Collectors.toList());
        assertThat(result).containsExactly(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L);

    }
}