package be.jacobsvanroy;


import java.math.BigInteger;

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

public class EulerSolver {

    public BigInteger getEuler002Result() {
        BigInteger ceiling = new BigInteger("4000000");
        BigInteger two = new BigInteger("2");
        return new FibonacciStream()
                .getStream(x -> x.compareTo(ceiling) < 0)
                .filter(x -> x.remainder(two).equals(BigInteger.ZERO))
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    public BigInteger getEuler025Result() {
        return new FibonacciStream()
                .getStream(x -> x.toString().length() < 1000)
                .reduce(BigInteger.ZERO, (x, y) -> x.add(BigInteger.ONE));
    }


    public static void main(String... args) {
        EulerSolver eulerSolver = new EulerSolver();
        System.out.println("Final sum is: " + eulerSolver.getEuler002Result());
        System.out.println("First fibonacci number with 1000 digits is term: " + eulerSolver.getEuler025Result());
    }
}
