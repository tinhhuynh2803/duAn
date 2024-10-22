package com.example.demo.controller;

import com.example.demo.model.Image;
import com.example.demo.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    private IImageService iImageService;

    @GetMapping
    public List<Image> getAllImage(){
        return iImageService.getAllImage();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable Long id){
        Image image = iImageService.getImageById(id);
        return ResponseEntity.ok(image);
    }

    @PostMapping
    public ResponseEntity<Image> createImage(@RequestBody Image image){
        Image createImage = iImageService.createImage(image);
        return ResponseEntity.ok(createImage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Image> updateImage(@PathVariable Long id, @RequestBody Image image){
        Image updateImage = iImageService.updateImage(id, image);
        return ResponseEntity.ok(updateImage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Image> deleteImage(@PathVariable Long id){
        iImageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}
