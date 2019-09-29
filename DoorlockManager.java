
public class DoorlockManager {
	
	private Password mPassword;
	
	DoorlockManager() {
	
	}
	
	public boolean initStage() {
		mPassword = new Password();
		boolean isPasswordSavedFile = mPassword.isPasswordSavedFile();
		if (isPasswordSavedFile) {
			System.out.println("초기 비밀번호가 설정되어있습니다.");
			return true;
		} else {
			return mPassword.initPassword();
		}
	}
	
	public void doInputStage() {
		System.out.println("비밀번호 입력단계입니다.");
		mPassword.inputPassword();
		mPassword.verifyPassword();
	}
	

}
