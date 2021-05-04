// https://www.learncpp.com/cpp-tutorial/random-number-generation/

#include <iostream>

unsigned int PRNG()
{
    static unsigned int seed { 5323 };
    seed = 8253729 * seed + 2396403;
    return seed % 32768;
}

int main()
{
    for (int i {1}; i <= 100; ++i) {
        std::cout << PRNG() << "\t";

        if (i % 5 == 0) {
            std::cout << "\n";
        }
    }

    return 0;
}
