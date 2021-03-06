package com.company;

public class Stack {
    private int top = 0;
    private Character[] array;

    public Stack(int size) {
        this.top = 0;
        this.array = new Character[size];
    }

    public boolean push(Character element) {
        if (array.length == top) {
            return false;
        }
        array[top] = element;
        top++;
        return true;
    }

    public Character pop() {
        if (top != 0) {
            top--;
            return array[top];
        }
        return null;
    }

}
