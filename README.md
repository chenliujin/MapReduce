# MapReduce

## InputFormat 类

## Mapper 类

---

## Combiner 类

### Hive

map 端聚合:

```
hive.map.aggr = true
```

---

## Partitioner 类

### 1. 作用

* 负载均衡，尽量的将工作均匀的分配给不同的 reduce；

---

## Reducer 类

### reduce 的个数

```
job.setNumReduceTasks(3);
```

---

## OutPutFormat 类

# Example

```
public static void main(String[] args) throws IOException {
  Configuration conf = new Configuration();
  Job job = new Job(conf);
  job.setInputFormatClass(TextInputFormat.class);
  job.setMapperClass(Mapper.class);
  job.setCombinerClass(null);
  job.setPartitionerClass(HashPartitioner.class);
  job.setReducerClass(Reducer.class);
  job.setOutputFormatClass(TextOutFormat.class);
}
```
