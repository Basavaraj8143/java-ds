# Linked List Deletions in Java

## 1. Delete at Beginning — O(1)

```text
Before:  10 → 20 → 30 → 40 → null
After:   20 → 30 → 40 → null
```

**Logic:** Move head to the next node. Node `10` becomes unreachable → Garbage Collected.

```java
void deleteAtBeginning() {
    if (head != null) {
        head = head.next;
    }
}
```

---

## 2. Delete at End — O(n)

```text
Before:  10 → 20 → 30 → 40 → null
After:   10 → 20 → 30 → null
```

**Logic:** Traverse to the second-last node, set its `next` to null.

```java
void deleteAtEnd() {
    if (head == null) return;

    if (head.next == null) {
        head = null;
        return;
    }

    Node temp = head;
    while (temp.next.next != null) {  // stop at second-last
        temp = temp.next;
    }

    temp.next = null;
}
```

---

## 3. Delete at Position — O(n)

```text
Before:  10 → 20 → 30 → 40 → 50 → null
Delete:  position 3  (node 30)
After:   10 → 20 → 40 → 50 → null
```

**Logic:** Walk to node at `pos - 1`, then bypass the target.

```java
void deleteAtPosition(int pos) {
    if (head == null) return;

    if (pos == 1) {
        head = head.next;
        return;
    }

    Node temp = head;
    for (int i = 1; i < pos - 1 && temp.next != null; i++) {
        temp = temp.next;
    }

    if (temp.next == null) {
        System.out.println("Invalid position");
        return;
    }

    temp.next = temp.next.next;  // skip target node
}
```

> **Core deletion statement:**
> ```java
> temp.next = temp.next.next;
> ```
> ```text
> Before:  20 → 30 → 40
> After:   20 -------→ 40   (30 unreachable → GC)
> ```

---

## Insertion vs Deletion — Side by Side

**Insertion** (two lines, order matters):
```java
newNode.next = temp.next;
temp.next = newNode;
// 20 → 30  becomes  20 → 25 → 30
```

**Deletion** (one line):
```java
temp.next = temp.next.next;
// 20 → 30 → 40  becomes  20 → 40
```

---

## Time Complexities

| Operation | Complexity | Reason |
|---|---|---|
| Delete at Beginning | O(1) | Just move head |
| Delete at End | O(n) | Must reach second-last node |
| Delete at Position | O(n) | Must reach `pos - 1` node |

---

## Complete Class

```java
class LinkedList {
    Node head;

    void deleteAtBeginning() {
        if (head != null) head = head.next;
    }

    void deleteAtEnd() {
        if (head == null) return;
        if (head.next == null) { head = null; return; }
        Node temp = head;
        while (temp.next.next != null) temp = temp.next;
        temp.next = null;
    }

    void deleteAtPosition(int pos) {
        if (head == null) return;
        if (pos == 1) { head = head.next; return; }
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) temp = temp.next;
        if (temp.next == null) { System.out.println("Invalid position"); return; }
        temp.next = temp.next.next;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
```

---

## Driver Program

```java
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.head = new Node(10);
        list.head.next = new Node(20);
        list.head.next.next = new Node(30);
        list.head.next.next.next = new Node(40);
        list.head.next.next.next.next = new Node(50);

        list.deleteAtPosition(3);
        list.display();
        // Output: 10 → 20 → 40 → 50 → null
    }
}
```

---

## Practice Problems

**Problem 1 — Delete at Beginning**
```text
Start:    10 → 20 → 30 → 40
Expected: 20 → 30 → 40
```

**Problem 2 — Delete at End**
```text
Start:    10 → 20 → 30 → 40
Expected: 10 → 20 → 30
```

**Problem 3 — Delete at Position**
```text
Start:    10 → 20 → 30 → 40 → 50
Delete:   position 4
Expected: 10 → 20 → 30 → 50
```

---

## Key Concepts

- Delete at Beginning → move `head`
- Delete at End → reach second-last, set `next = null`
- Delete at Position → reach `pos - 1`, skip target
- Core statement: `temp.next = temp.next.next`

---

## What's Next

1. Search in Linked List
2. Find Length of Linked List
3. Reverse Linked List ← most important interview question
4. Middle of Linked List
5. Detect Loop in Linked List