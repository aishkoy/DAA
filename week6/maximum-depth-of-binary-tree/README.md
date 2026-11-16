Maximum Depth of Binary Tree

1. Problem
Дан корень бинарного дерева. Нужно найти максимальную глубину - число узлов на самом длинном пути от корня до листа.

2. Approach
1) Если root == null, глубина 0.
2) Иначе рекурсивно считаем глубину левого и правого поддерева.
3) Возвращаем max(left, right) + 1, где +1 - это сам узел.

Tracing
root = [3, 9, 20, null, null, 15, 7]
maxDepth(9) = max(0, 0) + 1 = 1.
maxDepth(15) = 1, maxDepth(7) = 1, maxDepth(20) = max(1, 1) + 1 = 2.
maxDepth(3) = max(1, 2) + 1 = 3.

Challenges
Глубина считается в узлах, а не в рёбрах, поэтому у дерева из одного узла глубина 1.

3. Time Complexity
Time Complexity: O(n)

Нужно посетить все узлы.

4. Space Complexity
Space Complexity: O(h), где h - высота дерева

Только стек рекурсии.

5. Reflection / Improvement
По времени это оптимально. Рекурсию можно заменить обходом в ширину с очередью и считать количество уровней.
