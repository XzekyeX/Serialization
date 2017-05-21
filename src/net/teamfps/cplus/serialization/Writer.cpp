#include "Writer.h"
/**
* @author Zekye
*
*/
namespace teamfps {

	int Writer::writeBytes(vector<ubyte>& dest, int pointer, const ubyte& value) {
		dest.push_back(value);
		pointer++;
		return pointer;
	}

	int Writer::writeBytes(vector<ubyte>& dest, int pointer, const vector<ubyte>& value) {
		for (int i = 0; i < value.size(); i++) {
			pointer = writeBytes(dest, pointer, value[i]);
		}
		return pointer;
	}

	int Writer::writeBytes(vector<ubyte>& dest, int pointer, const char& value) {
		ubyte byte = static_cast<ubyte>(value);
		dest.push_back(byte);
		pointer++;
		return pointer;
	}

	int Writer::writeBytes(vector<ubyte>& dest, int pointer, const vector<char>& value) {
		for (int i = 0; i < value.size(); i++) {
			pointer = writeBytes(dest, pointer, value[i]);
		}
		return pointer;
	}

	int Writer::writeBytes(vector<ubyte>& dest, int pointer, const short& value) {
		//dest[pointer++] = (ubyte)((value >> 8) & 0xFF);
		//dest[pointer++] = (ubyte)((value >> 0) & 0xFF);
		dest.push_back((ubyte)((value >> 8) & 0xFF));
		dest.push_back((ubyte)((value >> 0) & 0xFF));
		pointer += 2;
		return pointer;
	}

	int Writer::writeBytes(vector<ubyte>& dest, int pointer, const vector<short>& value) {
		//for (int i = 0; i < sizeof(value) / sizeof(short); i++) pointer = writeBytes(dest, pointer, value[i]);
		for (int i = 0; i < value.size(); i++) {
			pointer = writeBytes(dest, pointer, value[i]);
		}
		return pointer;
	}

	int Writer::writeBytes(vector<ubyte>& dest, int pointer, const int& value) {
		//dest[pointer++] = (ubyte)((value >> 24) & 0xFF);
		//dest[pointer++] = (ubyte)((value >> 16) & 0xFF);
		//dest[pointer++] = (ubyte)((value >> 8) & 0xFF);
		//dest[pointer++] = (ubyte)((value >> 0) & 0xFF);
		dest.push_back((ubyte)((value >> 24) & 0xFF));
		dest.push_back((ubyte)((value >> 16) & 0xFF));
		dest.push_back((ubyte)((value >> 8) & 0xFF));
		dest.push_back((ubyte)((value >> 0) & 0xFF));
		pointer += 4;
		return pointer;
	}

	int Writer::writeBytes(vector<ubyte>& dest, int pointer, const vector<int>& value) {
		//for (int i = 0; i < sizeof(value) / sizeof(int); i++) pointer = writeBytes(dest, pointer, value[i]);
		for (int i = 0; i < value.size(); i++) {
			pointer = writeBytes(dest, pointer, value[i]);
		}
		return pointer;
	}

	int Writer::writeBytes(vector<ubyte>& dest, int pointer, const float& value) {
		unsigned long d = *(unsigned long *)&value;
		dest.push_back((ubyte)((d >> 24) & 0xFF));
		dest.push_back((ubyte)((d >> 16) & 0xFF));
		dest.push_back((ubyte)((d >> 8) & 0xFF));
		dest.push_back((ubyte)((d >> 0) & 0xFF));
		pointer += 4;
		return pointer;
	}

	int Writer::writeBytes(vector<ubyte>& dest, int pointer, const vector<float>& value) {
		//for (int i = 0; i < sizeof(value) / sizeof(int); i++) pointer = writeBytes(dest, pointer, value[i]);
		for (int i = 0; i < value.size(); i++) {
			pointer = writeBytes(dest, pointer, value[i]);
		}
		return pointer;
	}

	int Writer::writeBytes(vector<ubyte>& dest, int pointer, const double& value) {
		unsigned long long d = *(unsigned long long *)&value;
		dest.push_back((ubyte)((d >> 56) & 0xFF));
		dest.push_back((ubyte)((d >> 48) & 0xFF));
		dest.push_back((ubyte)((d >> 40) & 0xFF));
		dest.push_back((ubyte)((d >> 32) & 0xFF));
		dest.push_back((ubyte)((d >> 24) & 0xFF));
		dest.push_back((ubyte)((d >> 16) & 0xFF));
		dest.push_back((ubyte)((d >> 8) & 0xFF));
		dest.push_back((ubyte)((d >> 0) & 0xFF));
		pointer += 8;
		return pointer;
	}

	ubyte Writer::readByte(vector<ubyte>& src, int pointer) {
		return (src[pointer]);
	}

	short Writer::readShort(vector<ubyte>& src, int pointer) {
		return (short)((src[pointer] << 8) | src[pointer + 1]);
	}

	int Writer::readInt(vector<ubyte>& src, int pointer) {
		return (int)((src[pointer] << 24) | (src[pointer + 1] << 16) | (src[pointer + 2] << 8) | src[pointer + 3]);
	}

	uint Writer::readUInt(vector<ubyte>& src, int pointer) {
		return (unsigned int)((src[pointer] << 24) | (src[pointer + 1] << 16) | (src[pointer + 2] << 8) | src[pointer + 3]);
	}

	float Writer::readFloat(vector<ubyte>& src, int pointer) {
		return (float)((src[pointer] << 24) | (src[pointer + 1] << 16) | (src[pointer + 2] << 8) | src[pointer + 3]);
	}

	int Writer::readInt(ubyte b0, ubyte b1, ubyte b2, ubyte b3) {
		return (int)((b0 << 24) | (b1 << 16) | (b2 << 8) | b3);
	}
}