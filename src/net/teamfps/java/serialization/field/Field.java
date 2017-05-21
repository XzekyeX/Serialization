/**
 * 
 */
package net.teamfps.java.serialization.field;

import static net.teamfps.java.serialization.Utils.*;

import net.teamfps.java.serialization.Container;
import net.teamfps.java.serialization.ContainerType;
import net.teamfps.java.serialization.Type;

/**
 * @author Zekye
 *
 */
public abstract class Field extends Container {
	public Field(String name, Type type) {
		super(ContainerType.FIELD, type);
		setName(name);
	}

	public static ByteField Byte(String name, byte value) {
		return new ByteField(name, value);
	}

	public static StringField String(String name, String value) {
		return new StringField(name, value);
	}

	public static ShortField Short(String name, short value) {
		return new ShortField(name, value);
	}

	public static CharField Char(String name, char value) {
		return new CharField(name, value);
	}

	public static IntField Int(String name, int value) {
		return new IntField(name, value);
	}

	public static LongField Long(String name, long value) {
		return new LongField(name, value);
	}

	public static FloatField Float(String name, float value) {
		return new FloatField(name, value);
	}

	public static DoubleField Double(String name, double value) {
		return new DoubleField(name, value);
	}

	public static BooleanField Boolean(String name, boolean value) {
		return new BooleanField(name, value);
	}

	/**
	 * @param data
	 * @param pointer
	 * @return
	 */
	public static Field readData(byte[] data, int pointer) {
		ContainerType CType = ContainerType.getType(data[pointer]);
		if (CType == ContainerType.UNKNOWN) {
			System.err.println("Unknown CType!");
			return null;
		}
		short length = readShort(new byte[] { data[pointer + 1], data[pointer + 2] }, 0);
		byte[] nameBytes = new byte[length];
		for (int i = 0; i < nameBytes.length; i++) {
			nameBytes[i] = data[pointer + 3 + i];
		}
		String name = new String(nameBytes);
		Type type = Type.getType(data[pointer + 3 + length]);
		if (type == Type.UNKNOWN) return null;
		switch (type) {
		case BYTE:
			return Byte(name, data[pointer + 3 + length + 1]);
		case SHORT:
			return Short(name, readShort(data[pointer + 3 + length + 1], data[pointer + 3 + length + 2]));
		case CHAR:
			return Char(name, readChar(data[pointer + 3 + length + 1], data[pointer + 3 + length + 2]));
		case INT:
			return Int(name, readInt(data[pointer + 3 + length + 1], data[pointer + 3 + length + 2], data[pointer + 3 + length + 3], data[pointer + 3 + length + 4]));
		case LONG:
			return Long(name, readLong(data[pointer + 3 + length + 1], data[pointer + 3 + length + 2], data[pointer + 3 + length + 3], data[pointer + 3 + length + 4], data[pointer + 3 + length + 5], data[pointer + 3 + length + 6], data[pointer + 3 + length + 7], data[pointer + 3 + length + 8]));
		case FLOAT:
			return Float(name, readFloat(data[pointer + 3 + length + 1], data[pointer + 3 + length + 2], data[pointer + 3 + length + 3], data[pointer + 3 + length + 4]));
		case DOUBLE:
			return Double(name, readDouble(data[pointer + 3 + length + 1], data[pointer + 3 + length + 2], data[pointer + 3 + length + 3], data[pointer + 3 + length + 4], data[pointer + 3 + length + 5], data[pointer + 3 + length + 6], data[pointer + 3 + length + 7], data[pointer + 3 + length + 8]));
		case BOOLEAN:
			return Boolean(name, readBoolean(data[pointer + 3 + length + 1]));
		case STRING:
			int size = readInt(data[pointer + 3 + length + 1], data[pointer + 3 + length + 2], data[pointer + 3 + length + 3], data[pointer + 3 + length + 4]);
			byte[] str = new byte[size];
			for (int i = 0; i < str.length; i++) {
				str[i] = data[pointer + 3 + length + 5 + i];
			}
			return String(name, new String(str));
		default:
			break;
		}
		return null;
	}
}
