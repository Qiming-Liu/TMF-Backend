package com.thinkmore.forum.controller.v1;

import com.thinkmore.forum.dto.img.ImgGetDto;
import com.thinkmore.forum.entity.Img;
import com.thinkmore.forum.service.ImgService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/v1/img")
@RequiredArgsConstructor
public class ImgController {

    private final ImgService imgService;

    @GetMapping(path = "/get_img")
    public ResponseEntity<List<ImgGetDto>> findAll() {
        List<ImgGetDto> imgList = imgService.getAllImg();
        return ResponseEntity.ok(imgList);
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<ImgGetDto> findId(@PathVariable UUID id) {
        ImgGetDto img = imgService.getImgById(id);
        return ResponseEntity.ok(img);
    }

    @GetMapping(path = "/hash/{md5}")
    public ResponseEntity<ImgGetDto> findHash(@PathVariable String md5) {
        ImgGetDto img = imgService.getImgByHash(md5);
        return ResponseEntity.ok(img);
    }

    @PostMapping(path = "/upload")
    public ResponseEntity<Img> upload(@RequestParam MultipartFile file, @RequestParam String md5) throws Exception {
        return ResponseEntity.ok(imgService.uploadImg(file, md5));
    }
}
