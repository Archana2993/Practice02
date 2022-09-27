package Project1;

public class TofindMaxAndMinarray
{
  public static void main(String[] args)
  {
	  int a[]= {1,2,3,4,5,6,7};
	  int size=a.length;
	  int max=a[0];
	  int min=a[1];
	  for(int i=0;i<size;i++)
	  {
		  if(max<a[i])
		  {
			  max=a[i];
		  }
		  if(min>a[i])
		  {
			  min=a[i];
		  }
		  
	  }
	  System.out.println("Mamimum number="+max+"  Minimum number="+min);
}
}
