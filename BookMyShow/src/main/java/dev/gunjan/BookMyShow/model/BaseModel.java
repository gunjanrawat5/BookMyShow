package dev.gunjan.BookMyShow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass // Marking this class that all attributes should be present in all child class table
@EntityListeners(AuditingEntityListener.class) // listens to all entity changes - creation/update
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Temporal(value = TemporalType.TIMESTAMP)
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

}
