package net.teamfps.java.serialization;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import net.teamfps.java.serialization.field.IntField;
import net.teamfps.java.serialization.field.StringField;

/**
 * 
 * @author Zekye
 *
 */
public class Utils {
	public static final byte[] HEADER = "FPS".getBytes();
	public static final short VERSION = 0x0100;

	public static byte[] load(String path) {
		try {
			File f = new File(path);
			byte[] data = new byte[(int) f.length()];
			FileInputStream is = new FileInputStream(f);
			if (is.read(data) == -1) {
				is.close();
				return data;
			}
			is.close();
			return data;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] load(String path, String file) {
		try {
			File p = new File(path);
			File f = new File(p, file);
			byte[] data = new byte[(int) f.length()];
			FileInputStream is = new FileInputStream(f);
			if (is.read(data) == -1) {
				is.close();
				return data;
			}
			is.close();
			return data;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean save(String path, byte[] data) {
		try {
			File f = new File(path);
			if (!f.exists()) {
				if (!f.isDirectory() && f.createNewFile()) {
					System.out.println("new file has been created!");
				}
			}
			FileOutputStream fos = new FileOutputStream(f);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			System.out.println("Saving " + path);
			bos.write(data);
			bos.close();
			fos.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean save(String path, String file, Container c) {
		byte[] data = new byte[c.getSize()];
		c.setBytes(data, 0);
		return save(path, file, data);
	}

	public static boolean save(String path, String file, byte[] data) {
		try {
			File p = new File(path);
			if (!p.exists() && p.mkdirs()) System.out.println("new folder has been created!");
			File f = new File(p, file);
			if (!f.exists()) {
				if (!f.isDirectory() && f.createNewFile()) {
					System.out.println("new file has been created!");
				}
			}
			FileOutputStream fos = new FileOutputStream(f);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			System.out.println("Saving " + file);
			bos.write(data);
			bos.close();
			fos.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static int writeBytes(byte[] dest, int pointer, byte[] value) {
		for (int i = 0; i < value.length; i++)
			pointer = writeBytes(dest, pointer, value[i]);
		return pointer;
	}

	public static int writeBytes(byte[] dest, int pointer, short[] value) {
		for (int i = 0; i < value.length; i++)
			pointer = writeBytes(dest, pointer, value[i]);
		return pointer;
	}

	public static int writeBytes(byte[] dest, int pointer, char[] value) {
		for (int i = 0; i < value.length; i++)
			pointer = writeBytes(dest, pointer, value[i]);
		return pointer;
	}

	public static int writeBytes(byte[] dest, int pointer, int[] value) {
		for (int i = 0; i < value.length; i++)
			pointer = writeBytes(dest, pointer, value[i]);
		return pointer;
	}

	public static int writeBytes(byte[] dest, int pointer, long[] value) {
		for (int i = 0; i < value.length; i++)
			pointer = writeBytes(dest, pointer, value[i]);
		return pointer;
	}

	public static int writeBytes(byte[] dest, int pointer, float[] value) {
		for (int i = 0; i < value.length; i++)
			pointer = writeBytes(dest, pointer, value[i]);
		return pointer;
	}

	public static int writeBytes(byte[] dest, int pointer, double[] value) {
		for (int i = 0; i < value.length; i++)
			pointer = writeBytes(dest, pointer, value[i]);
		return pointer;
	}

	public static int writeBytes(byte[] dest, int pointer, boolean[] value) {
		for (int i = 0; i < value.length; i++)
			pointer = writeBytes(dest, pointer, value[i]);
		return pointer;
	}

	public static int writeBytes(byte[] dest, int pointer, String[] value) {
		for (int i = 0; i < value.length; i++)
			pointer = writeBytes(dest, pointer, value[i]);
		return pointer;
	}

	public static int writeBytes(byte[] dest, int pointer, byte value) {
		if (pointer > dest.length) return pointer;
		dest[pointer++] = value;
		return pointer;
	}

	public static int writeBytes(byte[] dest, int pointer, short value) {
		if (pointer > dest.length) return pointer;
		dest[pointer++] = (byte) ((value >> 8) & 0xff);
		dest[pointer++] = (byte) ((value >> 0) & 0xff);
		return pointer;
	}

	public static int writeBytes(byte[] dest, int pointer, char value) {
		if (pointer > dest.length) return pointer;
		dest[pointer++] = (byte) ((value >> 8) & 0xff);
		dest[pointer++] = (byte) ((value >> 0) & 0xff);
		return pointer;
	}

	public static int writeBytes(byte[] dest, int pointer, int value) {
		if (pointer > dest.length) return pointer;
		dest[pointer++] = (byte) ((value >> 24) & 0xff);
		dest[pointer++] = (byte) ((value >> 16) & 0xff);
		dest[pointer++] = (byte) ((value >> 8) & 0xff);
		dest[pointer++] = (byte) ((value >> 0) & 0xff);
		return pointer;
	}

	public static int writeBytes(byte[] dest, int pointer, long value) {
		if (pointer > dest.length) return pointer;
		dest[pointer++] = (byte) ((value >> 56) & 0xff);
		dest[pointer++] = (byte) ((value >> 48) & 0xff);
		dest[pointer++] = (byte) ((value >> 40) & 0xff);
		dest[pointer++] = (byte) ((value >> 32) & 0xff);
		dest[pointer++] = (byte) ((value >> 24) & 0xff);
		dest[pointer++] = (byte) ((value >> 16) & 0xff);
		dest[pointer++] = (byte) ((value >> 8) & 0xff);
		dest[pointer++] = (byte) ((value >> 0) & 0xff);
		return pointer;
	}

	public static int writeBytes(byte[] dest, int pointer, float value) {
		return writeBytes(dest, pointer, getBytes(value));
	}

	public static int writeBytes(byte[] dest, int pointer, double value) {
		return writeBytes(dest, pointer, getBytes(value));
	}

	public static int writeBytes(byte[] dest, int pointer, boolean value) {
		dest[pointer++] = (byte) (value ? 1 : 0);
		return pointer;
	}

	public static int writeBytes(byte[] dest, int pointer, String value) {
		pointer = writeBytes(dest, pointer, (short) value.length());
		return writeBytes(dest, pointer, value.getBytes());
	}

	public static byte[] getBytes(float value) {
		return ByteBuffer.allocate(4).putFloat(value).array();
	}

	public static byte[] getBytes(double value) {
		return ByteBuffer.allocate(8).putDouble(value).array();
	}

	public static byte readByte(byte[] src, int pointer) {
		return src[pointer];
	}

	public static short readShort(byte[] src, int pointer) {
		return ByteBuffer.wrap(src, pointer, 2).getShort();
	}

	public static short readShort(byte b0, byte b1) {
		return readShort(new byte[] { b0, b1 }, 0);
	}

	public static char readChar(byte[] src, int pointer) {
		return ByteBuffer.wrap(src, pointer, 2).getChar();
	}

	public static char readChar(byte b0, byte b1) {
		return readChar(new byte[] { b0, b1 }, 0);
	}

	public static int readInt(byte[] src, int pointer) {
		return ByteBuffer.wrap(src, pointer, 4).getInt();
	}

	public static int readInt(byte b0, byte b1, byte b2, byte b3) {
		return readInt(new byte[] { b0, b1, b2, b3 }, 0);
	}

	public static float readFloat(byte[] src) {
		return ByteBuffer.wrap(src).getFloat();
	}

	public static float readFloat(byte b0, byte b1, byte b2, byte b3) {
		return readFloat(new byte[] { b0, b1, b2, b3 });
	}

	public static long readLong(byte[] src, int pointer) {
		return ByteBuffer.wrap(src, pointer, 8).getLong();
	}

	public static long readLong(byte b0, byte b1, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7) {
		return readLong(new byte[] { b0, b1, b2, b3, b4, b5, b6, b7 }, 0);
	}

	public static double readDouble(byte[] src) {
		return ByteBuffer.wrap(src).getDouble();
	}

	public static double readDouble(byte b0, byte b1, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7) {
		return readDouble(new byte[] { b0, b1, b2, b3, b4, b5, b6, b7 });
	}

	public static boolean readBoolean(byte[] src, int pointer) {
		// assert (src[pointer] == 0 || src[pointer] == 1);
		return src[pointer] != 0;
	}

	public static boolean readBoolean(byte b) {
		return b != 0;
	}

	public static String toStr(byte data) {
		return String.format("0x%x", data);
	}

	public static String toStr(byte[] data) {
		StringBuilder sb = new StringBuilder();
		if (data == null) return "[" + sb.toString() + "]";
		for (int i = 0; i < data.length; i++) {
			sb.append(i < data.length - 1 ? String.format("0x%x", data[i]) + "," : String.format("0x%x ", data[i]));
		}
		return "[" + sb.toString() + "]";
	}

	public static String between(String str, String ch0, String ch1) {
		if (str.contains(ch0) && str.contains(ch1)) {
			int bi = str.indexOf(ch0);
			int ei = str.indexOf(ch1);
			return str.trim().substring(bi + 1, ei);
		}
		return str;
	}

	public static String toStrBytes(byte[] data) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			sb.append(String.format("0x%x ", data[i]));
		}
		return "[" + sb.toString() + "]";
	}

	public static String toStr(short[] data) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			sb.append(i < data.length - 1 ? data[i] + "," : data[i]);
		}
		return "[" + sb.toString() + "]";
	}

	public static String toStr(char[] data) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			sb.append(i < data.length - 1 ? data[i] + "," : data[i]);
		}
		return "[" + sb.toString() + "]";
	}

	public static String toStr(int[] data) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			sb.append(i < data.length - 1 ? data[i] + "," : data[i]);
		}
		return "[" + sb.toString() + "]";
	}

	public static String toStr(long[] data) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			sb.append(i < data.length - 1 ? data[i] + "," : data[i]);
		}
		return "[" + sb.toString() + "]";
	}

	public static String toStr(float[] data) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			sb.append(i < data.length - 1 ? data[i] + "," : data[i]);
		}
		return "[" + sb.toString() + "]";
	}

	public static String toStr(double[] data) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			sb.append(i < data.length - 1 ? data[i] + "," : data[i]);
		}
		return "[" + sb.toString() + "]";
	}

	public static String toStr(boolean[] data) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			sb.append(i < data.length - 1 ? data[i] + "," : data[i]);
		}
		return "[" + sb.toString() + "]";
	}

	public static String toStrText(byte[] name) {
		return new String(name);
	}

	public static String toStr(Container c) {
		return (c != null && c instanceof StringField) ? ((StringField) c).getData() : null;
	}

	public static ContainerObject toObj(Container c) {
		return (c != null && c instanceof ContainerObject) ? (ContainerObject) c : null;
	}

	public static int toInt(Container c) {
		return (c != null && c instanceof IntField) ? ((IntField) c).getData() : 0;
	}

}
