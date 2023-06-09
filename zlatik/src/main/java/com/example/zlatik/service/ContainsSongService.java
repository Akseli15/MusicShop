package com.example.zlatik.service;

import com.example.zlatik.entity.Album;
import com.example.zlatik.entity.ContainsSong;
import com.example.zlatik.entity.Song;
import com.example.zlatik.repository.ContainsSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainsSongService {

    @Autowired
    ContainsSongRepository containsSongRepository;
    @Autowired
    AlbumService albumService;
    @Autowired
    SongService songService;
    public List<ContainsSong> getAll() {
        return containsSongRepository.findAll();
    }

    public ContainsSong getById(Long id_containssong) {
        return containsSongRepository.findById(id_containssong).orElse(null);
    }

    public void create(ContainsSong containsSong) {
        containsSongRepository.save(containsSong);
    }

    public void delete(Long id_containssong) {
        containsSongRepository.deleteById(id_containssong);
    }

    public void update(ContainsSong containsSong) {
        ContainsSong containsSong1 = getById(containsSong.getId());
        Album album = albumService.getByAlbumName(containsSong.getAlbum().getAlbumName());
        Song song = songService.getBySongName(containsSong.getSong().getSongName());
        containsSong1.setAlbum(album);
        containsSong1.setSong(song);
        containsSongRepository.save(containsSong1);
    }
}
