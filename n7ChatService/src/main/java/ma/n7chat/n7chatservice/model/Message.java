package ma.n7chat.n7chatservice.model;

import lombok.*;
import ma.n7chat.n7chatservice.enums.Status;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Message {
    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private Status status;
}