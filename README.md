# 🧱 Brick Breaker Game (JavaFX)

A classic **Brick Breaker** game built from scratch using **Core Java** and **JavaFX**.  
This project focuses on learning **GUI development, real-time game loops, event handling, and collision detection** without using any external game engines.

---

## 🚀 Features

- 🎮 Smooth paddle movement (keyboard controls)
- ⚪ Ball physics with wall & paddle collision
- 🧱 Brick grid with destruction on hit
- 🧮 Score tracking
- ❤️ Lives system
- ❌ Game Over state
- 🔁 Restart game functionality
- 🧠 Frame-rate independent movement using delta time

---

## 🛠 Tech Stack

- **Java 21**
- **JavaFX (OpenJFX)**
- **Maven**
- **IntelliJ IDEA**

> No game engines (FXGL, LibGDX) were used — everything is implemented manually to strengthen fundamentals.

---

## 🎯 Controls

| Key | Action |
|----|-------|
| ← / A | Move paddle left |
| → / D | Move paddle right |
| R | Restart game (after Game Over) |

---

## 🧩 Project Structure

```
brick-breaker-javafx/
├── src/main/java/com/saikat/brickbreaker/
│   ├── Main.java        # Application entry point
│   ├── GameApp.java     # Game loop, state management
│   ├── Paddle.java      # Paddle logic & rendering
│   ├── Ball.java        # Ball physics & collision
│   └── Brick.java       # Brick representation
├── pom.xml              # Maven configuration
└── README.md
```

---

## ▶️ How to Run

### Prerequisites
- Java **17+** (Java 21 recommended)
- Maven
- IntelliJ IDEA (Community edition is sufficient)

### Run using Maven
```bash
mvn clean javafx:run
```

---

## 🧠 Learning Outcomes

This project helped practice:

- JavaFX Canvas rendering
- Game loop implementation using `AnimationTimer`
- Keyboard event handling
- Collision detection (ball–paddle, ball–brick)
- Game state management (score, lives, game over)
- Clean object-oriented design
- Git & GitHub workflow

---

## 📌 Future Improvements (Optional)

- Level progression
- Sound effects
- Power-ups
- Improved collision angles
- Pause / resume
- Packaging as executable JAR

---

## 👨‍💻 Author

**Saikat Samanta**  
GitHub: https://github.com/NeoTox419

---

## 📄 License

This project is open-source and intended for educational purposes.
