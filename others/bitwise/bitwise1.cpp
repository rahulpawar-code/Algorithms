/*
 * https://www.techiedelight.com/bit-hacks-part-1-basic/
 */

#include <iostream>
#include <bitset>
#include <climits>   // For CHAR_BIT
#include <cstddef>

template <typename T>
std::size_t bit_size()
{
    return sizeof(T) * CHAR_BIT;
}

template <typename T>
static bool isEven(T n)
{
    return ((n & 1) == 0);
}

template <typename T>
static bool isOdd(T n)
{
    return ((n & 1) != 0);
}

template <typename T>
static bool hasOppositeSigns(T x, T y)
{
    return ((x ^ y) < 0);
}

template <typename T>
static T addOne(T n)
{
    return -~n;
}

template <typename T>
static void swap(T& a, T& b)
{
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
}

template <typename T>
static void turnOffNthBit(T& num, T n)
{
    num = num & ~(1 << n);
}

template <typename T>
static void turnOnNthBit(T& num, T n)
{
    num = num | (1 << n);
}

template <typename T>
static bool isNthBitSet(T num, T n)
{
    return (num & (1 << n)) != 0;
}

template <typename T>
static T clearRightmostBit(T num)
{
    return num & (num - 1);
}

template <typename T>
static bool isPowerOfTwo(T num)
{
    return (num & (num - 1)) == 0;
}

int main()
{
    std::cout << "==================================================" << std::endl;
    int a = 123;
    std::bitset<sizeof(int) * CHAR_BIT> bitsA(a);
    std::cout << "a : " << a << ", in bits : " << bitsA << std::endl;

    a = 34;
    std:: cout << "a : " << a << ", isEven(a) : " << std::boolalpha
                << isEven(a) << std::endl;

    a = 218937393;
    std:: cout << "a : " << a << ", isOdd(a) : " << std::boolalpha
                << isOdd(a) << std::endl;

    std::cout << "==================================================" << std::endl;

    int x = 4;
    int y = -8;
    std::cout << "x: " << x << ", in binary " << std::bitset<32>(x) << std::endl;
    std::cout << "y: " << y << ", in binary " << std::bitset<32>(y) << std::endl;
    std::cout << "x & y has opposite signs? :  " << std::boolalpha
                << hasOppositeSigns(x, y) << std::endl;

    std::cout << "==================================================" << std::endl;
    x = -11;
    std::cout << "x: " << x << ", in binary " << std::bitset<32>(x) << std::endl;
    std::cout << "addOne(x) : " << addOne(x) << std::endl;
    y = 123;
    std::cout << "y: " << y << ", in binary " << std::bitset<32>(y) << std::endl;
    std::cout << "addOne(y) : " << addOne(y) << std::endl;

    std::cout << "==================================================" << std::endl;

    std::cout << "Before swap : x = " << x << " , y = " << y << std::endl;
    swap(x, y);
    std::cout << "After swap : x = " << x << " , y = " << y << std::endl;

    std::cout << "==================================================" << std::endl;

    std::cout << "x : " << x << ", in binary " << std::bitset<32>(x) << std::endl;
    turnOffNthBit(x, 4);
    std::cout << "4th bit off x: " << x << ", in binary " << std::bitset<32>(x) << std::endl;

    std::cout << "==================================================" << std::endl;

    std::cout << "x : " << x << ", in binary " << std::bitset<32>(x) << std::endl;
    turnOnNthBit(x, 12);
    std::cout << "12th bit on x : " << x << ", in binary " << std::bitset<32>(x) << std::endl;

    std::cout << "==================================================" << std::endl;

    std::cout << "x : " << x << ", in binary " << std::bitset<32>(x) << std::endl;
    std::cout << "Is 12th bit set : " << std::boolalpha << isNthBitSet(x, 12) << std::endl;

    std::cout << "==================================================" << std::endl;

    std::cout << "x : " << x << ", in binary " << std::bitset<32>(x) << std::endl;
    x = clearRightmostBit(x);
    std::cout << "Rightmost bit clear, x : " << x << ", in binary " << std::bitset<32>(x) << std::endl;

    std::cout << "==================================================" << std::endl;

    std::cout << "x : " << x << ", in binary " << std::bitset<32>(x) << std::endl;
    std::cout << "Is power of 2 : " << std::boolalpha << isPowerOfTwo(x) << std::endl;


    return 0;
}
