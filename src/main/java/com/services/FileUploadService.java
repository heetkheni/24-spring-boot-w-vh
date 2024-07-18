package com.services;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	public void uploadProductImage(MultipartFile multipartFile) {

		System.out.println(multipartFile.getOriginalFilename());

		String path = "D:\\spring_project\\24-spring-boot-w-vh\\src\\main\\webapp\\WEB-INF\\images\\productPic";

		try {

			byte[] b;

			b = multipartFile.getBytes();

			File file = new File(path, multipartFile.getOriginalFilename());

			FileUtils.writeByteArrayToFile(file, b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uploadProfilePic(MultipartFile multipartFile, String email) {

		System.out.println(multipartFile.getOriginalFilename());

		String path = "D:\\spring_project\\24-spring-boot-w-vh\\src\\main\\webapp\\WEB-INF\\images\\userProfilePic";

		File dir = new File(path, email);
		dir.mkdir();

		try {

			byte[] b;

			b = multipartFile.getBytes();

			File file = new File(dir, multipartFile.getOriginalFilename());

			FileUtils.writeByteArrayToFile(file, b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
