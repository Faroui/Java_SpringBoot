package ma.n7chat.n7chatservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.n7chat.n7chatservice.enums.Status;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {
    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private Status status;
}
