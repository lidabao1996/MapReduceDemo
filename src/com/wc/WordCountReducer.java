package com.wc;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//ʵ��Reducer�Ĺ���
public class WordCountReducer extends
		Reducer<Text, IntWritable, Text, IntWritable> {

	protected void reduce(Text k3, Iterable<IntWritable> v3, Context context)
			throws java.io.IOException, InterruptedException {
		/**
		 * context��Reducer�������� ������Map ������HDFS
		 */
		int total = 0;
		for (IntWritable v : v3) {
			// ���
			total = total + v.get();
		}
			
		//��� k4 v4
		context.write(k3, new IntWritable(total));
	};

}
