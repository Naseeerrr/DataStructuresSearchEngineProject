Ranking System with Query Processing ( Search Engine ) 

This repository implements a ranking system for documents using inverted indexes and Binary Search Trees (BST). It provides functionality for processing queries (Boolean and ranked), document ranking, and efficient retrieval using BSTs.

Features

	•	Inverted Index & Inverted BST: Efficiently stores and retrieves documents by keywords.
	•	Query Processing:
	•	Boolean Query (AND, OR, NOT).
	•	Ranked Query based on term frequency in documents.
	•	Data Structures Used:
	•	Linked Lists
	•	Binary Search Trees (BST)
	•	Ranking:
	•	Supports ranking with lists or BSTs for flexible query results.
	•	Display:
	•	Outputs ranked documents with their scores in descending order.

Core Classes

	1.	Document
	•	Represents a single document with an ID, content, and associated keywords.
	2.	Ranking
	•	Manages ranked document lists using a linked list.
	•	Calculates document ranks based on query term frequencies.
	3.	RankingBST
	•	Uses a BST for managing ranked documents for efficient retrieval and sorting.
	4.	QueryProcessing
	•	Handles Boolean and ranked queries using an inverted index.
	5.	QueryProcessingBST
	•	Similar to QueryProcessing but uses a BST for query results.
	6.	Index
	•	Maintains a list of all documents.
	•	Provides functionality to retrieve documents by ID or keyword.
	7.	InvertedIndex
	•	Manages inverted lists for keywords and associated document IDs.
	8.	InvertedBST
	•	Stores and retrieves keywords and document IDs using a BST.

How to Run

	1.	Clone the Repository:

git clone <repo-url>
cd <repo-name>


	2.	Compile the Code:
Use any Java compiler. For example:

javac *.java


	3.	Run the Main Class:
Run the Handler or Main class to load documents and perform queries:

java Handler

Usage

Menu Options

When the program is run, it will display a menu with options:
	1.	Retrieve terms using different indexing methods.
	2.	Perform Boolean retrieval.
	3.	Perform Ranked retrieval using lists or BSTs.
	4.	Display all indexed documents and terms.
	5.	View document ranking scores.

Dependencies

	•	Java JDK 8 or above.
	•	A dataset of documents in CSV format.

Contributors

	•	Your Name
Role: Developer
	•	Team Members
Roles: Collaborators

Future Enhancements

	•	Add support for phrase queries.
	•	Improve the efficiency of ranking algorithms.
	•	Integrate a user-friendly GUI.
