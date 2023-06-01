package com.example.zlatik.controller;

import com.example.zlatik.entity.Album;
import com.example.zlatik.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @Async
    @GetMapping("")
    public String test(Model model) {
        model.addAttribute("albums", albumService.getAllAlbums());
        return "album";
    }
    @Async
    @GetMapping("/{title}")
    public Album getAlbumByTitle(@PathVariable("title") String title) {
        return albumService.getAlbumByTitle(title);
    }
    @Async
    @PostMapping
    public Album createAlbum(@RequestBody Album album) {
            return albumService.createAlbum(album);
        }
    @Async
    @DeleteMapping("/{title}")
    public void deleteAlbum(@PathVariable("title") String title) {
        albumService.deleteAlbum(title);
        }
    @Async
    @GetMapping("/album/edit")
    public String editAlbum(@PathVariable("id") String id, Model model) {
        Album album = albumService.getAlbumByTitle(id);
        Map<String, Object> entityFields = createFieldsForAlbum(album);
        model.addAttribute("entity", entityFields);
        return "edit-entity";
    }

    private Map<String, Object> createFieldsForAlbum(Album album) {
        Map<String, Object> entityFields = new HashMap<>();
        entityFields.put("ID", album.getId());
        entityFields.put("Дата выпуска", album.getReleaseDate());
        entityFields.put("Продолжительность", album.getDuration());
        return entityFields;
    }
}
