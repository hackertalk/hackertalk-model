package net.hackertalk.model.message;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ChatId implements Serializable {
    private Long senderId;
    private Long recipientId;
    private RecipientType recipientType;
}
