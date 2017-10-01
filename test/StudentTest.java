import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class StudentTest {


    @Test
    public void smallIsHeap() throws Exception {
        Integer[] K = {1,2,3};
        Heap<Integer> H = new Heap<Integer>((Integer i, Integer j) -> i < j, Arrays.asList(K));
        assertTrue(H.is_heap());
    }

    @Test
    public void mediumIsHeap() throws Exception {
        Integer[] K = {1,2,3,4,7,8,9,10,14,16};
        Heap<Integer> H = new Heap<Integer>((Integer i, Integer j) -> i < j, Arrays.asList(K));
        assertTrue(H.is_heap());
    }

    @Test
    public void maximumOne() throws Exception {
        Integer[] K = {42};
        Heap<Integer> H = new Heap<Integer>((Integer i, Integer j) -> i < j, Arrays.asList(K));
        assertEquals(new Integer(42), H.maximum());
    }

    @Test
    public void maximumTwo() throws Exception {
        Integer[] K = {21, 42};
        Heap<Integer> H = new Heap<Integer>((Integer i, Integer j) -> i < j, Arrays.asList(K));
        assertEquals(new Integer(42), H.maximum());
    }

    @Test
    public void mediumMaximum() throws Exception {
        Integer[] K = {1,2,3,4,7,8,9,10,14,16};
        Heap<Integer> H = new Heap<Integer>((Integer i, Integer j) -> i < j, Arrays.asList(K));
        assertEquals(new Integer(16), H.maximum());
    }

    @Test
    public void insertOne() throws Exception {
        Heap<Integer> H = new Heap<Integer>((Integer i, Integer j) -> i < j);
        H.insert(42);
        assertEquals(new Integer(42), H.maximum());
    }

    @Test
    public void mediumInsert() throws Exception {
        Integer[] A = {1,2,3,4,7,8,9,10,14,16};
        Heap<Integer> H = new Heap<Integer>((Integer i, Integer j) -> i < j);
        for (int k : A) {
            H.insert(k);
            assertTrue(H.is_heap());
        }
        assertEquals(new Integer(16), H.maximum());
    }

    @Test
    public void extractMaxTwo() throws Exception {
        Integer[] A = {1, 2};
        Heap<Integer> H = new Heap<Integer>((Integer i, Integer j) -> i < j);
        for (int k : A) {
            H.insert(k);
            assertTrue(H.is_heap());
        }
        Arrays.sort(A);
        Collections.reverse(Arrays.asList(A));
        for (Integer x : A) {
            assertEquals(x, H.extract_max());
            assertTrue(H.is_heap());
        }
    }

    @Test
    public void mediumExtractMax() throws Exception {
        Integer[] A = {1, 2, 3, 4, 7, 8, 9, 10, 14, 16};
        Heap<Integer> H = new Heap<Integer>((Integer i, Integer j) -> i < j);
        for (int k : A) {
            H.insert(k);
            assertTrue(H.is_heap());
        }
        Arrays.sort(A);
        Collections.reverse(Arrays.asList(A));
        for (Integer x : A) {
            assertEquals(x, H.extract_max());
            assertTrue(H.is_heap());
        }
    }

    @Test
    public void mediumSortInPlace() throws Exception {
        Integer[] A = {16,4,10,14,7,9,3,2,8,1};
        Integer[] B = Arrays.copyOf(A, A.length);
        Arrays.sort(B);
        ArrayList<Integer> L = new ArrayList<Integer>(Arrays.asList(A));
        Heap.sortInPlace(L, (Integer i, Integer j) -> i < j);
        for (int i = 0; i != A.length; ++i)
            assertEquals(B[i], L.get(i));
    }

}