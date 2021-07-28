import java.util.Random;

public class linkedlist
{
	static node head, tail = null;
	static int linkedListSize = 0;
	
	public static void main(String[] args)
	{
		Random rand = new Random();
		int upperBound = 500;
		int randomValueBound = 100;
		int begOrEndBound = 2;
		for (int i = 0; i < upperBound; i++)
		{
			int randomValue = rand.nextInt(randomValueBound);
			int randomInsert = rand.nextInt(begOrEndBound);
			if (randomInsert == 0)
			{
				System.out.println("Adding node with value = " + randomValue + " to beginning");
				addNodeBeginning(randomValue);
			}
			else
			{
				System.out.println("Adding node with value = " + randomValue + " to end");
				addNodeEnd(randomValue);
			}
		}
		
		adjNodesIndex();
		System.out.println("Added 500 random nodes to linked list");
		System.out.println("Randomly inserting 500 more random nodes at random indexes");
		
		for (int j = 0; j < upperBound; j++)
		{
			int randomValue = rand.nextInt(randomValueBound);
			int randomInsertIndex = rand.nextInt(linkedListSize);
			
			addNodeAtIndex(randomInsertIndex, randomValue);
			System.out.println("Adding node with value = " + randomValue + " at index = " + randomInsertIndex);
		}
		printNodes();
	}
	
	//Create new node at beginning of linked list
	static void addNodeBeginning(int value)
	{
		node newNode = new node(value);
		
		if(head == null)
		{
			head = tail = newNode;
			newNode.setNodeBefore(null);
			newNode.setNodeAfter(null);
		}
		else
		{
			head.setNodeBefore(newNode);
			newNode.setNodeAfter(head);
			newNode.setNodeBefore(null);
			head = newNode;
		}
		
		newNode.setIndex(0);
	}
	
	//Create new node at index of linked list
	static void addNodeAtIndex(int index, int value)
	{
		node temp = getNodeAtIndex(index);

		if(temp == null)
		{
			System.out.println("Cannot find node with index = " + index);
			return;
		}
		node newNode = new node(value);
		
		newNode.setNodeBefore(temp.getNodeBefore());
		temp.getNodeBefore().setNodeAfter(newNode);
		newNode.setNodeAfter(temp);
		temp.setNodeBefore(newNode);
		adjNodesIndex();
	}
	
	//Create new node at end of linked list
	static void addNodeEnd(int value)
	{
		node newNode = new node(value);
		
		if(head == null)
		{
			head = tail = newNode;
			newNode.setNodeBefore(null);
			newNode.setNodeAfter(null);
		}
		else
		{
			tail.setNodeAfter(newNode);
			newNode.setNodeBefore(tail);
			newNode.setNodeAfter(null);
			tail = newNode;
		}
	}
	
	static void adjNodesIndex()
	{
		node temp = head;
		int index = 1;
		
		while(temp.getNodeAfter() != null)
		{
			temp.getNodeAfter().setIndex(index);
			temp = temp.getNodeAfter();
			index++;
			linkedListSize = Math.max(linkedListSize, index);
		}
	}
	
	static node getNodeAtIndex(int index)
	{
		node temp = head;
		
		while(temp != null)
		{
			if(temp.getIndex() == index)
			{
				return temp;
			}
			else
			{
				temp = temp.getNodeAfter();
			}
		}
		System.out.println("No matching node");
		return null;
	}
	
	static void printNodes()
	{
		node temp = head;
		
		while(temp != null)
		{
			temp.print();
			temp = temp.getNodeAfter();
		}
	}
	
}
