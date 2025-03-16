package contest.biweekly.c152;

import java.util.regex.Pattern;

public class Q2 {
    class Spreadsheet {
        private static final Pattern NUMERIC_PATTERN = Pattern.compile("^\\d+$");
        private static final Pattern CELL_PATTERN = Pattern.compile("^[A-Z]+\\d+$");
        int[][] matrix = null;

        public Spreadsheet(int rows) {
            matrix = new int[rows][26];
        }

    

        public void setCell(String cell, int value) {
            int col = cell.charAt(0) - 'A';
            int row = Integer.parseInt(cell.substring(1));
            matrix[row - 1][col] = value;
        }

        public void resetCell(String cell) {
            int col = cell.charAt(0) - 'A';
            int row = Integer.parseInt(cell.substring(1));
            matrix[row -1 ][col] = 0;
        }

        public int getValue(String formula) {
            String operator = "+";
            String[] parts = formula.substring(1).split("(?=[+\\-*/])|(?<=[+\\-*/])");
            int res = 0;
            for (String part : parts) {
                if (classifyToken(part).equalsIgnoreCase("Numeric")) {
                    int num = Integer.parseInt(part);
                    res = applyOperation(res, num, operator);
                } else if (classifyToken(part).equalsIgnoreCase("Operator")) {
                    operator = part;
                } else if (classifyToken(part).equalsIgnoreCase("Cell Reference")) {
                    int col = part.charAt(0) - 'A';
                    int row = Integer.parseInt(part.substring(1));
                    int num = matrix[row -1][col];
                    res = applyOperation(res, num, operator);
                }
            }
            return res;
        }

        private int applyOperation(int left, int right, String operator) {
            switch (operator) {
                case "+":
                    return left + right;
                case "-":
                    return left - right;
                case "*":
                    return left * right;
                case "/":
                    return right != 0 ? left / right : 0; // Prevent division by zero
                default:
                    throw new IllegalArgumentException("Invalid operator: " + operator);
            }
        }

        public static String classifyToken(String token) {
            if (NUMERIC_PATTERN.matcher(token).matches()) {
                return "Numeric";
            } else if (isOperator(token)) {
                return "Operator";
            } else if (CELL_PATTERN.matcher(token).matches()) {
                return "Cell Reference";
            } else {
                return "Unknown";
            }
        }

        public static boolean isOperator(String token) {
            return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
        }
    }

    public static void main(String[] args) {
        var sol = new Q2();
        Spreadsheet sheet = sol.new Spreadsheet(530);
        System.out.println(sheet.getValue("=29483+15079")); // 44562
        System.out.println(sheet.getValue("=A333+A135"));   // 0 (no values set)
        System.out.println(sheet.getValue("=J215+P337"));   // 0 (no values set)
        sheet.resetCell("F241");
        sheet.setCell("Y104", 2018);
        sheet.setCell("O71", 2353);
        System.out.println(sheet.getValue("=Y104+O71"));   // 4371
        System.out.println(sheet.getValue("=73100+39834"));// 112934
        sheet.setCell("Y118", 58058);
        System.out.println(sheet.getValue("=O71+Y104"));   // 4371
        sheet.resetCell("O71");
        sheet.resetCell("Y118");
        System.out.println(sheet.getValue("=F254+J85"));   // 0 (cells reset)
    }
}
