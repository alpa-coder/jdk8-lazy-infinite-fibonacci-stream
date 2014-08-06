package be.jacobsvanroy;


import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

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

public class EulerSolverTest {

    private EulerSolver eulerSolver;

    @Before
    public void setUp() throws Exception {
        eulerSolver = new EulerSolver();
    }

    @Test
    public void testEuler002() throws Exception {
        BigInteger euler002Result = eulerSolver.getEuler002Result();
        assertThat(euler002Result).isEqualTo(new BigInteger("4613732"));
    }

    @Test
    public void testEuler025() throws Exception {
        BigInteger euler025Result = eulerSolver.getEuler025Result();
        assertThat(euler025Result.intValue()).isEqualTo(4782);

    }

}