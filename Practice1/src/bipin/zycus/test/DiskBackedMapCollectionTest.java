package bipin.zycus.test;

import java.util.HashMap;

public class DiskBackedMapCollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Get current size of heap in bytes
		long heapSize = Runtime.getRuntime().totalMemory();
		HashMap<Integer, Integer> map = new HashMap<>();
		// Get maximum size of heap in bytes. The heap cannot grow beyond this size.
		// Any attempt will result in an OutOfMemoryException.
		long heapMaxSize = Runtime.getRuntime().maxMemory();

		// Get amount of free memory within the heap in bytes. This size will increase
		// after garbage collection and decrease as new objects are created.
		long heapFreeSize = Runtime.getRuntime().freeMemory();
		int div = 1;
		System.out.println("Current heap size " + heapSize / (div * div));
		System.out.println("Max heap size " + heapMaxSize / (div * div));
		System.out.println("Free heap size " + heapFreeSize / (div * div));
		for (int i = 0; i < 10000000; i++) {
			if (Runtime.getRuntime().freeMemory() > 24)
				map.put(i, i);
		}
		heapSize = Runtime.getRuntime().totalMemory();
		heapMaxSize = Runtime.getRuntime().maxMemory();
		heapFreeSize = Runtime.getRuntime().freeMemory();
		System.out.println("Current heap size " + heapSize / (div * div));
		System.out.println("Max heap size " + heapMaxSize / (div * div));
		System.out.println("Free heap size " + heapFreeSize / (div * div));
	}

}
