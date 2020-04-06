package misc;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class alpa3 extends JFrame {

	public JPanel contentPane;
	public static JTextField textField[];
	public static JTextField textField_met[];
	public static JTextField textField_weld[];
	public JLabel lblNewLabel[];
	public JLabel lblNewLabel_met[];
	public JLabel lblNewLabel_weld[];
	public JMenuBar mb;
	public final static int BUTTON_SIZE_1 = 18;
	public final static int BUTTON_SIZE_met = 8;
	public final static int BUTTON_SIZE_weld = 2;

	JLabel ImgBox;

	private final static int img_p_y = 50;
	private final static int img_s_x = 250;
	private final static int img_s_y = 250;

	private final static int P_Geo_p_y = 25;
	private final static int P_Geo_s_x = 350;
	private final static int P_Geo_s_y = 487;

	private final static int P_met_p_y = 25;
	private final static int P_met_s_x = 350;
	private final static int P_met_s_y = 240;

	private final static int P_weld_p_y = 275;
	private final static int P_weld_s_x = 350;
	private final static int P_weld_s_y = 72;

	private final static int P_1st_raw = 10;
	private final static int P_2nd_raw = img_s_x + 20;
	private final static int P_3rd_raw = P_2nd_raw + P_Geo_s_x + 10;

	private final static int Frame_size_x = P_3rd_raw + P_weld_s_x + 20;
	private final static int Frame_size_y = 562;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					alpa3 frame = new alpa3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public alpa3() {
		setTitle("alpa 3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, Frame_size_x, Frame_size_y);

		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(P_2nd_raw, P_Geo_p_y, P_Geo_s_x, P_Geo_s_y);
		panel.setBorder(new TitledBorder(new LineBorder(Color.gray, 1), "Geometry Property"));
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_met = new JPanel();
		panel_met.setBounds(P_3rd_raw, P_met_p_y, P_met_s_x, P_met_s_y);
		panel_met.setBorder(new TitledBorder(new LineBorder(Color.gray, 1), "Material Property"));
		contentPane.add(panel_met);
		panel_met.setLayout(null);

		JPanel panel_weld = new JPanel();
		panel_weld.setBounds(P_3rd_raw, P_weld_p_y, P_weld_s_x, P_weld_s_y);
		panel_weld.setBorder(new TitledBorder(new LineBorder(Color.gray, 1), "Welding Parameter"));
		contentPane.add(panel_weld);
		panel_weld.setLayout(null);

		textField = new JTextField[BUTTON_SIZE_1];

		lblNewLabel = new JLabel[BUTTON_SIZE_1];

		for (int i = 0; i < BUTTON_SIZE_1; i++) {
			lblNewLabel[i] = new JLabel();
			lblNewLabel[i].setBounds(13, 20 + i * 26, 200, 15);
			panel.add(lblNewLabel[i]);

			textField[i] = new JTextField();
			textField[i].setBounds(210, 17 + i * 26, 130, 21);
			panel.add(textField[i]);
			textField[i].setColumns(10);
			textField[i].setHorizontalAlignment(JTextField.RIGHT);
		}
		lblNewLabel[0].setText("전체 높이(mm)");
		lblNewLabel[1].setText("1번 Skin 높이(mm)");
		lblNewLabel[2].setText("1번 Skin 위치(mm)");
		lblNewLabel[3].setText("2번 Skin 높이(mm)");
		lblNewLabel[4].setText("2번 Skin 위치(mm)");
		lblNewLabel[5].setText("Skin 두께(mm)");
		lblNewLabel[6].setText("Top Frame 높이(mm)");
		lblNewLabel[7].setText("Top Frame 세로 두께 (mm)");
		lblNewLabel[8].setText("Top Frame 가로 두께 (mm)");
		lblNewLabel[9].setText("Top Frame 바깥지름(mm)");
		lblNewLabel[10].setText("Top Frame 안지름(mm)");
		lblNewLabel[11].setText("Mid Frame 높이(mm)");
		lblNewLabel[12].setText("Mid Frame 두께(mm)");
		lblNewLabel[13].setText("Bottom Frame 높이(mm)");
		lblNewLabel[14].setText("Bottom Frame 바깥지름(mm)");
		lblNewLabel[15].setText("Bottom Frame 안지름(mm)");
		lblNewLabel[16].setText("Elemental Size(mm)");
		lblNewLabel[17].setText("Elemental 회전 각도(drg)");

		textField[0].setText("2000");
		textField[1].setText("900");
		textField[2].setText("20");
		textField[3].setText("920");
		textField[4].setText("100");
		textField[5].setText("2.6");
		textField[6].setText("60");
		textField[7].setText("10");
		textField[8].setText("10");
		textField[9].setText("1400");
		textField[10].setText("1300");
		textField[11].setText("100");
		textField[12].setText("50");
		textField[13].setText("200");
		textField[14].setText("1700");
		textField[15].setText("1500");
		textField[16].setText("20");
		textField[17].setText("5");

		textField_met = new JTextField[BUTTON_SIZE_met];

		lblNewLabel_met = new JLabel[BUTTON_SIZE_met];

		for (int i = 0; i < BUTTON_SIZE_met; i++) {
			lblNewLabel_met[i] = new JLabel();
			lblNewLabel_met[i].setBounds(13, 20 + i * 26, 200, 15);
			panel_met.add(lblNewLabel_met[i]);

			textField_met[i] = new JTextField();
			textField_met[i].setBounds(210, 17 + i * 26, 130, 21);
			panel_met.add(textField_met[i]);
			textField_met[i].setColumns(10);
			textField_met[i].setHorizontalAlignment(JTextField.RIGHT);
		}

		lblNewLabel_met[0].setText("Skin Density");
		lblNewLabel_met[1].setText("Skin Elastic");
		lblNewLabel_met[2].setText("Skin Poissom's Ratio");
		lblNewLabel_met[3].setText("Skin Thermal Expansion");
		lblNewLabel_met[4].setText("Frame Density");
		lblNewLabel_met[5].setText("Frame Elastic");
		lblNewLabel_met[6].setText("Frame Poissom's Ratio");
		lblNewLabel_met[7].setText("Frame Thermal Expansion");

		textField_met[0].setText("7850");
		textField_met[1].setText("212000");
		textField_met[2].setText("0.3");
		textField_met[3].setText("0.00001");
		textField_met[4].setText("7850");
		textField_met[5].setText("212000");
		textField_met[6].setText("0.3");
		textField_met[7].setText("0.00001");

		textField_weld = new JTextField[BUTTON_SIZE_weld];

		lblNewLabel_weld = new JLabel[BUTTON_SIZE_weld];

		for (int i = 0; i < BUTTON_SIZE_weld; i++) {
			lblNewLabel_weld[i] = new JLabel();
			lblNewLabel_weld[i].setBounds(13, 20 + i * 26, 200, 15);
			panel_weld.add(lblNewLabel_weld[i]);

			textField_weld[i] = new JTextField();
			textField_weld[i].setBounds(210, 17 + i * 26, 130, 21);
			panel_weld.add(textField_weld[i]);
			textField_weld[i].setColumns(10);
			textField_weld[i].setHorizontalAlignment(JTextField.RIGHT);
		}

		lblNewLabel_weld[0].setText("Weld Inherent vol 1");
		lblNewLabel_weld[1].setText("Weld Inherent vol 2");

		textField_weld[0].setText("-250");
		textField_weld[1].setText("250");

		/*
			ImgBox=new JLabel(images[18]);
			ImgBox.setBounds(P_1st_raw,img_p_y,img_s_x,img_s_y);
			contentPane.add(ImgBox);
			*/

		JButton btnNewButton = new JButton("execute");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				System.out.println("버튼이 클릭되었습니다.");
				new IOtest3();

			}
		});
		btnNewButton.setBounds(P_3rd_raw + 50, 405, 97, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Analysis");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnNewButton_1.setBounds(P_3rd_raw + 170, 405, 97, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Open Mentat");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnNewButton_2.setBounds(P_3rd_raw + 50, 435, 97 + 120, 23);
		contentPane.add(btnNewButton_2);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 1, Frame_size_x, 21);
		contentPane.add(menuBar);

		JMenu File = new JMenu("File");

		File.add(new JMenuItem("New"));
		File.add(new JMenuItem("Open"));
		File.add(new JMenuItem("Save"));
		File.add(new JMenuItem("Save as"));
		File.add(new JMenuItem("Exit"));

		menuBar.add(File);

	}

}