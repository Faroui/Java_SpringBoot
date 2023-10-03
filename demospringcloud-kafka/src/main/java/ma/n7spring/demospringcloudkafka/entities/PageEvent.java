package ma.n7spring.demospringcloudkafka.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageEvent {
    private String name;
    private String user;
    private String date;
    private long duration;

}
