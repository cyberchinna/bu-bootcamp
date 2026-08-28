import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {

    private static int invalidLinesCount = 0;
 
    public static void main(String[] args) {
        String inputFile = "scores.txt";
        String outputFile = "report.txt";

        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores(inputFile);

        // Step 2: calculate statistics
        if (scores.isEmpty()) {
            System.out.println("No valid scores found. Report cannot be generated.");
            return;
        }
        double avg = calculateAverage(scores);

        int high = scores.get(0);
        int low = scores.get(0);

        for (int score : scores) {
            if (score > high) {
                high = score;
            }
            if (score < low) {
                low = score;
            }
        }

        // Step 3: write and print report
        writeReport(scores, avg, high, low, outputFile);
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();

                // Skip blank lines with a warning
                if (line.isEmpty()) {
                    System.out.println("Warning [Line " + lineNumber + "]: Blank line skipped.");
                    continue;
                }

                try {
                    int score = Integer.parseInt(line);
                    
                    // Ensure score falls within the valid range 0 - 100
                    if (score < 0 || score > 100) {
                        System.out.println("Warning [Line " + lineNumber + "]: Out of range score (" + score + ") skipped.");
                        continue;
                    }
                    scores.add(score);
                } catch (NumberFormatException e) {
                    System.out.println("Warning [Line " + lineNumber + "]: Invalid number format \"" + line + "\" skipped.");
                    invalidLinesCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return scores;
    }
    
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (int score : scores) sum += score;

        return sum / scores.size();
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 90) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

    // Build report string
    StringBuilder sb = new StringBuilder();
    sb.append("===  Grade Analysis Report  ===     \n");
    sb.append(String.format("%-24s %d\n", "Total Valid Scores:", scores.size()));
    sb.append(String.format("%-24s %d\n", "Invalid lines skipped:", invalidLinesCount));
    sb.append("\n");
    sb.append(String.format("%-24s %.2f\n", "Average score:", avg));
    sb.append(String.format("%-24s %d\n", "Highest score:", high));
    sb.append(String.format("%-24s %d\n", "Lowest score:", low));
    sb.append("\n");
    sb.append("Grade distribution:\n");
    sb.append(String.format("  %-22s %d\n", "A (90-100):", countA));
    sb.append(String.format("  %-22s %d\n", "B (80-89):",  countB));
    sb.append(String.format("  %-22s %d\n", "C (70-79):",  countC));
    sb.append(String.format("  %-22s %d\n", "D (60-69):",  countD));
    sb.append(String.format("  %-22s %d\n", "F (below 60):",  countF));
    sb.append("\n");

    String report = sb.toString();

    System.out.print("\n" + report);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(report);
            System.out.println("Report successfully written to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing report file: " + e.getMessage());
        }
    }
} 