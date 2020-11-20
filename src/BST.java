import java.text.NumberFormat;

public class BST {
	
	/*
	 * Invariant for this Binary Search Tree:
	 * 
	 * 1. the root node in the tree stored in instance variable root, of type
	 * BSTNode
	 * 
	 */
		
	private BSTNode root;
	
	//static object for formatting output
	private static NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
	BST(){
		this.root = null;
	}
	
	//main-public
	//insert method code taken from Sue Fitzgerald
	public void insert(MenuItem item) {
		if(root == null) {
			root = new BSTNode(item, null, null);
		}
		
		else {
			insert(root, item);
		}
	}
	
	//private-helper-aux
	//insert method code taken from Sue Fitzgerald
	private void insert(BSTNode cur, MenuItem item) {
		if(item.compareTo(cur.getData()) == 0) {
			int oldQty = cur.getData().getQuantity();
			int newQty = item.getQuantity();
			
			cur.getData().setQuantity(oldQty + newQty);
		}
		
		else if (item.compareTo(cur.getData()) < 0) {//if the item is less than or equal to cursor
			if (cur.getLeft() != null) {
				insert(cur.getLeft(), item);
			}
			else
				cur.setLeft(new BSTNode (item, null, null));
		}
		
		else if (item.compareTo(cur.getData()) > 0) {//if the item is greater than cursor
			if (cur.getRight() != null) {
				insert(cur.getRight(), item);
			}
				
			else {
				cur.setRight(new BSTNode(item, null, null));
			}
				
		}
			
	}
	
	//node,left,right
	public void preorder() {
		System.out.println();
		preorder(root);
	}
	
	//node,left,right
	private void preorder(BSTNode cursor) {
		
		if(cursor != null) {
			System.out.println(cursor.getData().getName());
			
			preorder(cursor.getLeft());
			
			preorder(cursor.getRight());
		}
		
	}
	
	//left,right,node
	public void postorder() {
		System.out.println();
		postorder(root);
	}
	//left,right,node
	private void postorder(BSTNode cursor) {
		if(cursor != null) {
			postorder(cursor.getLeft());
			
			postorder(cursor.getRight());
			
			System.out.println(cursor.getData().getName());
		}
	}
	
	//left,node,right
	public void inorder() {
		System.out.println();
		inorder(root);
	}
	//left,node,right
	private void inorder(BSTNode cursor) {
		
		if(cursor != null) {
			inorder(cursor.getLeft());
			
			System.out.println(cursor.getData().getName());
			
			inorder(cursor.getRight());
			
		}
	}
	
	//size method taken from Sue Fitzgerald
	public int size() {
		return size(root);
	}
	
	//size method taken from Sue Fitzgerald
	private int size(BSTNode cursor) {
		if(cursor == null) {
			return 0;
		}
		return 1 + size(cursor.getLeft()) + size(cursor.getRight());
	}
	
	//depth method internet source:
	//https://makeinjava.com/find-height-binary-tree-java-dfs-recursive-algorithm-example/
	public int depth() {
		return depth(root);
	}
	private int depth(BSTNode cursor) {
		if(cursor == null) {
			return 0;
		}
		int leftNum = depth(cursor.getLeft());
		int rightNum = depth(cursor.getRight());
		
		return Math.max(leftNum, rightNum) + 1;
	}
	
	public int getTotalQty() {
		return getTotalQty(root);
	}
	
	private int getTotalQty(BSTNode cursor) {
		
		if(cursor != null) {
			return cursor.getData().getQuantity() 
					+ getTotalQty(cursor.getLeft())
					+ getTotalQty(cursor.getRight());
			
		}
		
		return 0;
		
		
	}
	
	public MenuItem search(String str) {
		
		MenuItem temp = new MenuItem(str);
		
		return search(root, temp);
	}
	
	private MenuItem search(BSTNode cursor, MenuItem other) {
		
		if(cursor == null) {
			return null;
		}
		
		
		if(cursor.getData().compareTo(other) == 0) {
			return cursor.getData();
		}
		
		else if(cursor.getData().compareTo(other) < 0) {// other should go right
			return search(cursor.getRight(), other);
		}
		
		else if(cursor.getData().compareTo(other) > 0) {// other should go left
			return search(cursor.getLeft(), other);
		}
		
		else {
			return null;
		}
		
		
	}
	
	public double getTotalBeforeTax() {
		return getTotalBeforeTax(root);
	}
	
	private double getTotalBeforeTax(BSTNode cursor) {
		
		if(cursor != null) {
			
			return (cursor.getData().getPrice() *cursor.getData().getQuantity())
					+ getTotalBeforeTax(cursor.getLeft())
					+ getTotalBeforeTax(cursor.getRight());
		}
		
		return 0;
	}
	
	public double getTax() {
		double tax = 0.08;
		return getTotalBeforeTax() * tax;
	}
	
	public double getTip() {
		double tip = 0.2;
		return getTotalBeforeTax() * tip;
	}
	
	public double getGrandTotal() {
		return getTotalBeforeTax() 
				+ getTax() + getTip();
	}
	
	@Override
	public String toString() {
		String str = "Downtown Cafe\n";
		str += "------------------------------------------\n";
		str += "Item\t\tPrice\tQty\tTotal\n";
		str += "------------------------------------------\n";
		
		str += toString(root);
		
		str += "------------------------------------------\n";
		str += "Total:\t\t" + formatter.format(getTotalBeforeTax());
		str += "\nTax:\t\t" + formatter.format(getTax());
		str += "\nTip:\t\t" + formatter.format(getTip());
		
		str += "\n------------------------------------------\n";
		str += "Grand Total:\t" + formatter.format(getGrandTotal());;
		
		return str;
	}
	
	private String toString(BSTNode cursor) {
		
		if(cursor == null) {
			return "";
		}
		
		return toString(cursor.getLeft()) + cursor.getData().toString() 
		+ toString(cursor.getRight());
	}

}
