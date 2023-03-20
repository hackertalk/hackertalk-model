package net.hackertalk.model.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import net.hackertalk.data.TargetType;
import net.hackertalk.data.client.User;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "application", name = "report")
public class Report {

    @Id
    @Column(nullable = false, unique = true)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(as = Long.class)
    private Long id;

    @Column(name = "from_id", nullable = false, updatable = false)
    private Long fromId;

    @Column(name = "target_id", nullable = false, updatable = false)
    private Long targetId;

    @Column(name = "target_type", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private TargetType targetType;

    @Column(name = "report_type", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private ReportType reportType;

    @Column(nullable = false, updatable = false, length = 2048)
    private String content;

    @Column(nullable = false)
    private Boolean pending;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Long createdAt;

    @Column(name = "updated_at", nullable = false)
    private Long updatedAt;

    @ManyToOne
    @JoinColumn(name = "from_id", referencedColumnName = "id", updatable = false, insertable = false)
    private User from;

    @Transient
    @JsonProperty
    private Object target;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return id != null && Objects.equals(id, report.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
