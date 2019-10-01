
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import sun.audio.*; //import the sun.audio package
import java.io.*;

public class Main {

	public static void main(String[] args) {

		/*
		 * SoundManager sm = new SoundManager(); sm.playSound(SoundManager.CORRECT_WAV);
		 */

		// password: 참조형변수, 힙에 생성된 Password 객체의 주소를 담을 수 있다.
		// password는 메모리 어디에 위치하는가? -> 스택 (지역변수를 저장하는 곳)
		// password는 참조형 변수지, 객체가 아님
		// 참조형 변수라는 말은, 객체의 주소를 담는 그릇이다.
		// Scanner scanner = new Scanner(System.in);
		// Password password;

		// password는 main method에서 지역변수이다.
		// 객체는 무조건 new 가나와야만 생성됨!!
		// new를 만난순간 Password 클래스의 인스턴스가 생성되어 Heap 에 할당된ㄷ다.
		// String password, 와 그가 가지고있는 Method들
		// 자바에서 객체를만들면(new 를하면) 객체가 저장된 힙의 주소 (참조형 주소)를 반환한다.
		// 참조형 변수가, 힙에 생성된 객체의 주소를 가질 수 있다.
		// new Password(); // -> 1번 Password 객체 힙에 생성, 다만 접근을 못함
		// 2번 Password 객체, 참조형 변수 password를 통해서 접근가능

		DoorlockEngine doorlockEngine = new DoorlockEngine();
		doorlockEngine.doDoorlock();

	}

}
