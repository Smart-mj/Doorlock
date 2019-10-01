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
	static final int PASSWORD_LIMIT = 12 + 1; // 12�������� * = 13
	static final String PASSWORD_CHANGE = "*#";

	// ����: ��������� m���� ����
	private String mPassword;
	private String mInputTempPassword;
	private Scanner scanner = new Scanner(System.in);
	private SecurityHelper mSecurityHelper;

	// ������
	public Password() {
		System.out.println("901ȣ ����� �۵�");
		System.out.println("*#�� ������ ��й�ȣ�� ������ �� �ֽ��ϴ�.");
		
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

	// ��й�ȣ�� �����ϴ� �κ�
	private boolean setPassword() {
		int len = this.mInputTempPassword.length();

		if (len > PASSWORD_LIMIT) {
			System.out.println("12�ڸ��� �ʰ��߽��ϴ�. ���� ���");
			return false;
		}

		char lastPassword = this.mInputTempPassword.charAt(len - 1);

		if (lastPassword != '*') {
			System.out.println("��� ���ڸ��� *�� �ƴմϴ�. ���� ���");
			return false;
		}

		this.mPassword = this.mInputTempPassword.substring(0, len-1);
		return true;
	}

	// this -> ���� ��ü�� �ּ� (���� �ּ�!!!)

	private boolean verifyInitialPassword() {
		if (mPassword.equals(mInputTempPassword.substring(0, mInputTempPassword.length()-1))) {
			System.out.println("��ġ�� ��й�ȣ�� �Է��Ͽ����ϴ�. ��й�ȣ�� ���� ���� �Ǿ����ϴ�.");
			return true;
		}

		System.out.println("��ġ���� ���� ��й�ȣ�� �Է��Ͽ����ϴ�.");
		this.mPassword = null;
		return false;
	}

	public boolean verifyPassword() {
		if (mPassword.equals(mInputTempPassword.substring(0, mInputTempPassword.length()-1))) {
			System.out.println("��ġ�� ��й�ȣ�� �Է��Ͽ����ϴ�.");
			SoundUtil.playSound(SoundUtil.CORRECT_WAV);
			return true;
		}

		System.out.println("��ġ���� ���� ��й�ȣ�� �Է��Ͽ����ϴ�.");
		SoundUtil.playSound(SoundUtil.FAULT_WAV);
		this.mPassword = null;
		return false;
	}

	// ���������� �����ϴ� �뵵
	public void savePassword() {
		System.out.println("savePassword()");
		File saveFile = new File(PASSWORD_URL);
	    try {
	      //���Ͽ� ���ڿ��� ����.
	      //������ �̹� ������ �����ϸ� ��� ������ �����ϰ� ������ �����
	      //������ �ջ�� ����� �ִ�.
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
