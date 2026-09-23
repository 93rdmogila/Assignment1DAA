# Sorting and Selection Algorithms Benchmark

An academic Java project implementing, optimizing, and benchmarking Divide-and-Conquer algorithms: **QuickSort**, **MergeSort**, and **QuickSelect**.

---

## 🛠 Implemented Algorithms & Features

* **QuickSort:**
  * **Randomized Pivot:** Avoids $O(n^2)$ complexity on ordered arrays.
  * **3-Way Partitioning:** Efficiently groups duplicate elements ($<, =, >$).
  * **Bounded Stack Depth:** Recurs into the smaller subarray first, guaranteeing $O(\log n)$ max recursion depth.

* **MergeSort:**
  * **Single Auxiliary Array:** Allocates `aux` array only once in the top-level call to prevent memory churn.
  * **Cutoff:** Switches to InsertionSort for subarrays of size $\le 15$.

* **QuickSelect:**
  * **Single-Branch Partitioning:** Finds the $k$-th smallest element in expected $O(n)$ time.
  * Throws `IllegalArgumentException` for invalid inputs ($k < 0$ or $k \ge n$).

---

## 📊 Benchmark & CSV Output

The benchmark runner executes **5 runs** per configuration and records the **median values** to eliminate JVM warm-up/GC noise.

### CSV Structure (`results.csv`)
The generated `results.csv` contains:
`algorithm,input,n,time_ms,comparisons,max_depth`

### Asymptotic Ratio Metric
To verify theoretical bounds empirically:
* **Sorting Algorithms:** $\text{Ratio} = \frac{\text{Comparisons}}{n \cdot \log_2(n)}$
* **QuickSelect:** $\text{Ratio} = \frac{\text{Comparisons}}{n}$

If the algorithm matches its theoretical complexity, the ratio approaches a constant value $c$ as $n$ grows.

---

## 🚀 How to Run

1. **Compile:**
   ```bash
   javac *.java
