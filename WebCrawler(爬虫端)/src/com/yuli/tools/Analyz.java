package com.yuli.tools;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class Analyz {
	public static List<String> fenci(String str) throws IOException{
//		String text="我在用hadoop2.0,有个问题？"; 
        List<String> alist = new ArrayList<String>();
        //创建分词对象  
        Analyzer anal=new IKAnalyzer(true);       
        StringReader reader=new StringReader(str);  
        //分词  
        TokenStream ts=anal.tokenStream("", reader);  
        CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);  
        //遍历分词数据  
        while(ts.incrementToken()){  
//            System.out.print(term.toString()+"|");  
        	alist.add(term.toString());
        }  
//        for(String x :alist) {
//        	System.out.println(x);
//        }
        reader.close();  
        return alist;
	}
}
