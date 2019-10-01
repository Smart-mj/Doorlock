import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class Password {

	private static final String PASSWORD_URL = "./password.txt";
	static final int PASSWORD_LIMIT = 12 + 1; // 12ㅈㅏㄹㅣ * = 13
	static final String PASSWORD_CHANGE = "*#";

	// 관습: 멤버변수는 m으로 시작
	private String mPassword;
	private String mInputTempPassword;
	private Scanner scanner = new Scanner(System.in);
	private SecurityHelper mSecurityHelper;

	// 생성자
	public Password() {
		System.out.println("901호 도어락 작동");
		System.out.println("*#을 누르면 비밀번호를 변경할 수 있습니다.");
		
		mSecurityHelper = new SecurityHelper();
		BufferedReader br;
		if (isPasswordSavedFile()) {
			File savedPassword = new File(PASSWORD_URL);
			FileReader fileReader = null;
			try {
				fileReader = new FileReader(savedPassword);
				br = new BufferedReader(fileReader); 
				
				mPassword = br.readLine();
				mPassword = mSecurityHelper.doDecrypt(mPassword);

				System.out.println("loaded password:"+mPassword);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
	}

	public boolean initPassword() {
		boolean isNeedRestart = false;

		inputPassword();
		isNeedRestart = setPassword();
		if (!isNeedRestart) {
			return false;
		}

		inputPassword();
		isNeedRestart = verifyInitialPassword();

		if (!isNeedRestart) {
			return false;
		}

		savePassword();
		
		return true;
	}

	public void inputPassword() {
		this.mInputTempPassword = scanner.nextLine();
	}

	// 비밀번호를 설정하는 부분
	private boolean setPassword() {
		int len = this.mInputTempPassword.length();

		if (len > PASSWORD_LIMIT) {
			System.out.println("12자리를 초과했습니다. 설정 취소");
			return false;
		}

		char lastPassword = this.mInputTempPassword.charAt(len - 1);

		if (lastPassword != '*') {
			System.out.println("비번 끝자리가 *이 아닙니다. 설정 취소");
			return false;
		}

		this.mPassword = this.mInputTempPassword.substring(0, len-1);
		return true;
	}

	// this -> 현재 객체의 주소 (나의 주소!!!)

	private boolean verifyInitialPassword() {
		if (mPassword.equals(mInputTempPassword.substring(0, mInputTempPassword.length()-1))) {
			System.out.println("일치한 비밀번호를 입력하였습니다. 비밀번호가 새로 세팅 되었습니다.");
			return true;
		}

		System.out.println("일치하지 않은 비밀번호를 입력하였습니다.");
		this.mPassword = null;
		return false;
	}

	public boolean verifyPassword() {
		if (mPassword.equals(mInputTempPassword.substring(0, mInputTempPassword.length()-1))) {
			System.out.println("일치한 비밀번호를 입력하였습니다.");
			SoundUtil.playSound(SoundUtil.CORRECT_WAV);
			return true;
		}

		System.out.println("일치하지 않은 비밀번호를 입력하였습니다.");
		SoundUtil.playSound(SoundUtil.FAULT_WAV);
		this.mPassword = null;
		return false;
	}

	// 영구적으로 저장하는 용도
	public void savePassword() {
		System.out.println("savePassword()");
		File saveFile = new File(PASSWORD_URL);
	    try {
	      //파일에 문자열을 쓴다.
	      //하지만 이미 파일이 존재하면 모든 내용을 삭제하고 그위에 덮어쓴다
	      //파일이 손산될 우려가 있다.
	      FileWriter fw = new FileWriter(saveFile);	    
	     
	      fw.write(mSecurityHelper.doEncrypt(mPassword));
	      fw.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}

	public boolean isPasswordSavedFile() {
		File isPasswordSavedFile = new File(PASSWORD_URL);
		
		return isPasswordSavedFile.isFile();
	}

}
