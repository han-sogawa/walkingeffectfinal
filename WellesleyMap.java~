/* 
 * Team: Mary DuBard, Hannah Murphy, Alyssa Rivera
 * Writer for this Class: Mary DuBard
 * 
 * File name: WalkingEffectGUI.java
 * Date Created: 12/12/15
 * Last Updated: 12/12/15
 * 
 * Class that creates Map object for Wellesley
 */
import java.util.*;

public class WellesleyMap extends Map{
  public WellesleyMap(){
    //Create locations for Wellesley Map
    //Location(name, about, picture file)
    Location ksc = new Location("(1) Sports Center", "Nannerl O. Keohane Sports Center, named for Nannerl" 
                                + "Keohane '61 (Wellesley president, 1981-1993), is the focal point for recreation and "
                                  + "fitness at Wellesley College.  The Sports Center is home to 14 varsity athletics teams,"
                                  + "a diverse physical education curriculum, and a wide variety of recreational, intramural, and "
                                  + "wellness activities for the entire College community.", "pic1ksc.jpg");
    Location resQ = new Location("(2) Res Quad", "The Quad is made up of four dorms: Beebe, Cazenove, Pomeroy, and Shafer Halls."
                                + " The halls in the Quad are known for their convenient location and fun atmosphere. " 
                                + "One of the trickiest things about the Quad can be simply remembering which building is which - "
                                + "so something helpful to keep in mind is that the halls are in alphabetical order.", "pic2resQ.jpg");
    Location alum = new Location("(3) Alumnae Hall", "The Diana Chapman Walsh Alumnae Hall houses the Theatre Studies Department, "
                                   + "a 1300-seat auditorium, a black box theatre, and a ballroom for dance rehearsals, parties, and aerobics. "
                                   + "Many campus performances and events are held here.", "pic3alum.jpg");
    Location lulu = new Location("(4) Lulu", "The Lulu Chow Wang Campus Center, with its labyrinth-like layout and unexpected open spaces, "
                                   + "provides an inviting place where members of the Wellesley community can gather for impromptu conversation "
                                   + "or more formal meetings of the College's 160 student organizations and College Government. The 'Lulu' houses "
                                   + "a bookstore, dining area and coffee bar, cafe and pub, large multipurpose spaces for performances and social "
                                   + "functions, and meeting rooms.", "pic4lulu.jpg");
    Location acaQ = new Location("(5) Acad Quad", "Pendleton Hall, Founders Hall, and the Jewett Arts Center make up the heart of the Academic Quad, "
                                   + "where most of Wellesley's classes, except for the sciences, meet. These three buildings house all of the "
                                   + "social science, art, and humanities departments.", "pic5acaQ.jpg");
    Location sciCen = new Location("(6) Science Center", "The Science Center comprises four buildings: the Margaret Fergusson Greenhouses; Sage Hall; "
                                     + "the Laboratory Wing; and the E-wing.  The Science Center serves as the home of Science, Technology, Engineering, "
                                     + "and Mathematics at Wellesley College, and houses all the science departments and programs offered at the "
                                     + "College.", "pic6sciCen.jpg");
    Location twr = new Location("(7) Tower Court", "Made up of Tower Court and Severance and Claflin Halls, the Tower Complex is generally"
                                  + "considered to contain some of the more social dorms on campus (which isn't to say, of course, that all"
                                  + " the dorms aren't social, in their own ways - but there does tend to be a little more noise and activity"
                                  + " in the hallways in these dorms). And of course, the halls that make up Tower Court are some of the most "
                                  + "beautiful buildings on campus. Given its lovely courtyard, lake views, and Elizabethan Gothic and "
                                  + "Georgian-style architecture, it's no wonder that Tower Court is the dorm that you probably saw the most "
                                  + "pictures of in the Admissions literature!", "pic7twr.jpg");
    Location lib = new Location("(8) Library", "Named for Wellesley's eighth president, the Margaret Clapp Library is the centerpiece of the "
                                  + "College library system, which contains over a million volumes. The entire system is fully automated, with an "
                                  + "online catalog that can be accessed 24 hours a day.", "pic8lib.jpg");
    Location stone = new Location("(9) Stone-Davis", "The original Stone Hall was destroyed by fire in 1927. When rebuilt, the name “Davis” was added to "
                                    + "honor Olive Davis, a Head of House whose insistence on regular fire drills saved the lives of many students. "
                                    + "This is the dorm that Hillary Clinton lived in all four years during her time at Wellesley.", "pic9stone.jpg");
    Location east = new Location("(10) East Campus Dorms", "The East Campus residential complex is usually referred to as the 'New Dorms' - although, that's "
                                   + "sort of a misnomer, given that they were built in the 1950s and 60s. The residence halls that make up the New Dorms "
                                   + "are Freeman, Bates, and McAfee. Though the New Dorms are more box-like than castle-like in terms of architecture, "
                                   + "they more than make up for that with the size of their rooms, which are by and large bigger than in any other "
                                   + "dorm.", "pic10east.jpg");
    
    //Add locations to Wellesley Map
    addVertex(ksc);
    addVertex(resQ);
    addVertex(alum);
    addVertex(lulu);
    addVertex(acaQ);
    addVertex(sciCen);
    addVertex(twr);
    addVertex(lib);
    addVertex(stone);
    addVertex(east);
    
    //Create Paths: Path(distance, stairs, hilly, directions)
    //(1)KSC will go to ResQ and Alum
    Path ksc2resQ = new Path(.2, false, true, new LinkedList<String>(Arrays.asList("KSC", "ResQ")));
    Path ksc2alum = new Path(.05, false, false, new LinkedList<String>(Arrays.asList("KSC", "Alum")));
    //(2)ResQ will go to KSC(above), Lulu, AcaQ, and SciCen
    Path resQ2lulu = new Path(.1, false, true, new LinkedList<String>(Arrays.asList("ResQ", "Lulu")));
    Path resQ2acaQ = new Path(.2, true, true, new LinkedList<String>(Arrays.asList("ResQ", "AcaQ")));
    Path resQ2sciCen = new Path(.3, true, true, new LinkedList<String>(Arrays.asList("ResQ", "SciCen")));
    //(3)Alum will go to KSC(above), Lulu, and Twr
    Path alum2lulu = new Path(.14, false, false, new LinkedList<String>(Arrays.asList("Alum", "Lulu")));
    Path alum2twr = new Path(.2, false, true, new LinkedList<String>(Arrays.asList("Alum", "Twr")));
    //(4)Lulu will go to Alum(above), ResQ(above), AcaQ, Twr, and Lib
    Path lulu2acaQ = new Path(.2, true, false, new LinkedList<String>(Arrays.asList("Lulu", "AcaQ")));
    Path lulu2twr = new Path(.1, false, false, new LinkedList<String>(Arrays.asList("Lulu", "Twr")));
    Path lulu2lib = new Path(.2, false, true, new LinkedList<String>(Arrays.asList("Lulu", "Lib")));
    //(5)AcaQ will go to ResQ(above), Lulu(above), SciCen, Twr, Lib, Stone, and East
    Path acaQ2sciCen = new Path(.2, true, false, new LinkedList<String>(Arrays.asList("AcaQ", "SciCen")));
    Path acaQ2twr = new Path(.2, true, false, new LinkedList<String>(Arrays.asList("AcaQ", "Twr")));
    Path acaQ2lib = new Path(.2, true, true, new LinkedList<String>(Arrays.asList("AcaQ", "Lib")));
    Path acaQ2stone = new Path(.3, true, true, new LinkedList<String>(Arrays.asList("AcaQ", "Stone")));
    Path acaQ2east = new Path(.4, true, true, new LinkedList<String>(Arrays.asList("AcaQ", "East")));
    //(6)SciCen will go to ResQ(above), AcaQ(above), Lib, Stone, and East
    Path sciCen2lib = new Path(.3, false, false, new LinkedList<String>(Arrays.asList("SciCen", "Lib")));
    Path sciCen2stone = new Path(.2, false, false, new LinkedList<String>(Arrays.asList("SciCen", "Stone")));
    Path sciCen2east = new Path(.2, true, false, new LinkedList<String>(Arrays.asList("SciCen", "East")));
    //(7)Twr will go to Alum(above), Lulu(above), AcaQ(above), and Lib
    Path twr2lib = new Path(.2, false, true, new LinkedList<String>(Arrays.asList("Twr", "Lib")));
    //(8)Lib will go to Lulu(above), AcaQ(above), SciCen(above), Twr(above), Stone, and East
    Path lib2stone = new Path(.2, false, true, new LinkedList<String>(Arrays.asList("Lib", "Stone")));
    Path lib2east = new Path(.3, true, true, new LinkedList<String>(Arrays.asList("Lib", "East")));
    //(9)Stone will go to AcaQ(above), SciCen(above), Lib(above) and East
    Path stone2east = new Path(.1, true, true, new LinkedList<String>(Arrays.asList("Stone", "East")));
    //(10)East will go to AcaQ(above), SciCen(above), Lib(above), and Stone(above)
    
    //add Paths to Wellesley Map
    addEdge(ksc, resQ, ksc2resQ);
    addEdge(ksc, alum, ksc2alum);
    addEdge(resQ, lulu, resQ2lulu);
    addEdge(resQ, acaQ, resQ2acaQ);
    addEdge(resQ, sciCen, resQ2sciCen);
    addEdge(alum, lulu, alum2lulu);
    addEdge(alum, twr, alum2twr);
    addEdge(lulu, acaQ, lulu2acaQ);
    addEdge(lulu, twr, lulu2twr);
    addEdge(lulu, lib, lulu2lib);
    addEdge(acaQ, sciCen, acaQ2sciCen);
    addEdge(acaQ, twr, acaQ2twr);
    addEdge(acaQ, lib, acaQ2lib);
    addEdge(acaQ, stone, acaQ2stone);
    addEdge(acaQ, east, acaQ2east);
    addEdge(sciCen, lib, sciCen2lib);
    addEdge(sciCen, stone, sciCen2stone);
    addEdge(sciCen, east, sciCen2east);
    addEdge(twr, lib, twr2lib);
    addEdge(lib, stone, lib2stone);
    addEdge(lib, east, lib2east);
    addEdge(stone, east, stone2east);
  }
}