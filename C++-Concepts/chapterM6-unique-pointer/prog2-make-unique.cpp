// make unique function
// https://www.learncpp.com/cpp-tutorial/stdunique_ptr/


#include <iostream>
#include <memory>

class Fraction
{
private:
    int m_numerator{ 0 };
	int m_denominator{ 1 };

public:
    Fraction(int n = 0, int d = 1) : m_numerator(n), m_denominator(d) { }

    friend std::ostream& operator<<(std::ostream& out, const Fraction& frac)
    {
        out << frac.m_numerator << "/" << frac.m_denominator;
        return out;
    }
};


int main()
{
    auto f1 { std::make_unique<Fraction>(3, 5) };
    std::cout << *f1 << "\n";

    auto f2 { std::make_unique<Fraction[]>(4) };
    std::cout << f2[3] << "\n";

    return 0;
}