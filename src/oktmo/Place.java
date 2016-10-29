package oktmo;

/**
 * Created by designAi on 18.10.2016.
 */
public class Place {
    private long code;
    private String name;
    private String status;

    public Place(long code, String name, String status){
        this.code = code;
        this.name = name;
        this.status = status;
    }

    public long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object obj) {
        Place other =(Place) obj;

        return code==other.getCode();
    }
}
