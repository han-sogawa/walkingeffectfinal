/**************************************************************************************** 
  * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
  * Author of this File: Hannah Murphy
  * 
  * File Name: AddLocationPanel.java
  * Created: 12/11/15
  * Last Updated: 12/14/15
  * Known Bugs: None
  * 
  * Class that contains Panel elements for the Add Location tab of the Walking Effect GUI
  *****************************************************************************************/ 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class AddLocationPanel extends JPanel{
  private JLabel header, enterName, nearbyLoc1, nearbyLoc2, dist1, dist2, about, footer;
  private JPanel navi, mapPic;
  private JComboBox nearbyLoc1Combo, nearbyLoc2Combo;
  private JButton add;
  private JScrollPane aboutScroll;
  private JTextArea keyText;
  private JTextField locName, distField1, distField2;
  private JTextArea aboutInfo;
  private JCheckBox hasHillsCheck1, hasStairsCheck1, hasHillsCheck2, hasStairsCheck2;
  private Map instanceMap;
  private String[] locs, comboLocs;
  private final Color BACKGROUND = new Color(138, 226, 255);
  
  /*******************************************************************
    setKeyText(String[] locs)
    @param String array of location names
    
    Sets the content of the Map Key
    Used when user adds a new location
    *******************************************************************/
  public void setKeyText(){
    for(int i = 0; i < locs.length; i++){
      keyText.append("\n");
      keyText.append(locs[i]);
    }
  }
  
  /*******************************************************************
    AddLocationPanel Constructor
    @param Map object
    
    Creates AddLocationPanel
    *******************************************************************/ 
  public AddLocationPanel(Map map){
    instanceMap = map; //stores map to instance variable
    locs = instanceMap.getLocations();
    
    //Formatting
    setLayout(new BorderLayout()); 
    setBackground(BACKGROUND);
    
    /**
     * Code for Font style
     **/ 
    //set font to default as helvetica
    Font headerFont = new Font("Helvetica", Font.PLAIN, 20);
    Font customFont = new Font("Helvetica", Font.PLAIN, 15);
    Font keyFont = new Font("Helvetica", Font.PLAIN, 13);
    
    try {
      //create the font to use. Specify the size!
      headerFont = Font.createFont(Font.TRUETYPE_FONT, new File("fontBold.ttf")).deriveFont(25f);
      customFont = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf")).deriveFont(20f);
      keyFont = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf")).deriveFont(17f);
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      //register the font
      ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf")));
    } catch (IOException e) {
      e.printStackTrace();
    }
    catch(FontFormatException e)
    {
      e.printStackTrace();
    }
    
    
    /**
     * Creates content for AddLocationPanel
     **/ 
    //creates content for header
    header = new JLabel("\nFill in the fields below to add a custom location to your map!", SwingConstants.CENTER);
    header.setFont(headerFont);
    
    //creates comboLocs array and stores into dropdown menus, with "No Location" option
    comboLocs = instanceMap.getLocationsCombo();
    nearbyLoc1Combo = new JComboBox(comboLocs);
    nearbyLoc1Combo.setFont(keyFont);
    nearbyLoc2Combo = new JComboBox(comboLocs);
    nearbyLoc2Combo.setFont(keyFont);
    
    //initializes label for location name
    enterName = new JLabel("Name of New Location: ");
    enterName.setFont(customFont);
    
    //creates panel for user input; helps with formatting
    JPanel locNamePanel = new JPanel();
    locNamePanel.setBackground(BACKGROUND);
    locName = new JTextField(20);
    locNamePanel.add(locName);
    
    //initializes labels for combo boxes
    nearbyLoc1 = new JLabel("Nearby Location 1: ");
    nearbyLoc1.setFont(customFont);
    nearbyLoc2 = new JLabel("Nearby Location 2: ");
    nearbyLoc2.setFont(customFont);
    
    //initializes labels for distances
    dist1 = new JLabel("Distance to Location 1 (miles): ");
    dist1.setFont(customFont);
    dist2 = new JLabel("Distance to Location 2 (miles): ");
    dist2.setFont(customFont);
    
    //creates panels for distance user input; helps with formatting
    JPanel distField1Panel = new JPanel();
    distField1Panel.setBackground(BACKGROUND);
    distField1 = new JTextField(10);
    distField1Panel.add(distField1);
    JPanel distField2Panel = new JPanel();
    distField2Panel.setBackground(BACKGROUND);
    distField2 = new JTextField(20);
    distField2Panel.add(distField2);
    
    //Creates checkboxes for path hills and stairs
    hasHillsCheck1 = new JCheckBox("The Path to Location 1 has Hills");
    hasHillsCheck1.setFont(keyFont);
    hasHillsCheck1.setBackground(BACKGROUND);
    hasStairsCheck1 = new JCheckBox("The Path to Location 1 has Stairs");
    hasStairsCheck1.setFont(keyFont);
    hasStairsCheck1.setBackground(BACKGROUND);
    
    hasHillsCheck2 = new JCheckBox("The Path to Location 2 has Hills");
    hasHillsCheck2.setFont(keyFont);
    hasHillsCheck2.setBackground(BACKGROUND);
    hasStairsCheck2 = new JCheckBox("The Path to Location 2 has Stairs");
    hasStairsCheck2.setFont(keyFont);
    hasStairsCheck2.setBackground(BACKGROUND);
    
    about = new JLabel("Enter descriptive information about your location here: ");
    about.setFont(customFont);
    //aboutInfo text area
    aboutInfo = new JTextArea();
    aboutInfo.setFont(keyFont);
    aboutInfo.setPreferredSize(new Dimension(30, 50));
    //aboutInfo.setColumns(25);
    aboutInfo.setMaximumSize(aboutInfo.getPreferredSize());
    aboutInfo.setLineWrap(true);
    aboutInfo.setAlignmentY(CENTER_ALIGNMENT);
    aboutScroll = new JScrollPane (aboutInfo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    //JScrollPane  = new JScrollPane(keyText);
    
    //creates submit button
    add = new JButton("Add Location");
    add.setPreferredSize(new Dimension(40, 40));
    add.addActionListener(new AddButtonListener());
    add.setFont(customFont);
    
    //Creates panel for navigation options and adds content
    navi = new JPanel();
    navi.setBackground(BACKGROUND);
    navi.setLayout(new BoxLayout(navi, BoxLayout.Y_AXIS));
    //navi.add(Box.createRigidArea(new Dimension(0, 50)));
    navi.add(enterName);
    navi.add(locNamePanel);
    
    navi.add(nearbyLoc1);
    navi.add(nearbyLoc1Combo);
    navi.add(dist1);
    navi.add(distField1Panel);
    navi.add(hasHillsCheck1);
    navi.add(hasStairsCheck1);
    
    //navi.add(Box.createRigidArea(new Dimension(0, 10)));
    navi.add(nearbyLoc2);
    navi.add(nearbyLoc2Combo);
    navi.add(dist2);
    navi.add(distField2Panel);
    navi.add(hasHillsCheck2);
    navi.add(hasStairsCheck2);
    navi.add(Box.createRigidArea(new Dimension(0, 10)));
    navi.add(about);
    navi.add(aboutScroll);
    navi.add(add);
    
    
    //creates panel for map and key
    mapPic = new JPanel();
    mapPic.setBackground(BACKGROUND);
    mapPic.setLayout(new BoxLayout(mapPic, BoxLayout.X_AXIS));
    mapPic.add(Box.createRigidArea(new Dimension(100, 0)));
    
    //adds map image
    try{
      BufferedImage myPicture = ImageIO.read(new File("map.png"));
      ImageIcon pic = new ImageIcon(myPicture);
      Image img = pic.getImage();
      BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
      Graphics g = bi.createGraphics();
      g.drawImage(img, 100, 50, 500, 350, null); //locates and sizes image
      ImageIcon newIcon = new ImageIcon(bi);
      JLabel picLabel = new JLabel(newIcon);  //adds image to label
      mapPic.add(picLabel); //adds label to panel
    }
    catch(IOException io){
      System.out.println(io);
    }
    
    //creates map key
    keyText = new JTextArea(12, 20);
    keyText.setFont(keyFont);
    keyText.setMaximumSize(keyText.getPreferredSize());
    keyText.setEditable(false);
    keyText.append("Map Key: ");
    keyText.setRows(1);
    for(int i = 0; i < locs.length; i++){
      keyText.append("\n");
      keyText.append(locs[i]);
    }
    
    //makes map key scrollable and adds to map panel
    JScrollPane jp = new JScrollPane(keyText);
    jp.setMaximumSize(keyText.getPreferredSize());
    mapPic.add(jp);
    
    //Initializes footer
    footer = new JLabel("", SwingConstants.CENTER);
    footer.setFont(customFont);
    
    //adds elements to frame
    add(header, BorderLayout.NORTH);
    add(navi, BorderLayout.WEST);
    add(mapPic, BorderLayout.EAST);
    add(footer, BorderLayout.SOUTH);
  }
  
  /*******************************************************************
    AddButtonListener Class
    
    Used to add new location
    *******************************************************************/
  private class AddButtonListener implements ActionListener{
    private String newNearbyLoc1;
    private String newNearbyLoc2;
    
    /*******************************************************************
      actionPerformed(ActionEvent event)
      @param ActionEvent event
      
      When button is clicked, creates location from user's information
      and adds to map object. Updates map key.
      *******************************************************************/
    public void actionPerformed(ActionEvent event){
      Location l = null;
      
      if(!locName.getText().equals("")){ //if user inputted a location name
        //Stores user's location name plus count into string
        String newLocName = "(" + (instanceMap.n() + 1) + ") " + locName.getText(); 
        
         
        boolean isSecondDest = false; //sets existence of nearby second location default as false
        
        newNearbyLoc1 = nearbyLoc1Combo.getSelectedItem().toString(); //gets string of comboloc nearby destination
        if(!newNearbyLoc1.equals("No location selected.")){ //if user selected a location
          try{ //try to get distance and create a path
            if(!distField1.getText().equals("")){ //if user inputted distance
              l = new Location(newLocName); //Creates location from user's name
              double locDist1 = Double.parseDouble(distField1.getText()); //stores distance into double
              boolean hasHills1 = hasHillsCheck1.isSelected(); //whether path has hills
              boolean hasStairs1 = hasStairsCheck1.isSelected(); //whether path has stairs
              
              Path p = new Path(locDist1, hasStairs1, hasHills1); //creates new path
              //adds location and path
              instanceMap.addVertex(l);
              instanceMap.addEdge(l, instanceMap.findLocation(newNearbyLoc1), p);
              
              l.setAbout(aboutInfo.getText());
              
            }else{
              JOptionPane.showMessageDialog(null,
                                            "Enter a distance to Destination 1.");
            }
          }catch(NullPointerException e){
            System.out.println("You must enter valid input.");
          }catch(NumberFormatException n){
            JOptionPane.showMessageDialog(null,
                                          "Enter a valid number for the distance!");
          }
          
          //Attempts to do same process above for second location. If second nearby location isn't provided,
          //moves on.
          newNearbyLoc2 = nearbyLoc2Combo.getSelectedItem().toString();
          System.out.println(newNearbyLoc2.equals("No location selected."));
          if(!newNearbyLoc2.equals("No location selected.")){
            try{
              isSecondDest = true;
              if(!distField2.getText().equals("")){
                double locDist2 = Double.parseDouble(distField2.getText());
                boolean hasHills2 = hasHillsCheck2.isSelected();
                boolean hasStairs2 = hasStairsCheck2.isSelected();
                
                Path p = new Path(locDist2, hasStairs2, hasHills2);
                instanceMap.addEdge(l, instanceMap.findLocation(newNearbyLoc2), p);
              }else{
                JOptionPane.showMessageDialog(null,
                                              "Enter a distance to Destination 2.");
              }
            }catch(NullPointerException e){
              System.out.println("You must enter valid input.");
            }catch(NumberFormatException n){
              System.out.println("You must enter valid input.");
            }
          }
          
          //Sets footer text to represent that new location and path(s) have been added
          String footerText =  "New Location \"" + l.toString() + "\" has been added to the map,";
          footerText += isSecondDest ? " along with paths that lead to " + newNearbyLoc1 + " and " 
            + newNearbyLoc2 + "." : " along with a path that leads to " + newNearbyLoc1;
          
          footer.setText(footerText);
        }else{
          JOptionPane.showMessageDialog(null, "Please enter at least one nearby location and the distance to that location.");
          footer.setText("You have to select at least one nearby location! Try again.");
        }
        
        locs = instanceMap.getLocations();
        
        //resets AddLocation map key with new locations
        keyText.setText("");
        keyText.append("Map Key: ");
        keyText.setRows(1);
        for(int i = 0; i < locs.length; i++){
          keyText.append("\n");
          keyText.append(locs[i]);
        }
        
        nearbyLoc1Combo.removeAllItems(); //clears box
    for(int i = 0; i < locs.length; i++){ //adds the items back in, including the one that was just added
      nearbyLoc1Combo.addItem(locs[i]);
    }
     nearbyLoc2Combo.removeAllItems(); //clears box
    for(int i = 0; i < locs.length; i++){ //adds the items back in, including the one that was just added
      nearbyLoc2Combo.addItem(locs[i]);
    }
    
        //resets FindRoutePanel and ExplorePanel location lists
        FindRoutePanel.setKeyText(locs);
        FindRoutePanel.setComboBoxes(locs);
        ExplorePanel.setComboBox(locs);
        ExplorePanel.setKeyText(locs);
      }else{
        JOptionPane.showMessageDialog(null, "Please enter a Location Name.");
      }
    }
  }
}

