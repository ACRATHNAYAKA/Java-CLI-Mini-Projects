# Smart Password Strength Analyzer 🔐

![Java](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java)
![Platform](https://img.shields.io/badge/Platform-CLI-lightgrey?style=for-the-badge)
![Topic](https://img.shields.io/badge/Field-Cybersecurity-red?style=for-the-badge)

A high-performance Command-Line Interface (CLI) application built with **Java** to evaluate the cryptographic strength of passwords. This tool utilizes a mathematical approach to estimate brute-force resistance and provides educational insights into digital security.

---

## 🌟 Key Features

* **Entropy-Based Scoring:** Analyzes the complexity of passwords based on character diversity (Uppercase, Lowercase, Numbers, and Symbols).
* **Crack-Time Estimation:** Predicts the time required for a modern brute-force attack (at $10^9$ guesses/sec) to breach the password.
* **Secure Input Handling:** Implements `System.console().readPassword()` to ensure sensitive information is not echoed back to the terminal screen.
* **Smart Password Suggestion:** A custom algorithm that generates strong, memorable passwords by combining user-defined keywords with random symbols.
* **Security Best Practices:** Built-in module providing industry-standard tips for maintaining secure online identities.

---

## 🔬 Technical Methodology

### The Brute-Force Logic
The application evaluates the "search space" or total combinations ($C$) using the formula:

$$C = R^L$$

Where:
* $R$ = Size of the character pool (Range)
* $L$ = Length of the password

The **Estimated Crack Time** ($T$) is then derived by:

$$T = \frac{C}{\text{Guesses per Second}}$$



### Core Engineering Standards
* **Modular Programming:** Logic is separated into clear, maintainable methods for UI, Analysis, and Generation.
* **Resource Management:** Uses `Scanner` and `Console` classes efficiently for terminal interactions.
* **Scalability:** The code structure allows for easy integration of new character pools or more complex entropy algorithms (like Zxcvbn).

---

## 🚀 Getting Started

### Prerequisites
* Java Development Kit (JDK) 8 or higher.

### Installation & Execution
1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/ACRATHNAYAKA/java-mini-projects.git](https://github.com/ACRATHNAYAKA/java-mini-projects.git)
    ```
2.  **Navigate to Project Directory:**
    ```bash
    cd fundamentals/password-strength-analyzer
    ```
3.  **Compile:**
    ```bash
    javac PasswordAnalyzer.java
    ```
4.  **Run:**
    ```bash
    java PasswordAnalyzer
    ```

---

## 🗺️ Project Roadmap
- [ ] Add support for **Dictionary Attack** detection.
- [ ] Implement a **JavaFX-based GUI** for a modern desktop experience.
- [ ] Integration with a Password Manager API for secure vaulting.
- [ ] Support for multi-language security tips (Localization).

---

## 👨‍💻 Author
**Avishka Chamara**
*Computer Science Student | Strategic Developer*

[![GitHub](https://img.shields.io/badge/GitHub-Profile-black?style=flat&logo=github)](https://github.com/ACRATHNAYAKA)
[

---
*Disclaimer: This tool is for educational purposes only. Always use a reputable password manager for your sensitive accounts.*