package net.hackertalk.model.message;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Recipient {

    private Long id;

    private RecipientType type;

    private String name;

    private String avatar;
}
