package main.java.trainer;

public class Names {
    int numOfNames = 50;
    String[] names = { "Aaron", "Alexandra", "Aman", "Andrew", "Anna", "Arnold", "Benjamin", 
        "Blake", "Brandon", "Carlos", "Charles", "Cody", "Danny", "David", "Dhalia", "Eric", 
        "Esaias", "Forrest", "Gabrielle", "Gail", "Garrett", "Hala", "John", "Joseph", "Joshua",
        "Katie", "Kevin", "Mary", "Matthew", "Maura", "Minh", "Miranda", "Monique", "Neil",  
        "Nick", "Palak", "Paul", "Phuoc", "Reagan", "Richard", "Ryan", "Samuel", "Shawn", 
        "Shay", "Thomas", "Timothy", "Uija", "Van", "Venkata", "William" };
    
    public Names() {

    }

    /**
     * gets the name corresponding to the index.
     * @param idx the index corresponding to the returned name.
     * @return the returned name.
     */
    public String getName(int idx) {
        if (idx > numOfNames - 1) {
            idx = numOfNames - 1;
        }

        if (idx < 0) {
            idx = 0;
        }

        return names[idx];
    }
}
