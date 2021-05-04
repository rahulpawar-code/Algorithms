// https://www.learncpp.com/cpp-tutorial/random-number-generation/

#include <iostream>
#include <cstdlib>

int main()
{
    std::srand(5232);
    std::rand();

    for (int i {1}; i <= 100; ++i) {
        std::cout << std::rand() << "\t";

        if (i % 5 == 0) {
            std::cout << "\n";
        }
    }

    return 0;
}
