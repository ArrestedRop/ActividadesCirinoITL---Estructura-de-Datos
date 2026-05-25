#ifndef STACK_H
#define STACK_H

#include <stdbool.h>

// Macro that defines the Maximum size of the stack
#define MAX_SIZE 100

// Stack structure definiition
typedef struct {
    void* arr[MAX_SIZE];
    int top;
} Stack;

// Function prototypes
void initialize(Stack *stack);
bool isEmpty(Stack *stack);
bool isFull(Stack *stack);
void push(Stack *stack, void* value);
void pop(Stack *stack);
void peek(Stack *stack);

#endif // STACK_H   