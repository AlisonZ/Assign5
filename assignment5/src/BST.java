package com.company;

public class BST {

	private TreeNode root; //overall root
	private int size;

	public BST() {
		this.root = null;
	}

	public void insert(String key, String value) {
		root = insert(root, key, value);
		size+=1;
	}

	private TreeNode insert(TreeNode root, String key, String value) {
		if(root == null)
			root = new TreeNode(key, value);

		else if(root.key.compareTo(key) > 0)
			root.left = insert(root.left, key, value);
		else if(root.key.compareTo(key) < 0)
			root.right = insert(root.right, key, value);
		else if(root.key.compareTo(key) == 0)
			root.key = key;

		return root;
	}

	public void remove (String key) {
		root = remove(root, key);
	}

	private TreeNode remove(TreeNode root, String key) {
		if(root == null)
			return null;
//		else if (key < root.key)
			//TODO: check that this the correct ordering of compareTo()
		else if (root.key.compareTo(key) < 0)
			root.left =remove (root.left, key);
//		else if (key > root.key)
		else if (root.key.compareTo(key) > 0)
			root.right =remove(root.right, key);
		else { //key == root.key, we remove key-value pair
			if(root.right == null)
				return root.left;
			else if (root.left == null)
				return root.right;
			else { //a parent with two children, assume that we find the min of right subtree
				//TODO: check that this string value of is working as expected
				root.key = getMin(root.right);
				root.value = search(root.right, root.key);
				root.right = remove(root.right, root.key);
			}
		}
		return root;
	}


	public String getMin() {
		return getMin(root);
	}

	private String getMin(TreeNode root) {
		if(root != null) {
			if(root.left == null)
				return root.key;
			else
				return getMin(root.left);
		}

		return "NOT FOUND";
	}


	public String getMax() {
		return getMax(root);
	}

	private String getMax(TreeNode root) {
		if(root != null) {
			if(root.right == null)
				return root.key;
			else
				return getMax(root.right);
		}

		return "NOT FOUND";
	}


	public String search(String key) {
		return search(root, key); //root => overall root
	}

	private String search(TreeNode root, String key) {
		if(root == null)  //key is not found
			return "NOT FOUND";
		else if (root.key.compareTo(key) < 0)
			return search(root.left, key);
		else if (root.key.compareTo(key) > 0)
			return search(root.right, key);

		return root.value; 	//key == root.key, key is found
	}

	public void printInOrder() {
		printInOrder(root);
	}

	//recursive print in order function
	private void printInOrder(TreeNode root) {
		if(root != null) {
			printInOrder(root.left);
			System.out.println(root.key +":"+root.value);
			printInOrder(root.right);
		}
	}

	public void printPreOrder() {
		printPreOrder(root);
	}

	//recursive print pre order function
	private void printPreOrder(TreeNode root) {
		if(root != null) {
			System.out.println(root.key +":"+root.value);
			printPreOrder(root.left);
			printPreOrder(root.right);
		}
	}

	public void printPostOrder() {
		printPostOrder(root);
	}

	//recursive print post order function
	private void printPostOrder(TreeNode root) {
		if(root != null) {
			printPostOrder(root.left);
			printPostOrder(root.right);
			System.out.println(root.key +":"+root.value);
		}
	}

	public int leafCount() {
		return leafCount(root);
	}

	private int leafCount(TreeNode root) {
		if(root == null)
			return 0;
		else if (root.left == null && root.right == null)
			return 1;
		else
			return leafCount(root.left) + leafCount(root.right);
	}

	public int countParents() {
		return countParents(root);
	}

	private int countParents(TreeNode root) {
		if(root == null | (root.left == null && root.right == null))
			return 0;
		else if( root.left != null && root.right !=null)
			return countParents(root.left) + countParents(root.right);
		else {
			return 1 + countParents(root.left) + countParents(root.right);
		}

	}


	//inner class for a tree node
	private class TreeNode{
		public String key;
		public String value;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(String key, String value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	public int getSize() {
		return size;
	}
}
