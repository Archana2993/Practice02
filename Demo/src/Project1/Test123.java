package Project1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test123 
{

	public static void main(String[] args)
	{
		HashMap <Integer, String> hm=new HashMap<Integer,String>();
		hm.put(1, "Archana");
		hm.put(2, "Shranay");
		hm.put(3, "Kale");
		hm.put(4, "Sameer");
		for(Map.Entry<Integer, String> m:hm.entrySet())
		{
			System.out.println(m.getKey()+" "+m.getValue());
		}
	}

}
