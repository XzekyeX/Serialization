#include "Serialization.h"
#include "net\teamfps\cplus\serialization\Writer.h"
#include "net\teamfps\cplus\serialization\field\Fields.h"

using namespace teamfps;
int main() {
	vector<ubyte> dest;
	ShortField sf("Short", 128);
	sf.setBytes(dest, 0);
	IntField intf("Int", 32);
	intf.setBytes(dest, 0);
	printHex("Bytes: ", dest);
	system("pause");
	return 0;
}

void printHex(char* str, const vector<ubyte>& data) {
	std::cout << str;
	for (int i = 0; i < data.size(); i++) {
		if (i < data.size() - 1) std::cout << "0x" << std::hex << (int)data[i] << " ";
		else std::cout << "0x" << std::hex << (int)data[i] << std::endl;
	}
}