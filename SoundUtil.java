import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundUtil {
	// static ����, static �޼������, ���α׷� ����������� �̸� 
	// static ����(class ����, method ����, ��������)�� ���� �ö󰡰� �ȴ�.
	public static final String CORRECT_WAV = "./correct.wav";
	public static final String FAULT_WAV = "./fault.wav";
	public static final String INIT_FAIL_WAV = "./init_fail.wav";
	
	private SoundUtil () {
		
	}
	
	
	public static void playSound(String url) {
		// FIXME:why null?
		/*
		 new Thread(new Runnable() {
			  // The wrapper thread is unnecessary, unless it blocks on the
			  // Clip finishing; see comments.
			    public void run() {
			      try {	    	  
			        Clip clip = AudioSystem.getClip();
			        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
			          Main.class.getResourceAsStream(url));
			        clip.open(inputStream);
			        clip.start(); 
			      } catch (Exception e) {
			        System.err.println(e.getMessage());
			      }
			    }
			  }).start();
		 */
	}
	
}
