
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

		// password: ����������, ���� ������ Password ��ü�� �ּҸ� ���� �� �ִ�.
		// password�� �޸� ��� ��ġ�ϴ°�? -> ���� (���������� �����ϴ� ��)
		// password�� ������ ������, ��ü�� �ƴ�
		// ������ ������� ����, ��ü�� �ּҸ� ��� �׸��̴�.
		// Scanner scanner = new Scanner(System.in);
		// Password password;

		// password�� main method���� ���������̴�.
		// ��ü�� ������ new �����;߸� ������!!
		// new�� �������� Password Ŭ������ �ν��Ͻ��� �����Ǿ� Heap �� �Ҵ�Ȥ���.
		// String password, �� �װ� �������ִ� Method��
		// �ڹٿ��� ��ü�������(new ���ϸ�) ��ü�� ����� ���� �ּ� (������ �ּ�)�� ��ȯ�Ѵ�.
		// ������ ������, ���� ������ ��ü�� �ּҸ� ���� �� �ִ�.
		// new Password(); // -> 1�� Password ��ü ���� ����, �ٸ� ������ ����
		// 2�� Password ��ü, ������ ���� password�� ���ؼ� ���ٰ���

		DoorlockEngine doorlockEngine = new DoorlockEngine();
		doorlockEngine.doDoorlock();

	}

}
