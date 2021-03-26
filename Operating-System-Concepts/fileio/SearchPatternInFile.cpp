// https://www.systutorials.com/how-to-process-a-file-line-by-line-in-c/
// https://stackoverflow.com/questions/2340281/check-if-a-string-contains-a-string-in-c

#include <iostream>
#include <fstream>
#include <string>

const std::string filename = "shakespeare.txt";

int main ()
{
    std::ifstream file(filename);
    std::string str;

    std::string pattern("day");

    while (std::getline(file, str)) {
        if (str.find(pattern) != std::string::npos) {
            std::cout << str << "\n";
        }
    }

    return 0;
}