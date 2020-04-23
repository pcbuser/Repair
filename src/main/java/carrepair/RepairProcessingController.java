package carrepair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 @RestController
 public class RepairProcessingController {
  @Autowired
  RepairProcessingRepository repairProcessingRepository;

  //@RequestMapping(method= RequestMethod.PATCH, path="/repairProcessings")
  @RequestMapping(method= RequestMethod.PATCH, path="/repairProcessings/cancel")
  //@RequestMapping(method= RequestMethod.PATCH, path="/cancel")
  public void repairCancel(@RequestBody  RepairProcessing repairProcessing) {

   //System.out.println("log : "+repairProcessing.getStatus());
   //System.out.println("log : "+repairProcessing.getId().toString());

   RepairProcessing rp = new RepairProcessing();
   rp.setStatus(repairProcessing.getStatus());
   rp.setId(repairProcessing.getId());


   repairProcessingRepository.save(rp);
  }

 }
