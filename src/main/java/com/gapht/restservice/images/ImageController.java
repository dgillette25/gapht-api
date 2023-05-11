package com.gapht.restservice.images;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gapht.restservice.services.storage.StorageService;


@Controller
@RequestMapping("/images")
public class ImageController {
    private final StorageService storageService;

    public ImageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        storageService.store(file);

        redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

}
