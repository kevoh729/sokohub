#include <stdio.h>

int main() {
    int num;
    printf("\n enter a number\n");
    scanf("%d", & num);

    if (num > 0) {
        printf("\n The number is positive\n");
    } else if (num < 0) {
        printf("\n The number is negative\n");
    } else {
        printf("\n The number is zero\n");
    }

    return 0;
}