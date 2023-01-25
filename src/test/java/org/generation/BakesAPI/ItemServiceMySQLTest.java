package org.generation.BakesAPI;

import org.generation.BakesAPI.repository.ItemRepository;
import org.generation.BakesAPI.repository.entity.Bakes;
import org.generation.BakesAPI.service.ItemService;
import org.generation.BakesAPI.service.ItemServiceMySQL;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
@TestInstance( TestInstance.Lifecycle.PER_CLASS)
public class ItemServiceMySQLTest
{

    @Mock
    ItemRepository itemRepository;

    ItemService itemService;

    @BeforeAll
    public void setup()
    {
        itemService = new ItemServiceMySQL( itemRepository );
    }

    @Test
    public void saveCallsItemsRepositorySave()
    {
        Bakes itemMock = mock( Bakes.class );
        itemService.save( itemMock );
        verify( itemRepository ).save( itemMock );
    }
}