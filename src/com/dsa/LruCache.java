package com.dsa;

import java.util.HashMap;

public class LruCache {

	HashMap<Integer,  Node> cache;
	int cap;
	Node head;
	Node tail;
	
	
	class Node{
		int key;
		int value;
		Node next;
		Node prev;
	}
	
	public void addNode(Node node) {
		Node nbr = head.next;
		node.next = nbr;
		node.prev = head;
		
		head.next = node;
		nbr.prev = node;
	}
	
	public void removeNode(Node node) {
		Node prevNbr = node.prev;
		Node nextNbr = node.next;
		
		prevNbr.next = nextNbr;
		nextNbr.prev = prevNbr;
		
		node.next = node.prev = null;
	}
	
	
	public void moveFront(Node node) {
		removeNode(node);
		addNode(node);
	}
	
	
	
	LruCache(int cap){
		this.cap = cap;
		cache = new HashMap<>();
		head = new Node();
		tail = new Node();
	}
	
	
	
	public void put(int key,int value) {
		Node node = cache.get(key);
		
		if(node == null) {
			Node newNode = new Node();
			newNode.key = key;
			newNode.value = value;
			
			if(cache.size() == cap) {
				Node removeNode = tail.prev;
				cache.remove(removeNode.key);
				removeNode(removeNode);
			}
			
			cache.put(key, newNode);
			addNode(newNode);
		}
		else {
			node.value = value;
			moveFront(node);
		}
	}
}
