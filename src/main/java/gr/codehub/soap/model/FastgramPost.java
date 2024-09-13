package gr.codehub.soap.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FastgramPost {
    private Integer id;
    private String user;
    private Date date;
    private String content;
    private int views;
    
    public FastgramPost increaseViews() {
        views++;
        return this;
    }
}
