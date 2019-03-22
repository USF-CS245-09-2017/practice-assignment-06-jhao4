import java.lang.reflect.Array;
public class ArrayStack<Item> implements Stack<Item> 
{
	public int t;
	public Item[] a;

	@Override
	public void push(Item i)
	{

		if (t == a.length) 
		{
			grow_stack();
		} //if
		a[t++] = i;
	} //push

	@Override
	public Item peek()
	{
		if (empty() == false) 
		{
			return a[t-1];
		} //if
		return null;
	} //peek

	@Override
	public boolean empty()
	{
		if (t == 0) 
		{
			return true;
		}
		return false;
	} //empty
	
	public ArrayStack() 
	{
		a = (Item[]) new Object[10];
		t = 0;
	} //arraystack
	

	@Override
	public Item pop()
	{
		if (empty() == false) 
		{
			return a[--t];
		} //if
		return null;
	} //pop

	protected void grow_stack()
	{
		Item[] na = (Item[]) new Object[a.length * 2];
		System.arraycopy(a, 0, na, 0, a.length);
		a = na;
	} //grow_stack

} //arraystack