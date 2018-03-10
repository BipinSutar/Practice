package bipin.zycus.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
		setId(id);
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

	public void setId(int id) {
		this.id = id;
	}
}

class CumstomkeySerializer<T extends Serializable> {
	static int obj_count;
	ObjectInputStream objectInputStream = null;
	ObjectOutputStream objectOutputStream = null;
	Object lock1 = new Object();
	Object lock2 = new Object();

	CumstomkeySerializer() throws IOException {
		File f = new File(getFileDir());
		f.delete();
		f.mkdir();
	}

	public String getFileDir() {
		return "../CZ";
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

	public void create(int id, Object key) {
		synchronized (lock1) {

			try {
				objectOutputStream = new ObjectOutputStream(
						new FileOutputStream(new File(getFileDir(), getFileName(id))));
				objectOutputStream.writeObject(key);
				objectOutputStream.flush();
				objectOutputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				objectOutputStream = null;
			}
		}
	}

	public CustomKey read(int id) {
		synchronized (lock2) {
			try {
				objectInputStream = new ObjectInputStream(new FileInputStream(new File(getFileDir(), getFileName(id))));

				return (CustomKey) objectInputStream.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				objectInputStream = null;
			}
			return null;
		}
	}

	public boolean fileExists(int id) {
		return new File(getFileDir(), getFileName(id)).exists();
	}
}

/**
 * 
 * @author BipinSutar </br>
 *         This class will perform operations of adding object into the map. If
 *         heap memory is full or number capacity to hold the objects into the
 *         heap memory's map exceeds then it ill serialize or spill the objects
 *         in the local memory.</br>
 *         Also this class will also read last 20 objects created and display on
 *         the console to demonstrate object storing into map as well local
 *         memory.</br>
 * 
 * 
 *
 */
public class DiskBackedMapCollectionTest {

	public static void main(String[] args) throws IOException {
		Map<CustomKey, CustomKey> map = new HashMap<CustomKey, CustomKey>();
		CumstomkeySerializer<CustomKey> serialzer = new CumstomkeySerializer<CustomKey>();
		/**
		 * Size of one object
		 */
		long oneObj = ObjectSizeFetcher.getObjectSize(new CustomKey(Integer.MAX_VALUE));
		int exceed = 0;
		/**
		 * Number of objects can be save in memory
		 */
		long numberObj = serialzer.getFreeMemory() / oneObj;
		long limit = numberObj + exceed;
		CustomKey key = new CustomKey(-1);
		boolean flag = false;
		/**
		 * Creating limit + 10 number objects
		 */
		for (int i = 0; i < limit + 10; i++) {
			key.setId(i);
			if (numberObj - CumstomkeySerializer.obj_count < 0 || flag) {
				/**
				 * Spill on the disk
				 */
				serialzer.create(i, key);
			} else {
				/**
				 * Storing on heap memory's map
				 */
				try {
					map.put(key, key);
					CumstomkeySerializer.obj_count++;
				} catch (OutOfMemoryError e) {
					flag = true;
					continue;
				}

			}
		}
		/**
		 * Retrieving last 20 objects If object data not found in heap memory it will
		 * append "From disk" message else it will print object data
		 */
		for (int i = (int) limit - 10; i < limit + 10; i++) {
			key.setId(i);

			System.out.println(map.get(key) == null ? serialzer.read(i).getId() + " From disk " : map.get(key).getId());
		}
	}

}
