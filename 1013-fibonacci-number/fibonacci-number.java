class Solution {
    public int fib(int n) {
        return fibonacci(n);
        
    }
    private int fibonacci(int n){
        if(n == 0 ){
          return 0 ;}

        if (n == 1){
          return 1;}

        else{
            return fibonacci(n-1) + fibonacci(n-2);
        }  

    }
}