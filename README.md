#QuizCraft

QuizCraft is a customizable quiz and study guide application that enables users to create, save, and take quizzes with various question types. The program also allows users to create and store study guides for long-term access, review correct and incorrect answers, and track progress over time.

Features
User-Friendly Interface: Enhanced homepage with themed graphics and fonts inspired by Minecraft.
Quiz Functionality:
Take a Quiz: Users can select from three different quizzes, each containing ten questions. Upon completion, users are prompted for submission and their scores are displayed alongside any unanswered questions.
Dynamic Layout: Implemented a vertical box layout to frame quizzes and utilized arrays to store options for each question, leveraging for loops to populate the quiz frame.
Submission Process: The “Submit” button checks for unanswered questions, prompts for confirmation, calculates the final score, and presents results in a JOptionPane. A "Go Back" button allows users to return to the previous screen.
Study Guide Creation:
Create a Study Guide: Users can create new study guides, load existing ones, and navigate back to the previous page. When creating a study guide, a new frame is generated for text input, which can be saved to a file with confirmation messages.
Loading Study Guides: The "Load a Study Guide" button allows users to display the content of existing study guides, facilitating easy access to saved materials.
Implementation Details
Technologies Used: Developed in Java and run through VSCode.
UI Components: Utilizes JLabel, JButton, ImageIcon, and ActionListeners to enhance interactivity and visual appeal.
File Management: The application includes a saveToFile method for processing and saving user-entered text to a specified file path, ensuring data persistence.
