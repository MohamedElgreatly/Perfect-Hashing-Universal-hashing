public class NNSpaceSolution {

 private int numCollision=0,size=0;
 private boolean collision;
 private Integer[] hashTable,values;
   NNSpaceSolution(Integer values[])
   {
	 this.values=values;
	 size=values.length;
	 collision=true;
   }
   public void hashForm() {
	   
		   hashTable=new Integer[size*size];
		   Matrix_Method obj =new Matrix_Method(size*size);
		   obj.GenerateHash();
		   for(int i=0;i<size;i++)
		   {
			   //check for any collision
			   int indx=obj.HashValue(values[i]);
			   while(hashTable[indx]!=null && !(hashTable[indx].equals(values[i])))
			   {
				   obj.refresh_HashFunction();
				   indx=obj.HashValue(values[i]);
				   numCollision++;
			   }
			   hashTable[indx]=values[i];
		   }
	   }
   
   
   public void printHashTable()
   {
	   StringBuilder str= new StringBuilder();
	   str.append("[");
	   for(int i=0;i<hashTable.length;i++)
	   {
		   if(hashTable[i]!=null)
		   {
			   str.append(hashTable[i]+",");
		   }
		   else {
			   str.append("nan,");
		   }
	   }
	   str.deleteCharAt(str.length()-1);
	   str.append("]");
	   System.out.print(str);
   }
   public int numb_collision()
   {
	   return this.numCollision;
   }
}
