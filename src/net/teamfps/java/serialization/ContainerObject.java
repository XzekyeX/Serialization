package net.teamfps.java.serialization;

import static net.teamfps.java.serialization.Utils.*;

import java.util.ArrayList;
import java.util.List;

import net.teamfps.java.serialization.array.Array;
import net.teamfps.java.serialization.field.Field;

/**
 * 
 * @author Zekye
 *
 */
public class ContainerObject extends Container {
	protected List<Container> objects = new ArrayList<Container>();

	public ContainerObject(String name) {
		super(ContainerType.OBJECT, Type.UNKNOWN);
		setName(name);
	}

	@Override
	public int getSize() {
		int size = 0;
		for (Container c : objects) {
			size += c.getSize();
		}
		return Type.BYTE.getSize() + Type.SHORT.getSize() + name.length + Type.INT.getSize() + size;
	}

	@Override
	public int setBytes(byte[] dest, int pointer) {
		pointer = writeBytes(dest, pointer, CONTAINER_TYPE.getType());
		pointer = writeBytes(dest, pointer, nameLength);
		pointer = writeBytes(dest, pointer, name);
		pointer = writeBytes(dest, pointer, objects.size());
		for (Container c : objects) {
			pointer = c.setBytes(dest, pointer);
		}
		return pointer;
	}

	public void add(Container c) {
		if (c == null) return;
		objects.add(c);
	}

	public void clear() {
		objects.clear();
	}

	public Container get(String name) {
		return get(name, objects);
	}

	public static ContainerObject readData(byte[] data, int pointer) {
		// System.out.println("data[" + pointer + "]" + toStr(data[pointer]));
		ContainerType TYPE = ContainerType.getType(data[pointer]);
		if (TYPE == ContainerType.UNKNOWN) {
			System.err.println("Unknown CType!");
			return null;
		}
		short length = readShort(data[pointer + 1], data[pointer + 2]);
		byte[] name = new byte[length];
		for (int i = 0; i < name.length; i++) {
			name[i] = data[pointer + 3 + i];
		}
		ContainerObject obj = new ContainerObject(new String(name));
		int size = readInt(data[pointer + 3 + length], data[pointer + 3 + length + 1], data[pointer + 3 + length + 2], data[pointer + 3 + length + 3]);
		pointer += 3 + length + 4;
		for (int i = 0; i < size; i++) {
			TYPE = ContainerType.getType(data[pointer]);
			switch (TYPE) {
			case FIELD:
				Field f = Field.readData(data, pointer);
				if (f != null) {
					obj.add(f);
					pointer += f.getSize();
				} else {

				}
				break;
			case ARRAY:
				Array a = Array.read(data, pointer);
				if (a != null) {
					obj.add(a);
					pointer += a.getSize();
				} else {

				}
				break;
			case OBJECT:
				ContainerObject cobj = readData(data, pointer);
				if (cobj != null) {
					obj.add(cobj);
					pointer += cobj.getSize();
				} else {

				}
				break;
			default:
				break;
			}
		}
		return obj;
	}

	// public boolean save(String path, String file) {
	// byte[] data = new byte[getSize()];
	// setBytes(data, 0);
	// System.out.println("CObject Save: " + Utils.toStrBytes(data));
	// return Utils.save(path, file + ".fps", data);
	// }

	public String getObjectString() {
		String result = "";
		for (int i = 0; i < objects.size(); i++) {
			result += i < objects.size() - 1 ? objects.get(i) + ", " : objects.get(i);
		}
		return "[" + result + "]";
	}

	public List<Container> getObjects() {
		return objects;
	}

	public static ContainerObject to(Container c) {
		return (c != null && c instanceof ContainerObject) ? (ContainerObject) c : null;
	}

	@Override
	public String toString() {
		return CONTAINER_TYPE + "(" + getType() + "(\"" + getName() + "\"," + getObjectString() + "))";
	}
}
