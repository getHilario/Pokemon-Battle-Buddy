

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hilario
 */


public class practiceWindow {


    public static void main(String[] args)
    {
        try{
			aWindow a = new aWindow();
			a.setVisible(true);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			System.exit(0);
                }
    }

}
