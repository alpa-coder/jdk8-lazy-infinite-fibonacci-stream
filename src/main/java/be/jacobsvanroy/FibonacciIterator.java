package be.jacobsvanroy;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.function.Predicate;

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

public class FibonacciIterator implements Iterator<BigInteger> {

    private Predicate<BigInteger> predicate;
    private BigInteger x;
    private BigInteger y;

    public FibonacciIterator(Predicate<BigInteger> predicate) {
        this.predicate = predicate;
        x = new BigInteger("-1");
        y = BigInteger.ONE;
    }

    @Override
    public BigInteger next() {
        BigInteger result = x.add(y);
        x = y;
        y = result;
        return result;
    }

    @Override
    public boolean hasNext() {
        return predicate.test(x.add(y));
    }
}
