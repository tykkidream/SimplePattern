package com.tykkidream.pattern.serial.number;

import org.junit.Test;

/**
 * Created by Tykkidream on 2018/3/21.
 */
public class MachineCodeTest {
    @Test
    public void test() {
        String machineCode = MachineCode.generate();

        System.out.println(machineCode);
    }
}
