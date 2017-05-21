#include "Serialization.h"
#include <iostream>
#include <ctime>
#define println(str) std::cout << str << std::endl;

JNIEXPORT jstring JNICALL Java_Serialization_getDate(JNIEnv *env, jobject obj) {
	time_t rawtime;
	struct tm * timeinfo;
	char buffer[80];
	time(&rawtime);
	timeinfo = localtime(&rawtime);
	strftime(buffer, sizeof(buffer), "%d-%m-%Y %I:%M:%S", timeinfo);
	std::string str(buffer);
//	println(str.c_str());
	return env->NewStringUTF(str.c_str());
}