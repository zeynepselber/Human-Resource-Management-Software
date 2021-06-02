package kodlamaio.hrms.core.config;

import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.helpers.image.ImageManager;
import kodlamaio.hrms.core.helpers.image.ImageService;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public ImageService imageService() {
		return new ImageManager(cloudinary());
	}

	@Bean
	public Cloudinary cloudinary() {
		return new Cloudinary(ObjectUtils.asMap("cloud_name", "kodlamaiohrms",
				                                "api_key"   , "287684365911499", 
				                                "api_secret", "4uDj9JVZWqENiiMXnHl5e8n3j8Q"));
	}

}
