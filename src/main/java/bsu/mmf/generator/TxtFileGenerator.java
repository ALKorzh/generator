package bsu.mmf.generator;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

/**
 * A utility class that generates multiple text files with randomly selected word fragments
 * from a source input file.
 */
public class TxtFileGenerator {

  private static final String FILE_PREFIX = "file";
  private static final String FILE_EXTENSION = ".txt";
  private static final int ZERO_PADDING = 6;  // Number of leading zeros in filenames
  private static final String FILE_NAME_FORMAT = FILE_PREFIX + "%0" + ZERO_PADDING + "d" + FILE_EXTENSION;

  public static void main(String[] args) throws IOException {
    String inputFilePath = "C:\\Users\\vadim\\OneDrive\\Desktop\\input.txt";     // Absolute path to the input file
    String outputDirectory = "C:\\Users\\vadim\\OneDrive\\Desktop\\texts";       // Absolute path to the output directory
    int wordsPerFragment = 20;     // Number of words per text fragment
    int numberOfFiles = 1000;      // Number of output files to generate

    List<String> allWords = loadWordsFromFile(inputFilePath);

    if (allWords.size() < wordsPerFragment) {
      throw new IllegalArgumentException("Not enough words in the input file to create a fragment.");
    }

    Random random = new Random();

    for (int i = 1; i <= numberOfFiles; i++) {
      int maxStartIndex = allWords.size() - wordsPerFragment;
      int startIndex = random.nextInt(maxStartIndex + 1);  // Random starting index

      List<String> fragmentWords = allWords.subList(startIndex, startIndex + wordsPerFragment);
      String fragment = String.join(" ", fragmentWords);

      String fileName = String.format(FILE_NAME_FORMAT, i);
      Path outputPath = Paths.get(outputDirectory, fileName);
      Files.writeString(outputPath, fragment);

      System.out.println("Generated file: " + outputPath);
    }
  }

  /**
   * Loads all words from the specified text file.
   *
   * @param filePath the absolute path to the input file
   * @return a list of words
   * @throws IOException if an I/O error occurs reading from the file
   */
  private static List<String> loadWordsFromFile(String filePath) throws IOException {
    String content = Files.readString(Paths.get(filePath));
    return Arrays.asList(content.split("\\s+"));
  }
}
