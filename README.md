## 1. 复杂度分析

它是评价算法的 "标尺"，告诉我们执行某个算法需要的时间和空间，也可以此来展开不同算法之间的对比。而大 $O$ 复杂度表示法表示的只是一种变化趋势。

### 1.1 时间复杂度

我们只需要去关注循环执行次数最多的代码，其他部分代码忽略，并使用以下两个法则

- 加法法则: 代码总的复杂度等于量级最大的那段代码的复杂度
- 乘法法则: 嵌套代码的复杂度等于嵌套内外代码复杂度的乘积

- $O(n^2)$

```java
int sum = 0;
for(int i = 0; i < n; i++){
  sum += i;
  for (int j = 0; j < n; j++) {
    sum += j;    
  }
}
```

第5行代码执行次数为 $n$，第3行代码执行次数为 $n$，根据乘法法则，嵌套代码复杂度需要进行乘积

- $O(logn)$

```java
int i = 1;
while (i <= n) {
    i = i * 2;    
}
```

我们只需要关注第3行代码，而i的变化序列为 $2, 4, 8, 16...$，所以这段代码的时间复杂度为$O(logn)$

### 1.2 空间复杂度
空间复杂度指的是**除原本的数据存储空间以外**，算法运行过程中还需要的额外存储空间。

比如用数组实现栈数据结构，栈中虽有大小为 $n$ 的数组，但是并不代表它的空间复杂度为 $O(n)$ ，而是只关注数组之外的一些临时变量，因此它的空间复杂度为 $O(1)$

## 2. 数据结构

**所有数据结构都是基于数组或链表或两者组合实现的**

### 2.1 数组

数组是线性的数据结构，占用连续的内存空间存储一组相同类型的数据，正因如此，数组**支持随机访问**，即在 $O(1)$ 时间复杂度内按照索引快速访问数组中的元素。
但是它的插入、删除操作也因此变得低效，平均时间复杂度为 $O(n)$

### 2.3 背包

支持添加和遍历元素，但是不支持删除元素，使用背包可以说明元素的处理顺序并不重要。

### 2.6 二叉树

二叉树是一种非线性数据结构，代表着“一分为二”的分治思想。二叉树的节点包含「值」和两个「指针」，分别指向左子节点和右子节点。

#### 完美二叉树
在完美二叉树中，所有节点的度 = 2 ；若树高度 = h ，则节点总数 = $2^(h + 1)^ - 1$，呈标准的指数级关系，反映着自然界中常见的细胞分裂。

![img.png](src/main/resources/images/tree/img.png)

#### 满二叉树
除了叶节点之外，其余所有节点都有两个子节点。

![img_1.png](src/main/resources/images/tree/img_1.png)

#### 完全二叉树
「完全二叉树 Complete Binary Tree」只有最底层的节点未被填满，且最底层节点尽量靠左填充。

**完全二叉树非常适合用数组来表示**。如果按照层序遍历序列的顺序来存储，那么空节点 null 一定全部出现在序列的尾部，因此我们就可以不用存储这些 null 了。

![img_2.png](src/main/resources/images/tree/img_2.png)

#### 平衡二叉树
「平衡二叉树 Balanced Binary Tree」中任意节点的左子树和右子树的高度之差的绝对值 ≤ 1

![img_3.png](src/main/resources/images/tree/img_3.png)

#### 二叉搜索树
「二叉搜索树 Binary Search Tree」满足以下条件：
1. 对于根节点，左子树中所有节点的值 < 根节点的值 < 右子树中所有节点的值
2. 任意节点的左子树和右子树也是二叉搜索树，即也满足条件 1

（二叉搜索树不允许存在重复节点，否则将会违背其定义）

![img_4.png](src/main/resources/images/tree/img_4.png)

#### AVL树
「AVL 树」既是「二叉搜索树」又是「平衡二叉树」，同时满足这两种二叉树的所有性质，因此又被称为「平衡二叉搜索树」，它能在不断地添加和删除节点时保证AVL树不发生退化。

AVL树的独特之处在于旋转操作（左旋，先左旋再右旋，右旋，先右旋再左旋），其可**在不影响二叉树中序遍历的前提下，使失衡节点恢复平衡**，
平衡的意思可以理解为**性能不退化**的意思

#### 红黑树

「红黑树」是一种相对平衡的「二叉搜索树」，分别有黑色和红色两类节点，并满足以下四个要求: 
- 根节点是黑色的
- 每个叶子节点都是黑色的空节点，也就是说，叶子节点不存储数据
- 任何上下相邻的节点不能同时为红色，也就是说，红色节点被黑色节点隔开
- 对于每个节点，从该节点到其叶子节点的所有路径都包含相同数目的黑色节点

![](src/main/resources/images/tree/红黑树.jpg)

红黑树相比AVL树的应用要广泛，因为它维持"平衡"的成本相对较低而且性能损失又不太严重

### 2.6 堆（优先队列）

「堆 Heap」是一棵限定条件下的「完全二叉树」。根据成立条件，堆主要分为两种类型：
- 「小顶堆 Min Heap」，任意节点的值 ≤ 其子节点的值
- 「大顶堆 Max Heap」，任意节点的值 ≥ 其子节点的值

![img.png](src/main/resources/images/heap/img.png)

其中二叉树中的根节点对应「堆顶」，底层最靠右节点对应「堆底」。

堆化过程有**自上而下**和**自下而上**堆化两种，自上而下堆化可以理解为从上到下**找到自己合适的位置**的过程

#### 堆的存储与表示

「完全二叉树」非常适合使用「数组」来表示，给定索引 $i$，那么其左子节点索引为 $2i + 1$、右子节点索引为 $2i + 2$、父节点索引为 $(i - 1) / 2$，若索引越界，则代表空节点或节点不存在。

![img_1.png](src/main/resources/images/heap/img_1.png)

#### 元素入堆

以大顶堆为例，先将其添加至堆底，由于该值可能大于堆中其他元素，所以要从底至顶执行堆化。具体步骤: 比较该值与其父节点的大小，若插入节点更大则将它们交换，
直至遇到无需交换的节点或越过数组范围时结束。

[元素入堆图示](https://www.hello-algo.com/chapter_heap/heap/#_3)

[//]: # (![img_2.png]&#40;src/main/resources/images/heap/img_2.png&#41;)

[//]: # ()
[//]: # (![img_3.png]&#40;src/main/resources/images/heap/img_3.png&#41;)

[//]: # ()
[//]: # (![img_4.png]&#40;src/main/resources/images/heap/img_4.png&#41;)

[//]: # ()
[//]: # (![img_5.png]&#40;src/main/resources/images/heap/img_5.png&#41;)

[//]: # ()
[//]: # (![img_6.png]&#40;src/main/resources/images/heap/img_6.png&#41;)

- **时间复杂度**: $O(logn)$

#### 堆顶元素出堆

大顶堆堆顶元素出堆步骤
1. 交换堆顶元素和堆底元素
2. 交换完成后，将堆底元素删除
3. 从根节点开始，从顶至底执行堆化

与元素入堆相比，出堆堆化与入堆堆化方向相反，比较的是根节点和其最大子节点的值，
若根节点小于该子节点，则执行交换，循环该步骤，直至无需交换或者越过数组范围时结束。

[元素出堆图示](https://www.hello-algo.com/chapter_heap/heap/#_4)

[//]: # (![img_7.png]&#40;src/main/resources/images/heap/img_7.png&#41;)

[//]: # ()
[//]: # (![img_8.png]&#40;src/main/resources/images/heap/img_8.png&#41;)

[//]: # ()
[//]: # (![img_9.png]&#40;src/main/resources/images/heap/img_9.png&#41;)

[//]: # ()
[//]: # (![img_10.png]&#40;src/main/resources/images/heap/img_10.png&#41;)

[//]: # ()
[//]: # (![img_11.png]&#40;src/main/resources/images/heap/img_11.png&#41;)

[//]: # ()
[//]: # (![img_12.png]&#40;src/main/resources/images/heap/img_12.png&#41;)

[//]: # ()
[//]: # (![img_13.png]&#40;src/main/resources/images/heap/img_13.png&#41;)

[//]: # ()
[//]: # (![img_14.png]&#40;src/main/resources/images/heap/img_14.png&#41;)

[//]: # ()
[//]: # (![img_15.png]&#40;src/main/resources/images/heap/img_15.png&#41;)

[//]: # ()
[//]: # (![img_16.png]&#40;src/main/resources/images/heap/img_16.png&#41;)

#### 删除普通元素

如果替换元素比被删除元素大，则执行自下而上的堆化；如果替换元素比被删除元素小，则执行自上而下的堆化；否则不需要处理

### 2.7 哈希表

#### 哈希表高效扩容的方案

存在1GB的哈希表需要扩容，如果在插入元素使先将数据从旧哈希表搬迁到新哈希表，那么会非常耗时，为了避免这种情况，可以在每次插入新数据时只搬迁一部分数据到新哈希表，
每次插入都重复执行这个动作，经过多次数据插入后，数据迁移就完成了，这样使得分摊到每次插入操作的时间复杂度为 $O(1)$，但是这也存在新旧哈希表占用空间和查询数据需要
在两个哈希表中都要查找的问题。

#### 哈希冲突解决方案的应用

- **开放寻址法**: 适合数据量较小，装载因子小的场景，因为它的数据全存在数组中，更容易发生哈希冲突，所以装载因子不能太大。ThreadLocalMap使用该方法。
- **链表法**: HashMap、LinkedHashMap使用该方法。

#### LRUCache(Least Recently Used Cache)

```java
public class LRUCache {

    private static class LinkedNode {
        public int key;
        public int value;

        public LinkedNode prev;
        public LinkedNode next;

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Map<Integer, LinkedNode> cache = new HashMap<>();
    private int size;
    public int capacity;

    private final LinkedNode head;
    private final LinkedNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        // 哨兵节点
        this.head = new LinkedNode(-1, -1);
        this.tail = new LinkedNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * LRU查找节点，存在的话将该节点移到头节点
     */
    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node != null) {
            removeNode(node);
            addHead(node);

            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;

            removeNode(node);
            addHead(node);
        } else {
            LinkedNode newNode = new LinkedNode(key, value);
            // 容量满了的话，得删掉尾巴节点
            if (size == capacity) {
                cache.remove(tail.prev.key);
                removeNode(tail.prev);
                size--;
            }

            addHead(newNode);
            cache.put(key, newNode);
        }

        size++;
    }

    public void remove(int key) {
        LinkedNode node = cache.get(key);
        if (node != null) {
            size--;
            removeNode(node);
            cache.remove(key);
        }
    }

    private void removeNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addHead(LinkedNode node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    public void print() {
        if (size > 0) {
            StringBuilder res = new StringBuilder("LinkedList: {");
            LinkedNode temp = head.next;
            while (temp.key != -1) {
                res.append(temp.value).append(",");
                temp = temp.next;
            }
            res.replace(res.length() - 1, res.length(), "");
            res.append("}");

            StringBuilder cacheRes = new StringBuilder("Cache: {");
            for (LinkedNode value : cache.values()) {
                cacheRes.append(value.value).append(",");
            }
            cacheRes.replace(cacheRes.length() - 1, cacheRes.length(), "");
            cacheRes.append("}");

            System.out.println(res);
            System.out.println(cacheRes);
        }
    }
}
```

#### 哈希表的特殊形式: 位图

位图用来判断大范围数据中某个数是否存在非常合适，占用空间极小，因为每个数字仅用0或1一**位**来标记。但是在Java这种高级语言中，布尔值占用多个字节，
远远比**位**大，所以 可以通过使用字符数组来表示位图，每个char字符是2字节即16位，那么每个元素就能表示16个数字的存在情况，通过 `num / 16` 定位到它在字符数组中的位置，
通过 `num % 16` 来找到该元素在该字符下的哪个二进制位上，存在为1不存在为0。

```java
public class BitMap {
    // 每个字符是16位 用于表示16个数字的存在情况
    private final char[] bytes;

    // 数据量大小
    private final int bits;

    public BitMap(int bits) {
        this.bits = bits;
        this.bytes = new char[bits / 16 + 1];
    }

    public void set(int num) {
        if (num > bits) {
            return;
        }

        int byteIndex = num / 16;
        // 标记该数字在数组中存在
        bytes[byteIndex] |= (1 << num % 16);
    }

    public boolean get(int num) {
        if (num > bits) {
            return false;
        } else {
            int byteIndex = num / 16;

            return (bytes[byteIndex] & (1 << num % 16)) != 0;
        }
    }
}
```

#### 布隆过滤器

**布隆过滤器**是在位图基础上进行改造的产物，可以用小于数据范围的字符数组来**准确地**判断较大数据范围的数据**是否不存在**。
它会使用**多个哈希函数**来定位某个数的位置，存在时将它们都标记为1，因此可能会出现重复的情况，所以判断某个数据是否存在可能是不准确的。

布隆过滤器比较适合标记静态数据，而对于动态数据，随着标记的数据越来越多，准确性下降，需要使布隆过滤器支持动态扩容来保证校验结果的相对准确性。
布隆过滤器可以应用在网站每日用户访问量上，判断用户是否访问过进行去重。

- Java: BitSet; Redis: BitMap; Guava: BloomFilter

### 2.8 图

#### 图的应用

- 社交网络的好友关系，潜在好友推荐
- 地铁线路的站点连通性，最短路线推荐
- 太阳系星体间万有引力，行星轨道计算

#### 广度优先遍历

BFS 常借助「队列」来实现，队列具有 “先入先出” 的性质，这与 BFS “由近及远” 的思想异曲同工，它从距离最近的顶点开始访问，并一层层向外扩张

```java
    // 邻接表的广度优先遍历
    public List<Integer> bfs(Vertex vertex) {
        List<Integer> res = new ArrayList<>();
        HashSet<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();

        queue.offer(vertex);
        visited.add(vertex);
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            res.add(v.getVal());

            for (Vertex visit : adjacencyList.get(v)) {
                if (visited.contains(visit)) {
                    continue;
                }
                queue.offer(visit);
                visited.add(visit);
            }
        }

        return res;
    }
```

#### 深度优先遍历

深度优先遍历是一种优先走到底（递归）、无路可走再回头（回溯）的遍历方式

```java
    // 邻接表的深度优先遍历
    public void dfs(Vertex vertex, List<Integer> res, HashSet<Vertex> visited) {
        if (visited.contains(vertex)) {
            return;
        }

        visited.add(vertex);
        res.add(vertex.getVal());
        for (Vertex v : adjacencyList.get(vertex)) {
            dfs(v, res, visited);
        }
    }
```

#### Kahn 算法实现拓扑排序

拓扑排序解决有向无环图的依赖排序，将被依赖的顶点排在前面，依赖其他顶点的顶点位置排在后面

```java
    /**
     * 邻接表有向图 Kahn算法实现拓扑排序
     * 规定如果A依赖B的话，那么添加A指向B的边，A的出度为1，当出度为0时将其输出到结果序列中
     */
    public void topoSortByKahn() {
        List<Integer> res = new ArrayList<>(adjacencyList.size());
        Queue<Vertex> queue = new LinkedList<>();

        // 保存出度为0的顶点
        queue0OutDegree(queue);
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            res.add(vertex.getVal());

            // 移除这个点，再记录出度为0的点
            removeVertex(vertex);
            queue0OutDegree(queue);
        }

        System.out.println(res);
    }

    /**
     * 出度为0的顶点入队
     */
    private void queue0OutDegree(Queue<Vertex> queue) {
        for (Map.Entry<Vertex, List<Vertex>> vertexListEntry : adjacencyList.entrySet()) {
            if (vertexListEntry.getValue().isEmpty()) {
                queue.offer(vertexListEntry.getKey());
            }
        }
    }
```

## 3. 递归
**不要试图模拟计算机递归调用的过程！** **不要试图用你聪明的大脑去分解递归的每个步骤！** 而是思考递推公式，找出终止条件，然后将以上信息"翻译"成代码！

递归调用存在如下两个问题
- 警惕递归代码出现堆栈溢出
- 警惕递归代码出现的重复计算问题: 使用 **备忘录** 来解决

比如，爬n阶台阶的问题
```java
    /**
     * 爬台阶问题
     * <p>
     * 递推公式: f(n) = f(n - 1) + f(n - 2)
     * 终止条件: 爬到第1或第2阶台阶
     * <p>
     * 备忘录: 当计算5阶台阶时，会计算4阶台阶和3阶台阶，计算4阶台阶时还会计算3阶台阶，3阶台阶的计算是重复的
     * 所以我们可以依靠备忘录来解决重复计算的问题
     */
    private static int recursion(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = recursion(n - 1) + recursion(n - 2);
        map.put(n, res);
        
        return res;
    }

    // 备忘录
    private static final HashMap<Integer, Integer> map = new HashMap<>(16);
```

- 空间复杂度: $O(n)$ ，递归代码的空间复杂度等于最大深度乘以每层递归调用的空间消耗，每层递归空间消耗为常量级，而栈的最大深度为n所以为 $O(n)$

## 4. 排序算法

#### 4.2.3 堆排序

- 核心思想: 堆排序包含建堆和排序两个过程，首先先对**非叶子节点自上而下进行建堆**（因为叶子节点已经是最底了，不能再往下跑了），堆化完成后，不断地将堆顶元素放到数组末尾即可

```java
    /**
     * 要求数组从1开始保存数
     */
    public void heapSort(int[] nums) {
        // 判断数组中是否有数
        if (nums.length > 2) {
            // 先对数组进行建堆
            buildHeap(nums);

            // 不断地比较和交换位置来排序
            int heapTail = nums.length - 1;
            while (heapTail >= 1) {
                // 将最大值放到合适的位置
                swap(nums, 1, heapTail);
                heapTail--;
                // 重新堆化
                heapifyTopDown(nums, 1, heapTail);
            }
        }
    }

    private void buildHeap(int[] nums) {
        // 找到最后一个非叶子节点
        for (int index = (nums.length - 1) / 2; index >= 1; index--) {
            // 自上而下建堆
            heapifyTopDown(nums, index, nums.length - 1);
        }
    }

    /**
     * 自上而下堆化
     *
     * @param numIndex 执行堆化的数值索引
     * @param heapEnd  堆化停止的数组范围
     */
    private void heapifyTopDown(int[] nums, int numIndex, int heapEnd) {
        int num = nums[numIndex];
        // 找到该值的索引位置
        for (int leftIndex = 2 * numIndex, rightIndex = leftIndex + 1; leftIndex <= heapEnd;
             leftIndex = numIndex * 2, rightIndex = leftIndex + 1) {

            if (num < nums[leftIndex]) {
                swap(nums, leftIndex, numIndex);
                numIndex = leftIndex;
            }
            if (rightIndex <= heapEnd && num < nums[rightIndex]) {
                swap(nums, rightIndex, numIndex);
                numIndex = rightIndex;
            }
        }
    }

    private void swap(int[] nums, int numIndex, int i) {
        int temp = nums[numIndex];
        nums[numIndex] = nums[i];
        nums[i] = temp;
    }
```

- **空间复杂度**: $O(1)$
- **原地排序**
- **非稳定排序**
- **非自适应排序**

##### 为什么堆排序的性能不如快速排序？

1. 堆排序的数据访问方式没有快速排序高效，因为执行堆化的过程中索引的访问是随机的，而快速排序是按照连续下标访问数组元素
2. 对于同样的数据，堆排序的数据交换次数要多于快速排序

##### 堆的应用

- Top K 问题: 创建大小为K的小顶堆，如果堆中数量不足K直接插入，否则比较插入值和堆顶元素的大小，大于等于则插入否则不处理
- 中位数问题: 创建一个大顶堆和一个小顶堆，小顶堆中的值都比大顶堆中的大，当数字个数为偶数时，两个队列中的数字数量相等；当数字个数为奇数时，大顶堆中多一个，
  此时这个值即为中位数。随着数据的不断加入，两个堆中的数据需要不停的相互移动

### 4.3 $O(n)$

桶排序、计数排序和基数排序，时间复杂度都为 $O(n)$，也称为线性排序，它们**都不是**基于比较的排序算法。

#### 4.3.1 桶排序

- 核心思想: 对分治思想的应用，定义几个有序的"桶"，将要排序的数据分别放到这几个"桶"里，对每个桶里的数据单独进行排序，
再把每个"桶"里的数据按照顺序依次取出，结果便是有序的。

桶排序的时间复杂度虽然为 $O(n)$ ，但是它对数据是有要求的，待排序数组需要容易划分成m个"桶"，并且"桶"与"桶"之间有着 **"天然"的大小顺序** ，
这样在每个桶中的值排序完成后，取出结果便是有序的

```java
    /**
     * 桶排序
     * 指定数据范围为0 - 50，分桶为5个，每10个数为一个桶
     */
    @SuppressWarnings("unchecked")
    private static void bucketSort(int[] nums) {
        // 声明5个桶
        ArrayList<Integer>[] buckets = new ArrayList[5];
        Arrays.fill(buckets, new ArrayList<Integer>());

        // 数组元素分桶
        intoBucket(buckets, nums);

        // 出桶
        outOfBucket(buckets, nums);
    }

    private static void intoBucket(ArrayList<Integer>[] buckets, int[] nums) {
        for (int num : nums) {
            int bucketIndex = num / 10;
            buckets[bucketIndex].add(num);
        }
    }

    private static void outOfBucket(ArrayList<Integer>[] buckets, int[] nums) {
        for (ArrayList<Integer> bucket : buckets) {
            // 先排序 再出桶
            bucket.sort(Comparator.comparingInt(x -> x));

            // 出桶覆盖原数组值
            int numsIndex = 0;
            for (Integer num : bucket) {
                nums[numsIndex++] = num;
            }
        }
    }
```

- **空间复杂度**: $O(n)$
- **非原地排序**
- **稳定性**: 取决于桶内排序的算法是否稳定

##### 桶排序非常适合用在外部排序中：比如，有10GB的订单需要按照金额排序，但是服务器的内存只有几百MB，那么该如何做？

采用桶排序的方法，假定金额为 $1 - 1000$ 且均匀分布，那么我们划分出100个桶，每个桶内的金额范围为10元，这样我们逐个将每个桶进行排序，
分别写到100个小文件中，这样按顺序读取这100个小文件写到大文件中，就完成了该排序。如果金额不是均匀分布的，那么我们对分到订单数量过多的桶再进行桶划分，
直到保证每个桶内的数据量满足内存大小要求。

#### 4.3.2 计数排序

计数排序是桶排序的一种特殊情况，与桶排序类似，只是桶的大小粒度不一样，计数排序桶的粒度是**非负整数的单位值**，即待排序数组中最大值为k，则划分成k + 1个桶。
我们以如下例子来理解计数排序，是对**前缀和**的应用，桶中 `bucket[nums[i]] - 1` 代表某个元素出现的最后索引，每次将 `nums[i]` 写入正确的位置，
将该索引值减一，从而得到下次放置 `nums[i]` 的索引

```java
public class CountingSort {
    public static void main(String[] args) {
        // 假设8个考生，分数的范围是0 - 5分，他们的分数为[2, 5, 3, 0, 2, 3, 0, 3]，排序这些学生的分数
        int[] students = new int[]{2, 5, 3, 0, 2, 3, 0, 3};

        // 计数排序
        countingSort(students);

        System.out.println(Arrays.toString(students));
    }

  /**
   * 计数排序的计数体现在小于等于某个数出现的次数 - 1 即为该数在原数组排序后的位置
   */
  private static void countingSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        // 寻找数组中的最大值来以此定义max + 1个桶
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // 定义桶，索引范围即数组值的最大范围，每个桶中保存的是该数字出现的次数，计数排序的计数概念出现
        int[] bucket = new int[max + 1];
        Arrays.fill(bucket, 0);

        // 计算每个数的个数在桶中累加
        for (int num : nums) {
            bucket[num]++;
        }
        // 依次累加桶中的数，该数表示小于等于该索引值的数量
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] += bucket[i - 1];
        }

        // 创建临时数组来保存排序结果值
        int[] res = new int[nums.length];
        // 倒序遍历原数组
        for (int i = nums.length - 1; i >= 0; i--) {
            // 根据桶中的 计数 找出该数的索引
            int index = bucket[nums[i]] - 1;
            // 根据索引在结果数组中赋值
            res[index] = nums[i];
            // 该数分配完成后，需要将桶中的计数数量-1
            bucket[nums[i]]--;
        }

        // 结果数组覆盖原数组
        System.arraycopy(res, 0, nums, 0, res.length);
    }
}
```

- **时间复杂度**: $O(n)$，但是要保证数据在范围不大的场景下，否则就不适用计数排序了
- **稳定排序**: **从后往前遍历**保证计数排序为稳定性排序，反过来正序遍历就不是稳定排序了

#### 4.3.3 基数排序

基数排序是一种特殊的桶排序，基数体现在**待排序数据能够分割出独立的"位"，并且在"位"与"位"之间有递进关系**，比如整数可以分出个、十、百位等，且百位和十位存在递进关系。
基数排序的执行轮次和待排序数据最大值的长度一致。

```java
    /**
     * 基数排序 本例应用于整数排序
     */
    private static void radixSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        // 1. 整数的每位取值范围为 0-9，因此需要创建10个桶
        Queue<Integer>[] buckets = createBuckets();

        // 2. 获取基数排序的执行轮次
        int radixRounds = getRadixRounds(nums);

        // 3. 根据执行轮次处理各个"位"，eg: 第一轮处理个位...
        for (int round = 1; round <= radixRounds; round++) {
            for (int num : nums) {
                // 获取所在桶的索引
                int bucketIndex = getBucketIndex(num, round);
                // 进桶
                buckets[bucketIndex].offer(num);
            }

            // 出桶赋值，当前结果为根据当前位排序的结果
            int numsIndex = 0;
            for (Queue<Integer> bucket : buckets) {
                while (!bucket.isEmpty()) {
                    nums[numsIndex++] = bucket.poll();
                }
            }
        }
    }

    /**
     * 创建大小为10的数组作为桶，每个桶都是一个队列
     */
    @SuppressWarnings("unchecked")
    private static Queue<Integer>[] createBuckets() {
        Queue<Integer>[] buckets = new Queue[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        return buckets;
    }

    /**
     * 获取基数排序的执行轮次
     */
    private static int getRadixRounds(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        return String.valueOf(max).length();
    }

    /**
     * 获取该数所在桶的索引
     */
    private static int getBucketIndex(int num, int round) {
        int bucketIndex = 0;

        while (round != 0) {
            bucketIndex = num % 10;
            num /= 10;

            round--;
        }

        return bucketIndex;
    }
```

相较于计数排序，基数排序适用于数据范围较大的情况，前提是数据必须可以表示为固定位数的格式，且位数不能过大。

## 6. 分治、贪心、回溯和动态规划

### 分治

分治算法的核心是 **"分而治之"** ，将原问题分解成n个小问题，通过递归的方式将其解决，之后合并这些子问题。分治算法可以应用在解决数组**逆序度**问题上。

满足分治算法应用的条件

- 原问题与分解成的小问题具有相同的结构
- 由原问题分解成的子问题可以独立求解，子问题之间没有相关性
- 具备分解终止条件: 当问题足够小时，可以直接求解
- 可以将子问题的结果合并成原问题的结果

### 回溯、动态规划和贪心

回溯、动态规划和贪心多数都可以抽象成**分阶段决策最优解的模型**。

回溯算法相当于**穷举搜索**，穷举所有情况，然后对比得到最优解，通常采用深度优先搜索来遍历。它比较"万金油"，一般能用动态规划和贪心解决的问题它也能解决。
对于需要 **"做选择"** 的问题，适合用回溯来解决。回溯算法非常适合使用递归来实现，不过复杂度也非常高，是指数级别的，只能用来解决小规模数据问题。
可以通过**剪枝**和**备忘录**对其进行优化，**使用备忘录的回溯算法和动态规划在执行效率上基本没有区别**。

动态规划一般用来解决 **"最优"** 问题。在求解的过程中能划分为多个阶段，每个阶段（子问题）对应一个状态，而下一个阶段的状态可以用当前阶段的状态推导出来。
动态规划非常高效，相比于回溯算法，是因为它去除了回溯算法中存在的大量重复子问题。

浏览器搜索框，单词输入错误提示实现的基本原理是在字典中取**编辑距离最小**的单词

贪心算法是动态规划的一种特殊情况，通过**局部最优解产生全局最优解**。
