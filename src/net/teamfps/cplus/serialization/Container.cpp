#include "Container.h"
/**
* @author Zekye
*
*/
namespace teamfps {
	Container::Container(const ContainerType CONTAINER_TYPE, const Type type) : CONTAINER_TYPE(CONTAINER_TYPE), type(type) {}
	void Container::setName(const string name) {
		this->name = name;
		this->nameLength = (short)name.length();
		this->nameChars = vector<char>(name.begin(), name.end());
	}
}
