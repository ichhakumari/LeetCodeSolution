class MyStack {

  private Queue<Integer> q = new LinkedList<>();  
  public void push(int x) {
    q.add(x);
    for (int i = 0; i < q.size() - 1; i++) {
      q.add(q.remove());  
    }
  }

  public int pop() {  
    if (empty()) return -1;
    return q.remove();
  }

  public int top() {
    if (empty()) return -1;
    return q.peek();
  }

  public boolean empty() {
    return q.isEmpty();
  }
}

