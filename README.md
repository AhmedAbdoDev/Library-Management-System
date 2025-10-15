
# 📚 Library Management System (Java OOP)

A **console-based Library Management System** built entirely with **Java OOP principles**, designed to simulate a real-world library where **Admins** and **Members** have distinct functionalities.

---

## 🚀 Project Overview

This project demonstrates the power of **Object-Oriented Programming (OOP)** in Java by managing books, users, and operations like borrowing, returning, and searching — all through clean, reusable, and modular code.

It’s a perfect example of applying **Encapsulation**, **Inheritance**, **Polymorphism**, and **Abstraction** in one real-world scenario.

---

## 🧩 Features

### 👑 Admin Features:
- ➕ **Add a new book**
- ❌ **Remove an existing book**
- 🔍 **Search for a book**
- 📋 **Display all books**

### 👤 Member Features:
- 📖 **Borrow a book**
- 🔁 **Return a borrowed book**
- 📚 **View borrowed books**
- 🔍 **Search for a book**
- 📋 **View all available books**

---

## 💻 How It Works

### 🔑 Login Simulation:
Users log in by entering their **ID** and **Name**.

#### 🧭 Example 1: Admin Login
```
🔑 Login:
Enter ID (0 to exit): 1
Enter Name: Alice
✅ Welcome Alice

===== MENU =====

1. Add Book
2. Remove Book
3. Search Book
4. Show All Books
5. Exit
Your choice:
```

#### 🧭 Example 2: Member Login
```
🔑 Login:
Enter ID (0 to exit): 2
Enter Name: Bob
✅ Welcome Bob

===== MENU =====

1. Borrow Book
2. Return Book
3. Show Borrowed Books
4. Search Book
5. Show All Books
6. Exit
Your choice:
```

---

## 🧱 Project Structure

```
📦 Library-Management-System/src
┣ 📜 Main.java
┣ 📜 Library.java
┣ 📜 Book.java
┣ 📜 User.java
┣ 📜 Admin.java
┣ 📜 Member.java
````

---
## 🧠 Concepts Applied

| Concept | Description |
|----------|--------------|
| **Encapsulation** | Data hiding using private fields and public getters/setters |
| **Inheritance** | `Admin` and `Member` inherit from `User` |
| **Polymorphism** | Overridden methods for different user roles |
| **Abstraction** | Simplified interfaces for managing books and users |
| **Collections** | Use of `ArrayList` for dynamic data storage |
---

## 🛠️ Technologies Used
- 🧩 **Java (JDK 24)**
- 🖥️ **IntelliJ IDEA**
- 🧠 **OOP Concepts**

---

## ⚙️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/AhmedAbdoDev/Library-Management-System.git
   ```
2. Open the project in **IntelliJ IDEA**.
3. Compile and run `Main.java`.
4. Follow the on-screen instructions to log in and explore!

---

## 🌟 Future Improvements

* Store user and book data in files or databases
* Add GUI using JavaFX or Swing
* Support multiple admins and concurrent sessions

---

### 👨‍💻 Author

**Ahmed Abd El-Latif Mostafa**

I'm a passionate solo developer who enjoys building simple yet effective tools. If you have any questions or feedback, feel free to connect with me!

* [**GitHub**](https://github.com/AhmedAbdoDev)
* [**LinkedIn**](https://www.linkedin.com/in/3bkrenodev)
* [**Portfolio**](https://ahmedabdodev.github.io/Portfolio)

---

⭐ **If you like this project, don't forget to star the repo!**