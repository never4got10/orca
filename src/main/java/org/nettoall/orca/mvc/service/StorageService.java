package org.nettoall.orca.mvc.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {
    public void init();
    public void store(MultipartFile file);
    public Stream<Path> loadAll();
    public Path load(String filename);
    public Resource loadAsResouce(String filename);
    public void deleteAll();

}