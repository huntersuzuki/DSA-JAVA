This code implements an efficient algorithm to search for a specific number (the `target`) within a 2-Dimensional
matrix.

This is not a standard linear search (); it is an optimized search often called the **"Staircase Search"** because of
the path it traces through the grid. It relies on the specific property that the matrix is **sorted** in both rows and
columns.

### 1. The Matrix Setup (`main` method)

The `main` method sets up the data and handles user input.

```java
int[][] matrix = {
        {10, 20, 30, 40},
        {15, 25, 35, 45},
        {28, 29, 37, 49},
        {33, 34, 38, 50}
};

```

**Crucial Observation:** Notice the pattern in the numbers.

* **Rows are sorted:** Left to right, numbers increase (e.g., 10 -> 20 -> 30 -> 40).
* **Columns are sorted:** Top to bottom, numbers increase (e.g., 10 -> 15 -> 28 -> 33).

This sorting is essential. If the matrix were random, this code would **not** work.

---

### 2. The Search Logic (`search` method)

This is the heart of the code. Instead of checking every single box, we start at a specific "vantage point" where we can
make logical eliminations.

#### The Starting Point

```java
int row = 0;
int col = matrix.length - 1;

```

The code starts searching at the **Top-Right Corner** (Row 0, Last Column). In the example matrix, this is the number *
*40**.

**Why Top-Right?**
This is a strategic choice. At the top-right corner:

* Moving **Left** decreases the value.
* Moving **Down** increases the value.
* This distinct separation allows the algorithm to make a clear decision at every step: "Is my target smaller or
  bigger?"

*(Note: You could also start at the Bottom-Left. However, you cannot start at Top-Left or Bottom-Right, because moving
in either direction from those corners would result in the same change—e.g., at Top-Left, moving right increases and
moving down also increases, so you wouldn't know which way to go.)*

#### The Movement Loop

``` java
while(row<matrix.length &&col >=0){
        if(matrix[row][col]==target){
        return new int[]{row,col};
        }
        if(matrix[row][col] <target){
            row++;
        }else{
            col--;
        }
        }
```

This loop continues as long as the search is within the grid boundaries. Inside the loop, three things can happen:

1. **Match Found (`== target`):**
   We found the number! We immediately return the coordinates `{row, col}`.
2. **Current Element is Smaller than Target (`< target`):**

* We are currently at `matrix[row][col]`.
* If this number is *smaller* than what we want, then everything to its **left** in this row is also smaller (because
  the row is sorted).
* Therefore, the target cannot be in this row.
* **Action:** We move **Down** (`row++`) to find larger numbers.


3. **Current Element is Larger than Target (`else` / `> target`):**

* If the current number is *bigger* than what we want, then everything **below** it in this column is also bigger (
  because the column is sorted).
* Therefore, the target cannot be in this column.
* **Action:** We move **Left** (`col--`) to find smaller numbers.

---

### 3. A Step-by-Step Execution Trace

Let's trace the code using the example matrix and search for the **Target: 37**.

**Start:** Top-Right at `(0, 3)`. Value is **40**.

1. **Check 40:**

* Target is 37. Current is 40.
* (Current is too big).
* **Logic:** We need a smaller number. Since columns increase downwards, we eliminate this column.
* **Move:** Left (`col--`).


2. **Current is now `(0, 2)`. Value is 30.**

* Target is 37. Current is 30.
* (Current is too small).
* **Logic:** We need a bigger number. Since rows increase to the right, and we just came from the right, we know it's
  not in this row.
* **Move:** Down (`row++`).


3. **Current is now `(1, 2)`. Value is 35.**

* Target is 37. Current is 35.
* (Current is too small).
* **Logic:** We need bigger. Eliminate this row.
* **Move:** Down (`row++`).


4. **Current is now `(2, 2)`. Value is 37.**

* Target is 37. Current is 37.
* **Match Found!**
* **Return:** `{2, 2}`.

---

### 4. Code Improvements & Notes

There is a minor issue in the provided code regarding rectangular matrices.

**The Issue:**

```java
int col = matrix.length - 1;

```

`matrix.length` gives the number of **rows**. In a square matrix (like 4x4), this works fine. However, if you had a
matrix with 5 rows and 3 columns, this would cause an `ArrayIndexOutOfBoundsException` because it would try to access
column index 4, but only indices 0, 1, and 2 exist.

**The Fix:**
You should use `matrix[0].length` to get the number of columns.

```java
int col = matrix[0].length - 1; // Correct way to get column count

```

### Summary of Efficiency

* **Time Complexity:**
* In the worst case, you start at the top-right and walk all the way to the bottom-left. You traverse at most rows and
  columns. This is much faster than checking every element ().


* **Space Complexity:**
* We are not using any extra data structures, just two integer pointers (`row` and `col`).

Would you like me to show you how to modify this code to handle cases where the matrix is rectangular rather than a
perfect square?