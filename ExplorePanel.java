/************************************************************************************* 
  * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
  * Author of this File: Alyssa Rivera, Mary DuBard
  * 
  * File Name: ExplorePanel.java
  * Created: 12/8/15
  * Last Updated: 12/14/15
  * Known Bugs: None
  * 
  * Class that contains Panel elements for the Explore tab of the Walking Effect GUI
  *************************************************************************************/ 

//imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ExplorePanel extends JPanel {
  private JButton exploreButton; // clicked after location is selectd. has attached action listener
  private JLabel header, name, picLabel; //labels to assist user
  private JLabel nameBold, aboutBold;
  private static JTextArea about, keyText; //updates when a location is added or a locaion is explored
  private JScrollPane aboutScroll, bottomScroll;
  private static JComboBox locMenu;
  private Map map; //common map object
  private Location[] locations; // get locations from map object
  private Location chosenLocation; //store current location
  private final Color BACKGROUND = new Color(138, 226, 255);
  
  /******************************************************************
    setComboBoxes()
    called from AddLocationPanel to update the ComboBox whenever a new loation is added to the map
    ******************************************************************/
  public static void setComboBox(String[] locs){
    locMenu.removeAllItems(); //clears box
    for(int i = 0; i < locs.length; i++){ //adds the items back in, including the one that was just added
      locMenu.addItem(locs[i]);
    }
  }
  
  /******************************************************************
    setKeytext()
    called from AddLocationPanel to update the Key whenever a new loation is added to the map
    ******************************************************************/
  public static void setKeyText(String[] locs){
    keyText.setText(""); //clears keyText
    for(int i = 0; i < locs.length; i++){ //adds in the locations 
      keyText.append("\n");
      keyText.append(locs[i]);
    }
  }
  
  /******************************************************************
    ExplorePanel()
    Puts together the explore panel, lets the user find out more information about a chosen location
    ******************************************************************/
  public ExplorePanel(Map m){ //pass in Map from GUI driver
    
    this.setBackground(BACKGROUND); //sets background color
    
    //get location information (from Map passed in)
    map = m;
    locations = map.getAllVertices();
    
    //initialize everything
    chosenLocation = new Location (" ");
    Font headerFont = null;
    Font defaultFont = null;
    Font  boldFont = null;
    Font keyFont = null;
    
    //sets font of text
    try{
      defaultFont = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf")).deriveFont(20f);
      boldFont = Font.createFont(Font.TRUETYPE_FONT, new File ("fontBold.ttf")).deriveFont(20f);
      keyFont = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf")).deriveFont(17f);
    } catch (FontFormatException e){
      System.out.println ("font format exception");
    } catch (IOException i){
      System.out.println("io exception");
    }
    
    //sets up explore button, attaches listener
    exploreButton = new JButton("Explore!");
    exploreButton.addActionListener(new ExploreButtonListener());
    exploreButton.setFont(defaultFont);
    exploreButton.setPreferredSize(new Dimension (150, 50));
    exploreButton.setMaximumSize(exploreButton.getPreferredSize());
    
    //customizes header
    header = new JLabel("Use this menu to learn more about the locations on Wellesley's campus.", SwingConstants.CENTER);
    header.setFont(headerFont);
    JPanel headerPanel = new JPanel();
    
    //sets up panel
    headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
    headerPanel.add(Box.createRigidArea (new Dimension (5, 80)));
    headerPanel.add(header);
    headerPanel.add(Box.createRigidArea (new Dimension (5, 40)));
    
    //"You Selected" label
    nameBold = new JLabel("You Selected");
    nameBold.setFont(boldFont);
    name = new JLabel ( chosenLocation.getName());
    name.setFont(defaultFont);
    
    //sets up location menu, from which the user can select a location to explore
    locMenu = new JComboBox();
    locMenu.setFont(keyFont);
    locMenu.setPreferredSize(new Dimension (150, 50));
    locMenu.setMaximumSize(locMenu.getPreferredSize());
    locMenu.addItem("Select a Location");
    for(int i = 0; i < map.n(); i++){
      locMenu.addItem(locations[i].getName());
    }
    
    //sets up About text field, where information about a selected location will be displayed
    aboutBold = new JLabel ("About: ");
    aboutBold.setFont(boldFont);
    about = new JTextArea(chosenLocation.getAbout());
    about.setFont(defaultFont);
    about.setPreferredSize(new Dimension(500, 100));
    about.setColumns(25);
    about.setMaximumSize(about.getPreferredSize());
    about.setLineWrap(true);
    aboutScroll = new JScrollPane (about, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    about.setEditable(false);
    
    //layout manager, add everything to panels
    JPanel leftPanel = new JPanel();
    leftPanel.setBackground(BACKGROUND);
    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
    leftPanel.add(Box.createRigidArea (new Dimension (5, 80)));
    leftPanel.add(locMenu);
    leftPanel.add(Box.createRigidArea (new Dimension (5, 40)));
    leftPanel.add(exploreButton);
    leftPanel.add(Box.createRigidArea (new Dimension (5, 120)));
    
    JPanel rightPanel = new JPanel();
    rightPanel.setBackground(BACKGROUND);
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.X_AXIS));
    
    //adds map image
    try{
      BufferedImage myPicture = ImageIO.read(new File("map.png"));
      ImageIcon pic = new ImageIcon(myPicture);
      Image img = pic.getImage();
      BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
      Graphics g = bi.createGraphics();
      g.drawImage(img, 100, 50, 400, 280, null); //locates and sizes image
      ImageIcon newIcon = new ImageIcon(bi);
      JLabel picLabel = new JLabel(newIcon);  //adds image to label
      rightPanel.add(picLabel); //adds label to panel
    }
    catch(IOException io){
      System.out.println(io);
    }
    
    //formats and adds keyText
    keyText = new JTextArea(12, 20);
    keyText.setFont(keyFont);
    keyText.setEditable(false);
    keyText.setMaximumSize(keyText.getPreferredSize());
    keyText.setEditable(false);
    keyText.append("Map Key: ");
    for(int i = 0; i < map.n(); i++){
      keyText.append("\n");
      keyText.append(locations[i].getName());
    }
    
    //makes it scrolly!
    JScrollPane jp = new JScrollPane(keyText);
    jp.setMaximumSize(keyText.getPreferredSize());
    rightPanel.add(jp);
    
    JPanel bottomPanel = new JPanel();
    bottomPanel.setBackground(BACKGROUND);
    bottomPanel.setLayout(new BorderLayout());
    bottomPanel.add(nameBold, BorderLayout.NORTH);
    bottomPanel.add(name, BorderLayout.NORTH);
    bottomPanel.add(aboutBold, BorderLayout.WEST);
    bottomPanel.add(about, BorderLayout.WEST);
    
    //uploads picture to be added to botton panel
    ImageIcon pic = new ImageIcon(chosenLocation.getPic());
    Image img = pic.getImage();
    BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
    Graphics g = bi.createGraphics();
    g.drawImage(img, 100, 20, 300, 150, null); //locates and sizes image
    ImageIcon newIcon = new ImageIcon(bi);
    picLabel = new JLabel(newIcon);  //adds image to label
    bottomPanel.add(picLabel); //adds label to panel
    
    bottomScroll = new JScrollPane (bottomPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    //add picture to bottom panel
    this.setLayout (new BorderLayout());
    this.add(Box.createRigidArea(new Dimension(100, 10)), BorderLayout.NORTH);
    this.add(header, BorderLayout.NORTH);
    this.add(leftPanel, BorderLayout.WEST);
    this.add(rightPanel, BorderLayout.EAST);
    this.add(new JScrollPane(bottomPanel), BorderLayout.SOUTH); 
  }
  
  /******************************************************************
    Class that handles the Explore Button being clicked
    ******************************************************************/
  private class ExploreButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      //initializes instance variables
      Font  boldFont = null;
      
      //sets fonts for when the about infor is updated
      try{
        boldFont = Font.createFont(Font.TRUETYPE_FONT, new File ("fontBold.ttf")).deriveFont(20f);
      } catch (FontFormatException x){
        System.out.println ("font format exception");
      } catch (IOException i){
        System.out.println("io exception");
      }
      
      String s = locMenu.getItemAt(locMenu.getSelectedIndex()).toString();
      
      //Don't do anything if the user presses the explore button without actually selecting a location
      if(s.equals("Select a Location")){
        return;
      }
      else{
        // get location from the graph and display info on that object
        Location chosenLocation = map.findLocation(s);
        name.setText ("You Selected:    " + chosenLocation.getName());
        name.setFont(boldFont);
        about.setText("About:     " + chosenLocation.getAbout());
        
        ImageIcon pic = new ImageIcon(chosenLocation.getPic());
        Image img = pic.getImage();
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 100, 20, 300, 150, null); //locates and sizes image
        ImageIcon newIcon = new ImageIcon(bi);
        picLabel.setIcon(newIcon);
      } 
    }
  } 
}
