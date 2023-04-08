package net.hackertalk.model.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@IdClass(IdentityId.class)
@Table(schema = "application", name = "user_auth")
public class UserAuth {

    @Id
    @Column(name = "identity_type", nullable = false, length = 8)
    @Enumerated(EnumType.STRING)
    private IdentityType identityType;

    @Id
    @Column(name = "identifier", nullable = false, length = 32)
    private String identifier;    // email address, phone number, openid

    @Column(name = "user_id", nullable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long userId;

    @Column(name = "credential", nullable = false, length = 256)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String credential;    // pass_hash or access_token

    @Column(name = "refresh_credential", nullable = false, length = 256)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String refreshCredential; // refresh token

    @Column(name = "created_at", nullable = false, updatable = false)
    private Long createdAt;

    @Column(name = "updated_at", nullable = false)
    private Long updatedAt;
}
