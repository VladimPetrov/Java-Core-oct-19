package lesson14;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;



public class ArrayUtilsTest {
    private ArrayUtils arrUtil;

    @BeforeEach
    public void init() {
        arrUtil = new ArrayUtils();
    }

    @ParameterizedTest
    @MethodSource("testParams1")
    public void findLast4Test(int[] a, int[] b){
        Assertions.assertArrayEquals(a,arrUtil.findLast4(b));
    }

    @ParameterizedTest
    @MethodSource("testParams2")
    public void checkArrayTest(boolean a, int[] b){
        Assertions.assertEquals(a, arrUtil.checkArray(b));
    }


    @DisplayName("findLast4 Test Exception")
    @Test
    public void findLast4TestThrows(){
        Assertions.assertThrows(RuntimeException.class, () -> arrUtil.findLast4(new int[] {12, 12, 24}));
    }

    static Stream<Arguments> testParams1() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(new int[] {5}, new int[] {1, 2, 3, 4, 5}));
        list.add(Arguments.arguments(new int[] {5, 6, 7}, new int[] {1, 4, 5, 6, 7}));
        list.add(Arguments.arguments(new int[] {12, 12, 24}, new int[] {4, 12, 12, 24}));
        return list.stream();
    }

    static Stream<Arguments> testParams2() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(true , new int[] {1, 1, 1, 4, 4, 1, 4, 4}));
        list.add(Arguments.arguments(false, new int[] {1, 1, 1, 1, 1, 1}));
        list.add(Arguments.arguments(false, new int[] {4, 4, 4, 4}));
        list.add(Arguments.arguments(false, new int[] {4, 4, 4, 4}));
        return list.stream();
    }

}
