package com.linkiospace.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(UsersConnections.class)
@Table(name = "users_connections")
public class UsersConnections implements Serializable {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "connection_id")
    private Long connectionId;

    public UsersConnections() {
    }

    public UsersConnections(Long userId, Long connectionId) {
        this.userId = userId;
        this.connectionId = connectionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(Long connectionId) {
        this.connectionId = connectionId;
    }
}
