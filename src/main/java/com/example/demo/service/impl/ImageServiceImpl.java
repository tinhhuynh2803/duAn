package com.example.demo.service.impl;

import com.example.demo.model.Image;
import com.example.demo.repository.ImageRepository;
import com.example.demo.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements IImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Image> getAllImage() {
        return imageRepository.findAll();
    }

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id).orElseThrow();
    }

    @Override
    public Image createImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image updateImage(Long id, Image image) {
        Image existingImage = imageRepository.findById(id).orElseThrow();
        existingImage.setImageName(image.getImageName());
        existingImage.setImageUrl(image.getImageUrl());
        return imageRepository.save(existingImage);
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}
