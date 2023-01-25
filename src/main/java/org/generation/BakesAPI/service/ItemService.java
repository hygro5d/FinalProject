package org.generation.BakesAPI.service;

import org.generation.BakesAPI.repository.entity.Bakes;

import java.util.List;

public interface ItemService {

        Bakes save(Bakes item );

        void delete( int itemId );

        List<Bakes> all();

        Bakes findById(int itemId );

    }
