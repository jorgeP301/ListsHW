#!/bin/bash --verbose

javac -d bin src/cs2720/lists/ItemType.java
javac -d bin -cp bin src/cs2720/lists/NodeType.java
javac -d bin -cp bin src/cs2720/lists/SortedLinkedList.java
javac -d bin -cp bin src/cs2720/lists/LinkedListDriver.java

java -cp bin cs2720.lists.LinkedListDriver input.txt
