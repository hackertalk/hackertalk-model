package net.hackertalk.model.client;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserPoints {

    private Long id;

    private Integer level;

    private Integer total;

    private Boolean hasCheckIn;
}
