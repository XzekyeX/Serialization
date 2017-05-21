/**
 * 
 */
package net.teamfps.java.serialization;

/**
 * @author Zekye
 *
 */
public enum Type {
	UNKNOWN(0, 0), BYTE(1, 1), SHORT(2, 2), CHAR(3, 2), INT(4, 4), LONG(5, 8), FLOAT(6, 4), DOUBLE(7, 8), BOOLEAN(8, 1), STRING(9, 1);
	private final byte type;

	private final int size;

	private Type(int type, int size) {
		this.type = (byte) type;
		this.size = size;
	}

	/**
	 * @return the id
	 */
	public byte getType() {
		return type;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	public static Type getType(byte type) {
		for (Type t : values()) {
			if (t.getType() == type) {
				return t;
			}
		}
		assert (false);
		return UNKNOWN;
	}

}
