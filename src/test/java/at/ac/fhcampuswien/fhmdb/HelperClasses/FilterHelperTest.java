package at.ac.fhcampuswien.fhmdb.HelperClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterHelperTest {

    @Test
    void addition_if_true() {
        // given
        int x = 10;
        int y = 5;
        boolean add = true;
        //when
        int expected = 15;
        int actual = FilterHelper.addOrSubstract(x, y, add);
        // then
        assertEquals(expected, actual);
    }

    @Test
    void substraction_if_false() {
        // given
        int x = 10;
        int y = 5;
        boolean substract = false;
        //when
        int expected = 5;
        int actual = FilterHelper.addOrSubstract(x, y, substract);
        // then
        assertEquals(expected, actual);
    }

}