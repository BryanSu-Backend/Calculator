Overview 
    This project is a  calculator application made using Java. 
  	It has a graphical interface that allows you to perform simple operations like addition, subtraction, multiplication, and division.
    ![image](https://github.com/user-attachments/assets/a3b32f8b-17a0-4dc3-83c4-30b98bb3555a)

Features
    GUI with Swing: The calculator uses Java's Swing library to create a user-friendly interface with buttons.
    Basic Arithmetic Operations: It can add, subtract, multiply, and divide numbers.
    Clear Functionality: You can press a "C" button to clear the current input.
    Real-time Display: As you press buttons, the calculator shows the current expression.
    Error Handling: It handles errors like dividing by zero and displays messages such as "Infinity" when needed.

Prerequisites:
    Java 8 or newer installed.
    Java Development Kit (JDK) installed.
    Recommend using Eclipse

Clone the Repository:
    Use the command git clone <repository-url> to get the project files on your local machine.

Run:
    Open and Compile:
    Open the project in your Eclipse IDE.
    Run the application by clicking 'Run' on CalculatorGUI.java.

Usage
    Launch the Application: Open the calculator window.
    Input Numbers: Click the number buttons (0-9).
    Perform Operations: Click the operation buttons (+, -, *, /).
    Clear Input: Press "C" to clear the current input.
    Calculate Result: Press "=" to get the result of your expression.
    Error Handling: Division by zero shows "Infinity" or appropriate error messages for other issues.
    
Code Structure
    CalculatorGUI.java: This file controls the display and the calculator buttons.
    JTextField: Shows the current input and results.
    JButton[]: Represents the buttons for numbers and operations.
    Event Listeners: Manage what happens when you click the buttons.

Main Logic
    The calculator builds and evaluates expressions from button clicks.
    It processes the expression and handles errors like division by zero.

Example
    Input: 7 + 8 * 5
    Output: 47.
    ![image](https://github.com/user-attachments/assets/b3b25d83-9b95-4f9b-ab09-87af43d8987b)

Future Improvements
    Parentheses Support: Allow for more complex calculations using parentheses.
    Floating-Point Numbers: Handle decimal numbers.
    Better Error Handling: Provide clearer error messages.
