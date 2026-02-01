# Memory Block Manager

A simple **Memory Block Manager** in Java that simulates memory allocation, references, root management, and garbage collection using basic data structures (arrays, stack, and linked list).

---

## Features

- Allocate and free memory blocks
- Create references between blocks
- Manage root set for reachable blocks
- Manual garbage collection with Mark-and-Sweep algorithm
- View heap status with block allocations, references, and roots

---

## Commands

| Command | Description |
|---------|-------------|
| `ALLOC` | Allocate a new memory block |
| `REF <fromIndex> <toIndex>` | Create a reference from one block to another |
| `ROOT <blockIndex>` | Add a block to the root set |
| `UNROOT <blockIndex>` | Remove a block from the root set |
| `GC` | Run garbage collection (Mark-and-Sweep) |
| `STATUS` | Display heap status, references, and roots |
| `EXIT` | Exit the program |

---

## Data Structures Used

- **Array**: Represents the heap and stores memory blocks with their metadata
- **Stack**: Used for DFS traversal during the mark phase
- **Linked List**: Implements the free list for memory allocation
- **Set/Array**: Maintains the root set of directly reachable blocks

---

## Getting Started

### Prerequisites

- Java JDK 8 or above
- Git (optional, for cloning repository)

### Compile & Run

1. Open terminal in the `src` directory.
2. Compile all Java files:

```bash
  javac *.java
  
  ##RUN THE PROGRAM
  
 java Main
 
 
 
## Example usage
Memory Block Manager Started
Commands: ALLOC, REF, ROOT, UNROOT, GC, STATUS, EXIT
> ALLOC
Block allocated at index 0
> ALLOC
Block allocated at index 1
> REF 0 1
Reference added: Block 0 -> Block 1
> ROOT 0
Block 0 added to roots
> GC
Running Garbage Collection...
Freed 0 block(s)
> STATUS
Heap Status:
Index 0: ALLOCATED, refs: [1]
Index 1: ALLOCATED, refs: []
Roots: [0]
