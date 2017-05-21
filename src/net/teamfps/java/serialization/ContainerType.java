/**
 * 
 */
package net.teamfps.java.serialization;

/**
 * @author Zekye
 *
 */
public enum ContainerType {

	UNKNOWN(0), FIELD(1), ARRAY(2), OBJECT(3);

	private final byte type;

	private ContainerType(int type) {
		this.type = (byte) type;
	}

	public byte getType() {
		return type;
	}

	public static ContainerType getType(byte type) {
		for (ContainerType t : values()) {
			if (t.getType() == type) {
				return t;
			}
		}
		assert (false);
		return UNKNOWN;
	}
}
