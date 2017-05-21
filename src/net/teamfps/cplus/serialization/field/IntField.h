#pragma once
#include "Field.h"
/**
* @author Zekye
*
*/
namespace teamfps {
	class IntField : public Field {
	private:
		int data;
	public:
		IntField(string name, const int data);
		int getData() const;
		virtual const int getSize() const override;
		virtual int setBytes(vector<ubyte>& dest, int pointer) override;
	};
}