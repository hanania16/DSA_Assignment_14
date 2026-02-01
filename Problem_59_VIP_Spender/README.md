# Problem 59 – VIP Spender Tracker (Top K)

## Problem Overview
The VIP Spender Tracker is a command-line based system that monitors a live stream of customer purchases and continuously identifies the **Top 3 highest-spending users**.  
The system is designed to efficiently handle streaming data without sorting all users after every purchase.

This problem simulates a real-world **CRM (Customer Relationship Management)** scenario where businesses want to instantly reward their most valuable customers.

---

## Objectives
- Track total spending for each user
- Maintain the **Top K (K = 3)** spenders at all times
- Update rankings dynamically as new purchases arrive
- Provide a simple menu-driven user interface

---

## Data Structures Used

### 1. HashMap
- **Purpose:** Stores total spending for each user
- **Structure:**  
  `HashMap<UserID, TotalSpend>`
- **Reason:** Allows fast O(1) access and updates

### 2. Min Heap (PriorityQueue)
- **Purpose:** Maintains only the Top 3 spenders
- **Structure:**  
  `(TotalSpend, UserID)`
- **Key Property:**  
  The root always represents the *lowest spender among the VIPs*
- **Reason:** Efficient comparison and replacement when a user enters the Top 3

---

## ⚙️ System Rules
1. Each purchase updates the user’s total spending
2. If a user’s total spending is high enough, they are added to the Top 3
3. If the Top 3 is full, the lowest spender is removed when a higher spender appears
4. Existing VIP users are updated when they make new purchases

---

## 🖥️ User Interface (Menu-Based)

When the program starts, the following menu is displayed:

===== VIP Spender Tracker =====

Add Purchase
Show VIP Spenders
Exit



### Menu Options
- **1. Add Purchase**  
  Enter a user ID and purchase amount
- **2. Show VIP Spenders**  
  Displays a ranked list (1–3) of top spenders
- **3. Exit**  
  Terminates the program

## Time & Space Complexity

## Purchase Operation:
- HashMap update: O(1)
- Heap update: O(log K)

## Show VIP:
- Sorting Top K users: O(K log K)

## Space Complexity:

- O(N) for HashMap, where N is number of users
- O(K) for Min Heap
