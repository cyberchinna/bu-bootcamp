#include <stdio.h>

void print_math(int a, int b) {
    int sum = a + b;
    int product = a * b;

    printf("Sum:     %d\n", sum);
    printf("Product: %d\n", product);
}

int main(void) {
    int num1, num2;

    printf("Enter first number:  ");
    scanf("%d", &num1);

    printf("Enter second number: ");
    scanf("%d", &num2);

    print_math(num1, num2);

    return 0;
}