package trainingJavaPart2.abonentTask;

public class Subscriber {

    private long id;
    private String surname;
    private String name;
    private String middleName;
    private String address;
    private long debitCard;
    private long creditCard;
    private int timeCals;
    private int timeCalsIntercity;


    public Subscriber(){}

    public Subscriber(long id,
                      String surname,
                      String name,
                      String middleName,
                      String address,
                      long debitCard,
                      long creditCard,
                      int timeCals,
                      int timeCalsIntercity) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.address = address;
        this.debitCard = debitCard;
        this.creditCard = creditCard;
        this.timeCals = timeCals;
        this.timeCalsIntercity = timeCalsIntercity;
    }

    public Subscriber(long id,
                      String surname,
                      String name,
                      String middleName,
                      String address,
                      long debitCard,
                      long creditCard,
                      int timeCals) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.address = address;
        this.debitCard = debitCard;
        this.creditCard = creditCard;
        this.timeCals = timeCals;
    }

    public Subscriber(long id,
                      String surname,
                      String name,
                      String middleName,
                      String address,
                      long debitCard,
                      int timeCals) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.address = address;
        this.debitCard = debitCard;
        this.timeCals = timeCals;
    }

    public void getInfo(){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.address = address;
        this.debitCard = debitCard;
        this.creditCard = creditCard;
        this.timeCals = timeCals;
        this.timeCalsIntercity = timeCalsIntercity;

        System.out.println("Полная информация по абоненту: " + id
        + "номер, " + surname
        + "фамилия, " + name
        + "имя, " + middleName
        + "отчество, " + address
        + "адрес, " + debitCard
        + "кредитная карта, " + creditCard
        + "время городских переговоров, " + timeCals
        + "время междугородних переговоров " + timeCalsIntercity);
    }

    public long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getAddress() {
        return address;
    }

    public long getDebitCard() {
        if(Long.toString(debitCard).length() != 10);
        return debitCard;
    }

    public long getCreditCard() {
        if((Long.toString(debitCard).length() != 10));
        return creditCard;
    }

    public int getTimeCals() {
        return timeCals;
    }

    public int getTimeCalsIntercity() {
        return timeCalsIntercity;
    }

    public void setId(long id) {
        if(Long.toString(debitCard).length() != 8);
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDebitCard(long debitCard) {
        this.debitCard = debitCard;
    }

    public void setCreditCard(long creditCard) { this.creditCard = creditCard; }

    public void setTimeCals(int timeCals) {
        this.timeCals = timeCals;
    }

    public void setTimeCalsIntercity(int timeCalsIntercity) {
        this.timeCalsIntercity = timeCalsIntercity;
    }

    public boolean checkTimeCalsIntercity(int timeCalsIntercity){
        if(timeCalsIntercity == 0){
            return false;
        }else {
            return true;
        }
    }

}

