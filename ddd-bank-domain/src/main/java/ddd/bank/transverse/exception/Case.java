package ddd.bank.transverse.exception;

/**
 * @author <a href="mailto:jeremie@grodziski.com">Jérémie Grodziski</a>
 */
public class Case {

    private String id;
    private String description;
    private String suggestion;

    /**
     * @param id
     * @param description Attention aux apostrophes, il faut doubler les  apostrophes pour que le formatage se passe bien.
     * @param suggestion
     */
    public Case(String id, String description, String suggestion) {
        this.id = id;
        this.description = description;
        this.suggestion = suggestion;
    }

    /**
     * @param id
     * @param description Attention aux apostrophes,  il faut doubler les  apostrophes pour que le formatage se passe bien.
     */
    public Case(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getSuggestion() {
        return suggestion;
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Case)
            return (((Case) o).getId()).equals(this.getId());
        return false;
    }
}


