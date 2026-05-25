#include <stdio.h>
#include <stdbool.h>
#include "stack.h"

// Initialize the stack by setting the top index to -1
void initialize(Stack *stack) {stack->top = -1;}

// isEmpty returns the status of the stachm whether it is empty or not
bool isEmpty(Stack *stack) {return stack->top == -1;}

// isFull returns the status of the stacl, wether it is full or not
bool isFull(Stack *stack) {return stack->top >= MAX_SIZE - 1;}

//Push function adds an element to the top of the stack
void push(Stack *stack, void* value) 
{
    if (isFull(stack)) { printf("Stack Overflow\n"); return;}
    stack->arr[++stack->top] = value;
    
    printf("Se registro %p al stack\n", value);
}

// Pop functiin removes the top element from the stack and returns it
void pop(Stack *stack) 
{
    if (isEmpty(stack)) {printf("Stack Underflow\n");return;}
    int popped = stack->arr[stack->top];

    stack->top--;
    printf("Se elimino %d del stack\n", popped);
    return popped;
}

// Peek function returns the top element of the stack without removing it
int peek(Stack *stack) 
{
    if (isEmpty(stack)) { printf("El stack esta vacio\n"); return -1;}
    return stack->arr[stack->top];
}
