/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyphraseBasedCaseStudy;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.stanford.nlp.util.ArraySet;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Keyword_date_mapper
{       
    
    public void qsort(String[] list) {
//	super(list);
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
    public boolean isInt(String str)
    {
        if (str == null) 
        {
            return false;
        }
        int length = str.length();
        if (length == 0) 
        {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') 
        {
            if (length == 1) 
            {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) 
        {
            char c = str.charAt(i);
            if (c < '0' || c > '9') 
            {
                return false;
            }
        }
        return true;
    }
    
    //string output needed in dd-mm-yyyy format
    public List<String> find_date()
    {
        List<String> dates=new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        String arr[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept",
                      "Oct","Nov","Dec","January","February","March","April",
                      "May","June","July","August","September","October","November","December"};
        String arr1[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept",
                      "Oct","Nov","Dec","January","February","March","April",
                      "May","June","July","August","September","October","November","December"};
        BufferedReader br = null;
        String sCurrentLine = "";
        
        try 
        {
            
            br = new BufferedReader(new FileReader("/home/jain/Data/Articles/bihar-election/ALL/News"));//"C:\\Users\\Kandikunnta Achuth\\Desktop\\NLP\\myfile.txt"));
            //sCurrentLine = br.readLine();
            int count =0;
            String temp="";
            
            while ((sCurrentLine = br.readLine()) != null) 
            {
            
                try
                {
            
            temp = sCurrentLine;
            // System.out.println(" " + temp);
                
            
            // System.out.println("Done");
            
            StringTokenizer tok = new StringTokenizer(temp, ",!?:. ");
            String prevprev = "";
            String prev = "";
            String l = "";
            int move = 1;
                while(tok.hasMoreTokens())
                {
                    if(move == 1)
                    {
                        prevprev = prev;
                        prev = l;
                        l=tok.nextToken();

                        if(l.matches("^([a-zA-Z]*)([0-9]{4}|[0-9]{2})[./-]([0]?[1-9]|[1][0-2])[./-]([0]?[1-9]|[1|2][0-9]|[3][0|1])(>*)$"))
                            System.out.println("YES: "+l);

                        l=l.replace("html", "");    
                        if(l.contains("T"))    
                            l=l.substring(0, l.indexOf("T"));

    //                    if(l.matches("[a-zA-Z ]*\\d+.*"))
    //                        System.out.print("L: "+l);
    //                    ^(.*)([0-9]{4}|[0-9]{2})[./-]([0]?[1-9]|[1][0-2])[./-]([0]?[1-9]|[1|2][0-9]|[3][0|1])(>*)$
                    }
                    else
                    {
                        move = 1;
                    }

    //                System.out.print("T: "+l);
                    if(l!="")
                    {
                        l=l.replace("html", "");    
                        if(l.contains("T"))    
                            l=l.substring(0, l.indexOf("T"));

                        if(l.contains("_"))
                            l=l.replaceAll("_", "");
                        if(l.contains("="))
                            l=l.replaceAll("=", "");
                        if(l.contains("&"))
                            l=l.replaceAll("&", "");


    //                    if(l.matches("^([a-zA-Z]*[=]*[a-zA-Z]*[&]*[a-zA-Z]*)([0-9]{4}|[0-9]{2})[./-]([0]?[1-9]|[1][0-2])[./-]([0]?[1-9]|[1|2][0-9]|[3][0|1])(>*)$"))
    //                    {
    //                        System.out.print("YES: "+l);
    //                        l=l.replaceFirst("^([a-zA-Z]*[=]*[a-zA-Z]*[&]*[a-zA-Z]*)", "");
    //                        System.out.println("--: "+l);
    //                    }
                        if(l.matches("^([a-zA-Z]*[=]*[a-zA-Z]*[&]*[a-zA-Z]*)([0-9]{4}|[0-9]{2})[./-]([0]?[1-9]|[1][0-2])[./-]([0]?[1-9]|[1|2][0-9]|[3][0|1])(>*)$"))
                        {
                            System.out.print("YES: "+l);
                            l=l.replaceFirst("^([a-zA-Z]*[=]*[a-zA-Z]*[&]*[a-zA-Z]*)", "");
                            System.out.println("--: "+l);
                        }    

                        StringTokenizer tok1 = new StringTokenizer(l, "-");
                        //System.out.println(l);
                        if(tok1.countTokens() == 3)
                        {
                            String first = tok1.nextToken();
                            String second = tok1.nextToken();
                            String third = tok1.nextToken();
                            System.out.println("AB: "+l);

                            if(isInt(first) && isInt(second) && isInt(third))
                            {
                                count++;

                                if(hm.containsKey(l))
                                {
                                    int x = hm.get(l);
                                    hm.remove(l);
                                    x+=1;
                                    hm.put(l, x);
                                }
                                else
                                {
                                    hm.put(l, 1);
                                }
                                continue;
                            }
                            System.out.println("\nDate: "+l+"\n");
                        }
                        StringTokenizer tok2 = new StringTokenizer(l, "/");
                        if(tok2.countTokens() == 3)
                        {
                            String first = tok2.nextToken();
                            String second = tok2.nextToken();
                            String third = tok2.nextToken();
                            if(isInt(first) && isInt(second) && isInt(third))
                            {
                                count++;
                                String final1 = "";
                                final1 = third+"-"+second+"-"+first;
                                if(third.length()<3)
                                {
                                    continue;
                                }

                                if(hm.containsKey(final1))
                                {
                                    int x = hm.get(final1);
                                    hm.remove(final1);
                                    x+=1;
                                    hm.put(final1, x);
                                }
                                else
                                {
                                    hm.put(final1, 1);
                                }
    //                            System.out.println(final1);
                                continue;
                            }
                        }
                    }
                    int isDate = search(arr,24,l);
                    if(isDate != -1)
                    {
                        //System.out.println(l);
                        int dateToIn = 0;
                        boolean found = true;
                        for(int i = 0;i<24 ;i++)
                        {
                            if(found == true)
                            {

                            }
                            else
                            {
                                break;
                            }
                            if(l.equals(arr1[i]))
                            {
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
    //                    System.out.println(dateToIn);
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

                                    int prevprev_num=Integer.parseInt(prevprev.trim());
                                    if(prevprev_num<10)
                                    {
                                        if(prevprev.charAt(0)!='0')
                                            prevprev="0"+prevprev;
                                    }

                                    dummy =dummy +prev+"-"+dateToInt+"-"+prevprev;
                                    if(prev.length()<3){
                                    continue;
                                }
                                    System.out.println("Dummy1:  "+dummy);
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

                                    int prevprev_num=Integer.parseInt(prevprev.trim());
                                    if(prevprev_num<10)
                                    {
                                        if(prevprev.charAt(0)!='0')
                                            prevprev="0"+prevprev;
                                    }

                                    dummy =dummy+l+"-" +dateToInt+"-"+prevprev;
                                    if(l.length()<3){
                                    continue;
                                }
                                    System.out.println("Dummy2:  "+dummy);
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


                                    int nextnext_num=Integer.parseInt(nextnext.trim());
                                    if(nextnext_num<10)
                                    {
                                        if(nextnext.charAt(0)!='0')
                                            nextnext="0"+nextnext;
                                    }


                                    dummy =dummy +next+"-"+dateToInt+"-"+nextnext;
                                    if(next.length()<3){
                                    continue;
                                }
                                    System.out.println("Dummy3:  "+dummy);
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
                }
                catch(Exception ex)
                {
                }
            }
            
            ArrayList<String> datestring=new ArrayList<String>();
            
            System.out.println("Total: "+count);
            Set set = hm.entrySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()) 
            {
               Map.Entry mentry = (Map.Entry)iterator.next();
//               System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
               datestring.add(mentry.getKey()+" = "+mentry.getValue());
//               System.out.println(mentry.getValue());
            }
      
      
            
            
            Comparator<String> comparator2 = new Comparator<String>() 
            {
            public int compare(String o1, String o2) 
                    {
                    StringTokenizer tok3 = new StringTokenizer(o1, "-");
                    int year1 = Integer.parseInt(tok3.nextToken());
                    int month1 = Integer.parseInt(tok3.nextToken());
                    int day1 = Integer.parseInt(tok3.nextToken());
                    StringTokenizer tok4 = new StringTokenizer(o2, "-");
                    int year2 = Integer.parseInt(tok4.nextToken());
                    int month2 = Integer.parseInt(tok4.nextToken());
                    int day2 = Integer.parseInt(tok4.nextToken());
                    if(year1<year2)
                            {
                            return 1;
                            }
                    if(year1>year2)
                            {
                            return -1;
                    }
                    if(month1<month2)
                            {
                            return 1;
                    }
                    if(month1>month2)
                            {
                            return -1;
                    }
                    if(day1<day2)
                            {
                                    return 1;
                    }
                    if(day1>day2)
                            {
                            return -1;
                    }
                    return 1;
                    }
            };	

				//-------------------------Printing in file with sorted date and time along with their frequency.----------------------------
                                SortedSet<String> keys = new TreeSet<String>(comparator2);
                                keys.addAll(hm.keySet());
                                Iterator it = keys.iterator();
                                Object element = it.next();
//                                System.out.println("End Date is " +element.toString());

                                
                                try
                                {
//                                    FileWriter fw1 = new FileWriter("/home/jain/Data/Articles/Local_DUP_7/StartingDate", false);
//                                    BufferedWriter bw1 = new BufferedWriter(fw1);
                                    
                                    while (it.hasNext()) 
                                    {
                                        // Get element
                                         element = it.next();
//                                         if(hm.get(element)>2)
                                            System.out.println(element+"  -   "+hm.get(element));
                                            dates.add(element+"="+hm.get(element));
//                                         bw1.write(element+ "   -    " );
//                                        bw1.newLine();
                                    }
                                }
                                catch(Exception e)
                                {
                                    e.printStackTrace();
                                }
        }
        catch (IOException e) {
            System.out.println("Err  " + sCurrentLine);
            e.printStackTrace();
        } 
        catch (Exception e) {
            System.out.println("Err  " + sCurrentLine);
            e.printStackTrace();
        } 
        return dates;
    }
    
    public static int CompareDates(String o1, String o2)
    {
        StringTokenizer tok1 = new StringTokenizer(o1, "-");
        int year1 = Integer.parseInt(tok1.nextToken());
        int month1 = Integer.parseInt(tok1.nextToken());
        int day1 = Integer.parseInt(tok1.nextToken());
        
        StringTokenizer tok2 = new StringTokenizer(o2, "-");
        int year2 = Integer.parseInt(tok2.nextToken());
        int month2 = Integer.parseInt(tok2.nextToken());
        int day2 = Integer.parseInt(tok2.nextToken());
        
        int diffy=0, diffm=0, diffd=0;
        
//        Date 
        
        if(year1!=year2)
        {
            diffy=(year1-year2)*365;
            
            if(diffy<0)
                diffy*=-1;
        }
        if(month1!=month2)
        {
            diffm=(month1-month2)*30;
            
            if(diffm<0)
            {
                diffm*=-1;
            }
        }
        
        if(day1!=day2)
        {
            diffd=(day1-day2)*30;
            
            if(diffd<0)
            {
                diffd*=-1;
            }
        }
//        if(day1>day2)
//        {
//            return -1;
//        }
        return 1;
    }
    
    public static void Interval(List<String> dates)
    {
        System.out.println("    List: \n");
        HashMap<String, String> hs=new HashMap<>();
        
        for(String dd: dates )
            
        for(int i=0; i<dates.size()-1; i++)
        {
            System.out.println(""+dd);
            CompareDates(dates.get(i), dates.get(i+1));
        }
    }
    
    public static long get_day_diff(String date1, String date2)
    {
                String[] p = date1.split("=");
                String[] days = p[0].split("-");                
                
                Calendar fd1=Calendar.getInstance();
                Calendar fd2=Calendar.getInstance();
                
                int year = (int)Integer.parseInt(days[0]);
                int month = (int)Integer.parseInt(days[1]);
                int day = (int)Integer.parseInt(days[2]);
                
                fd1.set(year,month,day);
                
                p=date2.split("=");
                days=p[0].split("-");
                
                year = (int)Integer.parseInt(days[0]);
                month = (int)Integer.parseInt(days[1]);
                day = (int)Integer.parseInt(days[2]);
                
                fd2.set(year,month,day);
                
                long diff=(fd1.getTimeInMillis()-fd2.getTimeInMillis())/(24*60*1000*60);
                
        return diff;
    }

    public static void main(String[]args){
        Keyword_date_mapper k = new Keyword_date_mapper();
        /*String[] cmd = {"C:\\WINDOWS\\system32\\cmd.exe","/c","start"};
        try {        
            Runtime runtime = Runtime.getRuntime();
        //Process p = runtime.exec(notepad);
            Process p = runtime.exec(cmd);
        }
        catch (java.io.IOException exception) {
            System.out.println("Caught IOException: " + exception.getMessage());
        }*/
         List<String> mdates = k.find_date();         
         List<String> dates = new ArrayList<String>();
         
         for(int i=0; i<mdates.size()-1; i++)
            {                
                String[] p = mdates.get(i).split("=");
                if(Integer.parseInt(p[1].trim()) > 1)
                {
                    dates.add(mdates.get(i));
                }                
            }
//         Interval(dates);

        try
        {
//                for(String x: dates)
//                {
//                    System.out.println(""+x);
//                }
                        
            int start_int_index = 0;
            int total_count = 0;
            
            for(int i=0; i<dates.size()-1; i++)
            {   
                String[] p = dates.get(i).split("=");
                String[] days = p[0].split("-");
                int count = Integer.parseInt(p[1]);
                total_count += count;
                
                long diff = get_day_diff(dates.get(i),dates.get(i+1));
                
                //System.out.println("Interval --- : " + dates.get(i) + " : " + dates.get(i+1) + " : " + diff);    
                if(diff > 1)
                {
                    long duration = get_day_diff(dates.get(start_int_index),dates.get(i));                    
                    System.out.println("Interval : " + dates.get(start_int_index) + " : " + dates.get(i) + " : " + total_count + " : " + duration);
                    //System.out.println("Interval : " + start_int_index + " : " + (i));
                    start_int_index = i+1;
                    total_count = 0;
                            
                }
                
                
            }
            
                
                
                
//                long diff=(d1.getTime()-d.getTime())/(24*60*1000*60);
//                System.out.println("D: "+diff);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    
        
//        System.out.println("\n\nDate diff: "+d1.compareTo(d));
    
    }
}
