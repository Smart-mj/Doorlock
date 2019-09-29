
public class DoorlockEngine {

	static final private int INIT_STAGE = 0;
	static final private int INPUT_STAGE = 1;
	private int mCurStage = INIT_STAGE;
	private DoorlockManager mDoorlockManager;
	
	
	public DoorlockEngine() {
		super();
		mDoorlockManager = new DoorlockManager(); 
	}
	
	public void doDoorlock() {
		
		boolean initStage;
		do {
			initStage = mDoorlockManager.initStage();
			if (initStage) {
				mCurStage = INPUT_STAGE;
			} else {
				mCurStage = INIT_STAGE;
			}
		} while (mCurStage == INIT_STAGE);
		
		
		mDoorlockManager.doInputStage();
		while(true);
	}
	

}
