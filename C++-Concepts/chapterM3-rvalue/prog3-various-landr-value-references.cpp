// rvalue - valrious l and r value references
// https://www.learncpp.com/cpp-tutorial/rvalue-references/

int main()
{
    int x{};

    // l-value references
    int &ref1{ x }; // A
    int &ref2{ 5 }; // B

    const int &ref3{ x }; // C
    const int &ref4{ 5 }; // D

    // r-value references
    int &&ref5{ x }; // E
    int &&ref6{ 5 }; // F

    const int &&ref7{ x }; // G
    const int &&ref8{ 5 }; // H

    return 0;
}