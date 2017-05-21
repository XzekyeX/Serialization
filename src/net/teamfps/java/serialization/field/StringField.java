/**
 * 
 */
package net.teamfps.java.serialization.field;

import static net.teamfps.java.serialization.Utils.*;

import net.teamfps.java.serialization.Container;
import net.teamfps.java.serialization.Type;

/**
 * @author Zekye
 *
 */
public class StringField extends Field {
	protected String data;

	public StringField(String name, String data) {
		super(name, Type.STRING);
		this.data = data;
	}

	@Override
	public int getSize() {
		return Type.BYTE.getSize() + Type.SHORT.getSize() + name.length + Type.BYTE.getSize() + Type.INT.getSize() + data.length() * type.getSize();
	}

	@Override
	public int setBytes(byte[] dest, int pointer) {
		pointer = writeBytes(dest, pointer, CONTAINER_TYPE.getType());
		pointer = writeBytes(dest, pointer, nameLength);
		pointer = writeBytes(dest, pointer, name);
		pointer = writeBytes(dest, pointer, type.getType());
		pointer = writeBytes(dest, pointer, data.length());
		pointer = writeBytes(dest, pointer, data.getBytes());
		return pointer;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void addData(String data) {
		this.data += data;
	}

	public boolean equals(StringField other) {
		return (getData().equals(other.getData())) && (getName().equals(other.getName()));
	}

	public static StringField to(Container c) {
		return (c != null && c instanceof StringField) ? (StringField) c : null;
	}

	@Override
	public String toString() {
		return CONTAINER_TYPE + "(" + getType() + "(\"" + getName() + "\"," + getData() + "))";
	}

}
