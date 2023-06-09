package com.example.zlatik.service;

import com.example.zlatik.entity.Album;
import com.example.zlatik.entity.Artist;
import com.example.zlatik.entity.ContainsArtist;
import com.example.zlatik.repository.ContainsArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContainsArtistService {

    @Autowired
    ContainsArtistRepository containsArtistRepository;
    @Autowired
    AlbumService albumService;
    @Autowired
    ArtistService artistService;
    public List<ContainsArtist> getAll() {
        return containsArtistRepository.findAll();
    }

    public ContainsArtist getById(Long id_containsartist) {
        return containsArtistRepository.findById(id_containsartist).orElse(null);
    }

    public void create(ContainsArtist containsArtist) {
        containsArtistRepository.save(containsArtist);
    }

    public void delete(Long id_containsartist) {
        containsArtistRepository.deleteById(id_containsartist);
    }

    public void update(ContainsArtist containsArtist) {
        ContainsArtist containsArtist1 = getById(containsArtist.getId());
        Album album = albumService.getByAlbumName(containsArtist.getAlbum().getAlbumName());
        Artist artist = artistService.getByArtistName(containsArtist.getArtist().getArtistName());
        containsArtist1.setAlbum(album);
        containsArtist1.setArtist(artist);
        containsArtistRepository.save(containsArtist1);
    }
}

