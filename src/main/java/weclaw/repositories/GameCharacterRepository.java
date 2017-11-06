package weclaw.repositories;

import org.springframework.data.repository.CrudRepository;

import weclaw.domain.GameCharacter;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface GameCharacterRepository extends CrudRepository<GameCharacter, Long> {

}