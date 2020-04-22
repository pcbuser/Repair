package carrepair;

public class RepairCanceled extends AbstractEvent {

    private Long id;
    private String status;
    private Long acceptid;

    public RepairCanceled(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Long getAcceptid() {
        return acceptid;
    }

    public void setAcceptid(Long acceptid) {
        this.acceptid = acceptid;
    }
}
