public class Transaction {
    private long id;
    private String type;
    private String description;
    private double amount;
    private sDate date;

    public Transaction(long id, String type, String description, double amount, sDate date) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public Transaction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public sDate getDate() {
        return date;
    }

    public void setDate(sDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (id != that.id) return false;
        if (Double.compare(that.amount, amount) != 0) return false;
        if (!type.equals(that.type)) return false;
        if (!description.equals(that.description)) return false;
        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
