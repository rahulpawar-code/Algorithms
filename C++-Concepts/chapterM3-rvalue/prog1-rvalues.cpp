// rvalue - basics
// https://www.learncpp.com/cpp-tutorial/rvalue-references/

#include <iostream>

class Fraction
{
private:
    int m_num;
    int m_den;

public:
    Fraction(int n = 0, int d = 1) : m_num(n), m_den(d) { }

    friend std::ostream& operator<<(std::ostream& out, const Fraction& f)
    {
        out << f.m_num << "/" << f.m_den;
        return out;
    }
};

int main()
{
    int x = 5;
    int &lval { x} ;
    int &&rval { 5 };
    std::cout << "x using lval ref : " << lval << "\n";
    std::cout << "rval ref : " << rval << "\n";

    auto &&fracrref { Fraction{3, 5} };
    std::cout << "fraction value using rref : " << fracrref << "\n";

    int &&rref { 5 };
    rref = 10;
    std::cout << "rref : " << rref << "\n";

    return 0;
}