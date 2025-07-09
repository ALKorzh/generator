# Text File Generator

A simple Java utility that generates multiple text files, each containing a random fragment of words taken from a source text file.

## ✨ Features

* Reads words from a source text file
* Generates multiple output files
* Each file contains a random fragment of **consecutive words**
* Configurable parameters:

    * Number of words per fragment
    * Number of files to generate
    * Output file naming pattern (with zero padding)

## ⚙️ Usage

1. **Prepare** an input text file where words are separated by whitespace.
2. **Configure** the following parameters in the `main` method of `TxtFileGenerator`:

    * `inputFilePath`: Path to your input `.txt` file
    * `outputDirectory`: Destination directory for generated files
    * `wordsPerFragment`: Number of words per generated file
    * `numberOfFiles`: Total number of files to generate
3. **Run the program**:

   ```bash
   java bsu.mmf.generator.TxtFileGenerator
   ```

## 📁 Output Files

Generated files are saved with names in the format:

```
file000001.txt
file000002.txt
...
file999999.txt
```

The number of leading zeros can be adjusted via the `ZERO_PADDING` constant in the code.

## 💡 Example

Given an input file:

```
This is a sample text file with some words that will be used to generate fragments.
```

Possible output:

* `file000001.txt`: `a sample text file with some words that will be used to generate`
* `file000002.txt`: `text file with some words that will be used to generate fragments.`

## 📦 Requirements

* Java 11 or higher (uses `Files.readString()` introduced in Java 11)