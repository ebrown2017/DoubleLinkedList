public class node
{
	private int value;
	private int index;
	private node nodeBefore, nodeAfter;
	
	//Constructors
	public node(int value, node nodeBefore, node nodeAfter)
	{
		this.value = value;
		this.nodeBefore = nodeBefore;
		this.nodeAfter = nodeAfter;
	}
	
	public node(int value)
	{
		this.value = value;
		this.nodeBefore = null;
		this.nodeAfter = null;
	}
	
	//Setter
	public void setValue(int value)
	{
		this.value = value;
	}
	
	public void setIndex(int index)
	{
		this.index = index;
	}
	
	public void setNodeBefore(node nodeBefore)
	{
		this.nodeBefore = nodeBefore;
	}
	
	public void setNodeAfter(node nodeAfter)
	{
		this.nodeAfter = nodeAfter;
	}
	
	//Getter
	public int getValue()
	{
		return value;
	}
	
	public int getIndex()
	{
		return index;
	}
	
	public node getNodeBefore()
	{
		return nodeBefore;
	}
	
	public node getNodeAfter()
	{
		return nodeAfter;
	}
	
	//print
	public void print()
	{
		System.out.println("Index = " + getIndex()
		+ " Value = " + getValue());
	}
	
}
