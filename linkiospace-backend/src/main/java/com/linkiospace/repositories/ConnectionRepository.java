package com.linkiospace.repositories;

import com.linkiospace.entities.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ConnectionRepository extends JpaRepository<Connection, Long> {

    @Query("SELECT c FROM Connection c WHERE c.userOneId = :userOneId")
    Set<Connection> findAllConnectionsOfUserWhoIsOne(Long userOneId);

    @Query("SELECT c FROM Connection c WHERE c.userTwoId = :userTwoId")
    Set<Connection> findAllConnectionsOfUserWhoIsTwo(Long userTwoId);

    @Query("SELECT c FROM Connection c WHERE c.userOneId = :userOneId AND c.userTwoId = :userTwoId")
    Connection findConnectionByUserOneIdAndUserIdTwo(Long userOneId, Long userTwoId);
}
