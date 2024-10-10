import org.example.Variant12;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestVariant12 {

    @Test
    public void testGetEvenIndexedElements() {
        Variant12 variant = new Variant12();

        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = {2, 4, 6, 8};
        assertArrayEquals(expected, variant.getEvenIndexedElements(A));

        int[] B = {10, 20, 30, 40, 50, 60};
        int[] expectedB = {20, 40, 60};
        assertArrayEquals(expectedB, variant.getEvenIndexedElements(B));
    }

    @Test
    public void testAreAllPositive() {
        Variant12 variant = new Variant12();

        assertTrue(variant.areAllPositive(1, 2, 3));
        assertFalse(variant.areAllPositive(1, -2, 3));
        assertFalse(variant.areAllPositive(0, 1, 2));
        assertTrue(variant.areAllPositive(10, 20, 30));
    }
}