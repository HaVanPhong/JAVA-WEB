package com.hithaui.Helper;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

import com.hithaui.DAO.Districts;
import com.hithaui.DAO.Provinces;
import com.hithaui.DTO.DistrictsDTO;
import com.hithaui.DTO.ProvincesDTO;

public class ConvertObject {

	private static final Pattern NON_LATIN = Pattern.compile("[^\\w-]");

	private static final Pattern WHITE_SPACE = Pattern.compile("[\\s]");

	public static String toSlug(String input) {
		input = input.trim().replaceAll("\\s+", " ");
		String noWhiteSpace = WHITE_SPACE.matcher(input).replaceAll("-");
		String normalized = Normalizer.normalize(noWhiteSpace, Normalizer.Form.NFD);
		String slug = NON_LATIN.matcher(normalized).replaceAll("");
		return slug.toLowerCase(Locale.ENGLISH);
	}

	public static String slugify(String input) {
		return input.toLowerCase().replaceAll("[á|à|ả|ạ|ã|ă|ắ|ằ|ẳ|ẵ|ặ|â|ấ|ầ|ẩ|ẫ|ậ|ä|å|æ|ą]", "a")
				.replaceAll("[ó|ò|ỏ|õ|ọ|ô|ố|ồ|ổ|ỗ|ộ|ơ|ớ|ờ|ở|ỡ|ợ|ö|ô|œ|ø]", "o")
				.replaceAll("[é|è|ẻ|ẽ|ẹ|ê|ế|ề|ể|ễ|ệ|ě|ė|ë|ę]", "e").replaceAll("[ú|ù|ủ|ũ|ụ|ư|ứ|ừ|ử|ữ|ự]", "u")
				.replaceAll("[i|í|ì|ỉ|ĩ|ị|ï|î|į]", "i").replaceAll("[ù|ú|ü|û|ǘ|ů|ű|ū|ų]", "u")
				.replaceAll("[ß|ş|ś|š|ș]", "s").replaceAll("[ź|ž|ż]", "z").replaceAll("[ý|ỳ|ỷ|ỹ|ỵ|ÿ|ý]", "y")
				.replaceAll("[ǹ|ń|ň|ñ]", "n").replaceAll("[ç|ć|č]", "c").replaceAll("[ğ|ǵ]", "g")
				.replaceAll("[ŕ|ř]", "r").replaceAll("[·|/|_|,|:|;]", "-").replaceAll("[ť|ț]", "t").replaceAll("ḧ", "h")
				.replaceAll("ẍ", "x").replaceAll("ẃ", "w").replaceAll("ḿ", "m").replaceAll("ṕ", "p")
				.replaceAll("ł", "l").replaceAll("đ", "d").replaceAll("\\s+", "-").replaceAll("&", "-and-")
				.replaceAll("[^\\w\\-]+", "").replaceAll("\\-\\-+", "-").replaceAll("^-+", "").replaceAll("-+$", "");
	}

	

	public static Provinces ConvertProvinceDTOtoDAO(ProvincesDTO provincesDTO) {
		String name = provincesDTO.getName();

		String slug = slugify(provincesDTO.getName());

		String type = provincesDTO.getType();

		String name_with_type = type.compareTo("tinh")==0?"Tỉnh "+name:"Thành Phố "+name;

		String code = provincesDTO.getCode();

		Provinces provinces2 = new Provinces(name, slug, type, name_with_type, code);

		return provinces2;
	}
	public static Districts ConvertDistrictDTOtoDAO(DistrictsDTO districtsDTO) {
		String name=districtsDTO.getName();
		String slug= slugify(name);
		String code=districtsDTO.getCode();
		String type=districtsDTO.getType();
		String parentCode=districtsDTO.getParent_code();
		Districts districts=new Districts();
		districts.setName(name);
		districts.setType(type);
		districts.setSlug(slug);
		districts.setCode(code);
		if(districtsDTO.getType().compareTo("quan")==0) {
			districts.setName_with_type("Quận "+name);
		}else if (districtsDTO.getType().compareTo("huyen")==0){
			districts.setName_with_type("Huyện "+name);
		}else {
			districts.setName_with_type("Thành Phố "+name);
		}
		districts.setParent_code(parentCode);
		return districts;		
	}

}
