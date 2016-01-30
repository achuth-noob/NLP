
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

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
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.apache.lucene.store.FSDirectory;

public class DocIndex {	 

	@SuppressWarnings("deprecation")
	public static void main(String[] arg) throws IOException, ParseException
	{
		Date start = new Date();
		
		String indexPath = "/home/jayendra/Desktop/Headline_Time/indexDoc";
		String docsPath = "/home/jayendra/Desktop/Headline_Time/document";
		final Path docDir = Paths.get(docsPath);
		
		Directory dir = FSDirectory.open(Paths.get(indexPath));
		Analyzer analyzer = new StandardAnalyzer();
	    IndexWriterConfig config = new IndexWriterConfig(analyzer);
	    
	    config.setOpenMode(OpenMode.CREATE_OR_APPEND);	    
	    config.setRAMBufferSizeMB(256.0);
	    
	    IndexWriter writer = new IndexWriter(dir, config);
	    indexDocs(writer, docDir);
	    
	    writer.close();
	    
	    Date end = new Date();
	    System.out.println(end.getTime() - start.getTime() + " total milliseconds");
	}
	
	
	static void indexDocs(final IndexWriter writer, Path path) throws IOException 
	{
		if (Files.isDirectory(path)) 
		{
			Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException 
				{	
					try {
						indexDoc(writer, file, attrs.lastModifiedTime().toMillis());
					}
					catch (IOException ignore) {
						
					}
					return FileVisitResult.CONTINUE;
				}
			});
		}
		else
		{
			indexDoc(writer, path, Files.getLastModifiedTime(path).toMillis());
		}
	}
	
	static void indexDoc(IndexWriter writer, Path file, long lastModified) throws IOException 
	{
		System.out.println("Indexing Start ... " + file.toString());
		
		try (InputStream stream = Files.newInputStream(file)) 
		{			
			BufferedReader br1 = null;  					  		
	  		br1 = new BufferedReader(new BufferedReader(new InputStreamReader(stream,StandardCharsets.UTF_8)));
	  		
	  		String s = "";
			while ((s = br1.readLine()) != null) 
			{
				s = s.trim();								
				String[] s_spl = s.split(" <<!>> ");
				
				// System.out.println(s);
				
				if(s.length() > 0 && s_spl.length == 3)
				{					
					String s1 = s_spl[0].trim();
					String s2 = s_spl[1];
					String[] s3 = s2.split(" ");
					String s4 = "";
					if(s3.length > 1)
						s4 = s3[0];
					
					if(s4.contains("-"))
					{
						// System.out.println(s1 + " --- " + s4);
						Document doc = new Document();				
						// path is the value and contents are the key. 
						Field pathField = new StringField("path", s4, Field.Store.YES);					
						Field contentField = new TextField("contents", s1, Field.Store.YES);
						doc.add(pathField);
						doc.add(contentField);
						writer.addDocument(doc);
					}		
					
				}
			}
			
			br1.close();
		}
		catch(Exception ex)
		{			
		}
		System.out.println("Indexing Done ... " + file.toString());	
	}	
}

