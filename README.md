# Link Shortener

## Overview
This project is a simple **Link Shortener** implemented in Java. It allows users to convert long URLs into short, unique URLs and retrieve the original URL from a shortened version.

## Features
- Shortens long URLs using a hash-based algorithm.
- Expands shortened URLs back to their original form.
- Handles duplicate URLs and invalid inputs.
- Saves and loads URL mappings between sessions.
- Command-line interface (CLI) for user interaction.

## Requirements
- Java 8 or higher

## Usage
### Run the Application
```sh
javac src/*.java -d out
java -cp out Main
