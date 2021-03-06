package test1;


//下面的程序为一个整数栈，请实现整数出栈功能
public class Stack {
	
	private SingleLinkedList list = new SingleLinkedList();
	
	public boolean empty() {
		return list.getSize()==0;
	}
	
	public int size() {
		return list.getSize();
	}
	
	//请实现pop函数，从栈顶返回数据(弹出数据)，要求必须是先进后出，FILO结构
	public int pop() {
	  int size=size();
	  int num=0;
	  if(0==size){
		  return 0;
	  }
	  else if(1==size){
	   num=list.head.data;
	   list.head=list.tail=null;
	   list.size--;
	  
	  }
	  else{
		  Node temp=list.head;
		  for(int i=2;i<size;i++){
			  temp=temp.next;  
		  }
		  num=temp.next.data;
		  list.tail=temp;
		  if(temp.next.next==null){
			  list.tail.next=null;
		  }
		  list.size--;
		 } 
	 
	  return num;
	}
	
	//数据进栈操作
	public void push(int data) {  
		list.add(data);
		
	}
	
	//栈数据复制
	public Stack clone() {
		Stack s = new Stack();
		for(int i=0;i<list.getSize();i++) {
			s.list.add(list.get(i));
		}
		return s;
	}
	
	public static void main(String[] args) {
		Stack s1 = new Stack();
		s1.push(1);
		s1.push(2);
		s1.push(3);
		
		Stack s2 = s1.clone();
		
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		
		System.out.println(s1.size());
		
	}
}

