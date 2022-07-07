import java.util.Random;

public class Matrix_Method {
	
	private int hash[][];
	private int key[][];
	private int size;
	private Random rand;
	private int b_size;
	
	public Matrix_Method(int size)
	{
		this.size=size;
		key=new int[32][1];
		rand=new Random();
		GenerateHash();
	}
	public void GenerateHash()
	{
		b_size=(int)Math.ceil(Math.log(size)/Math.log(2));
		hash=new int[b_size][32];
		
		
		for(int i=0;i<hash.length;i++)
		{
			for(int j=0;j<32;j++)
			{
				hash[i][j]=rand.nextInt(2);
				
			}
			//System.out.println();
		}
	}
	public int HashValue(int x)
	{
		String keyBinary=Integer.toBinaryString(x);
		
		//System.out.print(keyBinary.charAt(0));////////////////////
		calc_keyArr(keyBinary);
		//System.out.print(key);////////////////////
		//.out.println(key.toString());///////////////////////////////////////////
		short[][] res=new short[b_size][1];
		int resAsInt=0;
		for(int i=0;i<b_size;i++)
		{
			int temp=0;
			for(int j=0;j<32;j++)
			{
				temp+=(hash[i][j] * key[j][0]);
			}
			res[i][0]= (short)(temp % 2);
		}
		
		// convert array of binary to an integer value
		for(int i=0;i<b_size;i++)
		{
			resAsInt += (int) (res[i][0]*Math.pow(2,b_size-1-i));
		}
		return resAsInt%size;
	}
	
	public void calc_keyArr(String keyBinary)
	{
		int from=32-keyBinary.length();
		int index=0;
		for(int i=0;i<32;i++)
		{
			if(i<from)
				key[i][0]=0;
			else {
				key[i][0]=Integer.valueOf(keyBinary.charAt(index))-'0';
				index++;
			}
		}
	}
	
	public void refresh_HashFunction()
	{
		hash=new int[b_size][32];
		for(int i=0;i<hash.length;i++)
		{
			for(int j=0;j<32;j++)
			{
				hash[i][j]=rand.nextInt(2);
			}
		}
	}

}
