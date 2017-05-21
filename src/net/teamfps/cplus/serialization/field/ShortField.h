#pragma once
#include "Field.h"
/**
* @author Zekye
*
*/
namespace teamfps {
	class ShortField : public Field {
	private:
		short data;
	public:
		ShortField(string name, const short data);
		short getData() const;
		virtual const int getSize() const override;
		virtual int setBytes(vector<ubyte>& dest, int pointer) override;
	};
}