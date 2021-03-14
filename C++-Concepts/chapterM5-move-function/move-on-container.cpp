// using std::move on container
// https://www.learncpp.com/cpp-tutorial/stdmove/
// https://en.cppreference.com/w/cpp/utility/move

#include <iostream>
#include <string>
#include <vector>
#include <utility>

int main()
{
    std::vector<std::string> v;
    std::string str = "knock";

    std::cout << "Copying std variable: \n";
    v.push_back(str);

    std::cout << "str: " << str << "\n";
    std::cout << "vector : " << v[0] << "\n";

    std::cout << "===============================\n";

    std::cout << "Moving std variable: \n";
    v.push_back(std::move(str));

    std::cout << "str: " << str << "\n";
    std::cout << "vector : " << v[0] << " " << v[1] <<"\n";

    return 0;
}