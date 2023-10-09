package patternsearching;


public class IPUrlMap
{
	public static String firstUnique(String[] array)
	{
		Node root = new Node();
		Node first = null;
		Node last = null;
		for (String s : array)
		{
			Node current = root;
			/* Modify the trie */
			for (char c : s.toCharArray())
			{
				int index = 0;
				if (':' == c) {index = 28;}
				else if ('/' == c) {index = 27;}
				else if ('.' == c) {index = 26;}
				else {index = c - 'a';}

				if (null == current.child[index])
				{
					Node next = new Node();
					next.parent = current;
					next.data = c;
					current.child[index] = next;
				}
				current = current.child[index];
			}

			/* Modify the linked list */
			current.count++;
			if (1 == current.count)
			{
				if (null == first) {first = last = current;}
				else
				{
					current.prev = last;
					last.next = current;
					last = current;
				}
			}
			else if (2 == current.count)
			{
				if (current == first)
				{
					first = current.next;
					if (null != first) {first.prev = null;}
				}
				else
				{
					Node prev = current.prev;
					prev.next = current.next;
					if (null != current.next)
					{
						current.next.prev = prev;
					}
				}
			}
		}

		StringBuffer sb = new StringBuffer();
		Node current = first;
		while (current != root)
		{
			sb.append(current.data);
			current = current.parent;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args)
	{
		String[] urls = {
				"abc.google.com",
				"abc.facebook.com",
				"abc.amazon.com",
				"abc.yahoo.com",
				"abc.facebook.com",
				"abc.yahoo.com",
				"abc.facebook.com",
				"abc.google.com"
		};
		System.out.println(firstUnique(urls));
		System.out.println(System.getProperty("tmpdir"));
	}
}
class Node
{
	public Node parent = null;
	public Node[] child = new Node[29];
	public Node prev = null;
	public Node next = null;
	public char data = ' ';
	public int count = 0;
}
