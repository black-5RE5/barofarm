package com.barofarm.fish.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// 수정중
@Getter @Setter @Data
public class UserVo {
	// 수정중
	@Pattern(regexp="^[a-zA-Z0-9_]{5,20}", message="영문,숫자,_만을 사용하세요")
	private String user_id = null;
	// 수정중
	@NotBlank(message="비밀번호는 필수 입력값입니다.")
	@Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\\\W)(?=\\\\S+$).{8,20}",message="영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 ")
	private String user_pass = null;
	// 수정중
	@Email(message="이메일 형식으로 입력 해주세요") @NotEmpty
	private String user_email = null;
	// 수정중
	@Pattern(regexp="^[ㄱ-힣]{1,10}", message="올바른 이름을 입력하세요")
	private String user_name = null;
	
	private String user_phone = null;
	private String user_gender = null;
	private int user_grade = 0;
	
}
