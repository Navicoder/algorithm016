#### 一些感想

> &emsp;参加这一次的算法训练营，最大的收获并不是在这段时间里刷了多少题，而是从此掌握了正确刷题的方法，以及养成适合自己的能够长期坚持下去的习惯。
<br>&emsp;首先，最最重要的是避免刷题的最大误区——只做一遍。这也是我以前乃至大部分人都常用的套路，用好几个小时甚至一两天的时间去解一道题目，得出的解法大多时候也只是暴力法，完全没有考虑最优性，下次即便碰到一样的题目也很难从容再做出来，花了这么多精力和功夫最终只是平白感动自己。这段时间尝试使用五遍刷题后，能切切实实地感受到征服一道道题目的快乐，以及由此带来的某种踏实感。
<br>&emsp;其次，真正理解算法的本质尤为重要。比如递归，不要跳进递归去做傻傻的人肉递归，而是利用明确的定义来实现算法逻辑。任何一个算法，掌握其本质及其原理才能走得更远，不要为了做题而做题。
<br>&emsp;最后，尽快熟练掌握各种数据结构，包括其定义、用法及复杂度等。比如数组，掌握其存储和查找的效率和性能，能熟练使用一些动作来操作数组，比如数组怎么排序，怎么反转一个数组，双指针操作等，并且通过一些题目来巩固这些小技巧能让我们自如地应对更具挑战性的题目。
#### 五遍刷题法（调整）

&emsp;我根据自己的情况，对五遍刷题法做了些小调整：

- 第1遍

> ① 拿到一道新的题目后，花6分钟时间思考求解
<br>② 如果在时限内能够进行解答，并且解法具有较优的效率，则以此为准跳过第③步
<br>③ 翻看题解，寻找优质题解，理解其解法思路，然后按自己的编码习惯（代码规范、习惯命名、注释等）重写一遍该解法，并能正确提交
<br>④ 拿一张A4空白纸，在正面再手写一遍
<br>⑤ 体会、总结在此题上的新收获（如果有），编入自制脑图中
- 第2遍

> 一天后，再次编码并正确提交
- 第3遍

> 七天后
- 第4遍

> 一个月后
- 第5遍

> 三个月后，最后一次正确提交。在这之前通过脑图记忆
&emsp;同时，用一个表格记录自己的每日刷题路径，通过表格函数自动生成遍数对应的日期，最后通过日期标色的方式进行每日打卡。

#### 代码模板

##### 二叉树

```
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList();
    inorderTraversal(root,list);
    return list;
}
   //前序遍历
public void inorderTraversal(TreeNode root,List<Integer> list) {
    if(root == null){
        return ;
    }
    list.add(root.val);
    inorderTraversal(root.left,list);
    inorderTraversal(root.right,list);
}
       //中序遍历
public void inorderTraversal(TreeNode root,List<Integer> list) {
    if(root == null){
        return ;
    }
  
    inorderTraversal(root.left,list);
    list.add(root.val);
    inorderTraversal(root.right,list);
}
//后序遍历
public void inorderTraversal(TreeNode root,List<Integer> list) {
    if(root == null){
        return ;
    }
    inorderTraversal(root.left,list);
    list.add(root.val);
    inorderTraversal(root.right,list);
}
```

##### 递归

```
public void recur(int level, int param) {
    // terminator
    if(level > MAX_LEVEL) {
        // process result
        return;
    }
    
    // process current logic
    process(level, param);
    
    // drill down
    recur(level: level + 1, newParam);
    
    // restore current status
}
```

##### DFS-深度优先搜索

```
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root == null){
            return allResults;
        }
        travel(root, 0 ,allResults);
        return allResults;
    }
    
    private void travel(TreeNode root,int level,List<List<Integer>> results){
        if(results.size() == level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left != null){
            travel(root.left, level+1, results);
        }
        if(root.right != null){
            travel(root.right, level+1, results);
        }
    }
```


##### BFS-广度优先搜索

```
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if (root == null) {
            return allResults;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                results.add(node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            allResults.add(results);
        }
        return allResults;
    }
```


##### 二分查找

```
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return -1;
}
```


##### 并查集

```
class UnionFind {
    private int count = 0;
    private int[] parent;
    
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; 
        } 
        
    }
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p; 
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    } 
}
```


##### 启发式搜索

```
public class AStar
{
    public final static int BAR = 1; // 障碍值
    public final static int PATH = 2; // 路径
    public final static int DIRECT_VALUE = 10; // 横竖移动代价
    public final static int OBLIQUE_VALUE = 14; // 斜移动代价
    Queue<Node> openList = new PriorityQueue<Node>(); // 优先队列(升序)
    List<Node> closeList = new ArrayList<Node>();
    /**
     * 开始算法
     */
    public void start(MapInfo mapInfo)
    {
        if(mapInfo==null) return;
        // clean
        openList.clear();
        closeList.clear();
        // 开始搜索
        openList.add(mapInfo.start);
        moveNodes(mapInfo);
    }
    /**
     * 移动当前结点
     */
    private void moveNodes(MapInfo mapInfo)
    {
        while (!openList.isEmpty())
        {
            Node current = openList.poll();
            closeList.add(current);
            addNeighborNodeInOpen(mapInfo,current);
            if (isCoordInClose(mapInfo.end.coord))
            {
                drawPath(mapInfo.maps, mapInfo.end);
                break;
            }
        }
    }
    /**
     * 在二维数组中绘制路径
     */
    private void drawPath(int[][] maps, Node end)
    {
        if(end==null||maps==null) return;
        System.out.println("总代价：" + end.G);
        while (end != null)
        {
            Coord c = end.coord;
            maps[c.y][c.x] = PATH;
            end = end.parent;
        }
    }
    
    /**
     * 添加所有邻结点到open表
     */
    private void addNeighborNodeInOpen(MapInfo mapInfo,Node current)
    {
        int x = current.coord.x;
        int y = current.coord.y;
        // 左
        addNeighborNodeInOpen(mapInfo,current, x - 1, y, DIRECT_VALUE);
        // 上
        addNeighborNodeInOpen(mapInfo,current, x, y - 1, DIRECT_VALUE);
        // 右
        addNeighborNodeInOpen(mapInfo,current, x + 1, y, DIRECT_VALUE);
        // 下
        addNeighborNodeInOpen(mapInfo,current, x, y + 1, DIRECT_VALUE);
        // 左上
        addNeighborNodeInOpen(mapInfo,current, x - 1, y - 1, OBLIQUE_VALUE);
        // 右上
        addNeighborNodeInOpen(mapInfo,current, x + 1, y - 1, OBLIQUE_VALUE);
        // 右下
        addNeighborNodeInOpen(mapInfo,current, x + 1, y + 1, OBLIQUE_VALUE);
        // 左下
        addNeighborNodeInOpen(mapInfo,current, x - 1, y + 1, OBLIQUE_VALUE);
    }
    
    /**
     * 添加一个邻结点到open表
     */
    private void addNeighborNodeInOpen(MapInfo mapInfo,Node current, int x, int y, int value)
    {
        if (canAddNodeToOpen(mapInfo,x, y))
        {
            Node end=mapInfo.end;
            Coord coord = new Coord(x, y);
            int G = current.G + value; // 计算邻结点的G值
            Node child = findNodeInOpen(coord);
            if (child == null)
            {
                int H=calcH(end.coord,coord); // 计算H值
                if(isEndNode(end.coord,coord))
                {
                    child=end;
                    child.parent=current;
                    child.G=G;
                    child.H=H;
                }
                else
                {
                    child = new Node(coord, current, G, H);
                }
                openList.add(child);
            }
            else if (child.G > G)
            {
                child.G = G;
                child.parent = current;
                openList.add(child);
            }
        }
    }
    /**
     * 从Open列表中查找结点
     */
    private Node findNodeInOpen(Coord coord)
    {
        if (coord == null || openList.isEmpty()) return null;
        for (Node node : openList)
        {
            if (node.coord.equals(coord))
            {
                return node;
            }
        }
        return null;
    }
    
    /**
     * 计算H的估值：“曼哈顿”法，坐标分别取差值相加
     */
    private int calcH(Coord end,Coord coord)
    {
        return Math.abs(end.x - coord.x)
                + Math.abs(end.y - coord.y);
    }
    /**
     * 判断结点是否是最终结点
     */
    private boolean isEndNode(Coord end,Coord coord)
    {
        return coord != null && end.equals(coord);
    }
    
    /**
     * 判断结点能否放入Open列表
     */
    private boolean canAddNodeToOpen(MapInfo mapInfo,int x, int y)
    {
        // 是否在地图中
        if (x < 0 || x >= mapInfo.width || y < 0 || y >= mapInfo.hight) return false;
        // 判断是否是不可通过的结点
        if (mapInfo.maps[y][x] == BAR) return false;
        // 判断结点是否存在close表
        if (isCoordInClose(x, y)) return false;
        return true;
    }
    
    /**
     * 判断坐标是否在close表中
     */
    private boolean isCoordInClose(Coord coord)
    {
        return coord!=null&&isCoordInClose(coord.x, coord.y);
    }
    
    /**
     * 判断坐标是否在close表中
     */
    private boolean isCoordInClose(int x, int y)
    {
        if (closeList.isEmpty()) return false;
        for (Node node : closeList)
        {
            if (node.coord.x == x && node.coord.y == y)
            {
                return true;
            }
        }
        return false;
    }
}
```


##### LRU缓存

```
public class LRUCache {
    private Map<Integer, Integer> map;
    public LRUCache(int capacity) {
        map = new LinkedCappedHashMap<>(capacity);
    }
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        return map.get(key);
    }
    public void put(int key, int value) {
        map.put(key, value);
    }
    private static class LinkedCappedHashMap<K, V> extends LinkedHashMap<K, V> {
        int maximumCapacity;
        LinkedCappedHashMap(int maximumCapacity) {
            super(16, 0.75f, true);
            this.maximumCapacity = maximumCapacity;
        }
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > maximumCapacity;
        }
    }
}
```


##### 选择排序

```
    public int[] selectionSort(int[] arr) {
        int len = arr.length;
        int minIndex, temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                // 找到最小数，记录其索引
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 将当前最小数加入已排序末尾
            temp = arr[i]; arr[i] = arr[minIndex]; arr[minIndex] = temp;
        }
        return arr;
    }
```


##### 插入排序

```
    public int[] insertionSort(int[] arr) {
        int len = arr.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }
```


##### 冒泡排序

```
    public int[] bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                // 将较大元素冒泡
                if (arr[j] > arr[j+1]) {
                    // 元素交换
                    int temp = arr[j + 1]; arr[j + 1] = arr[j]; arr[j] = temp;
                }
            }
        }
        return arr;
    }
```


##### 快速排序

```
    public static int[] quickSort(int[] arr, int begin, int end) {
        if (end <= begin) return arr;
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
        return arr;
    }
    
    public static int partition(int[] a, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
        return counter;
    }
```


##### 归并排序

```
    public static int[] mergeSort(int[] arr, int left, int right) {
        if (right <= left) return arr;
        int mid = (left + right) >> 1; // (left + right) / 2
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        return merge(arr, left, mid, right);
    }
    public static int[] merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 中间数组
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
        // 也可以用 System.arraycopy(a, start1, b, start2, length)
        return arr;
    }
```


##### 堆排序

```
    public static int[] heapSort(int[] arr) {
        if (arr.length == 0) return arr;
        int length = arr.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, length, i);
        }
        for (int i = length - 1; i >= 0; i--) {
            int temp = arr[0]; arr[0] = arr[i]; arr[i] = temp;
            heapify(arr, i, 0);
        }
        return arr;
    }
    public static void heapify(int[] arr, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        if (left < length && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i]; arr[i] = arr[largest]; arr[largest] = temp;
            heapify(arr, length, largest);
        }
    }
```
