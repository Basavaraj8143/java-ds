# Linked List in Java — Introduction

## What is a Linked List?

A collection of **nodes** where each node holds data and a reference to the next node.

```text
[10|•]→ [20|•]→ [30|•]→ null
```

Each box is a **Node**. The arrow is the `next` reference.

---

## Why Not Just Use Arrays?

Arrays store elements in contiguous memory — inserting in the middle requires shifting everything:

```java
int[] arr = {10, 20, 30};
// Insert 15 between 10 and 20 → must shift 20 and 30
```

```text
Before:  10  20  30
After:   10  15  20  30  ← elements shifted
```

With a linked list, only references change — no shifting needed:

```text
Before:  10 → 20 → 30
After:   10 → 15 → 20 → 30
```

| Operation | Array | Linked List |
|---|---|---|
| Access | O(1) | O(n) |
| Insertion | O(n) | O(1)* |
| Deletion | O(n) | O(1)* |
| Size | Fixed | Dynamic |
| Memory layout | Contiguous | Non-contiguous |

*\*If the position/node reference is already known.*

---

## Node Structure

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

Creating and connecting nodes manually:

```java
Node n1 = new Node(10);
Node n2 = new Node(20);
Node n3 = new Node(30);

n1.next = n2;
n2.next = n3;
// 10 → 20 → 30 → null
```

---

## Head Pointer

The **head** is the entry point of the list. Lose it — lose everything.

```java
Node head = n1;
```

```text
head
 ↓
10 → 20 → 30 → null
```

> Without `head`, the entire list becomes inaccessible and gets garbage collected.

---

## Traversal

Walk the list using a `temp` pointer — never move `head` itself.

```java
Node temp = head;
while (temp != null) {
    System.out.print(temp.data + " ");
    temp = temp.next;
}
// Output: 10 20 30
```

Traversal flow:

```text
temp → 10
temp → 20
temp → 30
temp → null  ← stop
```

---

## Complete Program

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        // Output: 10 20 30
    }
}
```

---

## Important Concept — Unlinking a Node

```java
head = head.next;
```

```text
Before:  10 → 20 → 30 → null
          ↑
         head

After:   20 → 30 → null
          ↑
         head   (10 is now unreachable → Garbage Collected)
```

This pattern is the core of most **deletion** operations.

---

## Practice Exercise

Build this list manually and print it using a `while` loop:

```text
5 → 15 → 25 → 35 → null
```

Expected output:

```text
5 15 25 35
```

---

## Key Concepts to Master

- What is a Node?
- What is Head and why it matters
- How traversal works (always use `temp`, not `head`)
- How nodes are connected via `next`
- When to prefer Linked List over Array

---

## What's Next

1. Insertion at Beginning
2. Insertion at End
3. Insertion at Position
4. Deletion Operations
5. Reversal of Linked List
6. Interview Problems