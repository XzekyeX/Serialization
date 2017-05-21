#include "Field.h"
/**
* @author Zekye
*
*/
namespace teamfps {
	Field::Field(string name, Type type) : Container(ContainerType::FIELD, type) {
		setName(name);
	}
}