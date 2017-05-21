/**
 * 
 */
package net.teamfps.java.serialization.array;

import static net.teamfps.java.serialization.Utils.*;

import net.teamfps.java.serialization.Container;
import net.teamfps.java.serialization.ContainerType;
import net.teamfps.java.serialization.Type;

/**
 * @author Zekye
 *
 */
public abstract class Array extends Container {
	protected int count;

	public Array(String name, Type type) {
		super(ContainerType.ARRAY, type);
		setName(name);
	}

	public static ByteArray Byte(String name, byte[] data) {
		return new ByteArray(name, data);
	}

	public static ShortArray Short(String name, short[] data) {
		return new ShortArray(name, data);
	}

	public static CharArray Char(String name, char[] data) {
		return new CharArray(name, data);
	}

	public static IntArray Int(String name, int[] data) {
		return new IntArray(name, data);
	}

	public static LongArray Long(String name, long[] data) {
		return new LongArray(name, data);
	}

	public static FloatArray Float(String name, float[] data) {
		return new FloatArray(name, data);
	}

	public static DoubleArray Double(String name, double[] data) {
		return new DoubleArray(name, data);
	}

	public static BooleanArray Boolean(String name, boolean[] data) {
		return new BooleanArray(name, data);
	}

	/**
	 * @param data
	 * @param pointer
	 * @return
	 */
	public static Array read(byte[] data, int pointer) {
		ContainerType CType = ContainerType.getType(data[pointer]);
		if (CType == ContainerType.UNKNOWN) return null;
		short length = readShort(new byte[] { data[pointer + 1], data[pointer + 2] }, 0);
		byte[] nameBytes = new byte[length];
		for (int i = 0; i < nameBytes.length; i++) {
			nameBytes[i] = data[pointer + 3 + i];
		}
		String name = new String(nameBytes);
		Type type = Type.getType(data[pointer + 3 + length]);
		if (type == Type.UNKNOWN) return null;
		int count = readInt(new byte[] { data[pointer + 3 + length + 1], data[pointer + 3 + length + 2], data[pointer + 3 + length + 3], data[pointer + 3 + length + 4] }, 0);
		int k = 0;
		switch (type) {
		case BYTE:
			k = 0;
			byte[] byteData = new byte[count];
			for (int i = 0; i < byteData.length; i += type.getSize()) {
				byteData[i] = data[pointer + 3 + length + 5 + k];
				k += type.getSize();
			}
			return Byte(name, byteData);
		case CHAR:
			k = 0;
			char[] charData = new char[count];
			for (int i = 0; i < charData.length; i++) {
				charData[i] = readChar(data[pointer + 3 + length + 5 + k], data[pointer + 3 + length + 5 + k + 1]);
				k += type.getSize();
			}
			return Char(name, charData);
		case SHORT:
			k = 0;
			short[] shortData = new short[count];
			for (int i = 0; i < shortData.length; i++) {
				shortData[i] = readShort(data[pointer + 3 + length + 5 + k], data[pointer + 3 + length + 5 + k + 1]);
				k += type.getSize();
			}
			return Short(name, shortData);
		case INT:
			k = 0;
			int[] intData = new int[count];
			for (int i = 0; i < intData.length; i++) {
				intData[i] = readInt(data[pointer + 3 + length + 5 + k], data[pointer + 3 + length + 5 + k + 1], data[pointer + 3 + length + 5 + k + 2], data[pointer + 3 + length + 5 + k + 3]);
				k += type.getSize();
			}
			return Int(name, intData);
		case LONG:
			long[] longData = new long[count];
			for (int i = 0; i < longData.length; i++) {
				longData[i] = readLong(data[pointer + 3 + length + 5 + k], data[pointer + 3 + length + 5 + k + 1], data[pointer + 3 + length + 5 + k + 2], data[pointer + 3 + length + 5 + k + 3], data[pointer + 3 + length + 5 + k + 4], data[pointer + 3 + length + 5 + k + 5], data[pointer + 3 + length + 5 + k + 6], data[pointer + 3 + length + 5 + k + 7]);
				k += type.getSize();
			}
			return Long(name, longData);
		case FLOAT:
			k = 0;
			float[] floatData = new float[count];
			for (int i = 0; i < floatData.length; i++) {
				floatData[i] = readFloat(data[pointer + 3 + length + 5 + k], data[pointer + 3 + length + 5 + k + 1], data[pointer + 3 + length + 5 + k + 2], data[pointer + 3 + length + 5 + k + 3]);
				k += type.getSize();
			}
			return Float(name, floatData);
		case DOUBLE:
			k = 0;
			double[] doubleData = new double[count];
			for (int i = 0; i < doubleData.length; i++) {
				doubleData[i] = readDouble(data[pointer + 3 + length + 5 + k], data[pointer + 3 + length + 5 + k + 1], data[pointer + 3 + length + 5 + k + 2], data[pointer + 3 + length + 5 + k + 3], data[pointer + 3 + length + 5 + k + 4], data[pointer + 3 + length + 5 + k + 5], data[pointer + 3 + length + 5 + k + 6], data[pointer + 3 + length + 5 + k + 7]);
				k += type.getSize();
			}
			return Double(name, doubleData);
		case BOOLEAN:
			k = 0;
			boolean[] booleanData = new boolean[count];
			for (int i = 0; i < booleanData.length; i++) {
				booleanData[i] = readBoolean(data[pointer + 3 + length + 5 + k]);
				k += type.getSize();
			}
			return Boolean(name, booleanData);
		default:
			break;
		}

		return null;
	}

	@Override
	public String toString() {
		return "" + getType() + "[]";
	}

}
