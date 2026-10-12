import static org.junit.Assert.*;

import org.junit.*;

public class MyLinkedListCustomTester {

	// Optional: add test variables here

	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test.
	 */
	@Before
	public void setUp() throws Exception {
		// Optional: add setup here
	}

	/**
	 * Aims to test the add(E data) method with a valid argument.
	 */
	@Test
	public void testCustomAdd() {
		// TODO: add your test here
	}

	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the beginning of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToStart() {
		// TODO: add your test here
	}

	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the middle of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToMiddle() {
		// TODO: add your test here
	}

	/**
	 * Aims to test the remove(int index) method. Remove from an empty list.
	 */
	@Test
	public void testCustomRemoveFromEmpty() {
		// TODO: add your test here
	}

	/**
	 * Aims to test the remove(int index) method.
	 * Remove a valid argument from the middle of MyLinkedList.
	 */
	@Test
	public void testCustomRemoveFromMiddle() {
		// TODO: add your test here
	}

	/**
	 * Aims to test the set(int index, E data) method.
	 * Set an out-of-bounds index with a valid data argument.
	 */
	@Test
	public void testCustomSetIdxOutOfBounds() {
		// TODO: add your test here
	}

	/**
	 * Aims to test the mergeLists(MyLinkedList<E> left, MyLinkedList<E> right)
	 * method.
	 * Merge lists when one is longer than the other. 
	 */
	@Test
	public void testCustomMergeUnequalSize() {
		// TODO: add your test here
	}

	/**
	 * Aims to test the mergeLists(MyLinkedList<E> left, MyLinkedList<E> right)
	 * method.
	 * Merge lists when both lists share a value.
	 */
	@Test
	public void testCustomMergeDuplicates() {
		// TODO: add your test here
	}

}
