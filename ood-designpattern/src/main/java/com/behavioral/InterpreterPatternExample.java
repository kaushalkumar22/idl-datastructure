package com.behavioral;

public class InterpreterPatternExample {
    public static void main(String[] args) {
        // Create a context with an input expression
        Context context = new Context("2 + 3");

        // Build the abstract syntax tree (AST)
        Expression expression = new AdditionExpression(
                new NumberExpression(2),
                new NumberExpression(3)
        );

        // Interpret and evaluate the expression
        int result = expression.interpret(context);

        System.out.println("Result: " + result); // Output: Result: 5
    }
}
// Abstract Expression
interface Expression {
    int interpret(Context context);
}

// Terminal Expression
class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret(Context context) {
        return number;
    }
}

// Non-terminal Expression (Addition)
class AdditionExpression implements Expression {
    private Expression left;
    private Expression right;

    public AdditionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }
}

// Context
class Context {
    private String input;

    public Context(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
