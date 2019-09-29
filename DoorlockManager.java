
public class DoorlockManager {
	
	private Password mPassword;
	
	DoorlockManager() {
	
	}
	
	public boolean initStage() {
		mPassword = new Password();
		boolean isPasswordSavedFile = mPassword.isPasswordSavedFile();
		if (isPasswordSavedFile) {
			System.out.println("�ʱ� ��й�ȣ�� �����Ǿ��ֽ��ϴ�.");
			return true;
		} else {
			return mPassword.initPassword();
		}
	}
	
	public void doInputStage() {
		System.out.println("��й�ȣ �Է´ܰ��Դϴ�.");
		mPassword.inputPassword();
		mPassword.verifyPassword();
	}
	

}
