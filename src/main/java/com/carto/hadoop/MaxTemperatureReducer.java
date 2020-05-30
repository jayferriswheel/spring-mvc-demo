//package com.carto.hadoop;
//
//import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.Text;
//import org.apache.hadoop.mapreduce.Reducer;
//
//import java.io.IOException;
//
//public class MaxTemperatureReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
//
//    @Override
//    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
//        int maxValue = Integer.MIN_VALUE;
//        for (IntWritable value : values) {
//            maxValue = Math.max(maxValue, value.get());
//        }
//        // 这里因为取最高温度的，所以他不需要保留每一个值，只需要保留最大值即可
//        context.write(key, new IntWritable(maxValue));
//    }
//
//}
