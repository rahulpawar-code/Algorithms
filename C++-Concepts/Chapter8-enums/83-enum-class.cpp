// enum classes https://www.learncpp.com/cpp-tutorial/enum-classes/

#include <iostream>

#include <iostream>

int main()
{
    enum class Color
    {
        color_red,
        color_blue
    };

    enum class Fruit
    {
        fruit_apple,
        fruit_banana
    };

    Color color { Color::color_blue };
    Fruit fruit { Fruit::fruit_banana };

    if (color == fruit) {
        std::cout << "color and fruit are equal\n";
    } else {
        std::cout << "color and fruit are not equal\n";
    }

    return 0;
}

