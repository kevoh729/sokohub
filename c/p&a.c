#include <stdio.h>

int main() {
    int length = 7;
    int width = 5;
    int perimeter = 2*(length) + 2*(width);
    int area = length * width;

    printf("Perimeter of the rectangle: %d\n", perimeter);
    printf("Area of the rectangle: %d\n", area);
    return 0;
}