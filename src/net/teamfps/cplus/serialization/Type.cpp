#include "Type.h"
/**
* @author Zekye
*
*/
namespace teamfps {
	const Type Type::UNKNOWN = Type(0, 0);
	const Type Type::BYTE = Type(1, 1);
	const Type Type::SHORT = Type(2, 2);
	const Type Type::CHAR = Type(3, 1);
	const Type Type::INT = Type(4, 4);
	const Type Type::LONG = Type(5, 8);
	const Type Type::FLOAT = Type(6, 4);
	const Type Type::DOUBLE = Type(7, 8);
	const Type Type::BOOLEAN = Type(8, 1);
	const Type Type::STRING = Type(9, 1);

	Type::Type(ubyte type, uint size) : type(type), size(size) {}

	const ubyte Type::getType() const {
		return type;
	}

	const uint Type::getSize() const {
		return size;
	}
}