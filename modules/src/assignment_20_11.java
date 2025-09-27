import java.io.*;
import java.util.Stack;

public class assignment_20_11 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java assignment_20_11 <filename>");
            return;
        }
        
        String filename = args[0];
        
        try {
            if (hasCorrectGroupingSymbols(filename)) {
                System.out.println("The source-code file has correct pairs of grouping symbols.");
            } else {
                System.out.println("The source-code file has incorrect pairs of grouping symbols.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static boolean hasCorrectGroupingSymbols(String filename) throws IOException {
        Stack<Character> stack = new Stack<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean inSingleLineComment = false;
            boolean inMultiLineComment = false;
            boolean inStringLiteral = false;
            boolean inCharLiteral = false;
            
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    
                    // Handle comments and string literals
                    if (!inStringLiteral && !inCharLiteral && !inMultiLineComment) {
                        // Check for single-line comment
                        if (ch == '/' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                            inSingleLineComment = true;
                            i++; // Skip next character
                            continue;
                        }
                        // Check for multi-line comment start
                        if (ch == '/' && i + 1 < line.length() && line.charAt(i + 1) == '*') {
                            inMultiLineComment = true;
                            i++; // Skip next character
                            continue;
                        }
                    }
                    
                    // Handle multi-line comment end
                    if (inMultiLineComment) {
                        if (ch == '*' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                            inMultiLineComment = false;
                            i++; // Skip next character
                        }
                        continue;
                    }
                    
                    // Skip if in single-line comment
                    if (inSingleLineComment) {
                        continue;
                    }
                    
                    // Handle string literals
                    if (ch == '"' && !inCharLiteral) {
                        if (!inStringLiteral) {
                            inStringLiteral = true;
                        } else {
                            // Check if it's not an escaped quote
                            int backslashCount = 0;
                            for (int j = i - 1; j >= 0 && line.charAt(j) == '\\'; j--) {
                                backslashCount++;
                            }
                            if (backslashCount % 2 == 0) {
                                inStringLiteral = false;
                            }
                        }
                        continue;
                    }
                    
                    // Handle character literals
                    if (ch == '\'' && !inStringLiteral) {
                        if (!inCharLiteral) {
                            inCharLiteral = true;
                        } else {
                            // Check if it's not an escaped quote
                            int backslashCount = 0;
                            for (int j = i - 1; j >= 0 && line.charAt(j) == '\\'; j--) {
                                backslashCount++;
                            }
                            if (backslashCount % 2 == 0) {
                                inCharLiteral = false;
                            }
                        }
                        continue;
                    }
                    
                    // Skip if inside string or character literal
                    if (inStringLiteral || inCharLiteral) {
                        continue;
                    }
                    
                    // Process grouping symbols
                    if (isOpeningSymbol(ch)) {
                        stack.push(ch);
                    } else if (isClosingSymbol(ch)) {
                        if (stack.isEmpty()) {
                            return false; // No matching opening symbol
                        }
                        
                        char opening = stack.pop();
                        if (!isMatching(opening, ch)) {
                            return false; // Mismatched symbols
                        }
                    }
                }
                
                // Reset single-line comment flag at end of line
                inSingleLineComment = false;
            }
        }
        
        return stack.isEmpty(); // All symbols should be matched
    }
    
    private static boolean isOpeningSymbol(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }
    
    private static boolean isClosingSymbol(char ch) {
        return ch == ')' || ch == '}' || ch == ']';
    }
    
    private static boolean isMatching(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
               (opening == '{' && closing == '}') ||
               (opening == '[' && closing == ']');
    }
}