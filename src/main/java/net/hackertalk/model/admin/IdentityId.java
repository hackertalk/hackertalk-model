package net.hackertalk.model.admin;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class IdentityId implements Serializable {

    private IdentityType identityType;

    private String identifier;
}
