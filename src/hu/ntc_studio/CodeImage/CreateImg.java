/**
 * Nos ide kell majd leírás ...
 * dokumentációs célzattal... 
 */

package hu.ntc_studio.CodeImage;

public class CreateImg {

	public static void main(String[] args) {

		try {
			
            final String charSet = "UTF-8";
            String filePath   = "test_hun.png"; // args[0]
            String codeData = "Ez egy teszt sor: éÉáÁűŰőŐúÚöÖüÜóÓíÍ"; // args[1]
          
            String filePathQr = filePath.substring(0, filePath.length() 
            		 - filePath.lastIndexOf("."))
            		 + "_QR" + filePath.substring(filePath.lastIndexOf("."));
            
            String filePathDm = filePath.substring(0, filePath.length() 
           		 - filePath.lastIndexOf("."))
           		 + "_DM" + filePath.substring(filePath.lastIndexOf("."));
            
            if ((args.length > 0) && (args[0].length() > 0 )) 
            	filePath = args[0];
 
            if ((args.length > 1) && (args[1].length() > 0 ))  
            	codeData = args[1];            	

            QRImage qrimg = new QRImage(codeData, filePathQr, charSet);            
            qrimg.writeImage ( qrimg.getImage() );
            
            DMImage dmimg = new DMImage(codeData, filePathDm, charSet);            
            dmimg.writeImage ( dmimg.getImage() );
                
            
        } catch (Exception e) {
        	
            System.err.println(e);
        }
    }
}