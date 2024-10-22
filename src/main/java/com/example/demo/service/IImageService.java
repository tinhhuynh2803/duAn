package com.example.demo.service;

import com.example.demo.model.Image;

import java.util.List;

public interface IImageService {

    public List<Image> getAllImage();
    public Image getImageById(Long id);
    public Image createImage(Image image);
    public Image updateImage(Long id, Image image);
    public void deleteImage(Long id);
}
