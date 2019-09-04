package com.example.SpringBoot.Controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.SpringBoot.Model.StockPrice;
import com.example.SpringBoot.Service.UploadExcelService;



@RestController
public class UploadExcelController {
	@Autowired
	private UploadExcelService uploadService;

	@PostMapping("/upload")
	public List<StockPrice> upload(@RequestParam("file") MultipartFile file) throws Exception {
		return uploadService.upload(file);
	}


}
