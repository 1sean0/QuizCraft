import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.io.*;

//Group: Daniel Ho, Justin Drake Santos, Nicholas Ramirez-Ornelas, Sean Solomon, Vanisa Suadprathon 

public class QuizCraft {

    // File path for storing quiz data
    private static final String FILE_PATH = "quiz_data.txt";

    // JFrames for different sections of application
    private JFrame homeFrame;
    private JFrame quizTakerFrame;
    private JFrame quizMakerFrame;
    private JFrame creditsFrame;
    private JLabel imageOnly; 

    // Constructor for QuizMaker clas
    QuizCraft() {

        // Create home frame with GridLayout
        homeFrame = new JFrame("QuizCraft");
        homeFrame.setSize(650, 600);
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setLayout(new GridLayout(4, 1)); // 4 rows, 1 column

        // Create JLabel
        //Font titleFont = new Font("Minecraftia", Font.BOLD | Font.ITALIC, 55);
        //Font buttonFont = new Font("Minecraftia", Font.BOLD, 18);

        try {
            // Load the font from a file
            Font minecraftTitleFont = Font.createFont(Font.TRUETYPE_FONT, new File("Minecraftia-Regular.ttf")).deriveFont(Font.BOLD, 42);
            // Register the font
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(minecraftTitleFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        // Create JLabel
        Font titleFont = new Font("Minecraftia", Font.BOLD, 42);
        Font buttonFont = new Font("Minecraftia", Font.BOLD, 18);
        JLabel titleLabel = new JLabel("QuizCraft");
        titleLabel.setFont(titleFont);
       
        // Title image
        ImageIcon myIcon = new ImageIcon(getClass().getResource("QuizCraft.jpg"));
        imageOnly = new JLabel(myIcon);
        imageOnly.setHorizontalAlignment(JLabel.CENTER);

        // Create buttons to access services
        JButton takeQuizButton = new JButton("Take a Quiz");
        takeQuizButton.setFont(buttonFont);

        JButton makeQuizButton = new JButton("Study Guide");
        makeQuizButton.setFont(buttonFont);

        JButton creditsButton = new JButton("Credits");
        creditsButton.setFont(buttonFont);

        // Add action listeners to buttons
        takeQuizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showQuizTakeFrame();
            }
        });

        makeQuizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showQuizMakerFrame();
            }
        });

        creditsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creditsFrame();
            }
        });

        // add components to content pane
        homeFrame.add(imageOnly);
        homeFrame.add(takeQuizButton);
        homeFrame.add(makeQuizButton);
        homeFrame.add(creditsButton);

        // Set visible
        homeFrame.setVisible(true);

        // Center the UI upon initial launch
        homeFrame.setLocationRelativeTo(null);
    }

    // New JFrame for "Take Quiz"
    private void showQuizTakeFrame() {

        // Create quiz taker frame
        quizTakerFrame = new JFrame("Take a Quiz");
        quizTakerFrame.setSize(650, 600);
        quizTakerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        quizTakerFrame.setLayout(new GridLayout(5, 1)); // 4 rows, 1 column

        // Label for the quiz title
        JLabel titleQuizLabel = new JLabel("Choose a Quiz", SwingConstants.CENTER);
        Font titleFont = new Font("Minecraftia", Font.BOLD, 55);
        titleQuizLabel.setFont(titleFont);

        // Add Quiz buttons to quiz taker frame
        JButton quiz1Button = new JButton("Anatomy Quiz");
        quiz1Button.setFont(new Font("Minecraftia", Font.BOLD, 18));

        // Add Quiz buttons to quiz taker frame
        JButton quiz2Button = new JButton("Minecraft Quiz");
        quiz2Button.setFont(new Font("Minecraftia", Font.BOLD, 18));

        // Add Quiz buttons to quiz taker frame
        JButton quiz3Button = new JButton("Animal Quiz");
        quiz3Button.setFont(new Font("Minecraftia", Font.BOLD, 18));

        // Initialize the score in an array
        int[] scoreContainer = new int[]{0};

        // ActionListeners for each quiz button
        quiz1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to start Anatomy Quiz
                showQuiz1(scoreContainer);
            }
        });

        quiz2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to start Minecraft Quiz
                showQuiz2(scoreContainer);
            }
        });

        quiz3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to start Animal Quiz
                showQuiz3(scoreContainer);
            }
        });

        // Add "Go Back" button to quiz taker frame
        JButton goBackButton = new JButton("Go Back");
        goBackButton.setFont(new Font("Minecraftia", Font.BOLD, 16));
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show main menu and dispose of quiz taker
                showHomeFrame();
                quizTakerFrame.dispose();
            }
        });

        // Add components to quiz taker frame
        quizTakerFrame.add(titleQuizLabel);
        quizTakerFrame.add(quiz1Button);
        quizTakerFrame.add(quiz2Button);
        quizTakerFrame.add(quiz3Button);
        quizTakerFrame.add(goBackButton);

        // Set visible
        quizTakerFrame.setVisible(true);
        quizTakerFrame.setLocationRelativeTo(null);

        // Hide the home frame
        homeFrame.setVisible(false);
    }

    // Show the existing home frame
    private void showHomeFrame() {
        homeFrame.setVisible(true);
        homeFrame.toFront();
    }

    // QUIZ 1, ANATOMY QUIZ
    private void showQuiz1(int[] scoreContainer) {

        // Array of questions and answers for Quiz 1
        String[] questions = {
            "What is the largest muscle in the human body?", // Correct answer is Gluteus Maximus (option index 1)
            "Which muscle is responsible for abducting the arm (lifting it sideways)?", // Correct answer is Deltoid (option index 0)
            "Which muscle group is located at the back of the thigh?", // Correct answer is Hamstrings (option index 1)
            "Which of the following muscles is part of the posterior chain?", // Correct answer is Erector spinae (option index 3)
            "Which muscle is a large, triangular muscle in the back?", // Correct answer is Latissimus Dorsi (option index 0)
            "Where is the bicep brachii located in the human body?", // Correct answer is Arm (option index 0)
            "Which of the following is a leg muscle?", // Correct answer is Vastus Lateralis (option index 2)
            "How many heads does the shoulder have?", // Correct answer is Three (option index 2)
            "Which muscle near the shoulder blade is responsible for shoulder extension and adduction?", // Correct answer is Teres Major (option index 1)
            "Where is the bicep femoris located in the human body?" // Correct answer is Leg (option index 3)
        };
        
        // Array of options for each question
        String[][] options = {
            {"Pectoralis Major", "Gluteus Maximus", "Quadricep", "Teres Major"}, // Correct answer is Gluteus Maximus (index 1)
            {"Deltoid", "Bicep", "Tricep", "Forearm"}, // Correct answer is Deltoid (index 0)
            {"Quadricep", "Hamstrings", "Adductor", "Trapezius"}, // Correct answer is Hamstrings (index 1)
            {"Vastus Lateralis", "Soleus", "Gastrocnemius", "Erector spinae"}, // Correct answer is Erector spinae (index 3)
            {"Latissimus Dorsi", "Rectus Intermedius", "Anterior Deltoid", "Endoplasmic Reticulum"}, // Correct answer is Latissimus Dorsi (index 0)
            {"Arm", "Back", "Face", "Leg"}, // Correct answer is Arm (index 0)
            {"Pectoralis Major", "Posterior Deltoid", "Vastus Lateralis", "Serratus Anterior"}, // Correct answer is Vastus Lateralis (index 2)
            {"One", "Two", "Three", "Four"}, // Correct answer is Three (index 2)
            {"Adductor Brevis", "Teres Major", "Adductor Magnus", "Teres Femoralis"}, // Correct answer is Teres Major (index 1)
            {"Arm", "Back", "Face", "Leg"} // Correct answer is Leg (index 3)
        };

        // Array of correct answers for each question (index of correct options for each question, 0-3)
        int[] correctAnswers = {1, 0, 1, 3, 0, 0, 2, 2, 1, 3};

        // Create quiz frame
        JFrame quizFrame = new JFrame("Anatomy Quiz");
        quizFrame.setSize(650, 600);
        quizFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a vertical BoxLayout for the quiz frame
        BoxLayout boxLayout = new BoxLayout(quizFrame.getContentPane(), BoxLayout.Y_AXIS);
        quizFrame.setLayout(boxLayout);

        // Create array to store ButtonGroups for each question
        ButtonGroup[] buttonGroups = new ButtonGroup[questions.length];

        // Create and add question panels to quiz frame
        for (int i = 0; i < questions.length; i++) {
            JPanel questionPanel = new JPanel();
            questionPanel.setLayout(new GridLayout(5, 1)); // 5 rows, 1 column

            JLabel questionLabel = new JLabel(questions[i]);
            questionLabel.setFont(new Font("Minecraftia", Font.BOLD, 16));

            ButtonGroup buttonGroup = new ButtonGroup();

            // Add question label to question panel
            questionPanel.add(questionLabel);

            // Add answer options to question panel
            for (int j = 0; j < options[i].length; j++) {
                JRadioButton optionButton = new JRadioButton(options[i][j]);
                optionButton.setFont(new Font("Minecraftia", Font.PLAIN, 14));
                optionButton.setActionCommand(Integer.toString(j));
                buttonGroup.add(optionButton);
                questionPanel.add(optionButton);
            }

            // Add question panel to quiz frame
            quizFrame.add(questionPanel);

            // Store the ButtonGroup in the array for later access
            buttonGroups[i] = buttonGroup;
        }

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); // Use FlowLayout for buttons

        // Add "Submit" button to button panel
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Minecraftia", Font.BOLD, 14));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if there are unanswered questions
                boolean unansweredQuestionsExist = false;
                for (int i = 0; i < buttonGroups.length; i++) {
                    ButtonGroup buttonGroup = buttonGroups[i];
                    if (buttonGroup.getSelection() == null) {
                        unansweredQuestionsExist = true;
                        break;
                    }
                }

                // Ask for confirmation before submitting
                int confirmResult;
                if (unansweredQuestionsExist) {
                    confirmResult = JOptionPane.showConfirmDialog(quizFrame,
                    "Not all questions were answered. Are you sure you want to submit?",
                    "Confirmation", JOptionPane.YES_NO_OPTION);
                } else {
                    confirmResult = JOptionPane.showConfirmDialog(quizFrame,
                    "Are you sure you want to submit?",
                    "Confirmation", JOptionPane.YES_NO_OPTION);
                }

                if (confirmResult == JOptionPane.YES_OPTION) {
                    // Compute the final score directly
                    int finalScore = 0;
                    int totalQuestions = buttonGroups.length;
                    StringBuilder unansweredQuestions = new StringBuilder("Unanswered questions:\n");

                    // Iterate through buttonGroups and check selected options
                    for (int i = 0; i < totalQuestions; i++) {
                        ButtonGroup buttonGroup = buttonGroups[i];
                        ButtonModel selectedButton = buttonGroup.getSelection();

                        if (selectedButton != null) {
                            int selectedOption = Integer.parseInt(selectedButton.getActionCommand());
                            if (selectedOption == correctAnswers[i]) {
                                finalScore++;
                            }
                        } else {
                            // If the question is not answered, add it to the list
                            unansweredQuestions.append("- ").append(questions[i]).append("\n");
                    }
                }

                // Display the user's final score
                String resultMessage;
                if (unansweredQuestions.length() == "Unanswered questions:\n".length()) {
                    // All questions answered
                    resultMessage = "Score: " + finalScore + " out of " + totalQuestions + " correct answers";
                } else {
                    // Some questions unanswered
                    resultMessage = "Score: " + finalScore + " out of " + totalQuestions + " correct answers\n\n"
                            + unansweredQuestions.toString();
                }

                JOptionPane.showMessageDialog(quizFrame, resultMessage);

                // Show the home frame and dispose of the quiz frame
                showHomeFrame();
                quizFrame.dispose();
            }
            // If the user clicks "No" or closes the dialog, do nothing (cancel submission)
        }
    });


        // Add "Go Back" button to button panel
        JButton goBackButton = new JButton("Go Back");
        goBackButton.setFont(new Font("Minecraftia", Font.BOLD, 14));
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizFrame.dispose();
                showQuizTakeFrame();
            }
        });

        // Add components to button panel
        buttonPanel.add(submitButton);
        buttonPanel.add(goBackButton);

        // Add the button panel to the quiz frame
        quizFrame.add(buttonPanel);

        // Create a JScrollPane and add the quiz frame to it
        JScrollPane scrollPane = new JScrollPane(quizFrame.getContentPane());

        // Set visible
        quizFrame.setContentPane(scrollPane);
        quizFrame.setVisible(true);
        quizFrame.setLocationRelativeTo(null);

        // Dispose of the quiz taker frame
        quizTakerFrame.dispose();
    } // END OF QUIZ 1

    // QUIZ 2, MINECRAFT QUIZ
    private void showQuiz2(int[] scoreContainer) {

        // Array of questions and answers for Quiz 2
        String[] questions = {
            "What material is required to craft a crafting table?", // Correct answer is Wood (option index 1)
            "Which dimension is known for having Magma Cubes and Blazes?", // Correct answer is The Nether (option index 0)
            "What is the maximum level that you can enchant items?", // Correct answer is 30 (option index 1)
            "Which block is used to create Nether Portals?", // Correct answer is Obsidian (option index 0)
            "What is the main purpose of a beacon?", // Correct answer is Buffs and effects (option index 2)
            "Which hostile is known for exploding when close to the player?", // Correct answer is Creeper (option index 0)
            "What is required to tame an Ocelot?", // Correct answer is Raw Fish (option index 1)
            "Which biome is characterized by giant mushrooms and mycelium?", // Correct answer is Mushroom Fields (option index 1)
            "Which mob drops a Tear when defeated in the Nether?", // Correct answer is Comparing signal strength (option index 1)
            "Which tool is most effective for mining diamonds?" // Correct answer is Diamond Pickaxe (option index 3)
        };
        
        // Array of options for each Minecraft question
        String[][] options = {
            {"Iron", "Wood", "Stone", "Gold"}, // Correct answer is Wood (index 1)
            {"The Nether", "The End", "The Overworld", "The Aether"}, // Correct answer is The Nether (index 0)
            {"25", "30", "15", "20"}, // Correct answer is 30 (index 1)
            {"Obsidian", "Bedrock", "End Stone", "Quartz"}, // Correct answer is Obsidian (index 0)
            {"Teleportation", "Healing", "Buffs and effects", "Lighting"}, // Correct answer is Buffs and effects (index 2)
            {"Creeper", "Zombie", "Skeleton", "Enderman"}, // Correct answer is Creeper (index 0)
            {"Seeds", "Raw Fish", "Bones", "Carrots"}, // Correct answer is Raw Fish (index 1)
            {"Taiga", "Mushroom Fields", "Savannah", "Desert"}, // Correct answer is Mushroom Fields (index 1)
            {"Enderman", "Ghast", "Wither Skeleton", "Magma Cube"}, // Correct answer is Ghast (index 1)
            {"Wooden Pickaxe", "Stone Pickaxe", "Gold Pickaxe", "Iron Pickaxe"} // Correct answer is Iron Pickaxe (index 3)
        };
        
        // Array of correct answers for each Minecraft question (index of correct options for each question, 0-3)
        int[] correctAnswers = {1, 0, 1, 0, 2, 0, 1, 1, 1, 3};

        // Create quiz frame
        JFrame quizFrame = new JFrame("Minecraft Quiz");
        quizFrame.setSize(650, 600);
        quizFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a vertical BoxLayout for the quiz frame
        BoxLayout boxLayout = new BoxLayout(quizFrame.getContentPane(), BoxLayout.Y_AXIS);
        quizFrame.setLayout(boxLayout);

        // Create array to store ButtonGroups for each question
        ButtonGroup[] buttonGroups = new ButtonGroup[questions.length];

        // Create and add question panels to quiz frame
        for (int i = 0; i < questions.length; i++) {
            JPanel questionPanel = new JPanel();
            questionPanel.setLayout(new GridLayout(5, 1)); // 5 rows, 1 column

            JLabel questionLabel = new JLabel(questions[i]);
            questionLabel.setFont(new Font("Minecraftia", Font.BOLD, 16));

            ButtonGroup buttonGroup = new ButtonGroup();

            // Add question label to question panel
            questionPanel.add(questionLabel);

            // Add answer options to question panel
            for (int j = 0; j < options[i].length; j++) {
                JRadioButton optionButton = new JRadioButton(options[i][j]);
                optionButton.setFont(new Font("Minecraftia", Font.PLAIN, 14));
                optionButton.setActionCommand(Integer.toString(j));
                buttonGroup.add(optionButton);
                questionPanel.add(optionButton);
            }

            // Add question panel to quiz frame
            quizFrame.add(questionPanel);

            // Store the ButtonGroup in the array for later access
            buttonGroups[i] = buttonGroup;
        }

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); // Use FlowLayout for buttons

        // Add "Submit" button to button panel
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Minecraftia", Font.BOLD, 14));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if there are unanswered questions
                boolean unansweredQuestionsExist = false;
                for (int i = 0; i < buttonGroups.length; i++) {
                    ButtonGroup buttonGroup = buttonGroups[i];
                    if (buttonGroup.getSelection() == null) {
                        unansweredQuestionsExist = true;
                        break;
                    }
                }

                // Ask for confirmation before submitting
                int confirmResult;
                if (unansweredQuestionsExist) {
                    confirmResult = JOptionPane.showConfirmDialog(quizFrame,
                    "Not all questions were answered. Are you sure you want to submit?",
                    "Confirmation", JOptionPane.YES_NO_OPTION);
                } else {
                    confirmResult = JOptionPane.showConfirmDialog(quizFrame,
                    "Are you sure you want to submit?",
                    "Confirmation", JOptionPane.YES_NO_OPTION);
                }

                if (confirmResult == JOptionPane.YES_OPTION) {
                    // Compute the final score directly
                    int finalScore = 0;
                    int totalQuestions = buttonGroups.length;
                    StringBuilder unansweredQuestions = new StringBuilder("Unanswered questions:\n");

                    // Iterate through buttonGroups and check selected options
                    for (int i = 0; i < totalQuestions; i++) {
                        ButtonGroup buttonGroup = buttonGroups[i];
                        ButtonModel selectedButton = buttonGroup.getSelection();

                        if (selectedButton != null) {
                            int selectedOption = Integer.parseInt(selectedButton.getActionCommand());
                            if (selectedOption == correctAnswers[i]) {
                                finalScore++;
                            }
                        } else {
                            // If the question is not answered, add it to the list
                            unansweredQuestions.append("- ").append(questions[i]).append("\n");
                    }
                }

                // Display the user's final score
                String resultMessage;
                if (unansweredQuestions.length() == "Unanswered questions:\n".length()) {
                    // All questions answered
                    resultMessage = "Score: " + finalScore + " out of " + totalQuestions + " correct answers";
                } else {
                    // Some questions unanswered
                    resultMessage = "Score: " + finalScore + " out of " + totalQuestions + " correct answers\n\n"
                            + unansweredQuestions.toString();
                }

                JOptionPane.showMessageDialog(quizFrame, resultMessage);

                // Show the home frame and dispose of the quiz frame
                showHomeFrame();
                quizFrame.dispose();
            }
            // If the user clicks "No" or closes the dialog, do nothing (cancel submission)
        }
    });


        // Add "Go Back" button to button panel
        JButton goBackButton = new JButton("Go Back");
        goBackButton.setFont(new Font("Minecraftia", Font.BOLD, 14));
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizFrame.dispose();
                showQuizTakeFrame();
            }
        });

        // Add components to button panel
        buttonPanel.add(submitButton);
        buttonPanel.add(goBackButton);

        // Add the button panel to the quiz frame
        quizFrame.add(buttonPanel);

        // Create a JScrollPane and add the quiz frame to it
        JScrollPane scrollPane = new JScrollPane(quizFrame.getContentPane());

        // Set visible
        quizFrame.setContentPane(scrollPane);
        quizFrame.setVisible(true);
        quizFrame.setLocationRelativeTo(null);

        // Dispose of the quiz taker frame
        quizTakerFrame.dispose();
    } // END OF QUIZ 2

    // QUIZ 3, ANIMAL QUIZ
    private void showQuiz3(int[] scoreContainer) {

        // Array of questions and answers for Quiz 3
        String[] questions = {
            "What is the largest mammal on Earth?", // Correct answer is Blue Whale (option index 2)
            "Which bird is known for its ability to mimic human speech?", // Correct answer is African Grey Parrot (option index 3)
            "What is the largest big cat in the world?", // Correct answer is Siberian Tiger (option index 2)
            "Which animal can live both in water and on land?", // Correct answer is Amphibian (option index 1)
            "What is the fastest land animal?", // Correct answer is Cheetah (option index 2)
            "Which insect is known for its ability to produce light?", // Correct answer is Firefly (option index 3)
            "What is the largest species of bear?", // Correct answer is Kodiak Bear (option index 2)
            "Which animal is capable of regenerating its lost limbs?", // Correct answer is Starfish (option index 2)
            "What is the main diet of a panda?", // Correct answer is Bamboo (option index 1)
            "Which reptile is known for camoflauging?" // Correct answer is Chameleon (option index 3)
        };

        // Array of options for each animal question
        String[][] options = {
            {"Elephant", "Giraffe", "Blue Whale", "Hippopotamus"}, // Correct answer is Blue Whale (index 2)
            {"Penguin", "Canary", "African Grey Parrot", "Ostrich"}, // Correct answer is African Grey Parrot (index 3)
            {"Lion", "Leopard", "Cheetah", "Siberian Tiger"}, // Correct answer is Siberian Tiger (index 2)
            {"Reptile", "Amphibian", "Mammal", "Bird"}, // Correct answer is Amphibian (index 1)
            {"Gazelle", "Ostrich", "Cheetah", "Horse"}, // Correct answer is Cheetah (index 2)
            {"Butterfly", "Ladybug", "Firefly", "Dragonfly"}, // Correct answer is Firefly (index 3)
            {"Brown Bear", "Polar Bear", "Kodiak Bear", "Black Bear"}, // Correct answer is Kodiak Bear (index 2)
            {"Lizard", "Turtle", "Starfish", "Snake"}, // Correct answer is Starfish (index 2)
            {"Meat", "Bamboo", "Fish", "Berries"}, // Correct answer is Bamboo (index 1)
            {"Iguana", "Turtle", "Crocodile", "Chameleon"} // Correct answer is Chameleon (index 3)
        };
    
        // Array of correct answers for each animal question (index of correct options for each question, 0-3)
        int[] correctAnswers = {2, 3, 2, 1, 2, 3, 2, 2, 1, 3};

        // Create quiz frame
        JFrame quizFrame = new JFrame("Animal Quiz");
        quizFrame.setSize(650, 600);
        quizFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a vertical BoxLayout for the quiz frame
        BoxLayout boxLayout = new BoxLayout(quizFrame.getContentPane(), BoxLayout.Y_AXIS);
        quizFrame.setLayout(boxLayout);

        // Create array to store ButtonGroups for each question
        ButtonGroup[] buttonGroups = new ButtonGroup[questions.length];

        // Create and add question panels to quiz frame
        for (int i = 0; i < questions.length; i++) {
            JPanel questionPanel = new JPanel();
            questionPanel.setLayout(new GridLayout(5, 1)); // 5 rows, 1 column

            JLabel questionLabel = new JLabel(questions[i]);
            questionLabel.setFont(new Font("Minecraftia", Font.BOLD, 16));

            ButtonGroup buttonGroup = new ButtonGroup();

            // Add question label to question panel
            questionPanel.add(questionLabel);

            // Add answer options to question panel
            for (int j = 0; j < options[i].length; j++) {
                JRadioButton optionButton = new JRadioButton(options[i][j]);
                optionButton.setFont(new Font("Minecraftia", Font.PLAIN, 14));
                optionButton.setActionCommand(Integer.toString(j));
                buttonGroup.add(optionButton);
                questionPanel.add(optionButton);
            }

            // Add question panel to quiz frame
            quizFrame.add(questionPanel);

            // Store the ButtonGroup in the array for later access
            buttonGroups[i] = buttonGroup;
        }

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); // Use FlowLayout for buttons

        // Add "Submit" button to button panel
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Minecraftia", Font.BOLD, 14));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if there are unanswered questions
                boolean unansweredQuestionsExist = false;
                for (int i = 0; i < buttonGroups.length; i++) {
                    ButtonGroup buttonGroup = buttonGroups[i];
                    if (buttonGroup.getSelection() == null) {
                        unansweredQuestionsExist = true;
                        break;
                    }
                }

                // Ask for confirmation before submitting
                int confirmResult;
                if (unansweredQuestionsExist) {
                    confirmResult = JOptionPane.showConfirmDialog(quizFrame,
                    "Not all questions were answered. Are you sure you want to submit?",
                    "Confirmation", JOptionPane.YES_NO_OPTION);
                } else {
                    confirmResult = JOptionPane.showConfirmDialog(quizFrame,
                    "Are you sure you want to submit?",
                    "Confirmation", JOptionPane.YES_NO_OPTION);
                }

                if (confirmResult == JOptionPane.YES_OPTION) {
                    // Compute the final score directly
                    int finalScore = 0;
                    int totalQuestions = buttonGroups.length;
                    StringBuilder unansweredQuestions = new StringBuilder("Unanswered questions:\n");

                    // Iterate through buttonGroups and check selected options
                    for (int i = 0; i < totalQuestions; i++) {
                        ButtonGroup buttonGroup = buttonGroups[i];
                        ButtonModel selectedButton = buttonGroup.getSelection();

                        if (selectedButton != null) {
                            int selectedOption = Integer.parseInt(selectedButton.getActionCommand());
                            if (selectedOption == correctAnswers[i]) {
                                finalScore++;
                            }
                        } else {
                            // If the question is not answered, add it to the list
                            unansweredQuestions.append("- ").append(questions[i]).append("\n");
                    }
                }

                // Display the user's final score
                String resultMessage;
                if (unansweredQuestions.length() == "Unanswered questions:\n".length()) {
                    // All questions answered
                    resultMessage = "Score: " + finalScore + " out of " + totalQuestions + " correct answers";
                } else {
                    // Some questions unanswered
                    resultMessage = "Score: " + finalScore + " out of " + totalQuestions + " correct answers\n\n"
                            + unansweredQuestions.toString();
                }

                JOptionPane.showMessageDialog(quizFrame, resultMessage);

                // Show the home frame and dispose of the quiz frame
                showHomeFrame();
                quizFrame.dispose();
            }
            // If the user clicks "No" or closes the dialog, do nothing (cancel submission)
        }
    });


        // Add "Go Back" button to button panel
        JButton goBackButton = new JButton("Go Back");
        goBackButton.setFont(new Font("Minecraftia", Font.BOLD, 14));
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizFrame.dispose();
                showQuizTakeFrame();
            }
        });

        // Add components to button panel
        buttonPanel.add(submitButton);
        buttonPanel.add(goBackButton);

        // Add the button panel to the quiz frame
        quizFrame.add(buttonPanel);

        // Create a JScrollPane and add the quiz frame to it
        JScrollPane scrollPane = new JScrollPane(quizFrame.getContentPane());

        // Set visible
        quizFrame.setContentPane(scrollPane);
        quizFrame.setVisible(true);
        quizFrame.setLocationRelativeTo(null);

        // Dispose of the quiz taker frame
        quizTakerFrame.dispose();
    } // END OF QUIZ 3

     void showQuizMakerFrame() {

        // Create quiz maker frame
        quizMakerFrame = new JFrame("Study Guide");
        quizMakerFrame.setSize(650, 600);
        quizMakerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        quizMakerFrame.setLayout(new GridLayout(5, 1)); // 5 rows, 1 column

        // Title Label for the study guide
        JLabel titleStudyGuideLabel = new JLabel("Study Guide", SwingConstants.CENTER);
        Font titleFont = new Font("Minecraftia", Font.BOLD, 42);
        titleStudyGuideLabel.setFont(titleFont);

        // Button to create a new study guide
        JButton createStudyGuideButton = new JButton("Create a Study Guide");
        createStudyGuideButton.setFont(new Font("Minecraftia", Font.BOLD, 18));
        createStudyGuideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createStudyGuide();
            }
        });

        // Button to load an existing study guide
        JButton loadStudyGuideButton = new JButton("Load a Study Guide");
        loadStudyGuideButton.setFont(new Font("Minecraftia", Font.BOLD, 18));
        loadStudyGuideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadStudyGuideContent();
            }
        });
        
        // Button to go back to the home frame
        JButton goBackButton = new JButton("Go Back");
        goBackButton.setFont(new Font("Minecraftia", Font.BOLD, 18));
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHomeFrame();
                quizMakerFrame.dispose();
            }
        });

        // Add components to the quiz maker frame
        quizMakerFrame.add(titleStudyGuideLabel);
        quizMakerFrame.add(createStudyGuideButton);
        quizMakerFrame.add(loadStudyGuideButton);
        quizMakerFrame.add(goBackButton);

        // Set frame visibility and position
        quizMakerFrame.setVisible(true);
        quizMakerFrame.setLocationRelativeTo(null);

        // Hide the home frame
        homeFrame.setVisible(false);
    }

    // Loads study guide content from a file and displays it in a new frame
    // If the file cannot be loaded, returns null
    private String loadFromFile() {
        StringBuilder loadedInput = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                loadedInput.append(line).append("\n");
            }
            System.out.println("User Input loaded from file.");
            return loadedInput.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Displays the study guide content in a new frame
    // Invokes loadFromFile() to load the content
    private void loadStudyGuideContent() {
        String loadedContent = loadFromFile(); 
    
        // Create the frame to display study guide content
        JFrame displayStudyGuideFrame = new JFrame("Study Guide Content");
        displayStudyGuideFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
        // Panel for displaying loaded study guide content
        JPanel loadStudyGuide = new JPanel();
        loadStudyGuide.setLayout(new BoxLayout(loadStudyGuide, BoxLayout.Y_AXIS)); // Set layout to BoxLayout
    
        // Label for the study guide content
        JLabel studyGuideTitle = new JLabel("Study Guide Content: ");
        studyGuideTitle.setFont(new Font("Minecraftia", Font.BOLD, 18));
    
        // Add components to the study guide panel
        loadStudyGuide.add(studyGuideTitle);
    
        // TextPane for displaying loaded content
        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setText(loadedContent);
    
        // Create JScrollPane with HORIZONTAL_SCROLLBAR_NEVER
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(500, 600)); // Set the preferred size of the scroll pane
    
        // Add scroll pane to the study guide panel
        loadStudyGuide.add(scrollPane);
    
        // Button to go back to the quiz maker frame
        JButton goBackButton = new JButton("Go Back");
        goBackButton.setFont(new Font("Minecraftia", Font.BOLD, 18));
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showQuizMakerFrame();
                displayStudyGuideFrame.dispose();
            }
        });
    
        // Add the "Go Back" button to the study guide panel
        loadStudyGuide.add(goBackButton);
    
        // Add study guide panel to the frame
        displayStudyGuideFrame.getContentPane().add(loadStudyGuide);
        displayStudyGuideFrame.setSize(500, 600); // Set the size of the frame
        displayStudyGuideFrame.setLocationRelativeTo(null);
        displayStudyGuideFrame.setVisible(true);
    }
    
    // Creates a study guide with user-entered text and saves it to a file
    void createStudyGuide() {

        // Create the frame for creating a study guide
        JFrame createStudyGuideFrame = new JFrame("Create a Study Guide");
        createStudyGuideFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        // Panel for creating a study guide
        JPanel createStudyGuidePanel = new JPanel();
        createStudyGuidePanel.setLayout(new BoxLayout(createStudyGuidePanel, BoxLayout.Y_AXIS)); // Set layout to BoxLayout
        createStudyGuidePanel.setPreferredSize(new Dimension(500, 600)); // Set the preferred size of the panel
    
        // Label prompting the user to enter text
        JLabel enterText = new JLabel("Enter text for the Study Guide: ");
        enterText.setFont(new Font("Minecraftia", Font.BOLD, 18));
    
        // Text area for user input
        JTextArea textArea = new JTextArea(5, 20);
        textArea.setLineWrap(true); // Enable line wrapping
        textArea.setWrapStyleWord(true); // Wrap at word boundaries

        // Label for status messages
        JLabel status = new JLabel("");
    
        // Button to save the study guide
        JButton saveButton = new JButton("Save");
        saveButton.setFont(new Font("Minecraftia", Font.BOLD, 18));
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = textArea.getText();
                saveToFile(userInput, status);
            }
        });
    
        // Button to go back to the quiz maker frame
        JButton goBackButton = new JButton("Go Back");
        goBackButton.setFont(new Font("Minecraftia", Font.BOLD, 18));
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showQuizMakerFrame(); // Go back to the quizMakerFrame
                createStudyGuideFrame.dispose();
            }
        });
    
        // Create JScrollPane with a specific size and HORIZONTAL_SCROLLBAR_NEVER
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 200)); // Set the preferred size of the scroll pane
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
        // Add components to the create study guide panel
        createStudyGuidePanel.add(enterText);
        createStudyGuidePanel.add(scrollPane); // Add the JScrollPane instead of directly adding textArea
        createStudyGuidePanel.add(saveButton);
        createStudyGuidePanel.add(goBackButton);
        createStudyGuidePanel.add(status);
    
        // Add create study guide panel to the frame
        createStudyGuideFrame.getContentPane().add(createStudyGuidePanel);
        createStudyGuideFrame.pack();
        createStudyGuideFrame.setLocationRelativeTo(null);
        createStudyGuideFrame.setVisible(true);
    }
    
    // Saves the input to a file and updates the status label
    private void saveToFile(String input, JLabel status) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            writer.println(input);
            System.out.println("Study Guide saved.");
    
            // Apply Minecraft font to the status label
            Font minecraftFont = new Font("Minecraftia", Font.PLAIN, 14);
            status.setFont(minecraftFont);
            status.setText("Study Guide saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

   // New JFrame for "Credits"
private void creditsFrame() {
    
    // Create credits frame
    creditsFrame = new JFrame("Credits");
    creditsFrame.setSize(650, 600);
    creditsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    // Use BoxLayout with Y_AXIS orientation
    creditsFrame.setLayout(new BoxLayout(creditsFrame.getContentPane(), BoxLayout.Y_AXIS));

    // Add vertical glue to center components vertically
    creditsFrame.add(Box.createVerticalGlue());

    // Create credits label with HTML naming content
    JLabel creditsLabel = new JLabel("<html>Daniel Ho"
            + "<br> Justin Drake Santos" 
            + "<br> Nicholas Ramirez-Ornelas"
            + "<br> Sean Solomon" 
            + "<br> Vanisa Suadprathon</html>");

    // Apply Minecraft font to the creditsLabel
    creditsLabel.setFont(new Font("Minecraftia", Font.PLAIN, 25));

    // Add the centered components
    creditsFrame.add(creditsLabel);

    // Add vertical glue to center components vertically
    creditsFrame.add(Box.createVerticalGlue());

    // Add "Go Back" button to button panel
    JButton goBackButton = new JButton("Go Back");
    goBackButton.setFont(new Font("Minecraftia", Font.BOLD, 14));
    goBackButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            creditsFrame.dispose();
            showHomeFrame();
        }
    });

    creditsFrame.add(goBackButton);

    // Set the credits frame to be visible
    creditsFrame.setVisible(true);

    // Center the credits frame on the screen
    creditsFrame.setLocationRelativeTo(null);

    // Hide the home frame
    homeFrame.setVisible(false);
}

    // Main 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new QuizCraft();
            }
        });
    }
}