package org.generation.BakesAPI.repository;

import org.generation.BakesAPI.repository.entity.Bakes;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called itemRepository
// CRUD refers Create, Read, Update, Delete
public interface ItemRepository extends CrudRepository<Bakes, Integer>
{
}

