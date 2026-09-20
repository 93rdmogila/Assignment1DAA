# Sorting and Selection Algorithms Benchmark

An academic Java project focused on implementing, optimizing, and benchmarking fundamental divide-and-conquer algorithms: **QuickSort**, **MergeSort**, and **QuickSelect**.

---

## 🛠 Implemented Algorithms & Optimizations

### 1. QuickSort
* **3-Way Partitioning (Dutch National Flag):** Handles duplicate keys efficiently by grouping elements equal to the pivot, avoiding $O(n^2)$ degradation on arrays with high redundancy.
* **Randomized Pivot Selection:** Mitigates worst-case performance on pre-sorted or reverse-sorted input sequences.
* **Recursion Tracking:** Monitors maximum stack depth to observe logarithmic space complexity.

### 2. MergeSort
* **Cutoff to InsertionSort:** Switches to InsertionSort for small sub-arrays ($\le 15$ elements) to eliminate recursive overhead on tiny partitions.
* **Reusable Auxiliary Buffer:** Allocates a single temporary array once in the primary call to prevent frequent memory allocation and garbage collection overhead during recursive steps.

### 3. QuickSelect
* **Single-Branch Recursion:** Finds the $k$-th smallest element in expected $O(n)$ time by pruning non-relevant sub-arrays instead of fully sorting the dataset.
* **3-Way Partitioning:** Utilizes dual-boundary partitioning to bypass duplicate values during selection.

---

## 📊 Benchmark Metrics

For every algorithm execution, the `Metrics` object tracks:
1. **Execution Time (ms):** Wall-clock time measured via `System.currentTimeMillis()`.
2. **Key Comparisons:** Total count of element-to-element comparison operations.
3. **Maximum Recursion Depth:** Peak depth reached by the call stack.

---

## 🚀 Build & Run Instructions

### Prerequisites
* **JDK 8** or higher installed.

### Compilation and Execution

1. Compile all source files:
   ```bash
   javac *.java
