#ifndef TPV_TC_H_

#include <algorithm>
#include <string>
using namespace std;
class Text
{
private:
	string str;
	char output [2048];
	
	public: 
		Text (char *input)
		{
			str=input;
		}
		Text ()
		{
				str="\0";
		}
		char* Odstran_new_line(char *input)
		{
			char* output;
			string tmp_str(str);
			tmp_str.erase(std::remove(tmp_str.begin(), tmp_str.end(), '\n'), tmp_str.end());
		return	output;
		}

};

#endif