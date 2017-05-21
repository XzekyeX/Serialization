#pragma once
#include "Writer.h"
#include "Types.h"

/**
* @author Zekye
*
*/
namespace teamfps {
	class Container {
	protected:
		ContainerType CONTAINER_TYPE;
		Type type;
		short nameLength;
		string name;
		vector<char> nameChars;
		void setName(const string name);
	public:
		Container(const ContainerType CONTAINER_TYPE, const Type type);
		virtual const int getSize() const = 0;
		virtual int setBytes(vector<ubyte>& dest, int pointer) = 0;
	};
}