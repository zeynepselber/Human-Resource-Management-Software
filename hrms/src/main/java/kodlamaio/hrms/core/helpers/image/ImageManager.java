package kodlamaio.hrms.core.helpers.image;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class ImageManager implements ImageService{

	private Cloudinary cloudinary;
	
	@Autowired
	public ImageManager(Cloudinary cloudinary) {
		this.cloudinary = cloudinary;
	}
	
	@Override
	public DataResult<Map> save(MultipartFile file) {
		try {
			 Map uploadResult = cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());

	         return new SuccessDataResult<Map>(uploadResult);
	         
	     } catch (IOException e) {

	         e.printStackTrace();
	     }
		 return new ErrorDataResult<Map>();
	}

}
