/****************************************************************************************  
  * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
  * Author of this File: Mary DuBard
  * 
  * File Name: FindRoutePanel.java
  * Created: 12/8/15
  * Last Updated: 12/14/15
  * Known Bugs: None
  * 
  * Class that contains Panel elements for the FindRoute tab of the Walking Effect GUI
  ****************************************************************************************/ 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class FindRoutePanel extends JPanel{
  private JLabel header, origin, destination;
  private JPanel navi, map;
  private static JComboBox orig, dest;
  private JButton submit;
  private static JTextArea keyText;
  private JTextPane directions;
  private String[] locs;
  private Map m;
  
  private final Color BACKGROUND = new Color(138, 226, 255); //stores background color for main panel(s)
  private final Color DIRECTIONS_BACKGROUND = new Color (204, 242, 255); //stores background color for directions
  
  /****************************************************************** 
    * setKeyText(String[] locs)
    * @param String array of location names
    * 
    * Sets the content of the Map Key
    * Used when user adds a new location
    ******************************************************************/ 
  public static void setKeyText(String[] locs){
    keyText.setText("Map Key: "); //resets text to title the key
    
    //Adds locations to key
    for(int i = 0; i < locs.length; i++){
      keyText.append("\n"); 
      keyText.append(locs[i]);
    }
  }
  
  /******************************************************************
    * setComboBoxes(String[] locs)
    * @param String array of location names
    * 
    * Sets the content for the dropdown menu for origin and destination
    * Used when user adds a new location
    ******************************************************************/ 
  public static void setComboBoxes(String[] locs){
    orig.removeAllItems(); //resets origin dropdown
    //adds back new locations
    for(int i = 0; i < locs.length; i++){
      orig.addItem(locs[i]);
    }
    
    dest.removeAllItems(); //resets destination dropdown
    //adds back new locations
    for(int i = 0; i < locs.length; i++){
      dest.addItem(locs[i]);
    }
  }
  
  /******************************************************************
    * FindRoutePanel Constructor
    * @param Map object
    * 
    * Creates FindRoutePanel
    ******************************************************************/ 
  public FindRoutePanel(Map ma){
    
    this.setBackground(BACKGROUND);
    
    m = ma; 
    setLayout(new BorderLayout());
    
    /**
     * Code for Font style
     **/ 
    //set font to default as helvetica
    Font headerFont = new Font("Helvetica", Font.PLAIN, 18);
    Font customFont = new Font("Helvetica", Font.PLAIN, 15);
    Font keyFont = new Font("Helvetica", Font.PLAIN, 13);
    
    try {
      //Creates the font to use
      headerFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/fontBold.ttf")).deriveFont(25f);
      customFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/font.ttf")).deriveFont(20f);
      keyFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/font.ttf")).deriveFont(17f);
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      //register the font
      ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font/font.ttf")));
    } catch (IOException e) {
      e.printStackTrace();
    }
    catch(FontFormatException e)
    {
      e.printStackTrace();
    }
    
    /**
     * Creates content for FindRoutePanel
     **/
    //Stores content into header JLabel
    header = new JLabel("\nPick your origin and destination below to receive the quickest path between them!", SwingConstants.CENTER);
    header.setFont(headerFont);
    
    locs = m.getLocations(); //stores map locations into locs array
    
    //initialize combo boxes, using WellesleyMap's initial locations
    orig = new JComboBox(locs);
    orig.setFont(keyFont);
    dest = new JComboBox(locs);
    dest.setFont(keyFont);
    
    //initializes labels for combo boxes
    origin = new JLabel("Origin: ");
    origin.setFont(customFont);
    destination = new JLabel("Destination: ");
    destination.setFont(customFont);
    
    //creates submit button
    submit = new JButton("Submit");
    submit.addActionListener(new submitListener());
    submit.setFont(customFont);
    
    //Creates panel for navigation options and stores content
    navi = new JPanel();
    navi.setBackground(BACKGROUND);
    navi.setLayout(new BoxLayout(navi, BoxLayout.Y_AXIS));
    navi.add(Box.createRigidArea(new Dimension(0, 50)));
    navi.add(origin);
    navi.add(Box.createRigidArea(new Dimension(0, 5)));
    navi.add(orig);
    navi.add(Box.createRigidArea(new Dimension(0, 50)));
    navi.add(destination);
    navi.add(dest);
    navi.add(Box.createRigidArea(new Dimension(0, 100)));
    navi.add(submit);
    navi.add(Box.createRigidArea (new Dimension (0, 100)));
    
    //creates panel for map and key
    map = new JPanel();
    map.setBackground(BACKGROUND);
    map.setLayout(new BoxLayout(map, BoxLayout.X_AXIS));
    
    //adds map image to map panel
    try{
      BufferedImage myPicture = ImageIO.read(new File("images/map.png"));
      ImageIcon pic = new ImageIcon(myPicture);
      Image img = pic.getImage();
      BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
      Graphics g = bi.createGraphics();
      g.drawImage(img, 100, 50, 500, 350, null); //locates and sizes image
      ImageIcon newIcon = new ImageIcon(bi);
      JLabel picLabel = new JLabel(newIcon);  //adds image to label
      map.add(picLabel); //adds label to panel
    }
    catch(IOException io){
      System.out.println(io);
    }
    
    //creates map key
    keyText = new JTextArea(12, 20);
    keyText.setMaximumSize(keyText.getPreferredSize());
    keyText.setEditable(false);
    keyText.append("Map Key: ");
    for(int i = 0; i < locs.length; i++){
      keyText.append("\n");
      keyText.append(locs[i]);
    }
    keyText.setFont(keyFont);
    
    //makes map key scrollable and adds to map panel
    JScrollPane jp = new JScrollPane(keyText);
    jp.setMaximumSize(keyText.getPreferredSize());
    map.add(jp);
    
    //Initializes footer to hold directions
    directions = new JTextPane();
    directions.setBackground(DIRECTIONS_BACKGROUND);
    directions.setEditable(false);
    directions.setText("<Directions here>");
    directions.setFont(customFont);
    StyledDocument doc = directions.getStyledDocument();
    SimpleAttributeSet center = new SimpleAttributeSet();
    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
    doc.setParagraphAttributes(0, doc.getLength(), center, false);
    
    //Makes directions scrollable
    JScrollPane jp2 = new JScrollPane(directions);
    jp2.setMaximumSize(directions.getPreferredSize());
    
    //adds elements to frame
    add(header, BorderLayout.NORTH);
    add(navi, BorderLayout.WEST);
    add(map, BorderLayout.EAST);
    add(directions, BorderLayout.SOUTH);
  }
  
  /******************************************************************
    * submitListener Class
    * 
    * Used when user clicks on the submit button
    ******************************************************************/ 
  private class submitListener implements ActionListener{
    /******************************************************************
      * actionPerformed(ActionEvent event)
      * @param ActionEvent
      * 
      * When user clicks on submit button, gets the directions from origin to destination
      * and puts the String in the directions JTextPane at bottom of FindRoutePanel
      ******************************************************************/ 
    public void actionPerformed(ActionEvent event){
      //Save combobox values as a string
      String origString = orig.getSelectedItem().toString();
      String destString = dest.getSelectedItem().toString();
      
      //Sets content for directions JTextPane
      directions.setText("Directions from " + origString + " to " + destString + ". " + "\n" 
                           + m.directionsString(m.findLocation(origString), m.findLocation(destString)));
    }
  }
}
