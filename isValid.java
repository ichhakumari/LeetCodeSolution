class Solution {
    public boolean isValid(String s) {
        char[] arr =s.toCharArray();
        Stack<Character>Stack = new Stack <>();

        for(char ch:arr){
            if (Stack.isEmpty()){
                Stack.push(ch);
            }
            else{
                char top = Stack.peek();
                if(ch-top==1 || ch-top==2){
                    Stack.pop();
                }
                else{
                    Stack.push(ch);
                }
            }
        }
        return Stack.isEmpty();
    }
}
