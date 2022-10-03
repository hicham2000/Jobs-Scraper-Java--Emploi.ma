public class data {
    public int id;
    public String Postname;
    public String DateDePublication;
    public String Entreprise;
    public String description;
    public String region;
    public String Competence;

    public data(int id,String Postname, String DateDePublication, String Entreprise,
                String description, String region, String Competence) {
        this.id = id;
        this.Postname = Postname;
        this.DateDePublication = DateDePublication;
        this.Entreprise = Entreprise;
        this.description = description;
        this.region = region;
        this.Competence = Competence;
    }
}
