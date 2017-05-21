#include "IntField.h"
/**
* @author Zekye
*
*/
namespace teamfps {
	IntField::IntField(string name, const int data) : Field(name, Type::INT) {
		this->data = data;
	}

	int IntField::getData() const {
		return data;
	}

	const int IntField::getSize() const {
		return Type::BYTE.getSize() + Type::SHORT.getSize() + name.length() + Type::BYTE.getSize() + type.getSize();
	}

	int IntField::setBytes(vector<ubyte>& dest, int pointer) {
		pointer = Writer::writeBytes(dest, pointer, CONTAINER_TYPE.getType());
		pointer = Writer::writeBytes(dest, pointer, nameLength);
		pointer = Writer::writeBytes(dest, pointer, nameChars);
		pointer = Writer::writeBytes(dest, pointer, type.getType());
		pointer = Writer::writeBytes(dest, pointer, data);
		return pointer;
	}

}