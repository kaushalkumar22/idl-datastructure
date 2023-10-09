package matrix;

/**
 * 
 */
public class SetMatrixZeroes {

	private static final int PAGE_SIZE =50000;
	private static int pageNumber;
	public static void main(String[] args) {
		pageNumber = 0;
		System.out.println(getNextFirstResult());
		System.out.println(getNextFirstResult());
	//	System.out.println(getNextFirstResult());
		int pageStartIndex = (50000 - 1) * PAGE_SIZE ;
		System.out.println(pageStartIndex + PAGE_SIZE);
	}
	private static int getNextFirstResult() {

		return (++pageNumber - 1) * PAGE_SIZE + 1;
	}

}

