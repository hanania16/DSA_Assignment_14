# Problem 28 – Memory Block Manager (Mark-Sweep Simulation)
## Problem Overview

The **Memory Block Manager** simulates a simplified **garbage collection system** similar to those used in programming language runtimes.  
It manages memory blocks, tracks references between them, and periodically reclaims unreachable blocks using the **Mark-Sweep algorithm**.

This system demonstrates how **runtime memory management** works and simulates object allocation, references, and garbage collection in a controlled environment.

---

## Objectives

- Allocate memory blocks using **First-Fit** strategy
- Track **references between blocks**
- Maintain a **Root Set** of directly reachable blocks
- Perform **Mark-Sweep Garbage Collection** to free unreachable blocks
- Provide a **menu-driven user interface** for easy interaction

---

## Data Structures Used

### 1. Array
- **Purpose:** Stores the memory heap  
- **Structure:** `MemoryBlock[] heap`  
- **Reason:** Efficient indexing and traversal during sweep phase

### 2. Stack
- **Purpose:** Performs DFS during Mark Phase  
- **Structure:** `Stack<Integer>` for block indices  
- **Reason:** Simulates traversal of object references starting from roots

### 3. Linked List (Free List)
- **Purpose:** Tracks free blocks for efficient First-Fit allocation  
- **Structure:** `LinkedList<Integer>`  
- **Reason:** Fast allocation without scanning the entire heap

### 4. HashSet
- **Purpose:** Maintains the Root Set of directly reachable blocks  
- **Structure:** `HashSet<Integer>`  
- **Reason:** O(1) add, remove, and lookup for roots

### 5. ArrayList
- **Purpose:** Stores references for each memory block  
- **Structure:** `ArrayList<Integer>` inside each `MemoryBlock`  
- **Reason:** Allows dynamic addition of references

---

## System Rules

1. **Memory Allocation**
   - Uses First-Fit strategy to allocate the first free block
   - If no free block exists, triggers a **Garbage Collection cycle**
2. **References**
   - Allocated blocks can point to other blocks
3. **Root Set**
   - Blocks in the root set are directly reachable
4. **Garbage Collection (Mark-Sweep)**
   - **Mark Phase:** DFS starting from roots; mark visited blocks
   - **Sweep Phase:** Free any allocated block that was **not visited**
5. **CLI Commands**
   - `ALLOC <block_id>`: Allocate a new block
   - `REF <from> <to>`: Create a reference
   - `ROOT <block_id>`: Add to root set
   - `UNROOT <block_id>`: Remove from root set
   - `GC`: Run Garbage Collection
   - `STATUS`: Display heap and references
   - `EXIT`: Quit program

## 💻 How to Compile and Run

### 1️⃣ Navigate to the `src` folder:

```bash
cd ~/Documents/DSA_Assignment_14/Problem_28_Memory_Manager/src

##  Compile all Java files:

javac *.java

## Run the program:

java Main

---

## User Interface (Menu-Based)

When the program starts, the menu is displayed:

```

===== Memory Block Manager (Mark-Sweep Simulation) =====

Menu:

1. Set Heap Size
2. Allocate Block
3. Add Reference
4. Add Root
5. Remove Root
6. Run Garbage Collection (GC)
7. Show Heap Status
8. Exit

```

### Menu Options

- **1. Set Heap Size** – Define the number of blocks in memory  
- **2. Allocate Block** – Allocate a new memory block  
- **3. Add Reference** – Make one block point to another  
- **4. Add Root** – Add a block to the root set  
- **5. Remove Root** – Remove a block from the root set  
- **6. Run GC** – Trigger Mark-Sweep garbage collection  
- **7. Show Status** – Display heap, roots, and references  
- **8. Exit** – Quit the program

---

## Time & Space Complexity

### Allocation
- First-Fit search: **O(N)** (using Free List can be optimized)  
- Heap update: **O(1)**  

### Garbage Collection
- **Mark Phase:** O(N + E) where N = number of blocks, E = total references  
- **Sweep Phase:** O(N)  

### Space Complexity
- Heap array: O(N)  
- Free List: O(N)  
- Root Set: O(R) where R = number of roots  
- References: O(E) total across all blocks  

---

