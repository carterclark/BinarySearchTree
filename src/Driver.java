
public class Driver {

	public static void main(String[] args) {
		MenuItem pie = new MenuItem("Pie", 10.50, 1);
		MenuItem burger = new MenuItem("Burger", 6.79, 2);
		MenuItem fries = new MenuItem("Fries", 3.00, 3);
		MenuItem shake = new MenuItem("Shake", 7.80, 1);
		MenuItem salad = new MenuItem("Salad", 14.49, 2);
		
		MenuItem soda = new MenuItem("Soda", 1.50, 2);
		MenuItem sandwich = new MenuItem("Sandwich", 9.00, 4);
		MenuItem blt = new MenuItem("BLT", 12.39, 1);
		MenuItem crisp = new MenuItem("Crisp", 19.99, 2);
		MenuItem omolet = new MenuItem("Omolet", 25.00, 1);
		
		MenuItem pancake = new MenuItem("Pancake", 8.50, 4);
		MenuItem pancake1 = new MenuItem("Pancake", 8.50, 4);
		MenuItem pancake2 = new MenuItem("Pancake", 8.50, 4);
		MenuItem soup = new MenuItem("Soup", 5.20, 4);
		MenuItem steak = new MenuItem("Steak", 16.00, 1);
		
		MenuItem soda1 = new MenuItem("Soda", 1.50, 2);
		MenuItem soup1 = new MenuItem("Soup", 5.20, 4);
		MenuItem sandwich1 = new MenuItem("Sandwich", 9.00, 4);
		MenuItem blt1 = new MenuItem("BLT", 12.39, 1);
		MenuItem salad1 = new MenuItem("Salad", 14.49, 2);
		
		BST tree = new BST();
		
	
		tree.insert(pie);
		tree.insert(burger);
		tree.insert(fries);
		tree.insert(shake);
		tree.insert(salad);
		
		tree.insert(soda);
		tree.insert(sandwich);
		tree.insert(blt);
		tree.insert(crisp);
		tree.insert(omolet);
		
		tree.insert(pancake);
		tree.insert(pancake1);
		tree.insert(pancake2);
		tree.insert(soup);
		tree.insert(steak);
		
		tree.insert(soda1);
		tree.insert(soup1);
		tree.insert(sandwich1);
		tree.insert(blt1);
		tree.insert(salad1);
		
		assert(tree.size() == 13);
		assert(tree.getTotalQty() == 49);
		assert(tree.depth() == 5);
		assert(tree.search("Soda").equals(soda));
		assert(tree.getTotalBeforeTax() == 426.20);
		assert(tree.getTax() > 34.09 && tree.getTax() < 34.11); //is 34.10
		assert(tree.getTip() > 85.23 && tree.getTip() < 85.25); //is 85.24
		System.out.println(tree);
		

//		tree.preorder();
//		tree.postorder();
//		tree.inorder();
		
		
	}

}
