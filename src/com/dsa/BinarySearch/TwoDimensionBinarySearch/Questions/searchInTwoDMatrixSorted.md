This code implements an optimized algorithm to search for a `target` number inside a 2D matrix.

The core idea is not to search every single element (which would be slow). Instead, it uses **Binary Search** to
eliminate large chunks of the matrix at once. It treats the matrix logic in two stages:

1. **Vertical Binary Search:** Narrow down the search to just **two rows** by looking at the middle column.
2. **Horizontal Binary Search:** Once we have only two rows left, find the exact position of the target in the remaining
   possible segments.

Here is the line-by-line detailed explanation.

---

### 1. The Helper Method: `binarySearch`

This method is a standard, simple Binary Search. It searches for a target within a *single row* between specific
columns (`cStart` and `cEnd`).

```java
static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
    while (cStart <= cEnd) {
        int mid = cStart + (cEnd - cStart) / 2; // Calculate middle index

        if (matrix[row][mid] == target) {
            return new int[]{row, mid}; // Found it! Return coordinates
        }
        if (matrix[row][mid] < target) {
            cStart = mid + 1; // Target is on the right
        } else {
            cEnd = mid - 1;   // Target is on the left
        }
    }
    return new int[]{-1, -1}; // Not found
}

```

* **Purpose:** This is used at the very end of the main algorithm. Once we know "The target is definitely in *this* part
  of *this* row," we call this function to find it.

---

### 2. The Main Logic: `search` Method

This is where the complex 2D logic happens.

#### **A. Initialization**

``` java
int rows = matrix.length;
int col = matrix[0].length;

if(rows ==1){
        return

binarySearch(matrix, 0,0,col -1, target);
}

```

* **`rows` / `col**`: Gets the dimensions of the matrix.
* **`if (rows == 1)`**: This is an edge case. If the matrix has only one row, we don't need the complex 2D logic. We
  just run a simple binary search on that single row.

#### **B. Setting up the "Middle Column" Search**

```java
int rStart = 0;
int rEnd = rows - 1;
int cMid = col / 2;

```

* **Strategy:** We are going to look at the **middle column** (`cMid`) of the matrix to decide which rows we can ignore.
* **`rStart` / `rEnd**`: These track the range of rows we are currently considering. Initially, we consider all rows (
  from 0 to last).

#### **C. The Row Reduction Loop**

This loop squeezes the `rStart` and `rEnd` closer together until only **two rows remain**.

``` java
while(rStart< (rEnd -1)){ // Run until only 2 rows are left
int mid = rStart + (rEnd - rStart) / 2; // Middle row index
    
    if(matrix[mid][cMid]==target){
        return new int[]{mid,cMid}; // Found target in the middle column!
        }
        if(matrix[mid][cMid] <target){
rStart =mid; // Target is below, ignore rows above
    }else{
rEnd =mid;   // Target is above, ignore rows below
    }
            }

```

* **`while (rStart < (rEnd - 1))`**: This condition is crucial. It ensures the loop stops when `rStart` and `rEnd` are
  neighbors (e.g., Row 3 and Row 4). We don't want them to overlap entirely here; we want to be left with a "top" row
  and a "bottom" row to check manually.
* **Logic:** It checks the value in the middle column (`cMid`) of the `mid` row.
* If that value is **less** than the target, the target must be in a row below (so we move `rStart` down).
* If that value is **greater** than the target, the target must be in a row above (so we move `rEnd` up).

#### **D. Check the Middle Column of Remaining Two Rows**

After the loop, we are left with two rows: `rStart` and `rStart + 1` (let's call them **Row A** and **Row B**).
The target might be in the middle column of these two rows, so we check them explicitly.

``` java
if(matrix[rStart][cMid]==target){
        return new int[]{rStart,cMid};
        }
        if(matrix[rStart +1][cMid]==target){
        return new int[]{rStart +1,cMid};
        }

```

#### **E. Search in the 4 Quadrants**

If we haven't found the target yet, it must be on the **Left** or **Right** of the middle column in either **Row A** or
**Row B**.
We have 4 possibilities (Quadrants):

1. **Row A (Left)**
2. **Row A (Right)**
3. **Row B (Left)**
4. **Row B (Right)**

The code checks these 4 areas one by one:

**1. Check Top-Left:**

``` java
if(target <=matrix[rStart][cMid -1]){
        return

binarySearch(matrix, rStart, 0,cMid -1, target);
}

```

* Is the target smaller than the element just to the left of the middle column in the top row? If yes, search the left
  side of the top row.

**2. Check Top-Right:**

``` java
if(target >=matrix[rStart][cMid +1]&&target <=matrix[rStart][col -1]){
        return

binarySearch(matrix, rStart, cMid +1, col -1, target);
}

```

* Is the target between the element to the right of the middle and the end of the top row? If yes, search the right side
  of the top row.

**3. Check Bottom-Left:**

``` java
if(target <=matrix[rStart +1][cMid -1]){
        return

binarySearch(matrix, rStart +1, 0,cMid -1, target);
}

```

* Is the target smaller than the element just to the left of the middle column in the bottom row? If yes, search the
  left side of the bottom row.

**4. Check Bottom-Right:**

``` java
else{
        return binarySearch(matrix, rStart +1, cMid +1, col -1, target);
}

```

* If it's none of the above, it **must** be in the right side of the bottom row.

---

### Dry Run with your Example

**Matrix:**

```
{1, 2, 3}  (Row 0)
{4, 5, 6}  (Row 1)
{7, 8, 9}  (Row 2)

```

**Target:** 9

1. **Setup:**

* `rows = 3`, `col = 3`.
* `rStart = 0`, `rEnd = 2`.
* `cMid = 1` (Index of middle column). Center column is `{2, 5, 8}`.


2. **While Loop (`rStart < rEnd - 1`) -> (`0 < 1`)**:

* Only runs if difference is > 1. Here `2 - 0 = 2`, so loop runs.
* `mid = 0 + (2-0)/2 = 1`.
* Check `matrix[1][1]` (which is `5`).
* `5 < 9` (Target is larger).
* `rStart` becomes `mid` (1).
* Loop condition check: `1 < (2 - 1)` -> `1 < 1` is **False**. Loop ends.


3. **Remaining Rows:**

* We are left with Row 1 (`rStart`) and Row 2 (`rStart + 1`).
* Rows to check: `{4, 5, 6}` and `{7, 8, 9}`.


4. **Middle Checks:**

* `matrix[1][1]` is 5? No.
* `matrix[2][1]` is 8? No.


5. **Quadrant Checks:**

* **Top-Left:** Is `9 <= 4`? No.
* **Top-Right:** Is `9 >= 6` AND `9 <= 6`? No.
* **Bottom-Left:** Is `9 <= 7`? No.
* **Bottom-Right:** (Else block). Search Row 2, from col `cMid+1` to end.
* Calls `binarySearch(matrix, row=2, start=2, end=2, target=9)`.


6. **Final Binary Search:**

* Looks at row 2, index 2. Value is 9.
* **Found!** Returns `{2, 2}`.



