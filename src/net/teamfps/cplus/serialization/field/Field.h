#pragma once
#include "../Container.h"
/**
* @author Zekye
*
*/
namespace teamfps {
	class Field : public Container {
	public:
		Field(string name, const Type type);
		virtual const int getSize() const = 0;
		virtual int setBytes(vector<ubyte>& dest, int pointer) = 0;
	};
}