# StringBuilder DSA Notes (Java)

## Why StringBuilder?

Strings in Java are **immutable** — every concatenation creates a new object:

```java
String s = "abc";
s += "d"; // new String object created
```

`StringBuilder` mutates in-place, making it far faster for repeated modifications.

```java
StringBuilder sb = new StringBuilder();
```

---

## Core Methods

### 1. `append()` — O(1) amortized

Adds data to the end.

```java
StringBuilder sb = new StringBuilder();
sb.append("abc");
sb.append('d');
System.out.println(sb); // abcd
```

---

### 2. `deleteCharAt(index)` — O(n)

Removes the character at the given index. Shifts everything left.

```java
sb.deleteCharAt(2);
// "abcd" → "abd"
```

**Used in:** Remove Stars From String · Backspace String Compare · Text Editor Simulation

---

### 3. `delete(start, end)` — O(n)

Deletes a range. End index is **excluded**.

```java
sb.delete(1, 4);
// "abcdef" → "aef"
```

---

### 4. `reverse()` — O(n)

Reverses the entire buffer in-place.

```java
sb.reverse();
// "abcd" → "dcba"
```

---

### 5. `length()` — O(1)

Returns the current length.

```java
StringBuilder sb = new StringBuilder("hello");
sb.length(); // 5
```

---

### 6. `charAt(index)` — O(1)

Returns the character at the given index.

```java
char ch = sb.charAt(0); // 'h'
```

---

### 7. `setCharAt(index, char)` — O(1)

Modifies a character in-place.

```java
sb.setCharAt(0, 'H');
// "hello" → "Hello"
```

---

### 8. `insert(offset, str)` — O(n)

Inserts a string at any position. Shifts elements right.

```java
sb.insert(2, "XYZ");
// "abcd" → "abXYZcd"
```

---

### 9. `toString()` — O(n)

Converts `StringBuilder` to a regular `String`.

```java
String ans = sb.toString();
```

---

### 10. `substring(start, end)` — O(n)

Returns a slice. End index is **excluded**.

```java
sb.substring(1, 4);
// "abcdef" → "bcd"
```

---

### 11. `indexOf(str)` — O(n)

Returns the index of the first occurrence.

```java
sb.indexOf("bc"); // 1
```

---

### 12. `lastIndexOf(str)` — O(n)

Returns the index of the last occurrence.

```java
sb.lastIndexOf("ab"); // 0
```

---

## Frequently Used Patterns

```java
// Get last character
char last = sb.charAt(sb.length() - 1);

// Remove last character
sb.deleteCharAt(sb.length() - 1);

// Check if empty
if (sb.length() == 0) { ... }

// Append a character
sb.append(ch);

// Reverse a string
String rev = new StringBuilder(s).reverse().toString();
```

---

## Time Complexities

| Method | Complexity | Notes |
|---|---|---|
| `append()` | O(1) amortized | Buffer resizes rarely |
| `charAt()` | O(1) | Direct index access |
| `setCharAt()` | O(1) | In-place write |
| `length()` | O(1) | Stored field |
| `deleteCharAt()` | O(n) | Shifts elements left |
| `delete()` | O(n) | Shifts elements left |
| `insert()` | O(n) | Shifts elements right |
| `reverse()` | O(n) | Full traversal |
| `toString()` | O(n) | Copies buffer |
| `substring()` | O(n) | Copies range |
| `indexOf()` | O(n) | Linear scan |
| `lastIndexOf()` | O(n) | Linear scan |

---

## Common LeetCode Problems

### 1. Remove Stars From String (LC 2390)
**Strategy:** Walk left to right — append letters, `deleteCharAt` on `'*'`.

```java
// Key ops: append(), deleteCharAt()
// "leet**cod*e" → "lecoe"
```

---

### 2. Backspace String Compare (LC 844)
**Strategy:** Build both strings simulating `#` as backspace.

```java
// Key ops: append(), deleteCharAt()
// "ab#c" and "ad#c" → both → "ac" → true
```

---

### 3. Make The String Great (LC 1544)
**Strategy:** Walk the string; pop the tail when adjacent chars are same letter, different case.

```java
// Key ops: charAt(), deleteCharAt(), append()
// "abBAcC" → ""
```

---

### 4. Process String With Special Operations
**Strategy:** Multi-op simulator — each char has a different effect.

```
letter → append
*      → delete last char
#      → duplicate entire buffer
%      → reverse entire buffer
```

```java
// Key ops: append(), deleteCharAt(), reverse(), toString()
```

---

### 5. Decode String (LC 394)
**Strategy:** Use a `StringBuilder` per nesting level, paired with a `Stack` for repeat counts.

```java
// Key structures: StringBuilder + Stack
// "3[a2[c]]" → "accaccacc"
```

---

## Interview Recognition Pattern

Reach for `StringBuilder` when the problem says:

- Process characters left to right
- Modify / build the current string incrementally
- Delete the previous character (undo, backspace, star)
- Reverse a string or part of it
- Simulate a text editor or command processor

---

## 90% Interview Toolkit

Memorise these six — they solve the vast majority of StringBuilder problems:

```java
append()        // build the string
deleteCharAt()  // undo / backspace
charAt()        // inspect a character
length()        // bounds checking
reverse()       // flip in-place
toString()      // return the answer
```