// rvalue - basics
// https://www.learncpp.com/cpp-tutorial/rvalue-references/

#include <iostream>

void foo(const int& x)
{
    std::cout << "foo : l-value reference to const\n";
}

void foo(int&& x)
{
    std::cout << "foo : r-value reference\n";
}

void bar(const int& x)
{
    std::cout << "bar : l-value reference to const\n";
}

int main()
{
    int x { 5 };

    foo(x); // l-value argument calls l-value version of function
    foo(5); // r-value argument calls r-value version of function

    std::cout << "=========================\n";
    int&& rref { 10 };
    foo(rref);

    std::cout << "=========================\n";
    bar(x);
    bar(5);

    return 0;
}