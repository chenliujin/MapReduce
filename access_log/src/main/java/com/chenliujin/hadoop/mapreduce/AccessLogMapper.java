package com.chenliujin.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.Text; 
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class AccessLogMapper extends Mapper<LongWritable, Text, Text, IntWritable> 
{
	/**
	 * @site http://www.chenliujin.com
	 * @author chenliujin <liujin.chen@qq.com>
	 * @since 2016-05-15
	 */
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedExctption
	{
		AccessLog access_log = AccessLog.parse(value.toString());

	}
}
