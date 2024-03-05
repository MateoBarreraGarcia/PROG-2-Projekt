package at.ac.fhcampuswien.fhmdb.HelperClasses;

public class FilterHelper {
    // A Helper Class containing methods for filtering. They can be accessed by creating an object of the class.

    public static int addOrSubstract(int x, int y, boolean operation) {

        return operation ? x + y: x - y;
    }
}
