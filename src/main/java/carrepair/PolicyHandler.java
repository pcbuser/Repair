package carrepair;

import carrepair.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired
    RepairProcessingRepository repairProcessingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAcceptPlaced_RepairtStart(@Payload AcceptPlaced acceptPlaced){

        if(acceptPlaced.isMe()){
            RepairProcessing repairProcessing = new RepairProcessing();
            repairProcessing.setCarno(acceptPlaced.getCarno());
            repairProcessing.setCarname((acceptPlaced.getCarname()));
            repairProcessing.setOwername(acceptPlaced.getOwnername());
            repairProcessing.setReqcontents(acceptPlaced.getReqcontents());
            repairProcessing.setStatus(acceptPlaced.getStatus());
            repairProcessing.setAcceptid(acceptPlaced.getId());

            repairProcessingRepository.save(repairProcessing);




            //System.out.println("##### listener RepairtStart : " + acceptPlaced.toJson());
        }
    }

}
