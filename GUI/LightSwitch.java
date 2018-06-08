//Andrew McKeown

//java core packages
import java.awt.*;
import java.awt.event.*;
//java extension packages
import javax.swing.*;
import javax.swing.event.*;

public class LightSwitch extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String xbutton, xradio;

	private JButton onButton = new JButton("ON");
	private JButton offButton = new JButton("OFF");
	private JButton apply = new JButton("APPLY");

	private JLabel label;

	private JSlider slider;

	private String strings[] = { "one", "five", "thirty", "sixty" };
	private JRadioButton[] radio;

	private ButtonGroup group;

	public LightSwitch() {
		super("LightSwitch");
		// set up container
		Container c = this.getContentPane();
		// set up main panel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		c.add(mainPanel);// add main panel to container
		// set up on/off panel and add buttons
		JPanel onoffPanel = new JPanel();

		onoffPanel.add(onButton);
		onoffPanel.add(offButton);
		onoffPanel.add(apply);
		// add on/off panel to main panel
		mainPanel.add(onoffPanel, BorderLayout.SOUTH);

		// Button Handler
		ButtonHandler handler = new ButtonHandler();
		onButton.addActionListener(handler);
		offButton.addActionListener(handler);
		ButtonHandler2 handler2 = new ButtonHandler2();
		apply.addActionListener(handler2);

		// set up slider
		slider = new JSlider(SwingConstants.HORIZONTAL, 1, 5, 1);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		JScrollPane contentPane = new JScrollPane(slider);
		mainPanel.add(contentPane, BorderLayout.CENTER);

		// register JSlider event listener
		slider.addChangeListener(new ChangeListener() {
			// handle change in slider value
			public void stateChanged(ChangeEvent e) {
				slider.getValue();
			}// end of anonymous inner class
		});// end call to addChangeListener

		// Timer button section:
		JPanel radioPanel = new JPanel(new GridLayout(5, 1));

		radio = new JRadioButton[strings.length];
		// radio panel is added to main panel
		mainPanel.add(radioPanel, BorderLayout.NORTH);
		// create button group to add radio buttons into
		group = new ButtonGroup();
		ItemHandler handler3 = new ItemHandler();
		for (int count = 0; count < radio.length; count++) {
			radio[count] = new JRadioButton(strings[count]);
			radio[count].addItemListener(handler3);
			group.add(radio[count]);
			radioPanel.add(radio[count]);
		}
		label = new JLabel("Status:", SwingConstants.LEFT);
		radioPanel.add(label);

		setSize(500, 250);
		this.setVisible(true);
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(LightSwitch.this,
					"You pressed the " + event.getActionCommand().toLowerCase() + " button!");
			// assigning event.getActionCommand to String 'xbutton', which is
			// used in
			// ButtonHandler2 for the apply button
			xbutton = event.getActionCommand().toLowerCase();

		}
	}

	// ButtonHandler2 used for apply button
	private class ButtonHandler2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String llabel = "Status: Light turned: " + xbutton + " | Intensity set to: " + slider.getValue()
					+ " | Timer set at: " + xradio + " minutes";
			label.setText(llabel);
		}
	}

	// private inner class to handle radio button events Outline
	private class ItemHandler implements ItemListener {

		// process user's look-and-feel selection
		public void itemStateChanged(ItemEvent event) {
			for (int count = 0; count < radio.length; count++)

				if (radio[count].isSelected()) {
					JOptionPane.showMessageDialog(null,
							"Light set to be switched on for " + strings[count] + " minute(s)");
					xradio = strings[count];
				}
		}

	} // end private inner class ItemHandler

	public static void main(String args[]) {
		LightSwitch w = new LightSwitch();

	}

}
