
package ohtu;

public class KurssiSubmission {
    
    private String name;
    private String term;

    public KurssiSubmission(String name, String term) {
        this.name = name;
        this.term = term;
    }
    
    

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    @Override
    public String toString() {
        return "Kurssi: " + name + ", " + term;
    }
    
    
    
}
