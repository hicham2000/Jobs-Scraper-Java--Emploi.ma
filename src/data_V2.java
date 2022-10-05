public class data_V2 {
    public int id;
    public String Postname;
    public String DateDePublication;
    public String Entreprise;
    public String description;
    public String region;
    public String Competence;
    public String Type_de_contrat;
    public String secteur;
    public String experience;
    public String niveau_etude;
    public String langue;
    int nombre_de_poste;

    public data_V2(int id, String Postname, String DateDePublication, String Entreprise,
                   String description, String region, String Competence, String Type_de_contrat, String secteur
    ,String experience, String niveau_etude , String langue, int nombre_de_poste) {
        this.id = id;
        this.Postname = Postname;
        this.DateDePublication = DateDePublication;
        this.Entreprise = Entreprise;
        this.description = description;
        this.region = region;
        this.Competence = Competence;
        this.Type_de_contrat = Type_de_contrat;
        this.secteur = secteur;
        this.experience = experience;
        this.niveau_etude = niveau_etude;
        this.langue = langue;
        this.nombre_de_poste = nombre_de_poste;
    }
}
