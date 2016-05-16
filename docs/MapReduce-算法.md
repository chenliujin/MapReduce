## 计数（WordCount）/求和/最大值
* Mapper
```
public static class WordCountMapper(LongWritable key, Text value, Context context) extends Mapper<LongWritable, Text, Text, IntWritable>
{
  context.write(key, 1);
}
```
* Reducer
```
static public class WordCountReducer(Text key, IntWritable value, Context context) extends Reducer<Text, IntWritable, Text, IntWritable>
{
  for (IntWritable num : value) {
    result = SUM() | COUNT() | Maths.MAX();
  }

  context.write(key, result);
}
```
* 缺陷：Mapper 发送大量虚假计数，可以先在 Mapper 中进行 Combiner，然后发送到 Reducer 中

## 去重

## 排序

## TopK

## 连接


## 参考文献
* [Hadoop学习笔记—8.Combiner与自定义Combiner](http://www.cnblogs.com/edisonchou/p/4297786.html)
* [Hadoop源码详解之一MapReduce篇之InputFormat](http://www.cnblogs.com/shitouer/archive/2013/02/28/hadoop-source-code-analyse-mapreduce-inputformat.html)
* [快速构建基于大数据的精准推荐系统](http://www.oracle.com/technetwork/cn/community/developer-day/3-recommended-system-2177876-zhs.pdf)
* [程序员如何准备面试中的算法](https://wizardforcel.gitbooks.io/the-art-of-programming-by-july/content/00.01.html)
* [详解MapReduce的模式、算法和用例](http://www.searchbi.com.cn/showcontent_70465.htm)
* [Hadoop学习笔记—12.MapReduce中的常见算法](http://www.cnblogs.com/edisonchou/p/4299950.html)
