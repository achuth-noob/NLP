
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


public class SearchFile {
	
	public static void main(String[] args) throws Exception 
	{
		// String indexPath = "/home/jayendra/categoryExtract/YagoTransitiveIndex";
		String indexPath = "/home/jayendra/Desktop/Headline_Time/indexDoc";
	    String field = "contents";
	    String queries = null;
	    int repeat = 1;
	    boolean raw = false;
	    String queryString = null;
	    int hitsPerPage = 10;
	    
	    IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(indexPath)));
	    IndexSearcher searcher = new IndexSearcher(reader);
	    Analyzer analyzer = new StandardAnalyzer();
	    
	    BufferedReader in = null;
	    in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
	    
	    QueryParser parser = new QueryParser(field, analyzer);
	    while (true) 
	    {
	    	if (queryString == null) 
	    	{                        // prompt the user
	    		System.out.println("Enter query: ");
	    	}
	    	
	    	String line = queryString != null ? queryString : in.readLine();
	    	
	    	if (line == null || line.length() == -1) 
	    	{
	    		break;
	    	}

	    	line = line.trim();
	    	if(line.length() == 0)
	    		break;
	    		    	
	    	Query query = parser.parse(line);
	    	System.out.println("Searching for: " + query.toString(field));
	    	
	    	TopDocs results = searcher.search(query, 5 * hitsPerPage);
	    	ScoreDoc[] hits = results.scoreDocs;
	    	int numTotalHits = results.totalHits;
	    	System.out.println(numTotalHits + " total matching documents");	    	    	
	    	
	    	if(numTotalHits == 0)
	    		continue;
	    	
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
	    	
	    }
		
	}

}
