#pragma once
#include "Types.h"
/**
* @author Zekye
*
*/
namespace teamfps {
	class Type {
	public:
		static const Type UNKNOWN, BYTE, SHORT, CHAR, INT, LONG, FLOAT, DOUBLE, BOOLEAN, STRING;
	protected:
		ubyte type;
		uint size;
	public:
		Type(const ubyte type, const uint size);
		const ubyte getType() const;
		const uint getSize() const;
	};
}