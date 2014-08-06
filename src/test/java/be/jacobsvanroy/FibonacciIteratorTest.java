package be.jacobsvanroy;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.stream.IntStream;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Copyright (C) 2014  Davy Van Roy
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

public class FibonacciIteratorTest {

    private FibonacciIterator fibonacciIterator;

    @Before
    public void setUp() throws Exception {
        fibonacciIterator = new FibonacciIterator(x -> x.compareTo(new BigInteger("4000000")) < 0);
    }

    @Test
    public void testFirstThreeNumbers() throws Exception {
        assertThat(fibonacciIterator.next()).isEqualTo(BigInteger.ZERO);
        assertThat(fibonacciIterator.next()).isEqualTo(BigInteger.ONE);
        assertThat(fibonacciIterator.next()).isEqualTo(BigInteger.ONE);
    }

    @Test
    public void testTenthNumber() throws Exception {
        IntStream.range(0, 9).forEach(x -> fibonacciIterator.next());
        assertThat(fibonacciIterator.next()).isEqualTo(new BigInteger("34"));
    }

    @Test
    public void testHasNext() throws Exception {
        BigInteger lastNumber = new BigInteger("-1");
        while(fibonacciIterator.hasNext()) {
            lastNumber = fibonacciIterator.next();
        }
        assertThat(lastNumber.longValue()).isNotNegative();
        assertThat(lastNumber.longValue()).isLessThan(4_000_000);
        assertThat(fibonacciIterator.hasNext()).isFalse();
    }
}