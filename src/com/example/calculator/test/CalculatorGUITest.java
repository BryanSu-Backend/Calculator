package com.example.calculator.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.calculator.CalculatorGUI;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;

class CalculatorGUITest {

	private CalculatorGUI gui;

    @BeforeEach
    void setUp() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            gui = new CalculatorGUI();
            gui.setVisible(true);
        });
    }

    @Test
    void testInitialState() {
        SwingUtilities.invokeLater(() -> {
            JTextField textField = gui.getTextField();
            assertEquals("", textField.getText(), "Text field should be initially empty.");
        });
    }

    @Test
    void testAdditionOperation() {
        SwingUtilities.invokeLater(() -> {
            JButton[] buttons = gui.getButtons();

            buttons[0].doClick();
            buttons[3].doClick();
            buttons[1].doClick();
            buttons[14].doClick();

            JTextField textField = gui.getTextField();
            assertEquals("2 + 3 = 5.0", textField.getText(), "The result of 2 + 3 should be 5.0.");
        });
    }

    @Test
    void testClearOperation() {
        SwingUtilities.invokeLater(() -> {
            JButton[] buttons = gui.getButtons();

            buttons[0].doClick();
            buttons[3].doClick();
            buttons[1].doClick();
            buttons[15].doClick();

            JTextField textField = gui.getTextField();
            assertEquals("", textField.getText(), "Text field should be cleared after pressing 'C'.");
        });
    }

    @Test
    void testDivisionByZero() {
        SwingUtilities.invokeLater(() -> {
            JButton[] buttons = gui.getButtons();

            buttons[0].doClick();
            buttons[0].doClick();
            buttons[15].doClick();
            buttons[15].doClick();
            buttons[14].doClick();

            JTextField textField = gui.getTextField();
            assertTrue(textField.getText().contains("Division can't be zero"), "Division by zero should show an error message.");
        });
    }
}