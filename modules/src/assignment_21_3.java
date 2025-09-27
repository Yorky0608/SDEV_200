import java.io.*;
import java.util.*;

public class assignment_21_3 {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java assignment_21_3 <filename>");
            return;
        }
        
        String filename = args[0];
        File file = new File(filename);
        
        if (file.exists()) {
            System.out.println("The number of keywords in " + filename
                + " is " + countKeywords(file));
        } else {
            System.out.println("File " + filename + " does not exist");
        }
    }

    public static int countKeywords(File file) throws Exception {
        // Array of all Java keywords + true, false and null
        String[] keywordString = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum",
            "extends", "for", "final", "finally", "float", "goto",
            "if", "implements", "import", "instanceof", "int",
            "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static",
            "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", "volatile",
            "while", "true", "false", "null"};

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean inMultiLineComment = false;

            while ((line = reader.readLine()) != null) {
                // Remove comments and strings from the line
                String processedLine = removeCommentsAndStrings(line, inMultiLineComment);
                
                // Check if we're still in a multi-line comment
                inMultiLineComment = isInMultiLineComment(line, inMultiLineComment);
                
                // Skip if entire line is in a comment
                if (processedLine.isEmpty()) {
                    continue;
                }

                // Split the processed line into words and count keywords
                Scanner lineScanner = new Scanner(processedLine);
                lineScanner.useDelimiter("\\W+"); // Split on non-word characters
                
                while (lineScanner.hasNext()) {
                    String word = lineScanner.next();
                    if (keywordSet.contains(word)) {
                        count++;
                    }
                }
                lineScanner.close();
            }
        }

        return count;
    }

    private static String removeCommentsAndStrings(String line, boolean inMultiLineComment) {
        StringBuilder result = new StringBuilder();
        boolean inStringLiteral = false;
        boolean inCharLiteral = false;
        boolean inSingleLineComment = false;
        
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            
            // Handle multi-line comment end
            if (inMultiLineComment) {
                if (ch == '*' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                    inMultiLineComment = false;
                    i++; // Skip the '/' character
                }
                continue; // Skip everything in multi-line comment
            }
            
            // Handle single-line comment
            if (inSingleLineComment) {
                break; // Rest of line is comment
            }
            
            // Handle string literals
            if (ch == '"' && !inCharLiteral && !inMultiLineComment) {
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
                continue; // Don't include quotes in result
            }
            
            // Handle character literals
            if (ch == '\'' && !inStringLiteral && !inMultiLineComment) {
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
                continue; // Don't include quotes in result
            }
            
            // Skip content inside string or character literals
            if (inStringLiteral || inCharLiteral) {
                continue;
            }
            
            // Check for comment starts
            if (ch == '/' && i + 1 < line.length()) {
                if (line.charAt(i + 1) == '/') {
                    inSingleLineComment = true;
                    break; // Rest of line is comment
                } else if (line.charAt(i + 1) == '*') {
                    inMultiLineComment = true;
                    i++; // Skip the '*' character
                    continue;
                }
            }
            
            // Add character to result if not in comment or string
            result.append(ch);
        }
        
        return result.toString();
    }
    
    private static boolean isInMultiLineComment(String line, boolean wasInComment) {
        boolean inComment = wasInComment;
        
        for (int i = 0; i < line.length() - 1; i++) {
            if (!inComment && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                inComment = true;
                i++; // Skip next character
            } else if (inComment && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                inComment = false;
                i++; // Skip next character
            }
        }
        
        return inComment;
    }
}