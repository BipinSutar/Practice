package bipin.zycus.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

class ObjectSizeFetcher {

	public static long getObjectSize(Object o) {
		return ObjectSizeCalculator.getObjectSize(o);
	}
}

class CustomKey implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private int id;

	public CustomKey(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {

		return getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomKey other = (CustomKey) obj;
		if (this.getId() != other.getId())
			return false;
		return true;
	}

	public int getId() {
		return this.id;
	}

}

class CumstomkeySerializer<T extends Serializable> {

	CumstomkeySerializer() {
		File f = new File(getFileDir());
		f.delete();
		f.mkdir();
	}

	public String getFileDir() {
		return "CZ";
	}

	public String getFileName(int id) {
		return "CustomeKey_" + id + "_.ser";
	}

	public long getFreeMemory() {
		return Runtime.getRuntime().freeMemory();
	}

	public long getObjectSize(int id) {
		File f = new File(getFileDir(), getFileName(id));
		return f.length();
	}

	public void create(int id) {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new FileOutputStream(new File(getFileDir(), getFileName(id))));
			objectOutputStream.writeObject(new CustomKey(id));
			// objectOutputStream.flush();
			// objectOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CustomKey read(int id) {
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(
					new FileInputStream(new File(getFileDir(), getFileName(id))));

			return (CustomKey) objectInputStream.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean fileExists(int id) {
		return new File(getFileDir(), getFileName(id)).exists();
	}
}

public class DiskBackedMapCollectionTest {

	public static void main(String[] args) {
		Map<CustomKey, Object> map = new HashMap<CustomKey, Object>();
		CumstomkeySerializer<CustomKey> serialzer = new CumstomkeySerializer();
		long memory = 10000;
		// for (int i = 0; i < 1000000000; i++) {
		// if (serialzer.getFreeMemory() < serialzer.getObjectSize(i)) {
		// serialzer.create(i, new CustomKey(i));
		// }
		// }
		long limit = ObjectSizeFetcher.getObjectSize(new CustomKey(10));
		System.out.println(limit);
		for (int i = 0; i < 10000000; i++) {

			CustomKey key = null;
			try {
				key = new CustomKey(i);
				map.put(key, i);
			} catch (OutOfMemoryError e) {
				serialzer.create(i);
			}
		}
		for (int i = 0; i < 1000; i++) {
			System.out.println(map.get(serialzer.read(i)));
		}
	}

	public static void main1(String[] args) {
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
