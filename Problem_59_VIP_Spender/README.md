# Problem 59 – VIP Spender Tracker (Top K)

This project tracks the top 3 highest spending users from a live purchase stream.

## Data Structures Used
- HashMap: User → Total Spend
- Min Heap (size K): Maintains top K spenders

## Commands
- PURCHASE <user> <amount>
- SHOW_VIP
- EXIT

## Run
```bash
javac src/*.java
java src/Main



---

## 🎯 Time Complexity
| Operation | Complexity |
|---------|------------|
| PURCHASE | **O(log K)** |
| SHOW_VIP | **O(K log K)** |
| Space | **O(N + K)** |

😎


