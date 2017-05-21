#pragma once
#include "Types.h"
/**
* @author Zekye
*
*/
namespace teamfps {
	class ContainerType {
	public:
		static const ContainerType UNKNOWN, FIELD, ARRAY, OBJECT;
	protected:
		ubyte type;
	public:
		ContainerType(const ubyte type);
		const ubyte getType() const;
	};
}
