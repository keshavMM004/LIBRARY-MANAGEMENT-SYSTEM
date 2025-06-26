# LIBRARY-MANAGEMENT-SYSTEM (Java, Swing, File Storage)

Description:
A simple desktop Library Management System written in Java.
Features:

Swing-based GUI with two tabs: View/Search and Manage

File-based persistence (no SQL) using Java object serialization (library.dat)

Admin operations: add, delete, issue, return books

Student view: search by title and browse all books

Dynamic refresh: View tab updates automatically after any Manage action

Project files:
Book.java — Book model class
DataStore.java — Load/save (library.dat) utilities
Library.java — Core logic (add, delete, issue, return, search)
BookTableModel.java — Table model for displaying books in JTable
ViewPanel.java — GUI panel for viewing/searching books
ManagePanel.java — GUI panel for managing books
LibraryApp.java — Main entry point (creates JFrame and tabs)
library.dat — Serialized data file (auto-generated)
bin/ — Compiled .class files (if you compile with –d bin)

How to compile and run:

Open a command prompt or terminal in the project folder.

Compile all Java source files into a bin folder:
javac -d bin *.java

Run the application:
java -cp bin LibraryApp

Usage:

On launch, a window appears with two tabs.

Manage tab (Admin):
• Enter ID, Title, Author
• Click Add / Delete / Issue / Return
• Actions are saved immediately to library.dat
• View tab auto-refreshes to show changes

View/Search tab (Student):
• Enter a keyword and click Search to filter by title
• View full list of books with issued status

Data persistence:

Uses a Map<Integer, Book> stored in library.dat

DataStore serializes the map after each change

Library loads existing data at startup

To reset all data:
Delete library.dat from the project folder and restart the app.

Enhancements To be Done :

Add login for Admin vs Student roles

Track due dates for issued books

Export/import book data to CSV or JSON

Migrate UI to JavaFX for a modern look