#pragma once
#include "Types.h"
/**
* @author Zekye
*
*/
namespace teamfps {
	class Writer {
	public:
		static int writeBytes(vector<ubyte>& dest, int pointer, const ubyte& value);
		static int writeBytes(vector<ubyte>& dest, int pointer, const vector<ubyte>& value);
		static int writeBytes(vector<ubyte>& dest, int pointer, const char& value);
		static int writeBytes(vector<ubyte>& dest, int pointer, const vector<char>& value);
		static int writeBytes(vector<ubyte>& dest, int pointer, const short& value);
		static int writeBytes(vector<ubyte>& dest, int pointer, const vector<short>& value);
		static int writeBytes(vector<ubyte>& dest, int pointer, const int& value);
		static int writeBytes(vector<ubyte>& dest, int pointer, const vector<int>& value);
		static int writeBytes(vector<ubyte>& dest, int pointer, const float& value);
		static int writeBytes(vector<ubyte>& dest, int pointer, const vector<float>& value);
		static int writeBytes(vector<ubyte>& dest, int pointer, const double& value);
		static int writeBytes(vector<ubyte>& dest, int pointer, const vector<double>& value);

		static ubyte readByte(vector<ubyte>& src, int pointer);
		static short readShort(vector<ubyte>& src, int pointer);
		static int readInt(vector<ubyte>& src, int pointer);
		static uint readUInt(vector<ubyte>& src, int pointer);
		static float readFloat(vector<ubyte>& src, int pointer);
		static int readInt(ubyte b0, ubyte b1, ubyte b2, ubyte b3);

	};
}
