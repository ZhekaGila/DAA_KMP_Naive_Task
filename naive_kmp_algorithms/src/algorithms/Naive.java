package algorithms;

public class Naive {
    private String text;
    private String pattern;

// constructor creating and intializing variables
    public Naive(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
    }

    // performing the algorithm
    // if pattern doesnt match we just move forward on 1 index and try again
    public void search(){
        int n = text.length();
        int m = pattern.length();

        for(int i=0; i<=n-m; i++){
            int j; // index for pattern

            for(j = 0; j < m; j++){
                if(text.charAt(i+j) != pattern.charAt(j)){
                    break;
                }
            }
            if(j == m){
                System.out.println("Pattern on index: " + i); // if pattern matches we print its index
            }
        }
    }
}
