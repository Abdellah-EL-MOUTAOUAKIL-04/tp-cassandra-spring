package ma.abdellah.tpcassandraspring.repository;

import ma.abdellah.tpcassandraspring.entities.User;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface UserRepository extends CassandraRepository<User, UUID> {
}
