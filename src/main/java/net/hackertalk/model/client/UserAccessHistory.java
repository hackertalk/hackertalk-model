package net.hackertalk.model.client;

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
@Table(schema = "application", name = "user_access_history")
public class UserAccessHistory {

    @Id
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long id;

    @Column(name = "user_id", nullable = false)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long userId;

    @Column(name = "ip", nullable = false, length = 63, updatable = false)
    private String ip; // max 63

    @Lob
    @Column(name = "user_agent", nullable = false, updatable = false)
    private String userAgent; // 4kb - 64kb

    @Column(name = "created_at", nullable = false, updatable = false)
    private Long createdAt;
}
