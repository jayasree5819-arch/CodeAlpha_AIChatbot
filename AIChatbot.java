import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class AIChatbot extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    private Map<String, String> faq;

   
    public AIChatbot() {

       
        faq = new HashMap<>();

        faq.put("what is java",
                "Java is a high-level, object-oriented programming language.");

        faq.put("what is ai",
                "AI stands for Artificial Intelligence. It enables machines to perform tasks that normally require human intelligence.");

        faq.put("what is machine learning",
                "Machine Learning is a branch of AI that allows computers to learn from data and make predictions or decisions.");

        faq.put("what is nlp",
                "NLP stands for Natural Language Processing. It helps computers understand and process human language.");

        faq.put("who created java",
                "Java was created by James Gosling and his team at Sun Microsystems.");

        faq.put("what is chatbot",
                "A chatbot is a software application that communicates with users using text or voice.");

        faq.put("how are you",
                "I am doing great! Thanks for asking.");

        faq.put("what is oop",
                "OOP stands for Object-Oriented Programming. Its main concepts include Encapsulation, Inheritance, Polymorphism, and Abstraction.");

        faq.put("what is data structure",
                "A data structure is a way of organizing and storing data so that it can be used efficiently.");

        faq.put("what is python",
                "Python is a high-level, interpreted programming language known for its simple and readable syntax.");

        createGUI();
    }

  
    private void createGUI() {

        setTitle("AI Chatbot - CodeAlpha");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

       
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 15));

        JScrollPane scrollPane = new JScrollPane(chatArea);

       
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 15));

        
        sendButton = new JButton("Send");
        sendButton.setFont(new Font("Arial", Font.BOLD, 14));

        
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        
        chatArea.append("Bot: Hello! Welcome to the AI Chatbot.\n");
        chatArea.append("Bot: Ask me questions about Java, AI, ML, NLP, OOP, and more.\n\n");

        
        sendButton.addActionListener(e -> sendMessage());

       
        inputField.addActionListener(e -> sendMessage());
    }

   
    private String preprocess(String input) {

        input = input.toLowerCase();

       
        input = input.replaceAll("[^a-zA-Z0-9\\s]", "");

       
        input = input.replaceAll("\\s+", " ").trim();

        return input;
    }

    
    private String getBotResponse(String userInput) {

        String input = preprocess(userInput);

       
        if (input.isEmpty()) {
            return "Please type something so I can help you.";
        }

       
        if (input.matches(".*\\b(hi|hello|hey)\\b.*")) {
            return "Hello! How can I help you today?";
        }

        
        if (input.matches(".*\\b(bye|goodbye|exit)\\b.*")) {
            return "Goodbye! Have a great day.";
        }

        
        if (input.matches(".*\\b(thank you|thanks)\\b.*")) {
            return "You're welcome!";
        }

        
        if (faq.containsKey(input)) {
            return faq.get(input);
        }

        
        if (input.contains("java")) {
            return "Java is an object-oriented programming language widely used for software and application development.";
        }

        if (input.contains("artificial intelligence") || input.equals("ai")) {
            return "Artificial Intelligence enables machines to simulate human intelligence such as learning, reasoning, and problem-solving.";
        }

        if (input.contains("machine learning") || input.equals("ml")) {
            return "Machine Learning allows computers to learn patterns from data and make predictions or decisions.";
        }

        if (input.contains("natural language processing") || input.equals("nlp")) {
            return "NLP helps computers understand, interpret, and generate human language.";
        }

        if (input.contains("programming")) {
            return "Programming is the process of creating instructions that computers can execute.";
        }

        if (input.contains("college") || input.contains("student")) {
            return "Students can use programming, AI, and data analytics skills to build useful projects.";
        }

        
        return "Sorry, I don't understand that question yet. Please ask me about Java, AI, Machine Learning, NLP, OOP, or Data Structures.";
    }

    private void sendMessage() {

        String userInput = inputField.getText().trim();

        if (userInput.isEmpty()) {
            return;
        }

       
        chatArea.append("You: " + userInput + "\n");

       
        String response = getBotResponse(userInput);

        
        chatArea.append("Bot: " + response + "\n\n");

        
        inputField.setText("");

       
        chatArea.setCaretPosition(chatArea.getDocument().getLength());
    }

   
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            AIChatbot chatbot = new AIChatbot();
            chatbot.setVisible(true);
        });
    }
}
