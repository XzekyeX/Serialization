/**
 * 
 */
package net.teamfps.java.serialization.array;

import static net.teamfps.java.serialization.Utils.*;

import net.teamfps.java.serialization.Container;
import net.teamfps.java.serialization.Type;

/**
 * @author Zekye
 *
 */
public class FloatArray extends Array {
	protected float[] data;

	public FloatArray(String name, float[] data) {
		super(name, Type.FLOAT);
		this.data = data;
		this.count = data.length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.teamfps.serialization.array.Array#getSize()
	 */
	@Override
	public int getSize() {
		return Type.BYTE.getSize() + Type.SHORT.getSize() + name.length + Type.BYTE.getSize() + Type.INT.getSize() + data.length * type.getSize();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.teamfps.serialization.array.Array#getBytes(byte[], int)
	 */
	@Override
	public int setBytes(byte[] dest, int pointer) {
		pointer = writeBytes(dest, pointer, CONTAINER_TYPE.getType());
		pointer = writeBytes(dest, pointer, nameLength);
		pointer = writeBytes(dest, pointer, name);
		pointer = writeBytes(dest, pointer, type.getType());
		pointer = writeBytes(dest, pointer, count);
		pointer = writeBytes(dest, pointer, data);
		return pointer;
	}

	@Override
	public String toString() {
		return CONTAINER_TYPE + "(" + getType() + "(\"" + getName() + "\"," + toStr(data) + "))";
	}

	public static FloatArray to(Container c) {
		return (c != null && c instanceof FloatArray) ? (FloatArray) c : null;
	}

	/**
	 * @return the data
	 */
	public float[] getData() {
		return data;
	}

	public int length() {
		return getData().length;
	}

	public int setData(int index, float value) {
		if (index >= 0 && index <= data.length - 1) data[index] = value;
		return index;
	}

	public float getData(int index) {
		if (index >= 0 && index <= data.length - 1) return data[index];
		return 0;
	}

}
