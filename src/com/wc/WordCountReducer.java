package com.wc;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//实现Reducer的功能
public class WordCountReducer extends
		Reducer<Text, IntWritable, Text, IntWritable> {

	protected void reduce(Text k3, Iterable<IntWritable> v3, Context context)
			throws java.io.IOException, InterruptedException {
		/**
		 * context是Reducer的上下文 上文是Map 下文是HDFS
		 */
		int total = 0;
		for (IntWritable v : v3) {
			// 求和
			total = total + v.get();
		}
			
		//输出 k4 v4
		context.write(k3, new IntWritable(total));
	};

}
