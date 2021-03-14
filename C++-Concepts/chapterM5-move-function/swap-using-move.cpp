// Swap using std::move function
// https://www.learncpp.com/cpp-tutorial/stdmove/

#include <iostream>
#include <string>
#include <utility>

template <typename T>
void swap(T& a, T& b)
{
    T temp { std::move(a) };  // invoke move constructor
    a = std::move(b);         // invoke move assignment
    b = std::move(temp);      // invoke move assignment
}

int main()
{
    std::string x { "hello"};
    std::string y { "world!"};

    std::cout << "Before swapping : \n";
    std::cout << "x : " << x << "\n";
    std::cout << "y : " << y << "\n";

    swap(x, y);
    std::cout << "After swapping : \n";
    std::cout << "x : " << x << "\n";
    std::cout << "y : " << y << "\n";

    return 0;
}