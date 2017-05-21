package net.teamfps.java.serialization;

import java.util.ArrayList;
import java.util.List;

import net.teamfps.java.serialization.array.Array;
import net.teamfps.java.serialization.field.Field;

/**
 * @author Zekye
 *
 */
public abstract class Container {
	protected final ContainerType CONTAINER_TYPE;
	protected short nameLength;
	protected byte[] name;
	protected Type type;

	public Container(ContainerType CONTAINER_TYPE, Type type) {
		this.CONTAINER_TYPE = CONTAINER_TYPE;
		this.type = type;
	}

	protected void setName(String name) {
		assert (name.length() < Short.MAX_VALUE);
		this.nameLength = (short) name.length();
		this.name = name.getBytes();
	}

	public abstract int getSize();

	public abstract int setBytes(byte[] dest, int pointer);

	public static List<Container> getData(byte[] data, int pointer) {
		List<Container> result = new ArrayList<Container>();
		if (data == null) return result;
		int attempts = 0;
		while (pointer < data.length) {
			ContainerType CType = ContainerType.getType(data[pointer]);
			// System.out.println("Ctype: " + CType);
			switch (CType) {
				case ARRAY:
					Array read = Array.read(data, pointer);
					if (read != null) {
						result.add(read);
						pointer += read.getSize();
					} else {
						attempts++;
					}
					break;
				case FIELD:
					Field field = Field.readData(data, pointer);
					if (field != null) {
						result.add(field);
						pointer += field.getSize();
					} else {
						attempts++;
					}
					break;
				case OBJECT:
					ContainerObject obj = ContainerObject.readData(data, pointer);
					if (obj != null) {
						result.add(obj);
						pointer += obj.getSize();
					} else {
						attempts++;
					}
					break;
				case UNKNOWN:
					attempts++;
					break;
				default:
					break;
			}
			if (attempts >= 5) break;
		}
		return result;
	}

	public static Container get(String name, List<Container> list) {
		for (Container c : list) {
			if (name.equals(c.getName())) {
				return c;
			}
		}
		return null;
	}

	public static List<Container> read(String path, String file) {
		byte[] data = Utils.load(path, file);
		return getData(data, 0);
	}

	public boolean save(String path, String file) {
		byte[] data = new byte[getSize()];
		setBytes(data, 0);
		System.out.println("Save: " + Utils.toStrBytes(data));
		return Utils.save(path, file.contains(".fps") ? file : file + ".fps", data);
	}

	/**
	 * set bytes to new byte array
	 * 
	 * @return byte array
	 */
	public byte[] getByteData() {
		byte[] data = new byte[getSize()];
		setBytes(data, 0);
		return data;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return new String(name);
	}

	@Override
	public String toString() {
		return CONTAINER_TYPE + "(" + getType() + "(\"" + getName() + "\"," + "))";
	}
}
