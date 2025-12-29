# OminiConvertCLI Unit Converter System ⚖️

![Java](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java)
![Platform](https://img.shields.io/badge/Platform-CLI-lightgrey?style=for-the-badge)
![Logic](https://img.shields.io/badge/Focus-Mathematical_Logic-blue?style=for-the-badge)

A precision-focused Command-Line Interface (CLI) application developed in **Java** that provides seamless conversion between various physical units. This project demonstrates core programming concepts such as modular method structures, control flow optimization, and real-time user input validation.

---

## 🌟 Key Features

* **Multi-Category Support:** Convert units across different domains including Length, Weight, Temperature, and more.
* **Bi-directional Conversion:** Supports two-way conversion logic (e.g., Celsius to Fahrenheit and vice-versa).
* **High Precision:** Implements double-precision floating-point arithmetic to ensure accurate scientific calculations.
* **Interactive CLI Menu:** A clean, user-friendly menu system that guides the user through the conversion process.
* **Input Sanitization:** Robust handling of numerical inputs to prevent runtime errors and ensure system stability.

---

## 🔬 Technical Methodology

### Conversion Engine Logic
The system utilizes standard conversion constants and mathematical formulas to ensure accuracy. For example, Temperature conversion uses the following linear relationship:

$$F = (C \times \frac{9}{5}) + 32$$

Where:
* $F$ = Fahrenheit
* $C$ = Celsius



### Core Engineering Standards
* **Modular Method Design:** Each conversion type is encapsulated in its own method, adhering to the **Single Responsibility Principle (SRP)**.
* **Switch-Case Optimization:** Used for high-speed menu navigation and category selection.
* **Scalability:** Designed to be easily extendable to new units (e.g., Currency, Data Storage) without modifying the core UI logic.

---

## 🚀 Getting Started

### Prerequisites
* Java Development Kit (JDK) 8 or higher.

### Installation & Execution
1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/ACRATHNAYAKA/Java-CLI-Mini-Projects.git
    ```

2.  **Navigate to Project Directory:**
    ```bash
    cd 01-Fundamentals/02-Unit-Converter-System/src
    ```

3.  **Compile:**
    ```bash
    javac OminiConvertCLI.java
    ```

4.  **Run:**
    ```bash
    java OminiConvertCLI
    ```

---

## 🗺️ Project Roadmap
- [ ] Add **Currency Conversion** with real-time API integration.
- [ ] Implement a **History Feature** to track recent conversions.
- [ ] Add support for **Scientific Units** (Kelvin, Newtons, Pascals).
- [ ] Develop a **GUI version** using JavaFX.

---

## 👨‍💻 Author
**AC Rathnayaka**
*BICT Student | Strategic Developer* [cite: 2025-12-13]

[![GitHub](https://img.shields.io/badge/GitHub-Profile-black?style=flat&logo=github)](https://github.com/ACRATHNAYAKA)


---
*Developed as part of the Java Fundamentals Mastery Journey.*