package org.generation.BakesAPI.service;

import org.generation.BakesAPI.repository.ItemRepository;
import org.generation.BakesAPI.repository.entity.Bakes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceMySQL
        implements ItemService
{
    private final ItemRepository itemRepository;
    public ItemServiceMySQL( @Autowired ItemRepository itemRepository )
    {
        this.itemRepository = itemRepository;
    }
    @Override
    public Bakes save(Bakes item )
    {
        return itemRepository.save( item );
    }
    @Override
    public void delete( int itemId )
    {
        itemRepository.deleteById( itemId );
    }
    @Override
    public List<Bakes> all()
    {
        List<Bakes> result = new ArrayList<>();
        itemRepository.findAll().forEach( result::add );
        return result;
    }
    @Override
    public Bakes findById(int itemId )
    {
        Optional<Bakes> item = itemRepository.findById(itemId);
        Bakes itemResponse = item.get();
        return itemResponse;
    }
}