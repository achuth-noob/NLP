
import java.awt.BorderLayout;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.apache.lucene.store.FSDirectory;


public class Time_Period {
    
        public static List<String> getTimePeriod(HashMap<String, Integer> value_type)
        {
            int  mean1 = 0;
            int size = 0;
            Set set = value_type.entrySet();
             Iterator iterator = set.iterator();
            while(iterator.hasNext()) {
             Map.Entry mentry = (Map.Entry)iterator.next();
             int x = (int)mentry.getValue();
             mean1=mean1+x;
             size++;
             }
            
            int ans = ((mean1)/size);
            //System.out.println("ans is "+ans);
            iterator = set.iterator();
            while(iterator.hasNext()) {
             Map.Entry mentry = (Map.Entry)iterator.next();
             int x = (int)mentry.getValue();
                //System.out.println("Before updating value is "+x);
             if(x<(ans)){
                 x = 0;
             }else{
                 x = 1;
             }
             mentry.setValue(x);
             //System.out.println("After updating value is "+mentry.getValue());
             }
            iterator = set.iterator();
            while(iterator.hasNext()) {
             Map.Entry mentry = (Map.Entry)iterator.next();
             System.out.println(mentry.getValue());
             }
            String timeStart = "";
            String timeStop = "";
            
            List<String>  tt = new ArrayList<String>();    	
	    	
	    	
	    	
	    	for(Entry<String, Integer> entry:value_type.entrySet())
			{
	    		tt.add(entry.getKey());
	            // System.out.println(entry.getKey()+" " + entry.getValue());
			}
	    	Collections.sort(tt);
	    	int sizeTimePeriod = 0;
                List<String>  listTimePeriod = new ArrayList<String>(); 
	    	for(String s:tt)
	    	{
//	    		System.out.println(s + " " + value_type.get(s));
                    if(value_type.get(s) == 1){
                        if(timeStart == ""){
                            timeStart = s;
                            timeStop = timeStart;
                        }else{
                            timeStop = s;
                        }
                    }else{
                        if(timeStop == ""){
                        
                        }else{
                            sizeTimePeriod++;
                            String dummy = timeStart+"<<>>"+timeStop;
                            listTimePeriod.add(dummy);
                        System.out.print("Period Starting at "+timeStart);
                        System.out.print(" Period ending at "+timeStop);
                        System.out.println("");
                        timeStart = timeStop ="";
                        }
                    }
	    	}
                if(timeStop == ""){
                        
                    }else{
                            sizeTimePeriod++;
                            String dummy = timeStart+"<<>>"+timeStop;
                            listTimePeriod.add(dummy);
                        System.out.print("Period Starting at "+timeStart);
                        System.out.print(" Period ending at "+timeStop);
                        System.out.println("");
                    }
                return listTimePeriod;
            /*if(timeStop == ""){
                        
                    }else{
                        System.out.print("Period Starting at "+timeStart);
                        System.out.print(" Period ending at "+timeStop);
                        System.out.println("");
                    }*/
        }
	
	public static void main(String[] args) throws Exception 
	{
		// String indexPath = "/home/jayendra/categoryExtract/YagoTransitiveIndex";
            String indexPath = "C:/Users/Kandikunnta Achuth/Desktop/NLP/Achuth/Headline_Time/indexDoc";
	    String field = "contents";
	    String queries = null;
	    int repeat = 1;
	    boolean raw = false;
	    String queryString = null;
	    int hitsPerPage = 10;
	    System.out.println("Executed ");
	    IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(indexPath)));
	    IndexSearcher searcher = new IndexSearcher(reader);
	    Analyzer analyzer = new StandardAnalyzer();
	    
	    BufferedReader in = null;
	    in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
	    
	    QueryParser parser = new QueryParser(field, analyzer);
            List<String> firstList = new ArrayList<String>();
            List<String> secondList = new ArrayList<String>();
	    	if (queryString == null) 
	    	{                        // prompt the user
	    		System.out.println("Enter query1: ");
	    	}
	    	
	    	String line = queryString != null ? queryString : in.readLine();
	    	
	    	

	    	line = line.trim();
	    	
	    		    	
	    	Query query = parser.parse(line);
                String printFirstWord = query.toString(field);
	    	System.out.println("Searching for: " + query.toString(field));
	    	
	    	TopDocs results = searcher.search(query, 5 * hitsPerPage);
	    	ScoreDoc[] hits = results.scoreDocs;
	    	int numTotalHits = results.totalHits;
	    	System.out.println(numTotalHits + " total matching documents");	    	    	
	    	
	    	
	    	hits = searcher.search(query, numTotalHits).scoreDocs;
	    	HashMap<String, Integer> value_type = new HashMap<String, Integer>();
	    	
	    	int month=0;
	    	
	    	for(int j=0;j<hits.length;j++) 
	    	{    			    		
	    		Document doc = searcher.doc(hits[j].doc);
	    		if(doc != null)
	    		{
	    			// System.out.print("doc="+hits[j].doc+" score="+hits[j].score + " ");
		    		String headline_p = doc.get("path");
		    		String headline = doc.get("contents");
		    		// System.out.println(" " + (j+1) + ". " + headline + " : " + headline_p);
		    		// System.out.println(headline_p);
		    		
		    		if(month == 0)
		    			headline_p = headline_p.substring(0, headline_p.lastIndexOf("-"));
		    		
		    		if (!value_type.containsKey(headline_p))
    				{
    					value_type.put(headline_p, 1);
    				}
		    		else
		    		{
		    			int fre_q = value_type.get(headline_p)+1;
		    			value_type.put(headline_p, fre_q);
		    		}		    		
	    		}
	    	}
	    	
	    	
	    	List<String>  tt = new ArrayList<String>();    	
	    	
	    	
	    	
	    	for(Entry<String, Integer> entry:value_type.entrySet())
			{
	    		tt.add(entry.getKey());
	            // System.out.println(entry.getKey()+" " + entry.getValue());
			}
	    	Collections.sort(tt);
	    	
	    	for(String s:tt)
	    	{
	    		System.out.println(s + " " + value_type.get(s));
	    	}
	    	for(String s:tt)
	    	{
	    		System.out.println(value_type.get(s));
                        
	    	}
                //getTimePeriod(value_type);
                firstList = getTimePeriod(value_type);
            String queryString1 = null;
            while (true) 
	    {
	    	if (queryString1 == null) 
	    	{                        // prompt the user
	    		System.out.println("Enter query2: ");
	    	}
	    	
                line = queryString1 != null ? queryString1 : in.readLine();
	    	
	    	if (line == null || line.length() == -1) 
	    	{
	    		break;
	    	}

	    	line = line.trim();
	    	if(line.length() == 0)
	    		break;
	    		    	
	    	query = parser.parse(line);
                String printSecondWord = query.toString(field);
	    	System.out.println("Searching for: " + query.toString(field));
	    	
	    	results = searcher.search(query, 5 * hitsPerPage);
	    	hits = results.scoreDocs;
	    	numTotalHits = results.totalHits;
	    	System.out.println(numTotalHits + " total matching documents");	    	    	
	    	
	    	if(numTotalHits == 0)
	    		continue;
	    	
	    	hits = searcher.search(query, numTotalHits).scoreDocs;
	    	value_type = new HashMap<String, Integer>();
	    	
	    	month=0;
	    	
	    	for(int j=0;j<hits.length;j++) 
	    	{    			    		
	    		Document doc = searcher.doc(hits[j].doc);
	    		if(doc != null)
	    		{
	    			// System.out.print("doc="+hits[j].doc+" score="+hits[j].score + " ");
		    		String headline_p = doc.get("path");
		    		String headline = doc.get("contents");
		    		// System.out.println(" " + (j+1) + ". " + headline + " : " + headline_p);
		    		// System.out.println(headline_p);
		    		
		    		if(month == 0)
		    			headline_p = headline_p.substring(0, headline_p.lastIndexOf("-"));
		    		
		    		if (!value_type.containsKey(headline_p))
    				{
    					value_type.put(headline_p, 1);
    				}
		    		else
		    		{
		    			int fre_q = value_type.get(headline_p)+1;
		    			value_type.put(headline_p, fre_q);
		    		}		    		
	    		}
	    	}
	    	
	    	
	    	tt = new ArrayList<String>();    	
	    	
	    	
	    	
	    	for(Entry<String, Integer> entry:value_type.entrySet())
			{
	    		tt.add(entry.getKey());
	            // System.out.println(entry.getKey()+" " + entry.getValue());
			}
	    	Collections.sort(tt);
	    	
	    	for(String s:tt)
	    	{
	    		System.out.println(s + " " + value_type.get(s));
	    	}
	    	for(String s:tt)
	    	{
	    		System.out.println(value_type.get(s));
                        
	    	}
                //getTimePeriod(value_type);
                secondList = getTimePeriod(value_type);
                
                
                ///// Pasting here
                String secondString = secondList.get(0);
            String[] arr = secondString.split("<<>>");
            String secondStart = arr[0];
            boolean emerged = false;
            for(int i = 0;i<firstList.size() && emerged == false;i++){
                String firstString = firstList.get(i);
                String[] arr1 = firstString.split("<<>>");
                String firstStart = arr1[0];
                String firstEnd = arr1[1];
                System.out.println("First STart is "+firstStart+" First end is "+firstEnd+"Second start is "+secondStart);
                System.out.println(firstStart.compareTo(secondStart)+" "+secondStart.compareTo(firstEnd));
                if(firstStart.compareTo(secondStart)<=0 && secondStart.compareTo(firstEnd)<=0){
                    emerged = true;
                }
            }
            
            if(emerged == true){
                line = "";
                if(printFirstWord.charAt(0) == '+'){
                    line = printFirstWord;
                }else{
                    line = "+"+printFirstWord;
                }
                line = line+" ";
                if(printSecondWord.charAt(0) == '+'){
                    line = printSecondWord;
                }else{
                    line = "+"+printSecondWord;
                }
	    	//line = "+"+printFirstWord+" +"+printSecondWord;
                System.out.println("Line is "+line);
	    	
	    	if (line == null || line.length() == -1) 
	    	{
	    		break;
	    	}

	    	line = line.trim();
	    	if(line.length() == 0)
	    		break;
	    		    	
	    	query = parser.parse(line);
	    	System.out.println("Searching for: " + query.toString(field));
	    	
	    	results = searcher.search(query, 5 * hitsPerPage);
	    	hits = results.scoreDocs;
	    	numTotalHits = results.totalHits;
	    	System.out.println(numTotalHits + " total matching documents");	    	    	
	    	
	    	if(numTotalHits == 0){
                    emerged = false;
                }
            }
            
            if(emerged == true){
                System.out.println("Yes "+printSecondWord+" emerged in "+printFirstWord);
            }else{
                System.out.println("No "+printSecondWord+" not emerged in "+printFirstWord);
            }
                
	    }
            
        }
}
