package DB_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

import javax.lang.model.element.NestingKind;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.concurrent.ThreadLocalRandom;
import java.sql.*;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GUI_3421A3 {

	private JFrame frame;
	private JTextField LinkField;
	private JTextField NameField;
	private JTextField TextField;
	private JTextField CityField;
	private JTextField CounrtryField;
	private JTextField DateField;
	private JTextField Publisher;
	private JTextField Journal;
	private JTextField ID;
	private JTextField Type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_3421A3 window = new GUI_3421A3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_3421A3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrThankYouFor = new JTextArea();
		txtrThankYouFor.setLineWrap(true);
		txtrThankYouFor.setText("This DB Software is using local cache and id to prevent insertion mistake, you can create a CFP locally and will be stored in cache. \r\n\r\nYou can search the CFP in cache by its ID, so please record your id, if you want to create several. \r\n\r\nFor Types , you must enter a value either \"Book\" \"Journal\" or \"Conference\", otherwise the software will not submit wrong values to the DB.\r\n\r\nYou can set your own ID, or ID will be randomly generated.");
		txtrThankYouFor.setBounds(483, 9, 291, 309);
		frame.getContentPane().add(txtrThankYouFor);
		
		JButton btnShow2 = new JButton("Coming Event");
		btnShow2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s="";
				String sql="select event, MIN(date) as date from ( select eventname as event, ActivityDate as date from activityhappens where EventName in (select eventname from eventconference)) as conference union select event, MIN(date) as date from ( select eventname as event, ActivityDate as date from activityhappens where EventName in (select eventname from eventjournal)) as journal union select event, MIN(date) as date from ( select eventname as event, ActivityDate as date from activityhappens where EventName in (select eventname from eventbook)) as book;";				try {
					Connection cnn = MysqlFunction.getConnection();
					Statement stmt = cnn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					rs.next();
						s=s+"The next comming Event is:\n\n"+rs.getString(1)+"\n\nOn Date:"+rs.getString(2);

					txtrThankYouFor.setText(s);
					MysqlFunction.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShow2.setBounds(648, 328, 126, 23);
		frame.getContentPane().add(btnShow2);
		
		JButton btnShow1 = new JButton("Month Count");
		btnShow1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s="Month|Count";
				String sql="select month, count(month) as count from(select extract(month from date) as month from eventconference) as month group by month union select month, count(month) as count from(select extract(month from date) as month from (select event, MIN(date) as date from (select eventname as event, ActivityDate as date from activityhappens where EventName in (select eventname from eventjournal) union select eventname as event, ActivityDate as date from activityhappens where EventName in (select eventname from eventbook)) as journal group by(event))as TableBothEarly) as month group by month;";
				try {
					Connection cnn = MysqlFunction.getConnection();
					Statement stmt = cnn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						s=s+"\n    "+rs.getInt(1)+"    |    "+rs.getInt(2)+"    ";
					}
					txtrThankYouFor.setText(s);
					MysqlFunction.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnShow1.setBounds(483, 328, 126, 23);
		frame.getContentPane().add(btnShow1);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 9, 463, 150);
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblName = new JLabel("CFP Name");
		panel.add(lblName);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		
		NameField = new JTextField();
		lblName.setLabelFor(NameField);
		panel.add(NameField);
		NameField.setColumns(41);
		
		JLabel lblLink = new JLabel("CFP Link");
		lblLink.setLabelFor(lblLink);
		panel.add(lblLink);
		lblLink.setHorizontalAlignment(SwingConstants.CENTER);
		
		LinkField = new JTextField();
		panel.add(LinkField);
		LinkField.setColumns(41);
		
		JLabel lblText = new JLabel("CFP Text");
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblText);
		
		TextField = new JTextField();
		lblText.setLabelFor(TextField);
		panel.add(TextField);
		TextField.setColumns(41);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 169, 463, 122);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblCity = new JLabel("City");
		panel_1.add(lblCity);
		
		CityField = new JTextField();
		lblCity.setLabelFor(CityField);
		panel_1.add(CityField);
		CityField.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country");
		panel_1.add(lblCountry);
		
		CounrtryField = new JTextField();
		lblCountry.setLabelFor(CounrtryField);
		panel_1.add(CounrtryField);
		CounrtryField.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		panel_1.add(lblDate);
		
		DateField = new JTextField();
		lblDate.setLabelFor(DateField);
		panel_1.add(DateField);
		DateField.setColumns(10);
		
		JLabel lblPublisher = new JLabel("Publisher");
		panel_1.add(lblPublisher);
		
		Publisher = new JTextField();
		panel_1.add(Publisher);
		Publisher.setColumns(13);
		
		JLabel lblJournal = new JLabel("JournalName");
		panel_1.add(lblJournal);
		
		Journal = new JTextField();
		panel_1.add(Journal);
		Journal.setColumns(13);
		
		JLabel lbllocalid = new JLabel("CFP ID");
		panel_1.add(lbllocalid);
		
		ID = new JTextField();
		lbllocalid.setLabelFor(ID);
		panel_1.add(ID);
		ID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setToolTipText("");
		panel_1.add(lblNewLabel_1);
		
		Type = new JTextField();
		lblNewLabel_1.setLabelFor(Type);
		Type.setToolTipText("Must be specified as Book Conference or Journal");
		panel_1.add(Type);
		Type.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 301, 463, 50);
		frame.getContentPane().add(panel_2);
		
		JButton btnLocal = new JButton("Creat Locally");
		btnLocal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = NameField.getText();
				String url = LinkField.getText();
				String text = TextField.getText();
				String publisher = Publisher.getText();
				String type = Type.getText();
				String id = ID.getText();
				 if (ID.getText().isEmpty()) {
					 id = Integer.toString(ThreadLocalRandom.current().nextInt(0, 100000 + 1));
				 }
				String city= CityField.getText();
				String country= CounrtryField.getText();
				String date= DateField.getText();
				String journalname= Journal.getText();
				CFP cfp = new CFP(CFP.builder().withName(name).withUrl(url).withText(text).withPublisher(publisher).withTypeString(type).withId(id).withCity(city).withCountry(country).withDate(date).withJournalname(journalname));
				if (Cache.getInstance().getByID(id)!=null) {
					txtrThankYouFor.setText("LOCAL RECORD UPDATED!!!\n"+cfp.display());
				}
				else {
					txtrThankYouFor.setText("LOCAL RECORD CREATED!!!\n"+cfp.display());
					Cache.getInstance().putValue(id, cfp);
				}
			}
		});
		panel_2.add(btnLocal);
		
		JButton btnSubmitCfpEvent = new JButton("Local Search By ID");
		btnSubmitCfpEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = ID.getText();
				if(Cache.getInstance().getByID(id)!=null)
				txtrThankYouFor.setText("RESULT FOUND!!!\n"+Cache.getInstance().getByID(id).display());
				else {
					txtrThankYouFor.setText("NO RESULT FOUND!!!");
				}
			}
		});
		panel_2.add(btnSubmitCfpEvent);
		
		JButton btnApply = new JButton("Add to DB (for Entered ID)");
		btnApply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 String id = ID.getText();
				 String name=Cache.getInstance().getByID(id).getName();
				 String url=Cache.getInstance().getByID(id).getUrl();
				 String text=Cache.getInstance().getByID(id).getText();
				 String city=Cache.getInstance().getByID(id).getCity();
				 String country=Cache.getInstance().getByID(id).getCountry();
				 String date=Cache.getInstance().getByID(id).getDate();
				 String publisher = Cache.getInstance().getByID(id).getPublisher();
				 String journalname=Cache.getInstance().getByID(id).getJournalname();
				 String sql="";
				try {
					Connection cnn = MysqlFunction.getConnection();
					Statement stmt = cnn.createStatement();
					switch (Cache.getInstance().getByID(id).getTypeString()) {
					case "Book":
						sql = "insert into event value(\""+ name + "\",\"" + url + "\",\"" + text + "\")";
						stmt.executeUpdate(sql);
						sql = "insert into eventbook value(\""+ name + "\",\"" + publisher +"\")";
						stmt.executeUpdate(sql);
						txtrThankYouFor.setText("CHANGE APPLIED TO DB\n");
						txtrThankYouFor.append(Cache.getInstance().getByID(id).display());
						MysqlFunction.close();
						break;
					case "Conference":
						sql = "insert into event value(\""+ name + "\",\"" + url + "\",\"" + text + "\")";
						stmt.executeUpdate(sql);
						sql = "insert into eventconference value(\""+ name + "\",\"" + city + "\",\"" + country + "\",\"" + date +"\")";
						stmt.executeUpdate(sql);
						txtrThankYouFor.setText("CHANGE APPLIED TO DB\n");
						txtrThankYouFor.append(Cache.getInstance().getByID(id).display());
						MysqlFunction.close();
						break;
					case "Journal":
						sql = "insert into event value(\""+ name + "\",\"" + url + "\",\"" + text + "\")";
						stmt.executeUpdate(sql);
						sql = "insert into eventjournal value(\""+ name + "\",\"" + journalname + "\",\"" + publisher +"\")";
						stmt.executeUpdate(sql);
						txtrThankYouFor.setText("CHANGE APPLIED TO DB\n");
						txtrThankYouFor.append(Cache.getInstance().getByID(id).display());
						MysqlFunction.close();
						break;
					default:
						txtrThankYouFor.setText("Type is not Correct, Please use Book, Conference or Journal as type input.");
					}
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_2.add(btnApply);
	}
}
