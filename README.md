# LibertCache

#### 1. 介绍

一种限制容量、基于`HashMap`的内存缓存实现。可用于Web项目中对最近访问过的热数据进行缓存，缓存总条数可设置（比如设为20万）。

#### 2. 缓存淘汰机制：

1. 先加入哈希表的数据先淘汰
2. 命中的数据如果在淘汰区（前1/4），则交换到最新的位置
3. 命中的数据如果在保留区（后3/4），则不作处理
#### 3. 性能测试

通过`JMH`测试其性能，与一般的`LimitHashTable`实现进行对比：

```bash
Benchmark                Mode  Cnt   Score   Error  Units
TestLibertCache.hitAll  thrpt   15  45.992 ± 1.634  ops/s --LibertCache
TestLibertCache.hitAll  thrpt   15  14.444 ± 0.414  ops/s --LimitHashTable
```

在并发数更高、缓存总容量更大的情况下，`LibertCache`表现得更好。