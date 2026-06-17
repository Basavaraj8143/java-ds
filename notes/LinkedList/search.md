# Search and Length in Linked List

## 1. Search an Element — O(n)

```text
List:   10 → 20 → 30 → 40 → null
Find:   30
```

**Logic:** Traverse node by node, compare each `data` with the key.

```java
boolean search(int key) {
    Node temp = head;
    while (temp != null) {
        if (temp.data == key) return true;
        temp = temp.next;
    }
    return false;
}
```

Dry run for `search(30)`:

```text
10 ✗
20 ✗
30 ✓ → return true
```

---

## 2. Find Length — O(n)

```text
List:    10 → 20 → 30 → 40 → 50 → null
Length:  5
```

**Logic:** Increment a counter at every node while traversing.

```java
int length() {
    int count = 0;
    Node temp = head;
    while (temp != null) {
        count++;
        temp = temp.next;
    }
    return count;
}
```

Dry run:

```text
10 → count = 1
20 → count = 2
30 → count = 3
40 → count = 4
50 → count = 5
null → return 5
```

---

## Time Complexities

| Operation | Complexity | Reason |
|---|---|---|
| Search | O(n) | Linear scan, worst case last node |
| Length | O(n) | Must visit every node |

---

## Complete Class

```java
class LinkedList {
    Node head;

    boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }

    int length() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
```

---

## Practice Problems

**Problem 1 — Search: present**
```text
List:     5 → 10 → 15 → 20
Search:   15
Expected: true
```

**Problem 2 — Search: absent**
```text
List:     5 → 10 → 15 → 20
Search:   100
Expected: false
```

**Problem 3 — Length**
```text
List:     5 → 10 → 15 → 20 → 25
Expected: 5
```

---

## Important Observation

Every operation learned so far — traversal, insertion, deletion, search, length — uses the same skeleton:

```java
Node temp = head;
while (temp != null) {
    // do something
    temp = temp.next;
}
```

Master this pattern and linked lists become predictable.

---

## What's Next

1. Reverse Linked List ← most important interview question
2. Middle of Linked List
3. Detect Loop
4. Interview Problems