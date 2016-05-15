package com.chenliujin.hadoop.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.Text; 
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class AccessLogMapper extends Mapper<LongWritable, Text, NullWritable, Text> 
{
	/**
	 * @site http://www.chenliujin.com
	 * @author chenliujin <liujin.chen@qq.com>
	 * @since 2016-05-15
	 */
	public void map( LongWritable key, Text value, Context context ) throws IOException, InterruptedException
	{
		try {
			AccessLog access_log = AccessLog.parse(value.toString());

			context.write(NullWritable.get(), new Text(access_log.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
