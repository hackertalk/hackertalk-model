package net.hackertalk.model.draft;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DraftTagId implements Serializable {
    private Long draftId;
    private Long tagId;
}
