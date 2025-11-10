package algorithms;

public class Naive {
    private String text;
    private String pattern;

    public Naive(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
    }

    public void search(){
        int n = text.length();
        int m = pattern.length();

        for(int i=0; i<=n-m; i++){
            int j;

            for(j = 0; j < m; j++){
                if(text.charAt(i+j) != pattern.charAt(j)){
                    break;
                }
            }
            if(j == m){
                System.out.println("Pattern on index: " + i);

            }
        }
    }
}
