#include <string>
#include <iostream>
#include <regex>
#include <fstream>


const std::regex decimalre("(-)?[0-9]+");
const std::regex octalre("(-)?(0)([0-7]*)");
const std::regex hexre("-?0[xX][0-9a-fA-F]*");

enum class TYPE
{
    HEX = 0,
    DECIMAL,
    OCTAL,
    OTHER
};

TYPE getType(std::string& word)
{
    TYPE type = TYPE::OTHER;
    if (std::regex_match(word, decimalre)) {
        type = TYPE::DECIMAL;
    } else if (std::regex_match(word, octalre)) {
        type = TYPE::OCTAL;
    } else if (std::regex_match(word, hexre)) {
        type = TYPE::HEX;
    }
    return type;
}

int main()
{
    std::string iFileName = "ifile.txt";
    std::ifstream iFile(iFileName);

    if (!iFile.is_open()) {
        std::cout << "ERROR: can't open file for reading\n";
        return 1;
    }

    std::string oFileName = "ofile.txt";
    std::ofstream oFile(oFileName);
    if (!oFile.is_open()) {
        std::cout << "ERROR: can't open file for writing\n";
        iFile.close();
        return 1;
    }


    std::string word;
    std::stringstream ss;
    int value;
    while (iFile >> word) {
        TYPE type = getType(word);
        ss << word;
        switch(static_cast<TYPE>(type)) {
            case TYPE::DECIMAL:
                ss >> std::dec >> value;
                oFile << value << " ";
                break;
            case TYPE::OCTAL:
                ss >> std::oct >> value;
                oFile << value << " ";
                break;
            case TYPE::HEX:
                ss >> std::dec >> value;
                oFile << value << " ";
                break;
            default:
                oFile << word << " ";
                break;
        }
        ss << "";
    }

    iFile.close();
    oFile.close();

    return 0;
}