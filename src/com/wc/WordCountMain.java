package com.wc;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * ������
 * @author lifang
 *
 */
public class WordCountMain {
	public static void main(String[] args) {
		
		try {
			//1������һ������
			Job job = Job.getInstance(new Configuration());
			//�������
			job.setJarByClass(WordCountMain.class);
			//2ָ�������map��map�������������
			job.setMapperClass(WordCountMapper.class);
			job.setMapOutputKeyClass(Text.class);//k2����������
			job.setMapOutputValueClass(IntWritable.class);//v2������
			
			//3��ָ�������reduce��reduce�����������
			job.setReducerClass(WordCountReducer.class);
			job.setOutputKeyClass(Text.class);//k4������
			job.setOutputValueClass(IntWritable.class);//v4������
			
			//4��ָ�����������·������������·��
			FileInputFormat.setInputPaths(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[1]));
			
			//5��ִ������
			job.waitForCompletion(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
