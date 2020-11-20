
public class BSTNode {
	
	private MenuItem data;
	private BSTNode left,right;
	
	BSTNode(MenuItem data, BSTNode left, BSTNode right){
		
		this.data = data;
		this.left = left;
		this.right = right;
		
	}

	public MenuItem getData() {
		return data;
	}

	public void setData(MenuItem data) {
		this.data = data;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}
	
	

}
