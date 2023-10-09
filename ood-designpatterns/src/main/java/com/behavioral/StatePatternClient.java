package com.behavioral;

public class StatePatternClient {
    public static void main(String[] args) {
        Context1 context = new Context1();
        context.performAction(); // Output: State 1 is active.
        context.performAction(); // Output: State 2 is active.
        context.performAction(); // Output: State 1 is active.
    }
}
// State interface
interface State {
    void doAction(Context1 context);
}
// Concrete State 1
class State1 implements State {
    @Override
    public void doAction(Context1 context) {
        System.out.println("State 1 is active.");
        context.setState(new State2()); // Transition to State 2
    }
}
// Concrete State 2
class State2 implements State {
    @Override
    public void doAction(Context1 context) {
        System.out.println("State 2 is active.");
        context.setState(new State1()); // Transition to State 1
    }
}
// Context
class Context1 {
    private State state;
    public Context1() {
        state = new State1(); // Initial state
    }
    public void setState(State state) {
        this.state = state;
    }
    public void performAction() {
        state.doAction(this);
    }
}
