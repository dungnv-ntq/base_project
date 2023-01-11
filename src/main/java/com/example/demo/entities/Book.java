package com.example.demo.entities;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Data
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "update books set status = 'DELETED' where id = ?")
@Where(clause = "status != 'DELETED' or status IS NULL  ")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @Fetch(value = FetchMode.JOIN)
    private Author author;
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private String status;

    @PreRemove
    public void removeBook() {
        this.status = "DELETED";
    }
}
