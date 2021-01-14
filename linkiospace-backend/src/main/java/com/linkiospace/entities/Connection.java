package com.linkiospace.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "connections")
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "users_connections",
            joinColumns = @JoinColumn(name = "connection_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User userOne;

    @Column(name = "user_one_id")
    private Long userOneId;

    @Column(name = "user_two_id")
    private Long userTwoId;

    @Column(name = "connection_date")
    private LocalDate connectionDate;

    public Connection() {
    }

    public Connection(Long userOneId, Long userTwoId, LocalDate connectionDate) {
        this.userOneId = userOneId;
        this.userTwoId = userTwoId;
        this.connectionDate = connectionDate;
    }

    public Connection(Long userOneId, Long userTwoId) {
        this.userOneId = userOneId;
        this.userTwoId = userTwoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserOne() {
        return userOne;
    }

    public void setUserOne(User userOne) {
        this.userOne = userOne;
    }

    public Long getUserOneId() {
        return userOneId;
    }

    public void setUserOneId(Long userOneId) {
        this.userOneId = this.userOne.getId();
    }

    public Long getUserTwoId() {
        return userTwoId;
    }

    public void setUserTwoId(Long userTwoId) {
        this.userTwoId = userTwoId;
    }

    public LocalDate getConnectionDate() {
        return connectionDate;
    }

    public void setConnectionDate(LocalDate connectionDate) {
        this.connectionDate = connectionDate;
    }
}