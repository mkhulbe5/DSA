package com.dsa.stacks;

import java.util.Stack;

import javax.xml.stream.events.Characters;

public class InfixEvaluation {

	String exp = "";
	
	Stack<Integer> oprnds = new Stack<>();
	Stack<Character> oprtors = new Stack<>();
	
	for(int i = 0; i < exp.length(); i++) {
		char ch = exp.charAt(i);
		
		if(ch == '(')oprtors.push(ch);
		else if(Character.isDigit(ch)) {
			oprnds.push(ch - '0');
		}
		
		else if(ch == ')') {
			while(oprtors.peek() != '(') {
				char optor = oprtors.pop();
				int v2 = oprnds.pop();
				int v1 = oprnds.pop();
				int operation = operation(v1, v2, optor);
				oprnds.push(operation);
			}
			
			oprtors.pop();
		}
		
		else if (ch == '+' || ch == '-' || ch =='*' || ch == '/' ){
			while(oprtors.size()  > 0 && oprtors.peek() != '(' &&  precedence(ch) <= precedence(oprtors.peek())) {
				char optor = oprtors.pop();
				int v2 = oprnds.pop();
				int v1 = oprnds.pop();
				int operation = operation(v1, v2, optor);
				oprnds.push(operation);
			}
			oprtors.push(ch);
		}
				
	}
	
	while(oprtors.size() > 0) {
		char optor = oprtors.pop();
		int v2 = oprnds.pop();
		int v1 = oprnds.pop();
		int operation = operation(v1, v2, optor);
		oprnds.push(operation);
	}
	
	System.out.print(oprtors.peek());
	
	
	public int precedence(char operator) {
		if (operator == '+')
			return 1;
		else if (operator == '-')
			return 1;
		else if (operator == '*')
			return 2;
		else
			return 2;
	}
	
	
	public int operation(int v1 , int v2 , char operator) {
		if (operator == '+')
			return v1 + v2;
		else if (operator == '-')
			return v1 - v2;
		else if (operator == '*')
			return v1 * v2;
		else
			return v1 / v2;
	}
}
