# Linked List Insertions in Java

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

---

## 1. Insert at Beginning — O(1)

```text
Before:  10 → 20 → 30 → null
After:    5 → 10 → 20 → 30 → null
```

**Logic:** Point new node to current head, then update head.

```java
void insertAtBeginning(int data) {
    Node newNode = new Node(data);
    newNode.next = head;  // step 1
    head = newNode;       // step 2
}
```

---

## 2. Insert at End — O(n)

```text
Before:  10 → 20 → 30 → null
After:   10 → 20 → 30 → 40 → null
```

**Logic:** Traverse to the last node, then attach.

```java
void insertAtEnd(int data) {
    Node newNode = new Node(data);

    if (head == null) {
        head = newNode;
        return;
    }

    Node temp = head;
    while (temp.next != null) {
        temp = temp.next;
    }

    temp.next = newNode;
}
```

---

## 3. Insert at Position — O(n)

```text
Before:  10 → 20 → 30 → 40 → null
Insert:  25 at position 3
After:   10 → 20 → 25 → 30 → 40 → null
```

**Logic:** Walk to node at `pos - 1`, rewire its `next`.

```java
void insertAtPosition(int data, int pos) {
    Node newNode = new Node(data);

    if (pos == 1) {
        newNode.next = head;
        head = newNode;
        return;
    }

    Node temp = head;
    for (int i = 1; i < pos - 1 && temp != null; i++) {
        temp = temp.next;
    }

    if (temp == null) {
        System.out.println("Invalid position");
        return;
    }

    newNode.next = temp.next;  // step 1 — must come first
    temp.next = newNode;       // step 2
}
```

> **Order matters.** Always do `newNode.next = temp.next` before `temp.next = newNode`.
> Reversing the two lines loses the rest of the list.

---

## Time Complexities

| Operation | Complexity | Reason |
|---|---|---|
| Insert at Beginning | O(1) | No traversal needed |
| Insert at End | O(n) | Must walk to last node |
| Insert at Position | O(n) | Must walk to `pos - 1` |

---

## Complete Class

```java
class LinkedList {
    Node head;

    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) { head = newNode; return; }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    void insertAtPosition(int data, int pos) {
        Node newNode = new Node(data);
        if (pos == 1) { newNode.next = head; head = newNode; return; }
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) temp = temp.next;
        if (temp == null) { System.out.println("Invalid position"); return; }
        newNode.next = temp.next;
        temp.next = newNode;
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

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(5);
        list.insertAtPosition(25, 4);

        list.display();
        // Output: 5 → 10 → 20 → 25 → 30 → null
    }
}
```

---

## Practice Problems

**Problem 1 — Insert at Beginning**
```text
Start:    10 → 20 → 30
Insert:   5 at beginning
Expected: 5 → 10 → 20 → 30
```

**Problem 2 — Insert at End**
```text
Start:    10 → 20 → 30
Insert:   40 at end
Expected: 10 → 20 → 30 → 40
```

**Problem 3 — Insert at Position**
```text
Start:    10 → 20 → 30 → 40
Insert:   25 at position 3
Expected: 10 → 20 → 25 → 30 → 40
```

---

## What's Next

1. Delete at Beginning
2. Delete at End
3. Delete at Any Position
4. Search in Linked List
5. Reverse Linked List
6. Detect Loop
7. Interview Problems