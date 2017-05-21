@echo Starting vsvars32.bat...
@call "F:\Program Files (x86)\Microsoft Visual Studio 14.0\Common7\Tools\vsvars32.bat" 
cd ..
cl Serialization.cpp /LD:\lib\Serialization.dll
pause