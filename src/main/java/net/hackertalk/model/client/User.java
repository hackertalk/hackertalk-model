package net.hackertalk.model.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "application", name = "user")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long id;

    @Column(nullable = false, length = 64)
    private String nickname;

    @Column(nullable = false, length = 16)
    private String username;

    @Column(nullable = false, length = 256)
    private String bio;

    @Column(nullable = false, length = 32)
    private String avatar;

    @Column(nullable = false, length = 32)
    private String cover;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false, length = 64)
    private String website;

    @Column(nullable = false, length = 32)
    private String location;

    @Column(nullable = false, length = 10)
    private String birthday; // MM/DD/YYYY

    @Column(nullable = false)
    private Boolean verified;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Long createdAt;

    @Column(name = "updated_at", nullable = false)
    private Long updatedAt;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private UserMetrics metrics;

    @Transient
    @JsonProperty
    private Boolean isInternalTestUser;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
