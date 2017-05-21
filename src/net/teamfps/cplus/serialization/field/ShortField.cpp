#include "ShortField.h"
/**
* @author Zekye
*
*/
namespace teamfps {
	ShortField::ShortField(string name, const short data) : Field(name, Type::SHORT) {
		this->data = data;
	}

	short ShortField::getData() const {
		return data;
	}

	const int ShortField::getSize() const {
		return Type::BYTE.getSize() + Type::SHORT.getSize() + name.length() + Type::BYTE.getSize() + type.getSize();
	}

	int ShortField::setBytes(vector<ubyte>& dest, int pointer) {
		pointer = Writer::writeBytes(dest, pointer, CONTAINER_TYPE.getType());
		pointer = Writer::writeBytes(dest, pointer, nameLength);
		pointer = Writer::writeBytes(dest, pointer, nameChars);
		pointer = Writer::writeBytes(dest, pointer, type.getType());
		pointer = Writer::writeBytes(dest, pointer, data);
		return pointer;
	}

}