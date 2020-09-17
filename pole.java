package game; 

// ����������� ����������� ��������� 
import javax.imageio.*; 
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.io.*; 


// ����� ������, ������� �������� ������� ����� 
class pole extends JPanel { 
	private Image shapka; // �������� ���������� ������, � ������� ����������� �����
	private Image fon; // �������� ���������� ������, � ������� ����������� ���
	public int x = 500; // �������� ���������� ������, � ������� �����������
	private int slogn; // ���������� ���������
	private podar[] gamePodar; // ������ ��������
	private Image end_game; // ����������� ��������� ����
	public Timer timerUpdate, timerDraw; // ��� ������� 
	public int ct = 0;
	
	// ����������� ������
	public pole(int slogn) {
		this.slogn = slogn;
		// �������� ����� �� �����
		try {
			shapka = ImageIO.read(new File("./shapka.png")); 
			JOptionPane.showMessageDialog(null, "�������� ��� ����� ������� ���������.");	
		}
	    	catch(IOException ex) {
	    		JOptionPane.showMessageDialog(null, "�������� ��� ����� �� ���������.");	
	    }
		
		// �������� ���� �� �����
		try {
			fon = ImageIO.read(new File("./fon.jpg"));
			JOptionPane.showMessageDialog(null, "�������� ���� ���� ������� ���������.");	
		}
			catch(IOException ex) {
				JOptionPane.showMessageDialog(null, "�������� ���� ���� �� ���������.");	
	}
		
		// �������� ��������� ���� �� �����
		try {
			end_game = ImageIO.read(new File("./end_game.jpg"));
			JOptionPane.showMessageDialog(null, "�������� ����� ���� ������� ���������.");	
			}
			catch(IOException ex) {
				JOptionPane.showMessageDialog(null, "�������� ����� ���� �� ���������.");	
		}
		
		// �������� ����������� ��������
		gamePodar = new podar[15];
		for (int i = 0; i < 15; i++) {
			try {
				gamePodar[i] = new podar(ImageIO.read(new File("./p" + i + ".png")));
				JOptionPane.showMessageDialog(null, "�������� �������  � " + i + " ������� ���������.");	
			}
				catch(IOException ex) {
					JOptionPane.showMessageDialog(null, "�������� �������  � " + i + " �� ���������.");				
			}
		}
		
		// �������� �������, ������� �����
		// ��� � ��� ������� ��������� �������
		// � ��������� �� �� ������� ����
		timerUpdate = new Timer(3000, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				// ����� ��� �������� � ���������� �������� �� ������� ����
				updateStart();
			}
		});
		
		timerUpdate.start(); // ������ ������� timerUpdate
		
		// �������� �������, ������� ����� ��������������
		// ������� ���� 20 ��� � �������
		timerDraw = new Timer(50, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				repaint(); // ������ ������ ����������� ���� (public void paintComponent(Graphics gr))
			}
		});
		
		timerDraw.start(); // ������ ������� ��� �����������
		}
	
	// �����, ������� ������������ ����������� ������� �� ������
	public void paintComponent(Graphics gr){
		// ��������� ��������� ������� ������ ����
		super.paintComponent(gr);
		gr.drawImage(fon, 0, 0, null); // ��������� ����
		gr.drawImage(shapka, x, 900, null); // ��������� �����
		// ����, ������� ���������� ������� �� ������� ����
		// � ��������� ����������� �������
		for (int i = 0; i < 7; i++){
			gamePodar[i].draw(gr); // ����������� �������
			if (gamePodar[i].act == true){ // ���� ������� ��������
				// ���� ������� ������ ������ �������:
				if(gamePodar[i].y + gamePodar[i].img.getHeight(null) >= 900)
					if (Math.abs(gamePodar[i].x - x) > 65){ // ���� ������� ��������
						// ����� �������� ��������� ����
						gr.drawImage(end_game, 0, 0, null);
						timerDraw.stop(); // ��������� ������� timerDraw
						timerUpdate.stop();  // ��������� ������� timerUpdate
						break; // ���������� �����
					} else gamePodar[i].act = false; 
					
			}
		}
	}
	
	// ����� ��� �������� � ���������� �������� �� ������� ����
	private void updateStart(){
		int kol = 0; // ���������� ��� �������� �������� �� ������� ����
		for(int i = 0; i < 7; i++){ // ���� �������� ���� �������� �������
			if(gamePodar[i].act == false){ // ���� ������� �� �� ������� ����
				if (kol < slogn){ // ���� ������� ���������� ����� ������ ��������� (�� 1 �� 7)
					// ����������� ������� �� ������� ����,
					// ����� ��� ������ �������� ����
					gamePodar[i].start();
					ct = ct + 1;
					break; // ���������� �����
				}
			} else kol++; // ���� ������� �� ������� ����
		}
	}
}	olukrav@mail.ru ������ ����� ������	