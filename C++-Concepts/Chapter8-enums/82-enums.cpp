// enums https://www.learncpp.com/cpp-tutorial/enumerated-types/

#include <iostream>

int main()
{
    enum Color
    {
        color_red,
        color_blue
    };

    enum Fruit
    {
        fruit_apple,
        fruit_banana
    };

    Color color { color_blue };
    Fruit fruit { fruit_banana };

    if (color == fruit) {
        std::cout << "color and fruit are equal\n";
    } else {
        std::cout << "color and fruit are not equal\n";
    }

    return 0;
}
