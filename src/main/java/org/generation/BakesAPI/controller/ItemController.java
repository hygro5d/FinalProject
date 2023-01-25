package org.generation.BakesAPI.controller;

import org.generation.BakesAPI.component.*;
import org.generation.BakesAPI.controller.dto.*;
import org.generation.BakesAPI.component.FileUploadUtil;
import org.generation.BakesAPI.controller.dto.ItemDTO;
import org.generation.BakesAPI.repository.entity.Bakes;
import org.generation.BakesAPI.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import java.io.*;
@RestController
@RequestMapping("/item")
public class ItemController {
    @Value("${image.folder}")
    private String imageFolder;

    private final ItemService itemService;

    public ItemController(@Autowired ItemService itemService)
    {
        this.itemService = itemService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Bakes> getItems()
    {
        return itemService.all();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Bakes findItemById(@PathVariable Integer id)
    {
        return itemService.findById( id );
    }

    @PutMapping( "/{id}" )
    public Bakes update( @RequestBody ItemDTO itemDto, @PathVariable Integer id )
    {
        Bakes item = itemService.findById( id );
        item.setName( itemDto.getName() );
        item.setDescription( itemDto.getDescription() );
        item.setImageUrl( itemDto.getImageUrl() );
        item.setPrice( itemDto.getPrice() );
        item.getBakeType( itemDto.getBakeType() );
        return itemService.save( item );
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id)
    {
        itemService.delete(id);
    }

    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="name", required = true) String name,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="imageUrl", required = true) String imageUrl,
                       @RequestParam(name="price", required = true) double price,
                       @RequestParam(name="bakeType", required = true) String bakeType,
                       @RequestParam("imagefile") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        FileUploadUtil.saveFile(imageFolder, fileName, multipartFile);

        String fullPath = imageFolder + '/' + imageUrl;

        ItemDTO itemDto = new ItemDTO(name, description, fullPath, price, bakeType);
        itemService.save(new Bakes(itemDto));
    }
}