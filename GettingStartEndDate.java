import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GettingStartEndDate{
	public void qsort(String[] list) {
//		super(list);
	    quicksort(list, 0, list.length-1);
	  }

	  public void quicksort(String[] list, int p, int r) {
	      
	    if (p < r) {
	      int q = partition(list,p,r);
	      if (q == r) {
		q--;
	      }
	      quicksort(list,p,q);
	      quicksort(list,q+1,r);
	    }
	  }

	  public int partition (String[] list, int p, int r) {
	    String pivot = list[p];
	    int lo = p;
	    int hi = r;
	    
	    while (true) {
	      while (list[hi].compareTo(pivot) >= 0 &&
		     lo < hi) {
		hi--;
	      }
	      while (list[lo].compareTo(pivot) < 0 &&
		     lo < hi) {
		lo++;
	      }
	      if (lo < hi) {
		String T = list[lo];
		list[lo] = list[hi];
		list[hi] = T;
	      }
	      else return hi;
	    }
	  }     
	    public static int binarySearch(String[] words, String value) {
	        return binarySearch(words, value, 0, words.length - 1);
	    }
	    
	    /**
	     * Searches an array of words for a given value using a recursive binary 
	     * search.  Returns the index that contains the value or -1 if the value 
	     * is not found.
	     * @param words
	     * @param value
	     * @return
	     */    
	    public static int binarySearch(String[] words, String value, int min, int max) {
	        if (min > max) {
	            return -1;
	        }
	        
	        int mid = (max + min) / 2;
	        
	        if (words[mid].equals(value)) {
	            return mid;
	        } else if(words[mid].compareTo(value) > 0) {
	            return binarySearch(words, value, min, mid - 1);
	        } else {
	            return binarySearch(words, value, mid + 1, max);
	        }
	    }
	    public int search(String array[],int n,String key){
	        qsort(array);
	        return  binarySearch(array,key);
	    }
	    public boolean isInt(String str){
	        if (str == null) {
	        return false;
	    }
	    int length = str.length();
	    if (length == 0) {
	        return false;
	    }
	    int i = 0;
	    if (str.charAt(0) == '-') {
	        if (length == 1) {
	            return false;
	        }
	        i = 1;
	    }
	    for (; i < length; i++) {
	        char c = str.charAt(i);
	        if (c < '0' || c > '9') {
	            return false;
	        }
	    }
	    return true;
	    }
	    
	    //string output needed in dd-mm-yyyy format
	    public void find_date()
	    {
	        HashMap<String, Integer> hm = new HashMap<String, Integer>();
	        String arr[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept",
	                      "Oct","Nov","Dec","January","February","March","April",
	                      "May",
	                      "June","July","August","September","October","November","December"};
	        String arr1[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept",
	                      "Oct","Nov","Dec","January","February","March","April",
	                      "May",
	                      "June","July","August","September","October","November","December"};
	        BufferedReader br = null;
	        try {
	            String sCurrentLine;
	            br = new BufferedReader(new FileReader("C:\\Users\\Kandikunnta Achuth\\Desktop\\NLP\\myfile.txt"));
	            //sCurrentLine = br.readLine();
	            int count =0;
	            String temp="";
	            
	            while ((sCurrentLine = br.readLine()) != null) {
	                temp+=sCurrentLine;
	            }
	            StringTokenizer tok = new StringTokenizer(temp, ",!?:. ");
	            String prevprev = "";
	            String prev = "";
	            String l = "";
	            int move = 1;
	            while(tok.hasMoreTokens()){
	                
	                if(move == 1){
	                prevprev = prev;
	                prev = l;
	                l=tok.nextToken();
	                }else{
	                    move = 1;
	                }
	                
	                if(l!=""){
	                    StringTokenizer tok1 = new StringTokenizer(l, "-");
	                    //System.out.println(l);
	                    if(tok1.countTokens() == 3){
	                        String first = tok1.nextToken();
	                        String second = tok1.nextToken();
	                        String third = tok1.nextToken();
	                        if(isInt(first) && isInt(second) && isInt(third)){
	                            count++;
	                            System.out.println(l);
	                            if(hm.containsKey(l)){
	                                int x = hm.get(l);
	                                hm.remove(l);
	                                x+=1;
	                                hm.put(l, x);
	                            }else{
	                                hm.put(l, 1);
	                            }
	                            continue;
	                        }
	                    }
	                    StringTokenizer tok2 = new StringTokenizer(l, "/");
	                    if(tok2.countTokens() == 3){
	                        String first = tok2.nextToken();
	                        String second = tok2.nextToken();
	                        String third = tok2.nextToken();
	                        if(isInt(first) && isInt(second) && isInt(third)){
	                            count++;
	                            if(hm.containsKey(l)){
	                                int x = hm.get(l);
	                                hm.remove(l);
	                                x+=1;
	                                hm.put(l, x);
	                            }else{
	                                hm.put(l, 1);
	                            }
	                            System.out.println(l);
	                            continue;
	                        }
	                    }
	                }
	                int isDate = search(arr,24,l);
	                if(isDate != -1){
	                    //System.out.println(l);
	                    int dateToIn = 0;
	                    boolean found = true;
	                    for(int i = 0;i<24 ;i++){
	                        if(found == true){
	                            
	                        }else{
	                            break;
	                        }
	                        if(l.equals(arr1[i])){
	                            found = false;
	                            dateToIn = i%12;
	                            dateToIn+=1;
	                        }
	                    }
	                    String dateToInt = "";
	                    if(dateToIn<10){
	                        dateToInt="0"+dateToIn;
	                    }else{
	                        dateToInt=""+dateToIn;
	                    }
	                    //System.out.println(dateToIn);
	                    if(prevprev != "" && prev != ""){
	                        String next = "";
	                        if(isInt(prev)){
	                            if(isInt(prevprev)){
	                                count++;
	                                String dummy = "";
	                                if(prev.length()<3){
	                                    String hacve = prev;
	                                    prev = prevprev;
	                                    prevprev= hacve;
	                                }
	                                dummy =dummy +prev+"-"+dateToInt+"-"+prevprev;
	                                System.out.println(dummy);
	                                if(hm.containsKey(dummy)){
	                                int x = hm.get(dummy);
	                                hm.remove(dummy);
	                                x+=1;
	                                hm.put(dummy, x);
	                            }else{
	                                hm.put(dummy, 1);
	                            }
	                            }else{
	                                next = tok.nextToken();
	                                prevprev = prev;
	                                prev = l;
	                                l = next;               
	                                if(isInt(next)){
	                                    count++;
	                                    String dummy = "";
	                                    
	                                if(l.length()<3){
	                                    String hacve = l;
	                                    l = prevprev;
	                                    prevprev = hacve;
	                                }
	                                dummy =dummy+l+"-" +dateToInt+"-"+prevprev;
	                                System.out.println(dummy);
	                                if(hm.containsKey(dummy)){
	                                int x = hm.get(dummy);
	                                hm.remove(dummy);
	                                x+=1;
	                                hm.put(dummy, x);
	                            }else{
	                                hm.put(dummy, 1);
	                            }
	                                }
	                            }
	                        }else{
	                            if(next == ""){
	                                next = tok.nextToken();
	                                prevprev = prev;
	                                prev = l;
	                                l = next;
	                            }
	                                if(isInt(next)){
	                                    String nextnext = tok.nextToken();
	                                    prevprev = prev;
	                                    prev = l;
	                                    l = nextnext;
	                                    //l=tok.nextToken();
	                                    if(isInt(nextnext)){
	                                        count++;
	                                        String dummy = "";
	                                        
	                                if(next.length()<3){
	                                    String hacve = next;
	                                    next = nextnext;
	                                    nextnext = hacve;
	                                }
	                                dummy =dummy +next+"-"+dateToInt+"-"+nextnext;
	                                System.out.println(dummy);
	                                if(hm.containsKey(dummy)){
	                                int x = hm.get(dummy);
	                                hm.remove(dummy);
	                                x+=1;
	                                hm.put(dummy, x);
	                            }else{
	                                hm.put(dummy, 1);
	                            }
	                                    }else{
	                                        move = 0;
	                                    }
	                                }
	                        }
	                    }
	                }
	            }
	            System.out.println(count);
	             Set set = hm.entrySet();
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	         Map.Entry mentry = (Map.Entry)iterator.next();
	         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
	         System.out.println(mentry.getValue());
	      }
	      
	      Comparator<String> comparator = new Comparator<String>() {
	    	  public int compare(String o1, String o2) {
	    		  StringTokenizer tok3 = new StringTokenizer(o1, "-");
	    		  int year1 = Integer.parseInt(tok3.nextToken());
	    		  int month1 = Integer.parseInt(tok3.nextToken());
	    		  int day1 = Integer.parseInt(tok3.nextToken());
	    		  StringTokenizer tok4 = new StringTokenizer(o2, "-");
	    		  int year2 = Integer.parseInt(tok4.nextToken());
	    		  int month2 = Integer.parseInt(tok4.nextToken());
	    		  int day2 = Integer.parseInt(tok4.nextToken());
	    		  if(year1<year2){
	    			  return 1;
	    		  }
	    		  if(year1>year2){
	    			  return -1;
	    		  }
	    		  if(month1<month2){
	    			  return 1;
	    		  }
	    		  if(month1>month2){
	    			  return -1;
	    		  }
	    		  if(day1<day2){
	    			  return 1;
	    		  }
	    		  if(day1>day2){
	    			  return -1;
	    		  }
	    		  return 1;
	    		  
	    	  }
	    	};
	      
	    	SortedSet<String> keys = new TreeSet<String>(comparator);
	    	keys.addAll(hm.keySet());
	    	Iterator it = keys.iterator();
	    	Object element = it.next();
            System.out.println("End Date is " +element.toString());
            
	    	while (it.hasNext()) {
	            // Get element
	             element = it.next();
	            
	         }
	    	System.out.println("Start Date is "+ element.toString());
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        } 
	    }
//	    public String date_changer(String date){
//	        String dd,mm,yy;
//	        
////	        if(date == )
////	        {
////	            
////	        }
//	    }
	public static void main(String[] args) {
		GettingStartEndDate k = new GettingStartEndDate();
		k.find_date();
	}
}