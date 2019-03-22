import java.lang.reflect.Array;
public class ArrayQueue<Item> implements Queue<Item> 
{
	public int h;
	public int t;
	public Item[] a;

	protected void grow_queue()
	{
		Item[] na = (Item[]) new Object[a.length * 2];
		System.arraycopy(a, 0, na, 0, a.length);
		a = na;
	} //grow_queue

	@Override
	public void enqueue(Item item)
	{
		if ((t + 1) % a.length == h) 
		{
			grow_queue();
		} //if
		a[t] = item;
		t = (t + 1) % a.length;
		
		if (t == a.length) 
		{
			t = 0;
	 	} //if	
	} //enqueue
	
	@Override
	public boolean empty()
	{
		if (h == t) 
		{
			h = 0;
			t = 0;
			return true;
		} //if
		return false;
	} //empty
	
	public ArrayQueue() 
	{
		a = (Item[]) new Object[10];
		h = 0;
		t = 0;
	} //arrayqueue
	
	@Override
	public Item dequeue()
	{
		if (empty()) 
		{
			return null;
		} //if
		Item i = a[h];
		h = (h + 1) % a.length;
		
		if (h == a.length)
		{
			h = 0;
		} //if
		return i;
	} //dequeue

	
}//arrayqueue