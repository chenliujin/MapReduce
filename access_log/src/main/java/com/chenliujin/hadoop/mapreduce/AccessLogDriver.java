package com.chenliujin.hadoop.mapreduce;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class AccessLogDriver extends Configured implements Tool
{
	/**
	 * @site http://www.chenliujin.com
	 * @author chenliujin <liujin.chen@qq.com>
	 * @since 2016-05-15
	 */
	public int run( String[] args ) throws Exception
	{
		if ( args.length != 2 ) {
			System.err.printf( "Usage: %s <input> <output>", getClass().getSimpleName() );
			ToolRunner.printGenericCommandUsage( System.err );
			return -1;
		}

		Job job = new Job( getConf() );

		job.setJobName("AccessLog");
		job.setJarByClass( getClass() );

		FileInputFormat.addInputPath( job, new Path(args[0]) );
		FileOutputFormat.setOutputPath( job, new Path(args[1]) );

		job.setMapperClass(AccessLogMapper.class);
		job.setNumReduceTasks(0);
		job.setOutputKeyClass(NullWritable.class);
		job.setOutputValueClass(Text.class);

		return job.waitForCompletion(true) ? 0 : 1;
	}

	/**
	 * @site http://www.chenliujin.com
	 * @author chenliujin <liujin.chen@qq.com>
	 * @since 2016-05-15
	 */
	static public void main( String[] args ) throws Exception
	{
		int exitcode = ToolRunner.run( new AccessLogDriver(), args );

		System.exit( exitcode );
	}
}
