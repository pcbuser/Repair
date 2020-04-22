package carrepair;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="RepairProcessing_table")
public class RepairProcessing {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String carno;
    private String carname;
    private String owername;
    private String reqcontents;
    private String status;
    private Long acceptid;

    @PostPersist
    public void onPostPersist(){
        RepairPlaced repairPlaced = new RepairPlaced();
        BeanUtils.copyProperties(this, repairPlaced);
        repairPlaced.publish();

    }

    @PostUpdate
    public void onPostUpdate(){

        AcceptCanceled acceptCanceled = new AcceptCanceled();
        BeanUtils.copyProperties(this, acceptCanceled);
        acceptCanceled.publish();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno;
    }
    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }
    public String getOwername() {
        return owername;
    }

    public void setOwername(String owername) {
        this.owername = owername;
    }
    public String getReqcontents() {
        return reqcontents;
    }

    public void setReqcontents(String reqcontents) {
        this.reqcontents = reqcontents;
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
