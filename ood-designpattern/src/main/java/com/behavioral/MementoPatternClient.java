package com.behavioral;

import java.util.ArrayList;
import java.util.List;

public class MementoPatternClient {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.setContent("First draft");
        history.addMemento(editor.save());

        editor.setContent("Second draft");
        history.addMemento(editor.save());

        editor.setContent("Final draft");

        // Undo
        editor.restore(history.getMemento(1));
        System.out.println("Undo: " + editor.getContent()); // Output: Undo: Second draft

        // Redo
        editor.restore(history.getMemento(0));
        System.out.println("Redo: " + editor.getContent()); // Output: Redo: First draft
    }
}
// Memento
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Originator
class TextEditor {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public Memento save() {
        return new Memento(content);
    }

    public void restore(Memento memento) {
        content = memento.getState();
    }

    public String getContent() {
        return content;
    }
}

// Caretaker
class History {
    private List<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementos.add(memento);
    }

    public Memento getMemento(int index) {
        return mementos.get(index);
    }
}

/*
// Memento
class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
*/

// Originator
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void restoreStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}

// Caretaker
class Caretaker {
    private Memento memento;

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }
}

class MementoPatternExample {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        // Set the initial state
        originator.setState("State 1");
        System.out.println("Current State: " + originator.getState());

        // Save the state to a Memento
        caretaker.setMemento(originator.saveStateToMemento());

        // Change the state
        originator.setState("State 2");
        System.out.println("Current State: " + originator.getState());

        // Restore the state from the Memento
        originator.restoreStateFromMemento(caretaker.getMemento());
        System.out.println("Restored State: " + originator.getState());
    }
}