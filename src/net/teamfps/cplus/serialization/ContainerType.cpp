#include "ContainerType.h"
/**
* @author Zekye
*
*/
namespace teamfps {
	const ContainerType ContainerType::UNKNOWN = ContainerType(0);
	const ContainerType ContainerType::FIELD = ContainerType(1);
	const ContainerType ContainerType::ARRAY = ContainerType(2);
	const ContainerType ContainerType::OBJECT = ContainerType(3);

	ContainerType::ContainerType(ubyte type) : type(type) {}

	const ubyte ContainerType::getType() const {
		return type;
	}
}